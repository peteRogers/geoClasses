package mapping;

import java.awt.geom.Point2D;

import geoPoints.MyGeoPoint;

import com.bbn.openmap.LatLonPoint;
import com.bbn.openmap.proj.coords.UTMPoint;

public class GeoCanvasPositioner {



	private int width, height;
	private float scaleFactor;
	public float getScaleFactor() {
		return scaleFactor;
	}



	public void setScaleFactor(float scaleFactor) {
		this.scaleFactor = scaleFactor;
	}

	private UTMPoint utm1;
	private UTMPoint utm2;
	private MyGeoPoint p1;
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
		return utm1;
	}



	public void setUtm1(UTMPoint utm1) {
		this.utm1 = utm1;
	}



	public UTMPoint getUtm2() {
		return utm2;
	}



	public void setUtm2(UTMPoint utm2) {
		this.utm2 = utm2;
	}


	
	public void initGeoDimensions(LatLonPoint l1, LatLonPoint l2, int width, int height){
		this.p1 = new MyGeoPoint();
		this.width = width;
		this.height = height;
		p1.makeGeoPoint(l1);
		this.p2 = new MyGeoPoint();
		p2.makeGeoPoint(l2);
		
		//p1 = mapPoint(p1);
		//p2 = mapPoint(p2);
		p1.setY(map(p1.getLng(), -180, 180, 0, 100*2));
	    p1.setX(map (p1.getLat(), 90, -90, 0, 100));
	    p2.setY(map(p2.getLng(), -180, 180, 0, 100*2));
	    p2.setX(map (p2.getLat(), 90, -90, 0,100));
		System.out.println("p1 x: "+p1.getX()+"p1 y: "+p1.getY());
		

	}
	
	public void setScaleFactor(){
		float x = (p1.getX()- p2.getX())*-1;
		float y = (p1.getY()- p2.getY())*-1;
		scaleFactor = 0f;
		if (x > y){
			scaleFactor = width / x;
			System.out.println("scale "+scaleFactor);
		}else{
			scaleFactor = width / y;
			System.out.println("scale "+scaleFactor);
		}
		
		
	}
	
	
	
	public MyGeoPoint mapPoint(MyGeoPoint p){
		
		p.setX(map(p.getLng(), -180, 180, 0, 100*2));
	    p.setY(map (p.getLat(), 90, -90, 0, 100));
	    System.out.println("p1 :"+p1.getY());
	    p.setY(p1.getY()-p.getY());
	    p.setX(p.getX()-p1.getX());
	    
		return p;
	}
	
	 static public final float map(float value,
             float istart, float istop,
             float ostart, float ostop) {
return ostart + (ostop - ostart) * ((value - istart) / (istop - istart));
}

}
