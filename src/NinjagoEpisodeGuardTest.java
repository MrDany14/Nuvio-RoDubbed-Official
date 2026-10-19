import java.nio.file.*;import java.util.*;import org.json.*;import org.jsoup.Jsoup;import org.jsoup.nodes.*;
public final class NinjagoEpisodeGuardTest {
 public static void main(String[] args)throws Exception{NativeHttp.CURRENT.set(new NativeHttp.Session(30000));try{
  JSONObject fixture=new JSONObject(new String(Files.readAllBytes(Paths.get(args[0])),"UTF-8")).getJSONArray("fixtures").getJSONObject(0),data=new JSONObject(fixture.getJSONObject("data").toString()).put("season",15).put("episode",1);String parent=args[1];Document page=Jsoup.parse(NativeHttp.text(parent,Collections.<String,String>emptyMap()),parent);String target="";for(Element a:page.select("#seasons a[href]"))if(DozaCatalog.episodeAddress(a.absUrl("href"),15,1)){target=a.absUrl("href");break;}if(target.isEmpty())throw new AssertionError("Missing publisher's renumbered episode");Document ep=Jsoup.parse(NativeHttp.text(target,Collections.<String,String>emptyMap()),target);
  if(DozaCatalog.episodeIdentity(ep,target,data))throw new AssertionError("Publisher's Crystalized S15E1 accepted as TMDB's Seabound S15E1");
  System.out.println("PASS real publisher S15E1 rejected for TMDB S15E1: different episode story, despite matching numbers");
 }finally{NativeHttp.session().stop();}System.exit(0);}
}
