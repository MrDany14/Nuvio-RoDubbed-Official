import java.nio.file.*;import org.json.*;
public final class MirrorUnavailableTest {
 public static void main(String[] args)throws Exception{
  JSONArray fixtures=new JSONObject(new String(Files.readAllBytes(Paths.get(args[0])),"UTF-8")).getJSONArray("fixtures"),results=new JSONArray();int passed=0;
  for(int i=0;i<fixtures.length();i++){JSONObject f=fixtures.getJSONObject(i),out=new JSONObject().put("title",f.getString("title"));NativeHttp.CURRENT.set(new NativeHttp.Session(12000));long start=System.nanoTime();try{
   NativeCatalog.Candidate c=new NativeCatalog.Candidate("Playmogo",f.getString("page"),"","ROMANA",f.getString("embed"),new JSONObject().put("title",f.getString("title")));
   PlaymogoClient.resolve(c);out.put("pass",false).put("error","Removed upload produced a stream");
  }catch(Exception e){boolean correct=e.getMessage()!=null&&e.getMessage().equals("Playmogo video unavailable");out.put("pass",correct).put("reason",e.toString());if(correct)passed++;}finally{NativeHttp.session().stop();NativeHttp.CURRENT.remove();}
   out.put("ms",(System.nanoTime()-start)/1000000);results.put(out);System.out.println(out);
  }Files.write(Paths.get(args[1]),new JSONObject().put("passed",passed).put("total",fixtures.length()).put("results",results).toString(2).getBytes("UTF-8"));System.exit(passed==fixtures.length()?0:1);
 }
}
