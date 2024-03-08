package sk;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;

import sk.model.Account;
import sk.repositories.AccountRepository;
import sk.services.TransferService;
import sk.exceptions.AccountNotFoundException;

@ExtendWith(MockitoExtension.class)
public class TransferServiceUnitTests {
    
    //*** ASSUMPTIONS ***
    //create and inject the mock instance
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TransferService transferService;

    @Test
    @DisplayName("Test the amount is transferred from one account to another if no exception occurs.")
    public void moneyTransferHappyFlow() {
        
        //*** ASSUMPTIONS ***
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal(1000));

        //You can read this line as “If one calls the findById() method with the sender ID parameter, then return the sender account instance.”
        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.getId())).willReturn(Optional.of(receiver));

        //*** CALL ***
        //We call the method we want to test with the sender ID, destination ID, and the value to be transferred
        transferService.tranferMoney(sender.getId(), receiver.getId(), new BigDecimal(100));

        //*** VALIDATION ***
        //Verify that the changeAmount() method in the AccountRepository was called with the expected parameters
        verify(accountRepository).changeAmount(1, new BigDecimal(900));
        verify(accountRepository).changeAmount(2, new BigDecimal(1100));
    }

    @Test
    public void moneyTransferDestinationAccountNotFoundFlow() {
        
        //*** ASSUMPTIONS ***
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        //We control the mock AccountRepository to return an empty Optional when the findById() method is called for the destination account
        given(accountRepository.findById(1L)).willReturn(Optional.of(sender));
        given(accountRepository.findById(2L)).willReturn(Optional.empty());

        //*** CALL ***
        //We assert that the method throws an AccountNotFoundException in the given scenario.
        //Does this call test if exception is thrown or does it assume it anyway?
        assertThrows(
            AccountNotFoundException.class,
            () -> transferService.tranferMoney(1, 2, new BigDecimal(100))
        );

        //*** VALIDATION ***
        //We use the verify() method with the never() conditional to assert that the changeAmount() method hasn’t been called
        verify(accountRepository, never()).changeAmount(anyLong(), any());
    }
}
