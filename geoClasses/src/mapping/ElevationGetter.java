package mapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ElevationGetter {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseException 
	 */
	
	public void getElevationLine() throws IOException, ParseException{
		URL url = new URL("http://open.mapquestapi.com/elevation/v1/profile?callback=handleHelloWorldResponse&outFormat=xml&shapeFormat=raw&latLngCollection=39.740112,-104.984856,39.799438,-105.72361,39.6403,-106.373596");
		InputStream is = url.openStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	    String jsonText = readAll(rd);
	    System.out.println(jsonText);
		JSONParser parser= new JSONParser();
		
		parser.parse(jsonText);
		System.out.println(parser.toString());
		
	}
	
	 private static String readAll(Reader rd) throws IOException {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    return sb.toString();
		  }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new ElevationGetter().getElevationLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
