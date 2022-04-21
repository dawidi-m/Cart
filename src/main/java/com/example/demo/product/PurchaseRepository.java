package com.example.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PurchaseRepository extends JpaRepository<Purchase,Long>  {

//    Optional<Purchase> findPurchaseByName(String name);

}
