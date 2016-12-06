package br.com.relatorio.pdfjson.jrxml;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public byte[] gerarRelatorio(String json ) throws JsonParseException, JsonMappingException, IOException, JRException{
	
		ObjectMapper mapa = new ObjectMapper();
		JsonPdfParecer relatorioDataBind = mapa.readValue(json, JsonPdfParecer.class);
		
		 JasperReport report = JasperCompileManager.compileReport(new File(".").getAbsolutePath() + "/br/com/relatorio/pdfjson/jsonPdfParecer.jrxml");
		
		Map parametros = new HashMap();
		 
		 /**PARAMETROS DO RELATORIO*/
		 parametros.put("instituto", relatorioDataBind.getInstituto());
		 parametros.put("numProcesso", relatorioDataBind.getNumProcesso());
		 parametros.put("sexo", relatorioDataBind.isSexo());
		 parametros.put("sexo", relatorioDataBind.getNomeProfessor());
		 parametros.put("nomeProfessor", relatorioDataBind.getNomeProfessor());
		 parametros.put("letraClasse", relatorioDataBind.getLetraClasse());
		 parametros.put("numNivel", relatorioDataBind.getNumNivel());
		 parametros.put("cidade", relatorioDataBind.getCidade());
		 parametros.put("estado", relatorioDataBind.getEstado());
		 parametros.put("mes", relatorioDataBind.getMes());
		 parametros.put("ano", relatorioDataBind.getAno());
		 parametros.put("membroCad1", relatorioDataBind.getMembroCad1());
		 parametros.put("membroCad2", relatorioDataBind.getMembroCad2());
		 parametros.put("presidenteCad", relatorioDataBind.getPresidenteCad());
		 
		
		JasperPrint print = JasperFillManager.fillReport(report, parametros, new JRBeanCollectionDataSource((Collection<Pontuacao>) relatorioDataBind.getListaPontuacao()));
		 byte[] bytes = JasperExportManager.exportReportToPdf(print);
		 return bytes;
	}
}


