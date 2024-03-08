package sk.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

public class Account {
    
    //we annotate the attribute that models the primary key with the @Id annotation
    @Id
    private long id;
    
    private String name;
    private BigDecimal amount;

    //getters
    public long getId() {return this.id;}
    public String getName() {return this.name;}
    public BigDecimal getAmount() {return this.amount;}

    //setters
    public void setId(long id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setAmount(BigDecimal amount) {this.amount = amount;}
}
