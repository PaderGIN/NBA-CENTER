package ru.nvacenter.nbacenter.entity;

import ru.nvacenter.nbacenter.promotion.Bonusable;
import ru.nvacenter.nbacenter.promotion.Depositable;

import java.math.BigDecimal;

public class RedBankCard extends DebitCard implements Bonusable, Depositable {

    public RedBankCard(BigDecimal balance) {
        super(balance);
    }

    @Override
    public void addMoney(BigDecimal amount) {
        amount = amount.multiply(new BigDecimal("1.005"));
        super.addMoney(amount);
    }
}
