package br.com.relatorio.pdfjson.jrxml;

import static junit.framework.TestCase.assertEquals;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.Test;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import net.sf.jasperreports.engine.JRException;


/**
 *Teste com um caso de radoque enviado no material de apoio do projeto
 * mas agora com o sexo do professor como feminino, relatorio devera mudar 
 * as preposições para o feminino.
 * */

public class JsonPdfParecerTest2 {
	public static final String teste = "{\"instituto\":\"InstitutodeInformatica-INF\",\"numProcesso\":\"23070.018035/2010-08\",\"sexo\":false,\"nomeProfessor\":\"Sand Luz Correa\",\"letraClasse\":\"D\",\"numNivel\":\"2\",\"listaPontuacao\":[{\"numero\":\"1\",\"descricao\":\"Obterumamédiaaritiméticaigualousuperior(40)pontosporano,noperíodoavaliado,noiteml-1AtividadesdeEnsino(\",\"pontuacao\":\"0,0\"},{\"numero\":\"2\",\"descricao\":\"Obterumamédiaaritméticaigualousuperioraoitenta(80)pontosporano,noperíodoavaliado,noitemI,AtividadesdeEnsino,doAnexoIIdaresolução,conformeestabeleceoArt.57daLeinº9394/96,de20/12/1996(LDB).\",\"pontuacao\":\"0,0\"},{\"numero\":\"3\",\"descricao\":\"Obterumamédiaaritméticaigualousuperioravinte(20)pontosporano,noperíodoavaliado,noitemII,ProduçãoIntelectual.,doAnexoIIdaresolução.\",\"pontuacao\":\"7,5\"},{\"numero\":\"4\",\"descricao\":\"Obtermédiafinaligualousuperioracincovírgulazero(5,0)nasavaliaçõesdocorpodiscente.\",\"pontuacao\":\"8,5\"},{\"numero\":\"5\",\"descricao\":\"Obternotaigualousuperioracincovírgulazero(5,0)naavaliaçãodaDiretoriadoINF/UFG.\",\"pontuacao\":\"10,0\"},{\"numero\":\"6\",\"descricao\":\"Obternotafinaligualousuperiorasetevírgulacinco(7,5)pontosnaavaliaçãodefinidanoArt.26daresolução.\",\"pontuacao\":\"0,5\"}],\"textoRodape\":\"A análise baseou-se nos Artigos 21 a 33 do Capítulo III da Resolução CONSUNI Nº 32/2013 e considerou os 2 últimos RADOCs anuais aprovados (2014 a 2015), conforme o Artigo 59 da resolução. Como o docente não atingiu o mínimo de 20 pontos exigidos no item III, esse limite mínimo foi reajustado para 40 pontos, conforme o Parágrafo 2 do Art. 27. Logo, a pontuação alcançada pelo docente é suficiente para satisfazer este item.\",\"cidade\":\"Goiânia\",\"estado\":\"GO\",\"dia\":\"04\",\"mes\":\"dezembro\",\"ano\":\"2016\",\"membroCad1\":\"DellerJamesFerreira\",\"membroCad2\":\"HumbertoJoséLongo\",\"presidenteCad\":\"JoãoCarlosdaSilva\"}";
	@Test
	public void testGerarRelatorio() throws JsonParseException, JsonMappingException, IOException, URISyntaxException, JRException{
		java.io.File file = new java.io.File( new java.io.File(".").getCanonicalPath() + "/PdfTestes/Teste2.pdf");
    	FileOutputStream in = new FileOutputStream(file) ;  
    	
    	in.write(new JsonPdfParecer().gerarRelatorio(teste));
    	in.close();
	    assertEquals(new java.io.File(new java.io.File(".").getCanonicalPath() + "/PdfTestes/Teste2.pdf").exists(), true);
	}
}
