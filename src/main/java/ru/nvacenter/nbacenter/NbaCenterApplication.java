package ru.nvacenter.nbacenter;

import ru.nvacenter.nbacenter.entity.GreenBankCard;
import ru.nvacenter.nbacenter.entity.RedBankCard;

import java.math.BigDecimal;

public class NbaCenterApplication {

    public static void main(String[] args) {

        GreenBankCard greenBankCard = new GreenBankCard(new BigDecimal(0), new BigDecimal(10000));

        System.out.println(greenBankCard.getAllFunds());

        greenBankCard.pay(new BigDecimal(1000));

        System.out.println(greenBankCard.getAllFunds());

        RedBankCard redBankCard = new RedBankCard(new BigDecimal(10000));

        System.out.println(redBankCard.getAllFunds());

        redBankCard.pay(new BigDecimal(1000));

        System.out.println(redBankCard.getAllFunds());

        redBankCard.addMoney(new BigDecimal(1000));

        System.out.println(redBankCard.getAllFunds());

    }

}