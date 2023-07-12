package br.jus.trern.payment.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float amount;
	private	int installments;
	private LocalDateTime dataOfPayment;
	private String idOfPurchase;
	private int expireCardMonth;
	private int expireCardYear;
	private int verificationCode;
	private TransationState transationState;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getInstallments() {
		return installments;
	}
	public void setInstallments(int installments) {
		this.installments = installments;
	}
	public LocalDateTime getDataOfPayment() {
		return dataOfPayment;
	}
	public void setDataOfPayment(LocalDateTime dataOfPayment) {
		this.dataOfPayment = dataOfPayment;
	}
	public String getIdOfPurchase() {
		return idOfPurchase;
	}
	public void setIdOfPurchase(String idOfPurchase) {
		this.idOfPurchase = idOfPurchase;
	}
	public int getExpireCardMonth() {
		return expireCardMonth;
	}
	public void setExpireCardMonth(int expireCardMonth) {
		this.expireCardMonth = expireCardMonth;
	}
	public int getExpireCardYear() {
		return expireCardYear;
	}
	public void setExpireCardYear(int expireCardYear) {
		this.expireCardYear = expireCardYear;
	}
	public int getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(int verificationCode) {
		this.verificationCode = verificationCode;
	}
	public TransationState getTransationState() {
		return transationState;
	}
	public void setTransationState(TransationState transationState) {
		this.transationState = transationState;
	}
	
	
	
}
