package br.com.relatorio.pdfjson.jrxml;

import java.io.InputStream;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


/**
 * @author gabriel
 * @since  2016-11-29
 *  
 * CLASSE COM O OBJETIVO DE MAPEAR O 
 * RELATÓRIO DE JSON/PDF SENDO QUE 
 * A MESMA SERVE PARA DAR FORMA AO 
 * JSON DA API DO RELARÓRIO. 
 * */

public class JsonPdfParecer {
	private String  instituto;
	private String  numProcesso;
	private boolean sexo;
	private String  nomeProfessor;
	private String  letraClasse;
	private String  numNivel;
	private List<Pontuacao> listaPontuacao;
	private String  textoRodape;
	private String  cidade;
	private String  estado;
	private String  dia;
	private String  mes;
	private String  ano;
	private String  membroCad1;
	private String  membroCad2;
	private String  presidenteCad;
	
	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	public String getNumProcesso() {
		return numProcesso;
	}

	public void setNumProcesso(String numProcesso) {
		this.numProcesso = numProcesso;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getLetraClasse() {
		return letraClasse;
	}

	public void setLetraClasse(String letraClasse) {
		this.letraClasse = letraClasse;
	}

	public String getNumNivel() {
		return numNivel;
	}

	public void setNumNivel(String numNivel) {
		this.numNivel = numNivel;
	}

	public List<Pontuacao> getListaPontuacao() {
		return listaPontuacao;
	}

	public void setListaPontuacao(List<Pontuacao> listaPontuacao) {
		this.listaPontuacao = listaPontuacao;
	}

	public String getTextoRodape() {
		return textoRodape;
	}

	public void setTextoRodape(String textoRodape) {
		this.textoRodape = textoRodape;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getMembroCad1() {
		return membroCad1;
	}

	public void setMembroCad1(String membroCad1) {
		this.membroCad1 = membroCad1;
	}

	public String getMembroCad2() {
		return membroCad2;
	}

	public void setMembroCad2(String membroCad2) {
		this.membroCad2 = membroCad2;
	}

	public String getPresidenteCad() {
		return presidenteCad;
	}

	public void setPresidenteCad(String presidenteCad) {
		this.presidenteCad = presidenteCad;
	}
	
	public void gerarRelatorio(String json ) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapa        = new ObjectMapper();
		JsonPdfParecer relatorio = mapa.readValue(json, JsonPdfParecer.class);
		
		InputStream fonte = JsonPdfParecer.class.getResourceAsStream("");
		
	}
}


