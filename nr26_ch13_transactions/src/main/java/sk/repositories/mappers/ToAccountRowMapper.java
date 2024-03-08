package sk.repositories.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sk.model.Account;

public class ToAccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet r, int i) throws SQLException {
        Account a = new Account();
        a.setId(r.getInt("id"));
        a.setName(r.getString("name"));
        a.setAmount(r.getBigDecimal("amount"));
        return a;
    }
}
