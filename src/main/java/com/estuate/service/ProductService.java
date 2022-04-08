package com.estuate.service;

import com.estuate.entity.Product;
import com.estuate.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productrepository;

    public List<Product> saveproducts( List<Product> products){
        return productrepository.saveAll(products);
    }

    public Product saveproduct( Product product){
        return productrepository.save(product);
    }
    public List<Product>  getAll(){
        return productrepository.findAll();
    }
    public Product getById(int id){
        return productrepository.findById(id).orElse(null);
    }
    public Product getByName(String name){
        return productrepository.findByName(name);
    }
    public String  deleteById(int id){
        productrepository.deleteById(id);
        return "Product deleted id"+id;
    }
    public Product update(Product product) {
        Product existatingId = productrepository.findById(product.getId()).orElse(null);
        existatingId.setName(product.getName());
        existatingId.setQuantity(product.getQuantity());
        existatingId.setPrice(product.getPrice());
        return productrepository.save(existatingId);
    }

}
