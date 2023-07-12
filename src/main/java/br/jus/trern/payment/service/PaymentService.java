package br.jus.trern.payment.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.trern.payment.model.Payment;
import br.jus.trern.payment.model.PaymentInfo;
import br.jus.trern.payment.model.TransationState;
import br.jus.trern.payment.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repository;

	public boolean pay(PaymentInfo info) {

		Payment payment = new Payment();
		
		payment.setAmount(info.amount());
		payment.setInstallments(info.installments());
		payment.setIdOfPurchase(info.idOfPurchase());
		payment.setExpireCardMonth(info.expireCardMonth());
		payment.setExpireCardYear(info.expireCardYear());
		payment.setVerificationCode(info.verificationCode());
		payment.setDataOfPayment(LocalDateTime.now());
		
		LocalDate cardExpireDate = LocalDate.of(info.expireCardYear(), info.expireCardMonth(), 1);
		
		if(cardExpireDate.isAfter(LocalDate.now())) {
			System.out.println(cardExpireDate);
			System.out.println(LocalDate.now());

			if(info.verificationCode() > 500) {
				
				if(info.cardNumber().equals("1111222233334444")) {
					
					payment.setTransationState(TransationState.SUCESSO);
					
					repository.save(payment);
					return true;

				}
			}
		}
		
		payment.setTransationState(TransationState.FALHA);

		repository.save(payment);
		
		return false;
				
	}
	
}
