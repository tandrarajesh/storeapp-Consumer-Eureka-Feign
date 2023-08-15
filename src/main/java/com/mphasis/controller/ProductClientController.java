package com.mphasis.controller;

import com.mphasis.domain.Product;
import com.mphasis.proxy.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("request")
public class ProductClientController {

    @Autowired
    private ProductServiceProxy productServiceProxy;

    @GetMapping("/get-products/{id}")
    public Product getProductById(@PathVariable("id") int id){
        Product product = productServiceProxy.GetProductById(id);
        return product;
    }

    @GetMapping("get-products")
    public List<Product> getALlProducts(){
        List<Product> products = productServiceProxy.GetAllProducts();
        return products;
    }
}
