import java.nio.file.*;import org.json.*;import java.util.*;
public final class DesenflixSearchAudit {
 public static void main(String[] args)throws Exception{
  JSONArray fixtures=new JSONObject(new String(Files.readAllBytes(Paths.get(args[0])),"UTF-8")).getJSONArray("fixtures"),results=new JSONArray();int count=args.length>2?Integer.parseInt(args[2]):fixtures.length(),passed=0;
  for(int i=0;i<count;i++){
   JSONObject f=fixtures.getJSONObject(i),r=new JSONObject().put("title",f.getString("title"));long start=System.nanoTime();NativeHttp.CURRENT.set(new NativeHttp.Session(26000));
   try{List<NativeCatalog.Candidate> found=new DesenflixCatalog().discover(f.getJSONObject("data"));boolean ok=f.getString("expected").isEmpty()?found.isEmpty():found.size()==1&&found.get(0).page.equals(f.getString("url"))&&found.get(0).embed.equals(f.getString("expected"));r.put("pass",ok).put("actual",found.isEmpty()?"":found.get(0).page);if(ok)passed++;}
   catch(Exception e){r.put("pass",false).put("error",e.toString());}finally{NativeHttp.session().stop();NativeHttp.CURRENT.remove();}
   r.put("ms",(System.nanoTime()-start)/1000000);results.put(r);System.out.println(r.toString());Thread.sleep(650);
  }
  Files.write(Paths.get(args[1]),new JSONObject().put("passed",passed).put("total",count).put("results",results).toString(2).getBytes("UTF-8"));if(passed!=count)throw new AssertionError("Discovery audit "+passed+"/"+count);
 }
}
