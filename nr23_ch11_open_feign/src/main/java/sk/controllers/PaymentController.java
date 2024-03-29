package sk.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sk.model.Payment;
import sk.proxy.PaymentProxy;

@RestController
public class PaymentController {
    
    private PaymentProxy paymentProxy;

    //inject the auto-implemented OpenFeign client
    public PaymentController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    //controller uses paymentProxy to call Payment service
    //which is a separate app 'sq-ch11-payments' running on separate port
    @PostMapping("/payment")
    public Payment createPayment(
        @RequestBody Payment payment
    ) {
        String requestId = UUID.randomUUID().toString();
        return paymentProxy.createPayment(requestId, payment);
    }
}
