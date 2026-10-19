import java.nio.file.*;
import org.json.*;
public final class DeseneAddressAudit {
 public static void main(String[] args)throws Exception{
  JSONObject fixture=new JSONObject(new String(Files.readAllBytes(Paths.get(args[0])),"UTF-8"));JSONArray cases=fixture.getJSONArray("fixtures"),results=new JSONArray();int passed=0,wrong=0;
  for(int i=0;i<cases.length();i++){
   JSONObject test=cases.getJSONObject(i),result=new JSONObject().put("title",test.getString("websiteTitle")).put("type",test.getString("type")).put("expected",test.getString("expectedPage"));long start=System.nanoTime();
   NativeHttp.CURRENT.set(new NativeHttp.Session(30000));
   try{
    NativeCatalog.Located found=new NativeCatalog().locate(test.getJSONObject("data"));String actual=found==null?"":found.pageUrl;boolean exact=actual.equals(test.getString("expectedPage")),ok=exact;
    JSONArray equivalent=test.optJSONArray("equivalentPages");if(equivalent!=null)for(int n=0;n<equivalent.length();n++)if(actual.equals(equivalent.getString(n)))ok=true;
    result.put("actual",actual).put("pass",ok).put("status",ok?(exact?"CORRECT":"CORRECT_EQUIVALENT"):actual.isEmpty()?"NOT_FOUND":"WRONG_ADDRESS");if(ok)passed++;else if(!actual.isEmpty())wrong++;
   }catch(Exception e){result.put("pass",false).put("status","ERROR").put("error",e.getMessage());}
   finally{NativeHttp.session().stop();NativeHttp.CURRENT.remove();}
   result.put("ms",(System.nanoTime()-start)/1000000);results.put(result);System.out.println((i+1)+" "+result.getString("status")+" "+test.getString("websiteTitle"));
  }
  Files.write(Paths.get(args[1]),new JSONObject().put("seed",fixture.getLong("seed")).put("passed",passed).put("wrong",wrong).put("total",cases.length()).put("results",results).toString(2).getBytes("UTF-8"));
  System.out.println("DESENE ADDRESS AUDIT "+passed+"/"+cases.length()+" wrong="+wrong+"; address-only, no host resolution");
 }
}
