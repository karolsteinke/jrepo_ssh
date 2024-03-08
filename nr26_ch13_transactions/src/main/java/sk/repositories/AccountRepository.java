package sk.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sk.model.Account;
import sk.repositories.mappers.ToAccountRowMapper;

@Repository
public class AccountRepository {
    
    private final JdbcTemplate jdbc;

    public AccountRepository(
        JdbcTemplate jdbc
    ) {
        this.jdbc = jdbc;
    }

    public Account findAccountById(long id) {
        String sql = "SELECT * FROM accounts WHERE id = ?";
        //we provide a RowMapper to tell JdbcTemplate how to map a row in the result to our model object
        return jdbc.queryForObject(sql, new ToAccountRowMapper(), id);
    }

    public void changeAmount(long id, BigDecimal amount) {
        String sql = "UPDATE accounts SET amount = ? WHERE id = ?";
        jdbc.update(sql, amount, id);
    }

    public List<Account> findAllAccounts() {
        String sql = "SELECT * FROM accounts";
        return jdbc.query(sql, new ToAccountRowMapper());
    }
}
