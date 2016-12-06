package br.com.relatorio.pdfjson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.relatorio.pdfjson.jrxml.JsonPdfParecer;
import net.sf.jasperreports.engine.JRException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JsonParseException, JsonMappingException, IOException, JRException
    {	
    	ObjectMapper mapper = new ObjectMapper();
    	
    	JsonPdfParecer json  = mapper.readValue(new File(".").getAbsolutePath() + "/br/com/relatorio/pdfjson/Teste.json", JsonPdfParecer.class);
    	String jsonInString = mapper.writeValueAsString(json);
    	
    	java.io.File file = new java.io.File("C:\\Teste.pdf");
    	FileOutputStream in = new FileOutputStream(file) ;  
    	
    	in.write(new JsonPdfParecer().gerarRelatorio(jsonInString));
    	in.close();
        
        
    }
}
