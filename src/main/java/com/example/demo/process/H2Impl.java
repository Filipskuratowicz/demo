package com.example.demo.process;

import com.example.demo.database.UserOrder;

public interface H2Impl {


    UserOrder getOrder(int id);

    void saveOrder(UserOrder uO);

    boolean removeOrder(int id);
}
