package com.abel.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.abel.springboot.di.app.springbootdi.models.Product;

@Repository
public class ProductRepositoryImpl implements ProductoRepository{

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L,"Memoria corsair 32",300L),
            new Product(2L,"CPU Intel Core i9",850L),
            new Product(3L,"Teclado Razer Mini 60%",180L),
            new Product(4L,"Motherboard Gigabyte",490L)
        );
        
    }

    @Override //Anotacion opcional para identificar que es una sobreescritura de la interfaz
    public List<Product> findAll(){
        return data;
    }

    @Override
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    
}
