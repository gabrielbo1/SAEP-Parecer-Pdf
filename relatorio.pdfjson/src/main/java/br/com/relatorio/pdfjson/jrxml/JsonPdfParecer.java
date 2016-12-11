package br.com.relatorio.pdfjson.jrxml;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import java.awt.Image;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * @author gabriel
 * @since 2016-11-29
 * 
 *        CLASSE COM O OBJETIVO DE MAPEAR O RELATÓRIO DE JSON/PDF SENDO QUE A
 *        MESMA SERVE PARA DAR FORMA AO JSON DA API DO RELARÓRIO.
 */

public class JsonPdfParecer {
	private final String numRomano[] = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII",
			"XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI",
			"XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
			"XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L" };

	private String instituto;
	private String numProcesso;
	private boolean sexo;
	private String nomeProfessor;
	private String letraClasse;
	private String numNivel;
	private List<Pontuacao> listaPontuacao;
	private String textoRodape;
	private String cidade;
	private String estado;
	private String dia;
	private String mes;
	private String ano;
	private String membroCad1;
	private String membroCad2;
	private String presidenteCad;

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
	public byte[] gerarRelatorio(String json)
			throws JsonParseException, JsonMappingException, IOException, JRException, URISyntaxException {
		
		/**OBJETO DA BIBLIOTECA JACKSON QUE REALIZA O PARSER DE JSON->OBJECT*/
		ObjectMapper mapa = new ObjectMapper();
		
		/**PARSER*/
		JsonPdfParecer relatorioDataBind = mapa.readValue(json, JsonPdfParecer.class);
		
		/**CARREGA O RELATORIO DO DISCO*/
		JasperReport relatorio = (JasperReport) JRLoader
				.loadObject(JsonPdfParecer.class.getResource("/br/com/relatorio/pdfjson/jrxml/jsonPdfParecer.jasper"));
		
		/** NUMEROS ROMANOS DE CADA ITEM DA PONTUACAO */
		for (int i = 0; i < relatorioDataBind.getListaPontuacao().size(); i++)
			relatorioDataBind.getListaPontuacao().get(i).setNumero(this.numRomano[i]);
		
		Image logo = new ImageIcon(getClass().getResource("/br/com/relatorio/pdfjson/jrxml/logo.jpg")).getImage();
		
		/**PASSA OS PARAMETROS EXIGIDOS PELO RELATORIO*/
		Map parametros = new HashMap();
		parametros.put("instituto", relatorioDataBind.getInstituto());
		parametros.put("numProcesso", relatorioDataBind.getNumProcesso());
		parametros.put("sexo", relatorioDataBind.isSexo());
		parametros.put("nomeProfessor", relatorioDataBind.getNomeProfessor());
		parametros.put("letraClasse", relatorioDataBind.getLetraClasse());
		parametros.put("textoRodapeDinamico", relatorioDataBind.getTextoRodape());
		parametros.put("numNivel", relatorioDataBind.getNumNivel());
		parametros.put("cidade", relatorioDataBind.getCidade());
		parametros.put("estado", relatorioDataBind.getEstado());
		parametros.put("dia", relatorioDataBind.getDia());
		parametros.put("mes", relatorioDataBind.getMes());
		parametros.put("ano", relatorioDataBind.getAno());
		parametros.put("membroCad1", relatorioDataBind.getMembroCad1());
		parametros.put("membroCad2", relatorioDataBind.getMembroCad2());
		parametros.put("presidenteCad", relatorioDataBind.getPresidenteCad());
		parametros.put("foto", logo);

		JasperPrint print = JasperFillManager.fillReport(relatorio, parametros,
				new JRBeanCollectionDataSource((Collection<Pontuacao>) relatorioDataBind.getListaPontuacao()));
		byte[] bytes = JasperExportManager.exportReportToPdf(print);
		return bytes;
	}
}
