import org.json.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;
import org.jsoup.parser.Parser;

final class DozaCatalog {
    static final class Located {
        final String titleUrl,pageUrl;final Document page;
        Located(String titleUrl,String pageUrl,Document page){this.titleUrl=titleUrl;this.pageUrl=pageUrl;this.page=page;}
    }
    static final String SITE="https://www.dozaanimata.net";
    static final Map<String,List<String>> SITEMAPS=new HashMap<>();
    static long sitemapTime;
    static boolean siteUrl(String value){try{URL u=new URL(value);return "https".equals(u.getProtocol())&&"www.dozaanimata.net".equals(u.getHost());}catch(Exception e){return false;}}
    static boolean dubbed(String heading){String n=NativeCatalog.normalize(heading);return RomanianAudio.declaredRomanian(heading)&&n.matches(".*\\bdublat(?:a)? in romana\\b.*");}
    static String heading(Document doc){Element h=doc.select(".mvic-desc h3[itemprop=name]").first();return h==null?"":h.text();}
    static boolean matches(Document doc,JSONObject data){
        String h=heading(doc);if(!dubbed(h))return false;
        Matcher year=Pattern.compile("\\((\\d{4})\\)").matcher(h);
        if(data.optInt("releaseYear",0)>0&&(!year.find()||Integer.parseInt(year.group(1))!=data.getInt("releaseYear")))return false;
        String title=NativeCatalog.normalize(h.replaceFirst("\\s*\\((?:19|20)\\d{2}\\).*$","").replaceFirst("(?i)\\s*[–-]\\s*Dublat.*$",""));
        for(String key:Arrays.asList("localTitle","movieName","originalTitle"))if(!data.optString(key).isEmpty()&&title.equals(NativeCatalog.normalize(data.optString(key))))return true;
        // Older posts keep their original title in the main artwork filename.
        // Require that identity plus the already-checked release year and dubbing declaration.
        Element mainImage=doc.select("img.hidden[itemprop=image][src]").first();
        for(Element image:mainImage==null?Collections.<Element>emptyList():Collections.singletonList(mainImage)){
            if(!image.attr("title").equals(h)&&!image.attr("alt").equals(h))continue;
            String src=image.attr("src");if(!src.startsWith(SITE+"/wp-content/uploads/"))continue;
            String name=src.substring(src.lastIndexOf('/')+1).replaceFirst("\\.[a-zA-Z0-9]+$","").replaceFirst("-\\d+x\\d+$","");
            String alias=NativeCatalog.normalize(name),compact=alias.replace(" ","");
            for(String key:Arrays.asList("originalTitle","englishTitle","localTitle")){
                String full=NativeCatalog.normalize(data.optString(key)).replace(" ","");
                if(compact.length()>=8&&compact.equals(full))return true;
                int distinctive=0;for(String word:alias.split(" "))if(word.length()>3&&!word.matches("the|and|with|from|live"))distinctive++;
                if(alias.split(" ").length>=3&&distinctive>=2&&compact.length()>=14&&full.startsWith(compact))return true;
            }
        }
        return false;
    }
    static List<NativeCatalog.Candidate> players(Document page,String url){
        List<NativeCatalog.Candidate> found=new ArrayList<>();Set<String> seen=new HashSet<>();
        for(Element iframe:page.select("#content-embed iframe[src], #media-player iframe[src]")){
            String embed=iframe.absUrl("src"),kind=NativeCatalog.kind(embed);
            if(!kind.isEmpty()&&seen.add(embed))found.add(new NativeCatalog.Candidate(kind,url,embed,"ROMANA",embed));
        }
        return found;
    }
    Located locateAt(String url,JSONObject data)throws Exception{
        if(!siteUrl(url))return null;
        boolean series=data.optInt("season",0)>0;if(series!=new URL(url).getPath().startsWith("/series/"))return null;
        Document page=Jsoup.parse(NativeHttp.text(url,Collections.<String,String>emptyMap()),url);
        if(!matches(page,data))return null;
        int season=data.optInt("season",0),episode=data.optInt("episode",0);
        if(season<=0||episode<=0)return new Located(url,url,page);
        String pattern=".*-sezonul-"+season+"-episodul-"+episode+"(?:-|/|$).*";
        for(Element a:page.select("a[href]")){
            String target=a.absUrl("href");if(!siteUrl(target)||!target.matches(pattern))continue;
            Document ep=Jsoup.parse(NativeHttp.text(target,NativeHttp.headers(url)),target);
            String seriesTitle=NativeCatalog.normalize(heading(page).replaceFirst("\\s*\\((?:19|20)\\d{2}\\).*$",""));
            String episodeTitle=NativeCatalog.normalize(heading(ep)).replaceFirst(" sezonul \\d+ episodul \\d+.*$","");
            if(!seriesTitle.equals(episodeTitle)||!RomanianAudio.declaredRomanian("ROMANA "+heading(ep)))return null;
            return new Located(url,target,ep);
        }
        return null;
    }
    List<NativeCatalog.Candidate> inspect(String url,JSONObject data)throws Exception{Located located=locateAt(url,data);return located==null?Collections.<NativeCatalog.Candidate>emptyList():players(located.page,located.pageUrl);}
    Located locate(JSONObject data)throws Exception{
        Set<String> visited=new HashSet<>(),titles=new LinkedHashSet<>();
        for(String key:Arrays.asList("localTitle","movieName","originalTitle"))if(!data.optString(key).isEmpty())titles.add(data.optString(key));
        for(String title:titles){
            String url=SITE+"/?s="+URLEncoder.encode(title,"UTF-8");Document search=Jsoup.parse(NativeHttp.text(url,Collections.<String,String>emptyMap()),url);int tried=0;
            for(Element a:search.select(".ml-item > a[href]")){
                String target=a.absUrl("href");if(!siteUrl(target)||target.contains("/episode/")||!visited.add(target))continue;
                // The visible result must declare dubbing before any detail/player fetch.
                if(!dubbed(a.text())||++tried>5)continue;
                Located found=locateAt(target,data);if(found!=null)return found;
            }
        }
        JSONObject identity=new JSONObject(data.toString());
        boolean series=data.optInt("season",0)>0;
        if(data.optInt("tmdbID",0)>0){
            JSONObject english=new JSONObject(NativeHttp.text("https://api.themoviedb.org/3/"+(series?"tv/":"movie/")+data.getInt("tmdbID")+"?language=en-US&api_key="+NativeCatalog.TMDB_KEY,Collections.<String,String>emptyMap()));
            identity.put("englishTitle",english.optString(series?"name":"title"));
        }
        List<String> urls=catalogUrls(series);List<String> candidates=new ArrayList<>();
        for(String url:urls)if(url.contains("-"+data.optInt("releaseYear",0)+"-")&&url.contains("-dublat-in-romana"))candidates.add(url);
        final JSONObject ranking=identity;
        Collections.sort(candidates,new Comparator<String>(){public int compare(String a,String b){return Integer.compare(score(b,ranking),score(a,ranking));}});
        int checked=0;
        for(String candidate:candidates){
            if(visited.contains(candidate)||++checked>16)continue;
            Located found=locateAt(candidate,identity);if(found!=null)return found;
        }
        return null;
    }
    static int score(String url,JSONObject data){
        String slug=NativeCatalog.normalize(url);int score=0;
        for(String key:Arrays.asList("localTitle","originalTitle","englishTitle"))for(String word:NativeCatalog.normalize(data.optString(key)).split(" "))if(word.length()>3&&slug.contains(word))score+=word.length();return score;
    }
    static synchronized List<String> catalogUrls(boolean series)throws Exception{
        String type=series?"tv":"movie";
        if(System.currentTimeMillis()-sitemapTime>3600000){SITEMAPS.clear();sitemapTime=System.currentTimeMillis();}
        if(SITEMAPS.containsKey(type))return SITEMAPS.get(type);
        Document index=Jsoup.parse(NativeHttp.text(SITE+"/sitemap_index.xml",Collections.<String,String>emptyMap()),"",Parser.xmlParser());List<String> urls=new ArrayList<>();
        for(Element loc:index.select("sitemap > loc")){
            String file=loc.text();if(!siteUrl(file)||!file.matches(series?".*/tvshows-sitemap\\d*\\.xml":".*/post-sitemap\\d*\\.xml"))continue;
            Document map=Jsoup.parse(NativeHttp.text(file,Collections.<String,String>emptyMap()),"",Parser.xmlParser());
            for(Element entry:map.select("url > loc")){String target=entry.text();if(siteUrl(target)&&(series==target.contains("/series/")))urls.add(target);}
        }
        SITEMAPS.put(type,urls);return urls;
    }
    List<NativeCatalog.Candidate> discover(JSONObject data)throws Exception{Located located=locate(data);return located==null?Collections.<NativeCatalog.Candidate>emptyList():players(located.page,located.pageUrl);}
}
