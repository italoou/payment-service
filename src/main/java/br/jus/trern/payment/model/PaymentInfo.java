package br.jus.trern.payment.model;

public record PaymentInfo(
		float amount, 
		int installments, 
		String idOfPurchase, 
		String cardNumber,
		int expireCardMonth, 
		int expireCardYear, 
		int verificationCode) {}
