import java.nio.file.*;import java.util.*;import org.jsoup.Jsoup;import org.jsoup.nodes.*;import org.json.*;
public final class DesenflixUnitTest {
 static void yes(boolean v,String msg){if(!v)throw new AssertionError(msg);}
 public static void main(String[] args)throws Exception{
  JSONArray cases=new JSONObject(new String(Files.readAllBytes(Paths.get(args[0])),"UTF-8")).getJSONArray("fixtures");int matched=0,missing=0;
  for(int i=0;i<cases.length();i++){
   JSONObject f=cases.getJSONObject(i),data=f.getJSONObject("data");String html=f.getString("html");Document page=Jsoup.parse(html,f.getString("url"));
   yes(DesenflixCatalog.matches(page,data),"Identity "+f.getString("title"));yes(DesenflixCatalog.player(page,data).equals(f.getString("expected")),"Exact player "+f.getString("title"));
   if(f.getString("expected").isEmpty())missing++;else matched++;
   yes(!DesenflixCatalog.matches(page,new JSONObject(data.toString()).put("tmdbID",data.getInt("tmdbID")+1)),"Wrong ID");
   yes(!DesenflixCatalog.matches(page,new JSONObject(data.toString()).put("releaseYear",data.getInt("releaseYear")+1)),"Wrong year");
   JSONObject wrongType=new JSONObject(data.toString());if(f.getString("type").equals("series")){wrongType.remove("season");wrongType.remove("episode");yes(DesenflixCatalog.player(page,wrongType).isEmpty(),"No series default as movie");yes(DesenflixCatalog.player(page,new JSONObject(data.toString()).put("episode",9999)).isEmpty(),"No missing episode fallback");}else{wrongType.put("season",1).put("episode",1);}
   yes(!DesenflixCatalog.matches(page,wrongType),"Wrong media type");
   yes(!DesenflixCatalog.matches(Jsoup.parse(html.replace("Dublat în Română","Subtitrat în Română").replace("Dublat în română","Subtitrat în română")),data),"Subtitled rejection");
  }
  String multi="<div class=dfx-episode-card data-title='Sezonul 2 - Episodul 11' data-src='https://byseraguci.com/e/wrong'></div><div class=dfx-episode-card data-title='Sezonul 2 - Episodul 01' data-src='https://byseraguci.com/e/right'></div>";
  yes(DesenflixCatalog.player(Jsoup.parse(multi),new JSONObject().put("season",2).put("episode",1)).endsWith("/right"),"Padded exact season/episode; E1 is not E11");
  yes(!DesenflixCatalog.siteUrl("https://desenflix.online.evil.invalid/"),"Host boundary");yes(!DesenflixCatalog.titleUrl("https://desenflix.online/not-subtitrat-in-romana/"),"Subtitle URL excluded");
  yes(DesenflixCatalog.byse("http://byseraguci.com/e/id").isEmpty(),"HTTPS");yes(DesenflixCatalog.byse("https://evil.invalid/e/id").isEmpty(),"Other hosts rejected");
  yes(DesenflixCatalog.byse("https://byseraguci.com/e/abc123/translated-title").equals("https://byseraguci.com/e/abc123"),"Descriptive suffix removed while video ID is preserved");
  System.out.println("PASS 40 title identities, "+matched+" film/S1E1 embeds, "+missing+" missing S1E1 withheld; wrong IDs/years/types, subtitled content and episode fallbacks rejected");
 }
}
