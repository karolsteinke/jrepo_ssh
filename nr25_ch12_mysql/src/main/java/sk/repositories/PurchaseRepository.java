package sk.repositories;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sk.model.Purchase;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbc;

    //jdbc bean was autocreated by spring-boot, we will inject and use it here
    public PurchaseRepository(
        JdbcTemplate jdbc
    ) {
        this.jdbc = jdbc;
    }

    //method to store the data in database
    public void storePurchase(Purchase purchase) {
        //table 'purchase' is (id, product, price)
        String sql = "INSERT INTO purchase (product, price) VALUES (?, ?)";

        //'update' method allows to execute any query of data mutation
        jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
    }

    //method to return records from the database, in a list of Purchase object
    public List<Purchase> findAllPurchases() {
        String sql = "SELECT * FROM purchase";

        //define functional interface RowMapper, which we use with SELECT query 
        //to specify how to transform a row from ResultSet to 'Purchase' object
        //"r" is the ResultSet (the data you get from the database) - or is it a row?
        //"i" is an int representing the row number
        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };

        //'query' method returns List transformed from ResultSet, with a help of RowMapper
        return jdbc.query(sql, purchaseRowMapper);
    }    
}
