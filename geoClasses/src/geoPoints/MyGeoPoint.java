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

	
		float x, y, lat, lng, scaleFactor, mercatedX, mercatedY;
		UTMPoint utm;
		String time, id, keyword, picture, tableName, placeName, fClass, fCode;
		
		public String getfClass() {
			return fClass;
		}

		public void setfClass(String fClass) {
			this.fClass = fClass;
		}

		public String getfCode() {
			return fCode;
		}

		public void setfCode(String fCode) {
			this.fCode = fCode;
		}

		public String getPlaceName() {
			return placeName;
		}

		public void setPlaceName(String placeName) {
			this.placeName = placeName;
		}

		public float getMercatedX() {
			return mercatedX;
		}

		public void setMercatedX(float mercatedX) {
			this.mercatedX = mercatedX;
		}

		public float getMercatedY() {
			return mercatedY;
		}

		public void setMercatedY(float mercatedY) {
			this.mercatedY = mercatedY;
		}
		
		
		
	
		
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
			MyMercator mercator = new MyMercator();
			setMercatedY((float)mercator.mercLat(this.lat));
			setMercatedX((float)mercator.mercLng(this.lng));
		}
		
		public void makeGeoPoint(LatLonPoint l){
			this.lat = l.getLatitude();
			this.lng = l.getLongitude();
			MyMercator mercator = new MyMercator();
			setMercatedY((float)mercator.mercLat(lat));
			setMercatedX((float)mercator.mercLng(lng));
		
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


