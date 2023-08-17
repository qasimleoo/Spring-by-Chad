package com.example.AOPDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing My DB work: Adding an account.");
    }
}
