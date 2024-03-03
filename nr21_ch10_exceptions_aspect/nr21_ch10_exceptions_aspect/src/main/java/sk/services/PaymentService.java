package sk.services;

import sk.exceptions.NotEnoughMoneyException;
import sk.model.PaymentDetails;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    
    public PaymentDetails processPayment() {
        //to simplyfy - it allways throws an exceptions
        //normally it would return proper PaymentDetails class
        throw new NotEnoughMoneyException();
    }
}
