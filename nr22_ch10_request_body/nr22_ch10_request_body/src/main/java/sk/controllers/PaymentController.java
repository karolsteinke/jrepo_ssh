package sk.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;
import sk.model.PaymentDetails;

@RestController
public class PaymentController {
    
    private static Logger logger = Logger.getLogger(PaymentController.class.getName());

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(
        //we get the payment detials from the request body
        @RequestBody PaymentDetails paymentDetails) {
        
        //we log the amount of the payment in the server console
        logger.info("Received payment " + paymentDetails.getAmount());
        return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .body(paymentDetails);
    }
}
