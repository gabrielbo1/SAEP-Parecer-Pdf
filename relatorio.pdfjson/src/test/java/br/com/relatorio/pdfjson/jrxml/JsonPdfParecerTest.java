package br.com.relatorio.pdfjson.jrxml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import net.sf.jasperreports.engine.JRException;

/**
 * Testa se todos os campos estao funcionando corretamente,
 * com todos os parametros passados ao relatorio.
 * 
 * */

public class JsonPdfParecerTest{
	
	public static final String teste = "{\"instituto\":\"Instituto de Informatica - INF\",\"numProcesso\":\"123456\",\"sexo\":true,\"nomeProfessor\":\"Gabriel Barbosa de Oliveira\",\"letraClasse\":\"A\",\"numNivel\":\"10\",\"listaPontuacao\":[{\"numero\": \"1\",\"descricao\":\"DESCRICAO 1\", \"pontuacao\":\"PONTUACAO 1\" }, {\"numero\": \"2\",\"descricao\":\"DESCRICAO 2\", \"pontuacao\":\"PONTUACAO 2\" }],\"textoRodape\":\"TEXTO DO RODAPE\",\"cidade\":\"Goiania\",\"estado\":\"Goias\",\"dia\":\"04\",\"mes\":\"10\",\"ano\":\"1996\",\"membroCad1\":\"NOME DO MEMBRO DA CAD1\",\"membroCad2\":\"NOME DO MEMBRO DA CAD2\",\"presidenteCad\":\"NOME DO PRESIDENTE DA CAD\"}";
	
	@Test
	public void testGerarRelatorio() throws JsonParseException, JsonMappingException, IOException, URISyntaxException, JRException{
		java.io.File file = new java.io.File( new java.io.File(".").getCanonicalPath() + "/PdfTestes/Teste.pdf");
    	FileOutputStream in = new FileOutputStream(file) ;  
    	
    	in.write(new JsonPdfParecer().gerarRelatorio(teste));
    	in.close();
	    assertEquals(new java.io.File(new java.io.File(".").getCanonicalPath() + "/PdfTestes/Teste.pdf").exists(), true);
	}
}
