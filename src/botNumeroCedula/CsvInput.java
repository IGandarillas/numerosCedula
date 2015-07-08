package botNumeroCedula;


import java.io.File;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * Read input file and returns it as Iterator
 * @author IGandarillas
 *
 */
	public class CsvInput {
		String path="";
		public CsvInput(String path){
			this.path=path;
		}

		public LineIterator ReadLog(){
			 File fichero = null;
		        try
		        {
		  
		            fichero = new File(path+"\\cedulas.csv");
		            LineIterator in = FileUtils.lineIterator(fichero, "UTF-8");
		    
		            return in;
		 
		        } catch (Exception e) {
		            e.printStackTrace();
		        } 
				return null;
		}
	}
