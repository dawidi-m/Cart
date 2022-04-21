package com.example.demo.product;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
@Entity
@Table
public class Purchase {

    @Id
    @SequenceGenerator(
            name = "purchase_sequence",
            sequenceName = "purchase_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "purchase_sequence"
    )

    private Long id;

    @ElementCollection
    private Map<Long,Integer> cart;

    private LocalDateTime created_on;
    private Double vat;
    private double price;
    private String customerName;

    public Purchase() {
    }

    public Purchase(Map<Long, Integer> cart, Double vat, String customerName) {
        this.cart = cart;
        this.vat = vat;
        this.customerName = customerName;
        this.created_on = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Long, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Long, Integer> cart) {
        this.cart = cart;
    }

    public LocalDateTime getCreated_on() {
        return created_on;
    }

    public void setCreated_on(LocalDateTime created_on) {
        this.created_on = created_on;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", cart=" + cart +
                ", created_on=" + created_on +
                ", vat=" + vat +
                ", price=" + price +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
