package br.jus.trern.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jus.trern.payment.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
