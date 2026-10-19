import org.json.*;import org.jsoup.Jsoup;import java.util.*;
public final class DoodDfUnitTest {
 static void yes(boolean v,String name){if(!v)throw new AssertionError(name);}
 public static void main(String[] args)throws Exception{
  String embed="https://doodstream.com/e/abcdefghijkl",movie=NativeCatalog.SITE+"/film/example",ep=NativeCatalog.SITE+"/epi/example-s1-ep1/";
  yes(PlaymogoClient.playerUrl(embed),"Dood alias");PlaymogoClient.verifyCanonical(embed,"https://playmogo.com/e/abcdefghijkl");
  JSONObject proof=new JSONObject().put("dfVerified",true);NativeCatalog.Candidate good=new NativeCatalog.Candidate("Playmogo",movie,"","ROMÂNĂ",embed,proof);yes(PlaymogoClient.enabled(good),"Verified DF movie");
  for(NativeCatalog.Candidate bad:Arrays.asList(new NativeCatalog.Candidate("Playmogo",movie,"","ROMANA",embed,null),new NativeCatalog.Candidate("Playmogo",movie,"","ROMANA",embed,new JSONObject()),new NativeCatalog.Candidate("Playmogo",movie,"","ENGLISH",embed,proof),new NativeCatalog.Candidate("Playmogo","https://other.invalid/film/example","","ROMANA",embed,proof),new NativeCatalog.Candidate("Playmogo",ep,"","ROMANA",embed,proof)))yes(!PlaymogoClient.enabled(bad),"Reject missing/wrong provenance or language");
  yes(PlaymogoClient.enabled(new NativeCatalog.Candidate("Playmogo",ep,"","ROMANA",embed,new JSONObject().put("dfVerified",true).put("season",1).put("episode",1))),"Verified DF episode");
  NativeCatalog c=new NativeCatalog();c.season=1;c.episode=1;String html="<a data-src='"+java.util.Base64.getEncoder().encodeToString(embed.getBytes("UTF-8"))+"'>SERVER 01 Doodstream - ROMÂNĂ</a>";List<NativeCatalog.Candidate> found=c.candidates(new NativeCatalog.Located(NativeCatalog.SITE+"/serial/example",ep,Jsoup.parse(html,ep)));yes(found.size()==1&&PlaymogoClient.enabled(found.get(0)),"Discovery carries exact episode context");yes(c.candidates(new NativeCatalog.Located(movie,movie,Jsoup.parse(html.replace("ROMÂNĂ","ENGLISH"),movie))).isEmpty(),"Foreign-language source excluded");
  System.out.println("PASS Dood alias, DF guarded discovery/provenance, episode context and language rejection");
 }
}
