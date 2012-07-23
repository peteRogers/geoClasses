package examples;



import geoPoints.MyMercator;
import geoPoints.MyGeoPoint;

import com.bbn.openmap.LatLonPoint;

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
		LatLonPoint botR  = new LatLonPoint(49.72f, 4.21f);

		LatLonPoint tester  = new LatLonPoint(52.55, -0.61667);
		geo.initGeoDimensions(topL, botR, 1000, 1000);

		MyGeoPoint testing = new MyGeoPoint();
		testing.makeGeoPoint(tester);
		System.out.println("p1 x: "+geo.getP1().getX()+" p1 y: "+geo.getP1().getY());
		System.out.println("p2 x: "+geo.getP2().getX()+" p2 y: "+geo.getP2().getY());
		System.out.println( "max merc W: "+Math.abs((geo.getP1().getMercatedX()-geo.getP2().getMercatedX()))+" H: "+Math.abs((geo.getP2().getMercatedY()-geo.getP1().getMercatedY())));
		System.out.println( "test merc x : "+(geo.getP1().getMercatedX()-testing.getMercatedX())*-1+" merc y : "+(geo.getP1().getMercatedY()-testing.getMercatedY()));
		geo.setMercatedScaleFactor();
		System.out.println(geo.getScaleFactor());
		
		System.out.println(Math.abs(geo.getP1().getMercatedY()-testing.getMercatedY())*geo.getScaleFactor());
	/**
		GeoCanvasPositioner geo = new GeoCanvasPositioner();
		LatLonPoint topL  = new LatLonPoint(58.63f, -8.87f);
		LatLonPoint botR  = new LatLonPoint(49.72f, 4.21f);
		geo.initGeoDimensions(topL, botR, 1000, 1000);
		geo.setMercatedScaleFactor();
		//System.out.println(list.size());
		System.out.println(geo.getScaleFactor());
		**/
	}

}
