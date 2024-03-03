package sk.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.model.PaymentDetails;
import sk.services.PaymentService;

@RestController
public class PaymentController {
    
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment() {
        //If calling the service method succeeds, we return an HTTP response with status Accepted and the PaymentDetails instance as a response body.
        //If an exception of type NotEnoughMoneyException occurs, ExeptionControllerAdvice class is triggered
        PaymentDetails paymentDetails = paymentService.processPayment();
        return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .body(paymentDetails);
    }
}
