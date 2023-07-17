package br.jus.trern.payment.model;

public class PaymentRequest {
		
	private String idCompra;
	private String numeroCartao;
	private int mes;
	private int ano;
	private int cvv;
	private float totalCompra;
	private int numeroParcelas;
	
	public String getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(String idCompra) {
		this.idCompra = idCompra;
	}
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public float getTotalCompra() {
		return totalCompra;
	}
	public void setTotalCompra(float totalCompra) {
		this.totalCompra = totalCompra;
	}
	public int getNumeroParcelas() {
		return numeroParcelas;
	}
	public void setNumeroParcelas(int numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

}
