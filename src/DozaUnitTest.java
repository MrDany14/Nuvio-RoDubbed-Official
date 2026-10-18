import org.json.*;
import org.jsoup.Jsoup;
public final class DozaUnitTest {
 static void yes(boolean b,String message){if(!b)throw new AssertionError(message);}
 public static void main(String[] args)throws Exception{
  JSONObject meta=new JSONObject().put("localTitle","Un Show Obisnuit: Casetele Pierdute").put("releaseYear",2026);
  String start="<div class='mvic-desc'><h3 itemprop='name'>",end="</h3></div>";
  yes(DozaCatalog.matches(Jsoup.parse(start+"Un Show Obisnuit: Casetele Pierdute (2026) - Dublat in Romana"+end),meta),"Matching dubbed series");
  yes(!DozaCatalog.matches(Jsoup.parse(start+"Un Show Obisnuit: Casetele Pierdute (2026) - Subtitrat in Romana"+end),meta),"Subtitled title excluded");
  yes(!DozaCatalog.matches(Jsoup.parse(start+"Un Show Obisnuit: Casetele Pierdute (2025) - Dublat in Romana"+end),meta),"Wrong year excluded");
  yes(!DozaCatalog.matches(Jsoup.parse(start+"Un Show Obisnuit (2026) - Dublat in Romana"+end),meta),"Related show excluded");
  yes(!DozaCatalog.matches(Jsoup.parse(start+"Un Show Obisnuit: Casetele Pierdute (2026) - Subtitrat in Romana"+end+"<h3>Other show Dublat in Romana</h3>"),meta),"Recommended dubbing cannot qualify current title");
  String html="<div id='content-embed'><iframe src='https://vidmoly.org/embed-unit.html'></iframe><iframe src='https://vidmoly.org/embed-unit.html'></iframe><iframe src='https://playmogo.com/e/test'></iframe><iframe src='https://player.desenefaine.net/e/test'></iframe></div><iframe src='https://ads.invalid/frame'></iframe>";
  java.util.List<NativeCatalog.Candidate> candidates=DozaCatalog.players(Jsoup.parse(html,DozaCatalog.SITE),DozaCatalog.SITE+"/episode/test/");
  yes(candidates.size()==1&&candidates.get(0).host.equals("Vidmoly"),"Supported host dedupe and blocked/unsupported hosts excluded");
  yes(!DozaCatalog.siteUrl("https://www.dozaanimata.net.evil.invalid/title"),"Unrelated catalog host excluded");
  JSONObject english=new JSONObject().put("originalTitle","Re-Animated").put("releaseYear",2006);
  String heading="Din mintea lui Jimmy: Filmul (2006) - Dublat in Romana";
  String artwork="<img class='hidden' itemprop='image' title='"+heading+"' src='https://www.dozaanimata.net/wp-content/uploads/2024/12/Re-Animated.jpg'>";
  yes(DozaCatalog.matches(Jsoup.parse(start+heading+end+artwork),english),"Original-title main artwork resolves missing translation");
  yes(!DozaCatalog.matches(Jsoup.parse(start+heading+end+artwork.replace("class='hidden'","class='recommendation'")),english),"Recommendation artwork cannot establish identity");
  yes(!DozaCatalog.matches(Jsoup.parse(start+heading.replace("2006","2007")+end+artwork),english),"Artwork cannot override release year");
  JSONObject generic=new JSONObject().put("originalTitle","The Adventures Of A Different Hero").put("releaseYear",2006);
  yes(!DozaCatalog.matches(Jsoup.parse(start+heading+end+artwork.replace("Re-Animated.jpg","The-Adventures-Of.jpg")),generic),"Generic artwork prefix cannot establish identity");
  System.out.println("PASS Doza dubbed-only, strict titles/year, recommendation isolation, supported-host filtering and dedupe");
 }
}
