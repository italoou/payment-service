package br.jus.trern.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.jus.trern.payment.model.PaymentInfo;
import br.jus.trern.payment.service.PaymentService;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@GetMapping
	public ResponseEntity<String> paymentGetInfo(@RequestBody PaymentInfo info){

		boolean result = service.pay(info);
		
		if(result == true) {
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
}
