package shapeFiles;

	import com.bbn.openmap.LatLonPoint;
import com.bbn.openmap.proj.coords.UTMPoint;

import diewald_shapeFile.files.dbf.DBF_Field;
import diewald_shapeFile.files.dbf.DBF_File;
import diewald_shapeFile.files.shp.SHP_File;
import diewald_shapeFile.files.shp.shapeTypes.ShpPolygon;
import diewald_shapeFile.files.shp.shapeTypes.ShpShape;
import diewald_shapeFile.files.shx.SHX_File;
import diewald_shapeFile.shapeFile.ShapeFile;

	public class ShapeFileReader_TEST {

	  public static void main(String[] args) {
		
		  
	    DBF_File.LOG_INFO           = !false;
	    DBF_File.LOG_ONLOAD_HEADER  = false;
	    DBF_File.LOG_ONLOAD_CONTENT = false;
	    
	    SHX_File.LOG_INFO           = !false;
	    SHX_File.LOG_ONLOAD_HEADER  = false;
	    SHX_File.LOG_ONLOAD_CONTENT = false;
	    
	    SHP_File.LOG_INFO           = !false;
	    SHP_File.LOG_ONLOAD_HEADER  = false;
	    SHP_File.LOG_ONLOAD_CONTENT = false;
	    

	    try {
	      // GET DIRECTORY
	      String curDir = System.getProperty("user.dir");
	      String folder = "/data/tallBuildingData/";
	      
	      // LOAD SHAPE FILE (.shp, .shx, .dbf)
	      ShapeFile shapefile = new ShapeFile(curDir+folder, "london_p").READ();
	      double[][] dd =  shapefile.getSHP_boundingBox();
	     System.out.println( dd[0][0]);
	     System.out.println( dd[0][1]);
	     System.out.println( dd[1][0]);
	     System.out.println( dd[1][1]);
	     System.out.println( dd[2][0]);
	     System.out.println( dd[2][1]);
	   
	      // TEST: printing some content
	      ShpShape.Type shape_type = shapefile.getSHP_shapeType();
	      System.out.println("\nshape_type = " +shape_type);
	    
	      int number_of_shapes = shapefile.getSHP_shapeCount();
	      int number_of_fields = shapefile.getDBF_fieldCount();
	  
	      for(int i = 0; i < number_of_shapes; i++){
	        ShpPolygon shape    = shapefile.getSHP_shape(i);
	        String[] shape_info = shapefile.getDBF_record(i);
	  
	        ShpShape.Type type     = shape.getShapeType();
	        int number_of_vertices = shape.getNumberOfPoints();
	        int number_of_polygons = shape.getNumberOfParts();
	        int record_number      = shape.getRecordNumber();
	        double[][] d = shape.getPoints();
	        double[] m = shape.getMeasureValues();
	        System.out.println(" foof "+m[0]);
	        for (int ii = 0; ii < d.length; ii ++){
	        	System.out.println(d[ii][0]);
	        	System.out.println(d[ii][1]);
	        	//System.out.println(d[ii][2]);
	        	//System.out.println(d[ii][3]);
	        	UTMPoint p = new UTMPoint();
	        	p.easting = 322859.88f + (float)d[ii][1];
	        	p.northing = 5741114.5f;
	        	p.zone_number =31;
	        	p.zone_letter = 'U';
	        	LatLonPoint l = p.toLatLonPoint();
	        	System.out.println(l.getLatitude());
	        	System.out.println(l.getLongitude());
	        	//UTMPoint p = new UTMPoint()
	        	break;
	        }
	        System.out.printf("\nSHAPE[%2d] - %s\n", i, type);
	        System.out.printf("  (shape-info) record_number = %3d; vertices = %6d; polygons = %2d\n", record_number, number_of_vertices, number_of_polygons);
	        
	        for(int j = 0; j < number_of_fields; j++){
	          String data = shape_info[j].trim();
	          DBF_Field field = shapefile.getDBF_field(j);
	          String field_name = field.getName();
	          System.out.printf("  (dbase-info) [%d] %s = %s", j, field_name, data);
	        }
	        System.out.printf("\n");
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

	}
