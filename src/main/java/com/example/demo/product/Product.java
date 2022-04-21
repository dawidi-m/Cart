package com.example.demo.product;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String name;
    private String category;
    private String tags;
    private Double price;
    private  Integer quantity;

    public Product() {
    }

    public Product(Long id, String name, String category,String tags, Double price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.tags = tags;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, String category,String tags, Double price, Integer quantity) {
        this.name = name;
        this.category = category;
        this.tags = tags;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", tags ='" + tags + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
