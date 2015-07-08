package botNumeroCedula;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.LineIterator;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class botLauncher {
	private static final String url = "http://inscripcionelectoral.carvajal.com:8280/srvidc-webcon/";
	public static void main(String[] args) throws IOException {
		
		String path = new File (".").getCanonicalPath(); //Path current folder
		
		HTTPConnection connect = new HTTPConnection(); //Init Http Dialog
		HtmlPage page = connect.loadURL(url); //Request url		 
	
		CsvInput in = new CsvInput(path);//Get cedulas.csv file
		LineIterator it =  in.ReadLog(); //Get cedulas iterator.
		
		CsvOutput out = new CsvOutput(path); 
		
		Persona p;
				
		while(it.hasNext()){			
			//while hasNext cedula number, make a person a save data as csv
			page=connect.inCedula(page, String.valueOf(it.next()));
			
				p = (Persona) connect.getData(page,new Persona());
				
				if(p!=null){				
					out.writeLog(p.getFechaIngreso());
					out.writeLog(";",p.getCedula(),";");
					out.writeLog(p.getNombre());
					out.writeLog(";",p.getApellidos(),";");
					out.writeLog(p.getDepartamento());
					out.writeLog(";",p.getMunicipio(),";");
					out.writeLog(p.getNombrePuesto());
					out.writeLog(";",p.getDireccionPuesto(),"");
					out.writeLog("\n");
					System.out.println(p.getNombre()+" "+p.getCedula()); 
				}
		}
	}

}
