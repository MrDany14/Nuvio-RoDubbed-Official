import org.json.*;import org.jsoup.Jsoup;import java.util.*;
public final class PlaymogoUnitTest {
 static void reject(RunnableChecked action)throws Exception{try{action.run();throw new AssertionError("Expected rejection");}catch(AssertionError e){throw e;}catch(Exception expected){}}
 interface RunnableChecked{void run()throws Exception;}
 public static void main(String[] args)throws Exception{
  String token="abcdefghijklmnopqrstuvwx",path="/pass_md5/123-456-abcdef/"+token,html="$.get('"+path+"',cb); function makePlay(){return '?token="+token+"&expiry='+Date.now()}";if(!PlaymogoClient.handshake(html).equals(path))throw new AssertionError("Literal handshake");reject(()->PlaymogoClient.handshake(html.replace("?token="+token,"?token=wrong")));
  if(!PlaymogoClient.mediaUrl("https://rdx369h.cloudatacdn.com/video/",token,"AbCdEf0123",123).endsWith("AbCdEf0123?token="+token+"&expiry=123"))throw new AssertionError("Public player suffix");reject(()->PlaymogoClient.mediaUrl("https://rdx369h.cloudatacdn.com.evil.invalid/video/",token,"AbCdEf0123",123));reject(()->PlaymogoClient.mediaUrl("http://rdx369h.cloudatacdn.com/video/",token,"AbCdEf0123",123));
  JSONObject expected=new JSONObject().put("season",1).put("episode",1);PlaymogoClient.verifyTitle("Miraculos - E01 - DoodStream",expected);reject(()->PlaymogoClient.verifyTitle("Miraculos - E02 - DoodStream",expected));reject(()->PlaymogoClient.verifyTitle("Miraculos S02E01",expected));reject(()->PlaymogoClient.verifyTitle("File deleted",expected));
  if(!NativeCatalog.kind("https://playmogo.com/e/m941m940ebqq").equals("Playmogo")||!NativeCatalog.kind("https://playmogo.com.evil.invalid/e/m941m940ebqq").isEmpty())throw new AssertionError("Host route");
  String page="<div id='content-embed'><iframe src='https://playmogo.com/e/m941m940ebqq'></iframe><iframe src='https://vidmoly.org/embed-example.html'></iframe></div>";List<NativeCatalog.Candidate> list=DozaCatalog.players(Jsoup.parse(page,DozaCatalog.SITE),DozaCatalog.SITE+"/episode/show-sezonul-1-episodul-1-title/");if(list.size()!=2||list.get(0).expected.optInt("episode")!=1)throw new AssertionError("Site discovery context");
  NativeCatalog.Candidate wrong=new NativeCatalog.Candidate("Playmogo","https://other.invalid/title","","ROMANA","https://playmogo.com/e/m941m940ebqq",expected);reject(()->PlaymogoClient.resolve(wrong));
  if(!DozaCatalog.spellingAlias("Miraculos Buburuza si Motan Noir","Miraculous Buburuza si Motan Noir"))throw new AssertionError("Corroborated long-title spelling");if(DozaCatalog.spellingAlias("Miraculos Buburuza si Motan Noir 2","Miraculous Buburuza si Motan Noir 3")||DozaCatalog.spellingAlias("Miraculos Buburuza si Motan Noir","Miraculous Buburuza si Motan Bleue")||DozaCatalog.spellingAlias("Miraculos Noir","Miraculous Noir"))throw new AssertionError("Broad fuzzy matching accepted");
  System.out.println("PASS Playmogo handshake/token, CDN/episode/deleted-video safeguards, Doza provenance and guarded long-title spelling");
 }
}
