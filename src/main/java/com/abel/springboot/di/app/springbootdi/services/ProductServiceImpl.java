package com.abel.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import com.abel.springboot.di.app.springbootdi.models.Product;
import com.abel.springboot.di.app.springbootdi.repositories.ProductRepositoryImpl;

public class ProductServiceImpl {

    private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    public List<Product> findAll(){
        
        return repository.findAll().stream().map(p -> {
            Double priceTax= p.getPrice()*1.25d;
           // Product newProduct =  new Product(p.getId(),p.getName(),priceImp.longValue());
           Product newProduct =  (Product) p.clone(); 
           newProduct.setPrice(priceTax.longValue());
           return newProduct;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){

        return repository.findById(id);
    }
}