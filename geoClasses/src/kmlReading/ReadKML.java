package kmlReading;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Polygon;

public class ReadKML {
	public ReadKML() throws FileNotFoundException{
		 
		 Kml kml = Kml.unmarshal(new FileInputStream("data/19927.kml"));
		 Document document = (Document) kml.getFeature();
		 document.getId();
		 System.out.println( document.getDescription());
		 Polygon p = new Polygon();
		List l =  document.getFeature();
		for (int i = 0; i < document.getFeature().size(); i ++){
			Placemark place = (Placemark)document.getFeature().get(i);
			System.out.println(place.withDescription(place.getName()));
		}
		 
	}
	
	public static void main (String args[]){
		try {
			new ReadKML();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
