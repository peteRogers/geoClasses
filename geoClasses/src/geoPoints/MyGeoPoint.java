package geoPoints;

import com.bbn.openmap.LatLonPoint;
import com.bbn.openmap.proj.coords.UTMPoint;

/**
 * class that encapsulates geo point of various types whilst doing
 * UTM config etc
 * @author dt
 *
 */
public class MyGeoPoint {

	
		float x, y, lat, lng, scaleFactor;
		
		String time, id, keyword, picture, tableName;
		
		
		UTMPoint utm;
		
		public UTMPoint getUtm() {
			return utm;
		}

		public void setUtm(UTMPoint utm) {
			this.utm = utm;
		}

		public void makeGeoPoint(float lat, float lng){
			this.lat = lat;
			this.lng = lng;
			LatLonPoint p = new LatLonPoint(lat, lng);
			utm = new UTMPoint(p);
			x =  (utm.easting);
			y = (utm.northing);
		}
		
		public void makeGeoPoint(LatLonPoint l){
			this.lat = l.getLatitude();
			this.lng = l.getLongitude();
			LatLonPoint p = new LatLonPoint(lat, lng);
			utm = new UTMPoint(p);
			x =  (utm.easting);
			y = (utm.northing);
		}
		public String getTableName() {
			return tableName;
		}


		public void setTableName(String tableName) {
			this.tableName = tableName;
		}
		
		public String getPicture() {
			return picture;
		}

		public void setPicture(String picture) {
			this.picture = picture;
		}
		
		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
		
		public float getScaleFactor() {
			return scaleFactor;
		}

		public void setScaleFactor(float scaleFactor) {
			this.scaleFactor = scaleFactor;
		}
		
		public float getX() {
			return x;
		}
		public void setX(float x) {
			this.x = x;
		}
		public float getY() {
			return y;
		}
		public void setY(float y) {
			this.y = y;
		}
		public float getLat() {
			return lat;
		}

		public float getLng() {
			return lng;
		}

		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
	

}


