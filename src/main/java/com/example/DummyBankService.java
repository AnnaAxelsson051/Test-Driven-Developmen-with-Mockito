package com.example;

public class DummyBankService implements BankService {
    @Override
    public void pay(String Id, double amount) {
        throw new RuntimeException("Not implemented dummy");
    }
}
