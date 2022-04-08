package com.estuate.controller;

import com.estuate.entity.Product;
import com.estuate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProducatController {

    @Autowired
    private ProductService productService;

@PostMapping("saveProduct")
    public Product saveproduct(@RequestBody Product product){
        return productService.saveproduct(product);
    }
    @PostMapping("saveProducts")
    public List<Product> saveproducts(@RequestBody List<Product>  products){
        return productService.saveproducts(products);
    }
    @GetMapping("getAll")
    public List<Product>  getAllProduct(){
    return productService.getAll();
    }
    @GetMapping("getProductByid/{id}")
    public Product getProductById(@PathVariable int id){
    return productService.getById(id);
    }

    @GetMapping("getProductByName/{name}")
    public Product getProductByName(@PathVariable String name){
        return productService.getByName(name);
    }

    @DeleteMapping("deleteById/{id}")
    public String deleteById(@PathVariable int id){
    return productService.deleteById(id);

    }
    @PutMapping("editProductById")
    public Product editById(@RequestBody Product product){
    return  productService.update(product);
    }

}
