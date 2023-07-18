package br.jus.trern.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.jus.trern.payment.model.Payment;
import br.jus.trern.payment.model.PaymentInfo;
import br.jus.trern.payment.service.PaymentService;
import jakarta.websocket.server.PathParam;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> paymentGetInfo(@PathVariable Long id){

		Payment payment = service.getPayment(id);
		
		if(payment != null) {
			return new ResponseEntity<>(payment, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Não há pagamento com o ID informado", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/health")
	public ResponseEntity<?> healt(){
		return new ResponseEntity<>("PaymentService is Running", HttpStatus.OK);
	}
}
