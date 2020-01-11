package com.example.demo.database;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String orderId;
    private String name;
    private int quantity;
    private double price;

    public UserOrder(){};

    public UserOrder(String orderId, String name, int quantity, double price) {
        this.orderId = orderId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

        public int getId () {
            return id;
        }

        public void setId ( int id){
            id = id;
        }

        public String getOrderId () {
            return orderId;
        }

        public void setOrderId (String orderId){
            this.orderId = orderId;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public int getQuantity () {
            return quantity;
        }

        public void setQuantity ( int quantity){
            this.quantity = quantity;
        }

        public double getPrice () {
            return price;
        }

        public void setPrice ( double price){
            this.price = price;
        }

        @Override
        public String toString () {
            final StringBuilder sb = new StringBuilder("UserOrder{");
            sb.append("Id=").append(id);
            sb.append(", orderId='").append(orderId).append('\'');
            sb.append(", name='").append(name).append('\'');
            sb.append(", quantity=").append(quantity);
            sb.append(", price=").append(price);
            sb.append('}');
            return sb.toString();
        }
}