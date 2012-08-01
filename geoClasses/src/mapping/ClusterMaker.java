package mapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


import geoPoints.MyGeoPoint;

public class ClusterMaker {

	
	public static double distFrom(double lat1, double lng1, double lat2, double lng2) {
	    double earthRadius = 3958.75;
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double sindLat = Math.sin(dLat / 2);
	    double sindLng = Math.sin(dLng / 2);
	    double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2) * Math.cos(lat1) * Math.cos(lat2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    double dist = earthRadius * c;

	    return dist;
	    }


public static double distBetween(MyGeoPoint p1, MyGeoPoint p2) {
	 double earthRadius = 3958.75;
    double dLat = Math.toRadians(p2.getLat()-p1.getLat());
    double dLng = Math.toRadians(p2.getLng()-p1.getLng());
    double sindLat = Math.sin(dLat / 2);
    double sindLng = Math.sin(dLng / 2);
    double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2) * Math.cos(p1.getLng()) * Math.cos(p2.getLat());
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
   
    return earthRadius * c;
    }

public double distance(MyGeoPoint p, MyGeoPoint q){
	double dx   = p.getX() - q.getX();         //horizontal difference 
	double dy   = p.getY() - q.getY();         //vertical difference 
	double dist = Math.sqrt( dx*dx + dy*dy ); //distance using Pythagoras theorem
	return dist;
}


public ArrayList makeClusters(ArrayList inList){
	double proximity = 0.3;
	ArrayList returnList = new ArrayList();
	for (int i = 0; i < inList.size(); i ++){
		MyGeoPoint checker = (MyGeoPoint) inList.get(i);
		if (checker.isNeighbour()== false){
		for (int ii = 0; ii < inList.size(); ii ++){
			MyGeoPoint p = (MyGeoPoint) inList.get(ii);
			double d = distance(checker, p);
			
			
			if (d > 0 && d < proximity){
				System.out.println(d+ " "+p.getX()+" "+p.getY());
				p.setNeighbour(true);
				inList.set(ii, p);
				}
			
			}
		}
	}
	
	
	for (int i = 0; i < inList.size(); i ++){
		MyGeoPoint p = (MyGeoPoint) inList.get(i);
		if (p.isNeighbour()== false){
			//System.out.println(p.getLat());
			returnList.add(p);
		}
	}
	
	
	
	System.out.println(returnList.size()+" " +inList.size());
	
	return returnList;
}
}