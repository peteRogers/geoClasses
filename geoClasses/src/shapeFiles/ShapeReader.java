package shapeFiles;

import java.awt.geom.GeneralPath;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;



import com.bbn.openmap.dataAccess.shape.DbfTableModel;
import com.bbn.openmap.dataAccess.shape.EsriGraphicList;
import com.bbn.openmap.dataAccess.shape.EsriPolygon;
import com.bbn.openmap.layer.shape.ESRIPoly;
import com.bbn.openmap.layer.shape.ESRIPolygonRecord;
import com.bbn.openmap.layer.shape.ESRIRecord;
import com.bbn.openmap.layer.shape.ShapeFile;
import com.bbn.openmap.omGraphics.geom.BasicGeometry;
import com.bbn.openmap.plugin.PlugInLayer;
import com.bbn.openmap.plugin.esri.EsriPlugIn;

public class ShapeReader {

	public ShapeReader() throws IOException{
		 File dbf = new File("data/TM_WORLD_BORDERS-0.3/TM_WORLD_BORDERS-0.3.dbf");
		 File shp = new File("data/TM_WORLD_BORDERS-0.3/TM_WORLD_BORDERS-0.3.shp");
		 File shx = new File("data/TM_WORLD_BORDERS-0.3/TM_WORLD_BORDERS-0.3.shx");
		 EsriPlugIn epi = new EsriPlugIn("name", dbf.toURI().toURL(), shp.toURI().toURL(), shx.toURI().toURL());
		PlugInLayer pil = new PlugInLayer();
		pil.setPlugIn(epi);
		ShapeFile sh = new ShapeFile(shp);
		
		ESRIPolygonRecord record = (ESRIPolygonRecord) sh.getNextRecord();
		ESRIPoly[] p = record.polygons;
		ESRIPoly poly = p[0];
		//System.out.println(poly.getX(0));

		
		
		
		//esri.getS

		
			
	
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new ShapeReader();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
