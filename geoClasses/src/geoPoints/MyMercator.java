package geoPoints;



import java.awt.Point;
import java.util.ArrayList;

import com.bbn.openmap.LatLonPoint;
import com.bbn.openmap.proj.Mercator;



public class MyMercator {
	int scale = 1;
	int divider = 1000;
	final private static double R_MAJOR = 6378137.0;
	final private static double R_MINOR = 6356752.3142;
	
	public ArrayList getMercatorGridY(){
		ArrayList a = new ArrayList();
		for (int i = 90 ; i > -90; i --){
			LatLonPoint point = new LatLonPoint(0, 0);
			Mercator mercator = new Mercator(point, scale, 1,1);
			Point p = mercator.forward(i, 0);
			float f = p.y/1000;
			a.add(f);
		}
		return a;
	}
	
	public ArrayList getMercatorGridX(){
		ArrayList a = new ArrayList();
		
		for (int i = -180 ; i < 180; i ++){
			LatLonPoint point = new LatLonPoint(0, 0);
			Mercator mercator = new Mercator(point, scale, 1, 1);
			Point p = mercator.forward(0, i);
			float f = p.x/1000;
			a.add(f);
		}
		return a;
	}
	
	public float[] getMercator(float[] topLeft, float[] geoPoint){
		
		//LatLonPoint point = new LatLonPoint(51.503908f,-0.019526f);
		LatLonPoint point = new LatLonPoint(0, 0);
		Mercator mercator = new Mercator(point, scale, 1, 1);
		Point p = mercator.forward(geoPoint[0], geoPoint[1]);
		
		//float myX = p.x / 1000;
		//float myY = p.y / 1000;
		float r[] = {p.x, p.y};
		return r;
	}
	
	
	
	 public float map(float value,float istart, float istop,float ostart, float ostop) {
		 
		 System.out.println(value+" "+istart+" "+ istop+" "+ ostart+" "+ ostop);
		 		return ostart + (ostop - ostart) * ((value - istart) / (istop - istart));
	 	}
	 

	 
	    public double[] merc(double x, double y) {
	        return new double[] {mercLat(x), mercLng(y)};
	    }
	    
	    public MyGeoPoint merc(MyGeoPoint p) {
	    	
	    	p.setMercatedX((float)mercLat(p.getLat()));
	    	p.setMercatedY((float)mercLng(p.getLng()));
	        return p;
	    }
	    
	    public double  mercLng(double lon) {
	        return R_MAJOR * Math.toRadians(lon);
	    }
	 
	    public double mercLat(double lat) {
	        if (lat > 89.5) {
	            lat = 89.5;
	        }
	        if (lat < -89.5) {
	            lat = -89.5;
	        }
	        double temp = R_MINOR / R_MAJOR;
	        double es = 1.0 - (temp * temp);
	        double eccent = Math.sqrt(es);
	        double phi = Math.toRadians(lat);
	        double sinphi = Math.sin(phi);
	        double con = eccent * sinphi;
	        double com = 0.5 * eccent;
	        con = Math.pow(((1.0-con)/(1.0+con)), com);
	        double ts = Math.tan(0.5 * ((Math.PI*0.5) - phi))/con;
	        double y = 0 - R_MAJOR * Math.log(ts);
	        return y;
	    }
	
}
