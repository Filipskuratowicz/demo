package com.example.demo.controll;

import com.example.demo.database.UserOrder;
import org.h2.engine.User;
import org.springframework.web.bind.annotation.RequestParam;

public class OrderCheck {


    public boolean oderChecker(String id, String name, int quantity, double price) {

        String alert = "Have wrong format in :";

        if (!id.matches("[0-9A-Z a-z]{1,6}")) {
            return false;
        } else if (name.matches("[0-9 A-Z a-z]{1,255}"))) {
            return false;
        }
        String qua = Integer.toString(quantity);
        else if (qua.matches("[0-2,147,483,647]")) {
            return false;
        }
        String pri = Double.toString(price);
        else if (pri.matches("[0-9]{0,999}[.][0-9]{2}")) {
            return false;
        }else {
            return true;
        }
    }
}