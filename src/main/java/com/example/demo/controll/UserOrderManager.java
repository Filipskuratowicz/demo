package com.example.demo.controll;

import com.example.demo.database.UserOrder;
import com.example.demo.process.H2Impl;
import com.example.demo.process.OrdersH2Impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.transaction.Transactional;

@RestController
@Transactional
public class UserOrderManager {

    private static final Logger logger = LoggerFactory.getLogger(UserOrder.class);

    OrderCheck orderCheck;

    @Autowired
    OrdersH2Impl ordersH2;

    @GetMapping(path = "/getOrder/{id}")
    public UserOrder getOrder(@PathVariable int id) {
        return ordersH2.getOrder(id);
    }

    @GetMapping(path = "/saveOrder")
    public UserOrder saveOrder(

            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("quantity") int quantity,
            @RequestParam("price") double price
    )
    {
        if (orderCheck.oderChecker(id, name, quantity, price) == true) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        UserOrder userOrder = new UserOrder(id, name, quantity, price);
        logger.info(userOrder.toString());
        ordersH2.saveOrder(userOrder);
        return userOrder;
    }

    @GetMapping("/remove/{id}")
    public HttpEntity<UserOrder> remove(@PathVariable int id) {

        logger.info(Integer.toString(id));
        UserOrder userOrder = ordersH2.getOrder(id);
        if (ordersH2.removeOrder(id)) {
            return new HttpEntity(userOrder);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
