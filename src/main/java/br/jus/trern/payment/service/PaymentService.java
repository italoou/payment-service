package br.jus.trern.payment.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.jus.trern.payment.constants.RabbitMQConstants;
import br.jus.trern.payment.model.Payment;
import br.jus.trern.payment.model.PaymentInfo;
import br.jus.trern.payment.model.PaymentRequest;
import br.jus.trern.payment.model.TransationState;
import br.jus.trern.payment.repository.PaymentRepository;

@Service
public class PaymentService {

	private PaymentRepository repository;
	
	private ObjectMapper objectMapper;

	public PaymentService(PaymentRepository repository, ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
		this.repository = repository;
	}
	
	public boolean pay(PaymentRequest info) {

		Payment payment = new Payment();
		
		payment.setAmount(info.getTotalCompra());
		payment.setInstallments(info.getNumeroParcelas());
		payment.setIdOfPurchase(info.getIdCompra());
		payment.setExpireCardMonth(info.getMes());
		payment.setExpireCardYear(info.getAno());
		payment.setVerificationCode(info.getCvv());
		payment.setDataOfPayment(LocalDateTime.now());
		
		LocalDate cardExpireDate = LocalDate.of(payment.getExpireCardYear(), payment.getExpireCardMonth(), 1);
		
		if(cardExpireDate.isAfter(LocalDate.now())) {
			System.out.println(cardExpireDate);
			System.out.println(LocalDate.now());

			if(payment.getVerificationCode() > 500) {
				
				if(info.getNumeroCartao().equals("1111222233334444")) {
					
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
	
	@RabbitListener(queues = RabbitMQConstants.FILA_PAGAMENTO_REQUEST)
	private void consumer(String paymentInfo) throws Exception {
		
		System.out.println("solicitação recebida");
		
		System.out.println(paymentInfo);
		
		PaymentRequest paymentRequest = objectMapper.readValue(paymentInfo, PaymentRequest.class);
		
		Optional<Payment> existPayment = repository.findById(Long.parseLong(paymentRequest.getIdCompra()));
		
		boolean result = false;
		
		if(existPayment.isPresent()) {
			throw new Exception("payment already process");
		}else {
			result = pay(paymentRequest);
		}
		
		System.out.println("Resultado do processamento: " + result);
				
	}
	
}
