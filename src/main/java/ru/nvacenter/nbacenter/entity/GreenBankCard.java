package ru.nvacenter.nbacenter.entity;

import ru.nvacenter.nbacenter.promotion.Cashbackable;

import java.math.BigDecimal;

public class GreenBankCard extends CreditCard implements Cashbackable {

    public GreenBankCard(BigDecimal balance, BigDecimal creditLimit) {
        super(balance, creditLimit);
    }



}
