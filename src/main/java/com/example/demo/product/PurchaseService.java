package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final ProductService productService;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository, ProductService productService) {
        this.purchaseRepository = purchaseRepository;
        this.productService = productService;
    }




    public List<Purchase> getPurchases(){
        return  purchaseRepository.findAll();
    }


    public void addNewPurchase(Purchase purchase) {
        System.out.println(purchase);
        purchase.setCreated_on(LocalDateTime.now());
         Double total= computePrice(purchase.getCart());
         purchase.setPrice(total);
        purchaseRepository.save(purchase);
          }

    public double computePrice(Map<Long, Integer> cart){
       Double total = 0.0;

        for (Map.Entry<Long, Integer> entry : cart.entrySet()) {
                Double newPrice = productService.getProductPrice(entry.getKey());
                total = total+(newPrice*entry.getValue());
                productService.updateProductById(entry.getKey(),entry.getValue());


        }
           return  total;
    }

}
