package kg.itProject.itProject.service;

import kg.itProject.itProject.Entity.Payment;
import kg.itProject.itProject.Entity.Student;
import kg.itProject.itProject.model.PaymentRequest;
import kg.itProject.itProject.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private StudentService studentService;


    @Override
    public Payment save(PaymentRequest p) {
        Student student = studentService.getStudentByLogin(p.getLogin());
        if (student != null) {
            Payment payment = new Payment(student, p.getSum());
            return paymentRepository.save(payment);
        }
        return null;
    }

    @Override
    public Payment confirmContract(Long idPayment) {
        Payment payment = paymentRepository.findById(idPayment).get();
        payment.setStatus("Оплата успешно завершена");
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPaymentOfStudent(Long idStudent) {
        return paymentRepository.getStudentPayments(idStudent);
    }

    @Override
    public List<Payment> getAllPaymentByParams(String login, String fullname, String status) {
        return paymentRepository.getPaymentsByParam(login, fullname, status);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
