package sk.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.exceptions.AccountNotFoundException;
import sk.model.Account;
import sk.repositories.AccountRepository;

@Service
public class TransferService {
    
    private final AccountRepository accountRepository;

    //Spring is smart and knows that if you requested a DI for a field with an interface type, it needs to find a bean that implements that interface.
    public TransferService(
        AccountRepository accountRepository
    ) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void tranferMoney(
        long idSender,
        long idReceiver,
        BigDecimal amount
    ) {
        Account sender = accountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException());
        Account receiver = accountRepository.findById(idReceiver).orElseThrow(() -> new AccountNotFoundException());

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public Iterable<Account> getAllAccounts() {
        //AccountRepository inherits this method from the Spring Data CrudRepository interface.
        return accountRepository.findAll();
    }

    public List<Account> findAccountsByName(String name) {
        return accountRepository.findAccountsByName(name);
    }
}
