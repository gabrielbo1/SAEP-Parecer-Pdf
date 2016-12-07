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
 * 
 * */

public class JsonPdfParecerTest1 {
	public static final String teste = "{\"instituto\":\"InstitutodeInformatica-INF\",\"numProcesso\":\"23070.018035/2010-08\",\"sexo\":true,\"nomeProfessor\":\"JoséPereiradaSilva\",\"letraClasse\":\"D\",\"numNivel\":\"2\",\"listaPontuacao\":[{\"numero\":\"1\",\"descricao\":\"Obterumamédiaaritiméticaigualousuperior(40)pontosporano,noperíodoavaliado,noiteml-1AtividadesdeEnsino(\",\"pontuacao\":\"0,0\"},{\"numero\":\"2\",\"descricao\":\"Obterumamédiaaritméticaigualousuperioraoitenta(80)pontosporano,noperíodoavaliado,noitemI,AtividadesdeEnsino,doAnexoIIdaresolução,conformeestabeleceoArt.57daLeinº9394/96,de20/12/1996(LDB).\",\"pontuacao\":\"0,0\"},{\"numero\":\"3\",\"descricao\":\"Obterumamédiaaritméticaigualousuperioravinte(20)pontosporano,noperíodoavaliado,noitemII,ProduçãoIntelectual.,doAnexoIIdaresolução.\",\"pontuacao\":\"7,5\"},{\"numero\":\"4\",\"descricao\":\"Obtermédiafinaligualousuperioracincovírgulazero(5,0)nasavaliaçõesdocorpodiscente.\",\"pontuacao\":\"8,5\"},{\"numero\":\"5\",\"descricao\":\"Obternotaigualousuperioracincovírgulazero(5,0)naavaliaçãodaDiretoriadoINF/UFG.\",\"pontuacao\":\"10,0\"},{\"numero\":\"6\",\"descricao\":\"Obternotafinaligualousuperiorasetevírgulacinco(7,5)pontosnaavaliaçãodefinidanoArt.26daresolução.\",\"pontuacao\":\"0,5\"}],\"textoRodape\":\"Aanálisebaseou-senosArtigos21a33doCapítuloIIIdaResoluçãoCONSUNINº32/2013econsiderouos2últimosRADOCsanuaisaprovados(2014a2015),conformeoArtigo59daresolução.Comoodocentenãoatingiuomínimode20pontosexigidosnoitemIII,esselimitemínimofoireajustadopara40pontosconformeoParágrafo2doArt.27.Logo,apontuaçãoalcançadapelodocenteésuficienteparasatisfazeresteitem.\",\"cidade\":\"Goiânia\",\"estado\":\"GO\",\"dia\":\"04\",\"mes\":\"dezembro\",\"ano\":\"2016\",\"membroCad1\":\"DellerJamesFerreira\",\"membroCad2\":\"HumbertoJoséLongo\",\"presidenteCad\":\"JoãoCarlosdaSilva\"}";
	@Test
	public void testGerarRelatorio() throws JsonParseException, JsonMappingException, IOException, URISyntaxException, JRException{
		java.io.File file = new java.io.File( new java.io.File(".").getCanonicalPath() + "/PdfTestes/Teste1.pdf");
    	FileOutputStream in = new FileOutputStream(file) ;  
    	
    	in.write(new JsonPdfParecer().gerarRelatorio(teste));
    	in.close();
	    assertEquals(new java.io.File(new java.io.File(".").getCanonicalPath() + "/PdfTestes/Teste1.pdf").exists(), true);
	}
}
