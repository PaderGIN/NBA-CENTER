package ru.nvacenter.nbacenter.entity;

import ru.nvacenter.nbacenter.promotion.Cashbackable;

import java.math.BigDecimal;

public class GreenBankCard extends CreditCard implements Cashbackable {

    public GreenBankCard(BigDecimal balance, BigDecimal creditLimit) {
        super(balance, creditLimit);
    }

    @Override
    public Boolean pay(BigDecimal amountToDeducted) {
        Boolean transactionResult = super.pay(amountToDeducted);

        if (transactionResult) {
            BigDecimal cashback = amountToDeducted.multiply(new BigDecimal("0.01"));
            giveCashback(cashback);
            System.out.println(String.format("You've earned cashback! It's %s", cashback));
            return true;
        } else return false;
    }

    private void giveCashback(BigDecimal cashback) {
        super.addMoney(cashback);
    }
}
