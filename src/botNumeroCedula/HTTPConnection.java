package botNumeroCedula;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

/**
 * Make a webClient, then
 * Sets connection with the server.
 * And get data.
 * @author IGandarillas
 *
 */
public class HTTPConnection {
	private WebClient wb;

	public HTTPConnection(){
		//Config webClient
		wb = new WebClient();
		wb.waitForBackgroundJavaScript(1000);
		wb.getCookieManager().setCookiesEnabled(true);//!important
		wb.getOptions().setJavaScriptEnabled(true);//!Important
		wb.getOptions().setCssEnabled(false);
	    wb.getOptions().setUseInsecureSSL(true);
	    wb.getOptions().setThrowExceptionOnScriptError(false);
		wb.getOptions().setThrowExceptionOnFailingStatusCode(false);
		wb.setAjaxController(new NicelyResynchronizingAjaxController()); //!Imporant
		//Avoid warning log
	    java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
		java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

	}
	/**
	 * Load a url
	 * @param url String
	 * @return
	 */
	public HtmlPage loadURL(String url){
		try {
			return wb.getPage(url);
		
		} catch (FailingHttpStatusCodeException | IOException e) {
			System.out.println("Error al cargar la página");
			e.printStackTrace();
		}
		return null;
	}
	
/**
 * Get form, set attributes and submit.
 * @param page
 * @param cedula
 * @return HtmlPage with the new data
 * @throws IOException
 */
	public HtmlPage inCedula(HtmlPage page,String cedula) throws IOException{
		
		HtmlInput cedulaInput = (HtmlInput) page.getElementById("f1:nroDocto");
		cedulaInput.setValueAttribute(cedula);		
		HtmlForm form = page.getForms().get(0);
		HtmlSubmitInput submit = form.getInputByValue("Consultar");
		return (HtmlPage) submit.click();
	}
	/**
	 * Get every field data and make a person with them.
	 * @param page
	 * @param p
	 * @return
	 */
	public Persona getData(HtmlPage page,Persona p) {
		try{
			
			HtmlElement ele;
			
			ele = (HtmlElement) page.getByXPath("//*[@id='pg1']/tbody/tr/td/table/tbody/tr[1]/td[2]").get(0); //Field 1
			p.setFechaIngreso(ele.asText());
			ele = (HtmlElement) page.getByXPath("//*[@id='pg1']/tbody/tr/td/table/tbody/tr[2]/td[2]").get(0); //Field 2
			p.setCedula(ele.asText());
			ele = (HtmlElement) page.getByXPath("//*[@id='pg1']/tbody/tr/td/table/tbody/tr[3]/td[2]").get(0);
			p.setNombre(ele.asText());
			ele = (HtmlElement) page.getByXPath("//*[@id='pg1']/tbody/tr/td/table/tbody/tr[4]/td[2]").get(0);
			p.setApellidos(ele.asText());
			ele = (HtmlElement) page.getByXPath("//*[@id='pg1']/tbody/tr/td/table/tbody/tr[5]/td[2]").get(0);
			p.setDepartamento(ele.asText());			
			ele = (HtmlElement) page.getByXPath("//*[@id='pg1']/tbody/tr/td/table/tbody/tr[6]/td[2]").get(0);
			p.setMunicipio(ele.asText());
			ele = (HtmlElement) page.getByXPath("//*[@id='pg1']/tbody/tr/td/table/tbody/tr[7]/td[2]").get(0);
			p.setNombrePuesto(ele.asText());
			ele = (HtmlElement) page.getByXPath("//*[@id='pg1']/tbody/tr/td/table/tbody/tr[8]/td[2]").get(0); //Field N.
			p.setDireccionPuesto(ele.asText());			
			
			return p;
			
		}catch(com.gargoylesoftware.htmlunit.ElementNotFoundException | IndexOutOfBoundsException e){
			System.out.println("No se ha encontrado  en Page"); //If Cedula not exists
		}
		return null;
		
	}
	

}
