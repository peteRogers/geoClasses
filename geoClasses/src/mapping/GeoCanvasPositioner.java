package mapping;

import geoPoints.MyGeoPoint;

import com.bbn.openmap.LatLonPoint;
import com.bbn.openmap.proj.coords.UTMPoint;

public class GeoCanvasPositioner {


	private MyGeoPoint canvasDimension;
	private UTMPoint utm1;
	private UTMPoint utm2;
	
	public MyGeoPoint getCanvasDimension() {
		return canvasDimension;
	}



	public void setCanvasDimension(MyGeoPoint canvasDimension) {
		this.canvasDimension = canvasDimension;
	}



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


	
	public void initGeoDimensions(LatLonPoint p1, LatLonPoint p2){
		utm1 = new UTMPoint(p1);
		utm2 = new UTMPoint(p2);
		canvasDimension = new MyGeoPoint();
		canvasDimension.setX(utm2.easting - utm1.easting);
		canvasDimension.setY(utm1.northing - utm2.northing);
	}
	
	
	public MyGeoPoint positionPoint(MyGeoPoint p){
		p.setX((p.getUtm().easting-utm1.easting));
		p.setY((utm2.northing - p.getUtm().northing));
		return p;
	}
	
	
}
