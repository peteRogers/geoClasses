package mapping;

import geoPoints.MyGeoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ElevationGetter {

	ArrayList inputList;
	public float finLng;
	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public ElevationGetter(){
		inputList = new ArrayList();
	}
	  ContainerFactory containerFactory = new ContainerFactory(){
		    public List creatArrayContainer() {
		      return new LinkedList();
		    }

		    public Map createObjectContainer() {
		      return new LinkedHashMap();
		    }
		                        
		  };
		  
		  public String jsonURL(float lat, float lng){
			  String pref = "http://open.mapquestapi.com/elevation/v1/profile?shapeFormat=raw&latLngCollection=";
			  String latLng = "";
			  //float lat = 54.483443f;			 
			 // float lng = -3.69f;
			  for (int i = 0; i < 3; i ++){
				  lat = lat +0.02f;
				  latLng = latLng +""+lng+","+lat+","; 
				  MyGeoPoint p = new MyGeoPoint();
				  p.makeGeoPoint(lat, lng);
				  inputList.add(p);
				  finLng = lat;
			  }
			  
			  //System.out.println(pref+latLng);
			  return pref+latLng;
		  }
	
	public ArrayList getElevationLine(float lat, float lng, int line) throws IOException{
		URL url = new URL(jsonURL(lng, lat));
		ArrayList returner = new ArrayList();
		InputStream is = url.openStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	    String jsonText = readAll(rd);
	    //now make web text into json
	    System.out.println(jsonText);
		JSONParser parser= new JSONParser();
		Object obj;
		try {
			obj = parser.parse(jsonText);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray elevationArray = (JSONArray) jsonObject.get("elevationProfile");
		JSONArray locationArray = (JSONArray) jsonObject.get("shapePoints");
		for (int i = 0; i < elevationArray.size(); i ++){
			// = new ArrayList();
			MyGeoPoint p = new MyGeoPoint();
			JSONObject elevationJson = (JSONObject) elevationArray.get(i);
			//JSONObject locationJson = (JSONObject) locationArray.get(i);
			
			float fLat = ((Double) locationArray.get((i*2))).floatValue();
			
			float fLng = ((Double) locationArray.get((i*2)+1)).floatValue();
			
			p.makeGeoPoint(fLat,fLng);
			p.setLine(line);
			float fElev = ((Long) elevationJson.get("height")).floatValue();
			p.setElevation(fElev);
			System.out.println(p.getElevation()+" "+p.getLat()+" "+p.getLng());
			returner.add(p);
		}
		
		
		//System.out.println(parser.getPosition());
		
		return returner;
		//parser.
		
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
			new ElevationGetter().getElevationLine(54.483443f,  -3.69f, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
