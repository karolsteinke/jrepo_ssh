package sk.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.exceptions.NotEnoughMoneyException;
import sk.model.ErrorDetails;
import sk.model.PaymentDetails;
import sk.services.PaymentService;

@RestController
public class PaymentController {
    
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try {
            //try calling paymentServcie and we know it will throw an exception
            //If calling the service method succeeds, we return an HTTP response with status Accepted and the PaymentDetails instance as a response body.
            PaymentDetails paymentDetails = paymentService.processPayment();
            return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);

        }
        catch (NotEnoughMoneyException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money to make the payment");
            //If an exception of type NotEnoughMoneyException is thrown, we return an HTTP response with status Bad Request and an ErrorDetails instance as a body.
            return ResponseEntity
                .badRequest()
                .body(errorDetails);
        }
    }
}
