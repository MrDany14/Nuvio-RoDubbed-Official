import java.nio.file.*;import org.json.*;
public final class FdAddressAudit {
 public static void main(String[] args)throws Exception{
  JSONObject fixture=new JSONObject(new String(Files.readAllBytes(Paths.get(args[0])),"UTF-8"));JSONArray cases=fixture.getJSONArray("fixtures"),results=new JSONArray();int passed=0;
  for(int i=0;i<cases.length();i++){JSONObject test=cases.getJSONObject(i),result=new JSONObject().put("title",test.getString("title")).put("type",test.getString("type"));long start=System.nanoTime();NativeHttp.CURRENT.set(new NativeHttp.Session(30000));
   try{FdCatalog.Located found=new FdCatalog().locate(test.getJSONObject("data"));boolean ok=found!=null&&found.titleUrl.equals(test.getString("expectedPage"))&&found.wrapper.equals(test.getString("expectedWrapper"));result.put("actual",found==null?"":found.titleUrl).put("wrapper",found==null?"":found.wrapper).put("pass",ok);if(ok)passed++;}
   catch(Exception e){result.put("pass",false).put("error",e.getMessage());}finally{NativeHttp.session().stop();NativeHttp.CURRENT.remove();}
   result.put("ms",(System.nanoTime()-start)/1000000);results.put(result);System.out.println((result.getBoolean("pass")?"PASS ":"FAIL ")+test.getString("title"));
  }
  Files.write(Paths.get(args[1]),new JSONObject().put("seed",fixture.getLong("seed")).put("passed",passed).put("total",cases.length()).put("results",results).toString(2).getBytes("UTF-8"));System.out.println("ADDRESS AUDIT "+passed+"/"+cases.length()+"; no stream hosts requested");if(passed!=cases.length())System.exit(1);
 }
}
