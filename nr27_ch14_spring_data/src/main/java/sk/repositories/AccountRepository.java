package sk.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import sk.model.Account;

//the first generic type value is the type of the model class representing the table. The second is the type of the primary key field
//Spring Data auto-implements this interface and exposes a bean
//Watch out for naming! SQL Table name needs to be 'account' when using name 'account' here!
public interface AccountRepository extends CrudRepository<Account, Long>{
    
    //@Query annotation allows to introduce new queries
    //parameter’s name in the query should be the same as the method parameter’s name
    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findAccountsByName(String name);

    //we annotate the methods that define operations that change data with the @Modifying annotation.
    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void changeAmount(long id, BigDecimal amount);
}