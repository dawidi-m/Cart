package com.example.demo.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.HashMap;

@Configuration
public class PurchaseConfig {

//
//    @Bean
//    CommandLineRunner commandLineRunner(PurchaseRepository repository){
//        return args -> {
//
//            HashMap<Long, Integer> carrt = new HashMap<Long, Integer>();
//            carrt.put(1L,7);
//            carrt.put(3L,2);
//            carrt.put(2L,4);
//
//            Purchase p1 =  new Purchase(
//                carrt,18.0,"Martha"
//            );
//
//            HashMap<Long, Integer> cart = new HashMap<Long, Integer>();
//            cart.put(1L,17);
//            cart.put(2L,44);
//
//            Purchase p2 =  new Purchase(
//                    cart,15.0,"Maria"
//            );
//
//
//
//
//
//            repository.saveAll(List.of(p1,p2));
//        };
//
//    }
}
