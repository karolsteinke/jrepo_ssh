package sk.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import sk.model.Payment;

//@FeignClient tells OpenFeign client to auto-implement this contract (=interface)
//this interface is also called OpenFeign client
//${name.service.url} is defined in application.properties file

@FeignClient(name = "payments", url = "${name.service.url}")
public interface PaymentProxy {
    
    @PostMapping("/payment")
    Payment createPayment(
        @RequestHeader String requestId,
        @RequestBody Payment payment);
}
