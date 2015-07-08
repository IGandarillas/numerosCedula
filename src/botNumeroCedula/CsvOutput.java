package botNumeroCedula;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Save obtained data in log.csv
 * @author IGandarillas
 *
 */
public class CsvOutput {
	String path="";
	
	public CsvOutput(String path){
		this.path=path;
	}
	
	public void writeLog(String msg){
		writeLog("",msg,"");
	}
	
	public void writeLog(String headcsv, String msg,String tailcsv){
		 FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter(path+"\\log.csv",true);
	            pw = new PrintWriter(fichero);	 
	                 pw.print(headcsv+msg+tailcsv);
	 
	        } catch (Exception e) {
	            e.printStackTrace();	        
	        }
	}
}
