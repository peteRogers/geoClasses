package examples;



import geoPoints.MyGeoPoint;

import com.bbn.openmap.LatLonPoint;

import mapping.GeoCanvasPositioner;

public class GeoCanvasExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeoCanvasPositioner geo = new GeoCanvasPositioner();

		
		LatLonPoint p1  = new LatLonPoint(51.5113f, -0.1911f);
		LatLonPoint p2  = new LatLonPoint(51.5008f, -0.1491f);
		
		geo.initGeoDimensions(p1, p2);
		System.out.println(geo.getCanvasDimension().getX());
		System.out.println(geo.getCanvasDimension().getY());
		MyGeoPoint p =  new MyGeoPoint();
		p.makeGeoPoint(p2);
		p = geo.positionPoint(p);
		System.out.println(p.getX());
		
	}

}
