package kg.itProject.itProject.service;

import kg.itProject.itProject.Entity.Payment;
import kg.itProject.itProject.model.PaymentRequest;

import java.util.List;

public interface PaymentService {

    Payment save(PaymentRequest p);

    Payment confirmContract(Long idPayment);

    List<Payment> getAllPaymentOfStudent(Long idStudent);

    List<Payment> getAllPaymentByParams(String login, String fullname, String status);

    List<Payment> getAllPayments();
}
