package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/purchase")
public class PurchaseController
{

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<Purchase> getPurchase(){
        return purchaseService.getPurchases();
    }

    @PostMapping
    public void registerNewProduct(@RequestBody Purchase purchase){
        purchaseService.addNewPurchase(purchase);
    }
}
