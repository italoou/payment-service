package br.jus.trern.payment.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.jus.trern.payment.model.PaymentInfo;
import br.jus.trern.payment.service.PaymentService;

@Component
public class PaymentConsumer {

	@Autowired
	private PaymentService service;
	
	@RabbitListener(queues = "Local")
	private void consumer(PaymentInfo info) {
		
		service.pay(info);
		
	}
}
