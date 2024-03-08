package sk.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.model.Account;
import sk.repositories.AccountRepository;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(
        AccountRepository accountRepository
    ) {
        this.accountRepository = accountRepository;
    }
    
    //we use the @Transactional annotation to instruct Spring to wrap the method’s calls in transactions
    @Transactional
    public void trasferMoney(
        long idSender,
        long idReceiver,
        BigDecimal amount
    ) {
        Account sender = accountRepository.findAccountById(idReceiver);
        Account receiver = accountRepository.findAccountById(idReceiver);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);

        //exception test to see if transaction works
        //throw new RuntimeException("Oh no! Something went wrong!");
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}
