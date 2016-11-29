package br.com.relatorio.pdfjson.jrxml;

/**
 * @author gabriel
 * @since  2016-11-29
 * @see	   JsonPdfParecer
 * 
 * CLASSE COM O OBJETIVO DE MAPEAR O 
 * VETOR DE PONTUAÇÕES DINÂMICO,
 * QUE FAZ PARTE DO CORPO DO RELATÓRIO.
 * */

public class Pontuacao {
	
	private String numero;
	private String descricao;
	private String pontuacao;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(String pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
