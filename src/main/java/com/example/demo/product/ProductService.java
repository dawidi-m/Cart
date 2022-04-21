package com.example.demo.product;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
    return  productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        Optional<Product> productByName = productRepository.findProductByName(product.getName());

        if(productByName.isPresent()){
            throw new IllegalStateException("Product Name is already there");
        }

        System.out.println("Tralla");
        productRepository.save(product);
    }

    @Transactional
    public void updateProductByName(String name,Integer quantity){
       Long id = getProductId(name);

       if((id != null) && (quantity>0)){
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Product not found"));

       if (quantity<=product.getQuantity()){
           product.setQuantity(quantity);
       }

       } else{
           throw  new IllegalStateException("Quantity is less or id does name does not exist");
       }


    }

    @Transactional
    public void updateProductById(Long id,Integer quantity){

        if(quantity>0){
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException("Product Id not found"));

            if (quantity<=product.getQuantity()){
                product.setQuantity(product.getQuantity()-quantity);
            } else {
                throw  new IllegalStateException("Quantity is greater than current one");
            }

        } else{
            throw  new IllegalStateException("Quantity is less than 0");
        }


    }

    public double getProductPrice(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Product Id not found"));
        return product.getPrice();
    }


    public Long getProductId(String name){
        Optional<Product> productByName = productRepository.findProductByName(name);
       Long id;
        if(productByName.isPresent()){
            id = productByName.get().getId();
        } else{
            id = null;
        }
        return id;
    }
}
