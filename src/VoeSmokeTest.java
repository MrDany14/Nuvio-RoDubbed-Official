public final class VoeSmokeTest {
 public static void main(String[] args)throws Exception{
  long start=System.nanoTime();NativeHttp.CURRENT.set(new NativeHttp.Session(25000));
  try{
   NativeCatalog.Candidate c=new NativeCatalog.Candidate("VOE","https://desenefaine.com/film/avatar/","","VOE","https://voe.sx/e/atfhxpehsmkq");
   ResolvedStream stream=VoeClient.resolve(c);HlsProbe.validate(stream);
   System.out.println("PASS VOE Avatar: HTTPS playlist and media segment; "+(System.nanoTime()-start)/1000000+"ms");
  }finally{NativeHttp.session().stop();}
 }
}
