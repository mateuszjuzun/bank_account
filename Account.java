package edu.java;

import java.math.BigDecimal;

public class Account {

    private String number;

    private Person owner;

    private BigDecimal amount;



    public Account(String number, Person owner) {
        this.number = number;
        this.owner = owner;
        this.amount = BigDecimal.ZERO;
    }

    public BigDecimal deposit(BigDecimal value){
        this.amount = this.amount.add(value);
        return this.amount;

    }



    public String getNumber() {
        return number;
    }

    public Person getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", owner=" + owner +
                '}';
    }

}
