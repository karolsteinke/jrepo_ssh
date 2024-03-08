package sk;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import sk.model.Account;
import sk.repositories.AccountRepository;
import sk.services.TransferService;

@SpringBootTest
public class TransferServiceSpringIntegrationTests {
    
    //*** ASSUMPTIONS ***
    //create and inject the mock instance
    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private TransferService transferService;

    @Test
    public void transferServiceTransferAmountTest() {
        
        //*** ASSUMPTIONS ***
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal(1000));

        //You can read this line as “If one calls the findById() method with the sender ID parameter, then return the sender account instance.”
        given(accountRepository.findById(1L)).willReturn(Optional.of(sender));
        given(accountRepository.findById(2L)).willReturn(Optional.of(receiver));

        //*** CALL ***
        //We call the method we want to test with the sender ID, destination ID, and the value to be transferred
        transferService.tranferMoney(1, 2, new BigDecimal(100));

        //*** VALIDATION ***
        //Verify that the changeAmount() method in the AccountRepository was called with the expected parameters
        verify(accountRepository).changeAmount(1, new BigDecimal(900));
        verify(accountRepository).changeAmount(2, new BigDecimal(1100));
    }
}
