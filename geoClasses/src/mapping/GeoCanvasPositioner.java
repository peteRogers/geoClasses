package mapping;

import java.awt.geom.Point2D;

import geoPoints.MyGeoPoint;

import com.bbn.openmap.LatLonPoint;
import com.bbn.openmap.proj.Length;
import com.bbn.openmap.proj.Mercator;
import com.bbn.openmap.proj.Projection;
import com.bbn.openmap.proj.coords.UTMPoint;

public class GeoCanvasPositioner {



	private int width, height;
	private float scaleFactor;
	private UTMPoint topLeft;
	private UTMPoint bottomRight;
	private MyGeoPoint p1;
	
	
	public float getScaleFactor() {
		return scaleFactor;
	}



	public void setScaleFactor(float scaleFactor) {
		this.scaleFactor = scaleFactor;
	}

	
	public MyGeoPoint getP1() {
		return p1;
	}



	public void setP1(MyGeoPoint p1) {
		this.p1 = p1;
	}



	public MyGeoPoint getP2() {
		return p2;
	}



	public void setP2(MyGeoPoint p2) {
		this.p2 = p2;
	}

	private MyGeoPoint p2;
	
	



	public UTMPoint getUtm1() {
		return topLeft;
	}



	public void setUtm1(UTMPoint utm1) {
		this.topLeft = utm1;
	}



	public UTMPoint getUtm2() {
		return bottomRight;
	}



	public void setUtm2(UTMPoint utm2) {
		this.bottomRight = utm2;
	}


	
	public void initGeoDimensions(LatLonPoint l1, LatLonPoint l2, int width, int height){
		this.p1 = new MyGeoPoint();
		this.p2 = new MyGeoPoint();
		this.width = width;
		this.height = height;	
		p1.makeGeoPoint(l1);
		p2.makeGeoPoint(l2);
		p1.setX(map(p1.getLng(), -180, 180, 0, 360));
	    p1.setY(map (p1.getLat(), 90, -90, 0,  180));
	    p2.setX(map(p2.getLng(), -180, 180, 0, 360));
	    p2.setY(map (p2.getLat(), 90, -90, 0,  180));
	    //topLeft.
	}
	
	public void initGeoDimensions(MyGeoPoint p1, MyGeoPoint p2, int width, int height){
		this.p1 = p1;
		this.p2 = p2;
		this.width = width;
		this.height = height;	
		
		p1.setX(map(p1.getLng(), -180, 180, 0, 360));
	    p1.setY(map (p1.getLat(), 90, -90, 0,  180));
	    p2.setX(map(p2.getLng(), -180, 180, 0, 360));
	    p2.setY(map (p2.getLat(), 90, -90, 0,  180));
	}
	
	
	public void setMercatedScaleFactor(){
		float w = Math.abs(p1.getMercatedX()-p2.getMercatedX());
		float h = Math.abs(p1.getMercatedY()-p2.getMercatedY());
		if (w > h){
			scaleFactor = width/w;
		}else{
			scaleFactor = height/h;
		}
	}
	
	
	
	public MyGeoPoint mapPoint(MyGeoPoint p){
		p.setX(map(p.getLng(), -180, 180, 0, 100*2));
	    p.setY(map (p.getLat(), 90, -90, 0, 100));
		return p;
	}
	
	 static public final float map(float value,
             float istart, float istop,
             float ostart, float ostop) {
return ostart + (ostop - ostart) * ((value - istart) / (istop - istart));
}
	 
	    public static void main(String args[]) { 

            LatLonPoint center = new LatLonPoint(90, -180); 
            LatLonPoint degreePoint = new LatLonPoint(0, 0); 

            System.out.println("Distance in miles: " 
                            + Math.round(Length.NM.fromRadians(center.distance(degreePoint)))); 
            System.out.println("Distance in meters: " 
                            + Math.round(Length.METER.fromRadians(center.distance(degreePoint)))); 

            Projection proj = new Mercator(center, 1000000, 100, 100); 
            System.out.println(proj.forward(center).distance(proj.forward(degreePoint))); 
    } 

}
