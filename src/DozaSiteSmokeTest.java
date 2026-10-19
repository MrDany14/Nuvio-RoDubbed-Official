import org.json.*;
import java.util.*;
public final class DozaSiteSmokeTest {
 public static void main(String[] args)throws Exception{
  NativeHttp.CURRENT.set(new NativeHttp.Session(25000));
  try{
   JSONObject metadata=new JSONObject().put("localTitle","Un Show Obisnuit: Casetele Pierdute").put("releaseYear",2026).put("season",1).put("episode",1);
   List<NativeCatalog.Candidate> found=new DozaCatalog().discover(metadata);
   if(found.size()!=2||!found.get(0).host.equals("Vidmoly")||!found.get(1).host.equals("Playmogo"))throw new AssertionError("Expected Doza Vidmoly and Playmogo sources");
   ResolvedStream stream=RoDubbedProvider.resolve(found.get(0));if(!stream.site.equals("DozaAnimata"))throw new AssertionError("Wrong site attribution");
   System.out.println("PASS Doza episode discovery, parent dubbing declaration, Vidmoly playlist and initial segment");
   RoDubbedProvider.resolve(found.get(1));System.out.println("PASS same episode Playmogo MP4");
   JSONObject subtitled=new JSONObject().put("localTitle","Avatar: Aang The Last Airbender").put("releaseYear",2026);
   if(!new DozaCatalog().inspect("https://www.dozaanimata.net/avatar-aang-the-last-airbender-2026-subtitrat-in-romana/",subtitled).isEmpty())throw new AssertionError("Subtitled movie accepted");
   System.out.println("PASS actual Avatar subtitled movie excluded before resolving its players");
   JSONObject wednesday=new JSONObject().put("localTitle","Wednesday").put("releaseYear",2022).put("season",1).put("episode",1);
   List<NativeCatalog.Candidate> more=new DozaCatalog().discover(wednesday);
   if(more.size()!=2)throw new AssertionError("Expected Wednesday Vidmoly and Playmogo sources");
   java.util.Set<String> hosts=new java.util.HashSet<>();for(NativeCatalog.Candidate candidate:more){RoDubbedProvider.resolve(candidate);hosts.add(candidate.host);}if(!hosts.contains("Vidmoly")||!hosts.contains("Playmogo"))throw new AssertionError("Missing Wednesday host");System.out.println("PASS Wednesday S01E01 Vidmoly and Playmogo");
  }catch(Throwable e){System.out.println("FAIL "+e.getClass().getSimpleName()+": "+e.getMessage());System.exit(1);}
  finally{NativeHttp.session().stop();}
 }
}
