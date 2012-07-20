package examples;



import geoPoints.MyMercator;
import geoPoints.MyGeoPoint;

import com.bbn.openmap.LatLonPoint;
import com.bbn.openmap.proj.Mercator;
import com.bbn.openmap.proj.coords.UTMPoint;

import mapping.GeoCanvasPositioner;

public class GeoCanvasExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeoCanvasPositioner geo = new GeoCanvasPositioner();

		
	
		
		
		
		
		LatLonPoint topL  = new LatLonPoint(58.63f, -8.87f);
		LatLonPoint botR  = new LatLonPoint(49.724479, 4.21875f);
		//LatLonPoint topL  = new LatLonPoint(90, -180);
		//LatLonPoint botR  = new LatLonPoint(-90, 180);
		LatLonPoint tester  = new LatLonPoint(49.724479f,4.87f);
		geo.initGeoDimensions(topL, botR, 1000, 1000);
		geo.setScaleFactor();
		MyGeoPoint testing = new MyGeoPoint();
		testing.makeGeoPoint(tester);
		testing = geo.mapPoint(testing);
		int x =  (int) ((MAP_WIDTH/360.0) * (180 + lon));
		int y =  (int) ((MAP_HEIGHT/180.0) * (90 - lat));
		//System.out.println(ll.getLatitude());
		//UTMPoint utm = geo.getUtm1();
		//System.out.println("x "+geo.getUtm1().easting+" "+geo.getUtm2().easting+" "+"w "+ geo.getCanvasDimension().getX());
		//System.out.println("y "+geo.getUtm1().northing+" "+geo.getUtm2().northing+" "+geo.getCanvasDimension().getY());

		
		//System.out.println(geo.getP1().getX()+" "+geo.getP2().getX());
		//System.out.println(geo.getP1().getY()+" "+geo.getP2().getY());
		
		
		System.out.println("tester x "+ (testing.getX())+" tester y "+ testing.getY());
	}

}
