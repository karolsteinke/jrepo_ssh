package sk.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sk.dto.TransferRequest;
import sk.model.Account;
import sk.services.TransferService;

@RestController
public class AccountController {
    
    private final TransferService transferService;

    public AccountController(
        TransferService transferService
    ) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(
        //we use an object of type TransferRequest as the transferMoney() controller action parameter
        //TransferRequest is DTO
        @RequestBody TransferRequest request
    ) {
        transferService.trasferMoney(
            request.getSenderAccountId(),
            request.getReceiverAccountId(),
            request.getAmount()
        );

        //***TEST*** curl -X POST http://localhost:8080/transfer -H "Content-Type: application/json" -d "{\"senderAccountId\":1, \"receiverAccountId\":2, \"amount\": 199.0}"
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return transferService.getAllAccounts();

        //*** TEST *** curl http://localhost:8080/accounts
    }
}
