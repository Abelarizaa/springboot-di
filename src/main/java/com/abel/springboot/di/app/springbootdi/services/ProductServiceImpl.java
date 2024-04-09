package com.abel.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.abel.springboot.di.app.springbootdi.models.Product;
import com.abel.springboot.di.app.springbootdi.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    
    private ProductRepository repository;

    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll(){
        
        return repository.findAll().stream().map(p -> {
            Double priceTax= p.getPrice()*1.25d;
           // Product newProduct =  new Product(p.getId(),p.getName(),priceImp.longValue());
           Product newProduct =  (Product) p.clone(); 
           newProduct.setPrice(priceTax.longValue());
           //p.setPrice(priceTax.longValue());
           //return p;
           return newProduct;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){

        return repository.findById(id);
    }



}
