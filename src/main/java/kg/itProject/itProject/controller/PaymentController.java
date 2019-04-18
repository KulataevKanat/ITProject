package kg.itProject.itProject.controller;


import kg.itProject.itProject.Entity.Payment;
import kg.itProject.itProject.model.PaymentRequest;
import kg.itProject.itProject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment addPayment(@RequestBody PaymentRequest p) {
        return paymentService.save(p);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @PutMapping("/confirm/{id}")
    public Payment confirmContract(@PathVariable Long id) {
        return paymentService.confirmContract(id);
    }

    @GetMapping("/student/{id}")
    public List<Payment> getPaymentsOfClient(@PathVariable Long id) {
        return paymentService.getAllPaymentOfStudent(id);
    }

    @GetMapping(params = {"login", "fullname", "status"}, value = "/search")
    public List<Payment> getPaymentsByParams(
            @RequestParam(value = "login", required = false) String login,
            @RequestParam(value = "fullname", required = false) String fullname,
            @RequestParam(value = "status", required = false) String status) {
        return paymentService.getAllPaymentByParams(login, fullname, status);
    }
}
