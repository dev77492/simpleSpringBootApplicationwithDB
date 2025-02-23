package com.dev77492WebApp.demoWebApp.service;

import com.dev77492WebApp.demoWebApp.model.Product;
import com.dev77492WebApp.demoWebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Product> products= new ArrayList<>(Arrays.asList(new Product(101,"iphone",50000), new Product(102, "Samsung", 100000)));

    public List<Product> getProducts(){
        return repo.findAll();

    }

    public Product getProductById(int prodId) {
        /* We can use below enhanced loop
        if (products == null) {
            return null; // or handle the null case as appropriate
        }

        for (Product product : products) {
            if (prodId == product.getProdId()) {
                return product;
            }
        }

        return null;


        OR we can use below stream method


        return products.stream()
                .filter(p ->p.getProdId()==prodId).findFirst()
                .orElse(new Product(00,"ProdNotFound", 00));

         */

        return repo.findById(prodId).orElse(new Product());

    }

    public void addProduct(Product prod){
//        products.add(prod);
        repo.save(prod);
    }

    public void updateProduct(Product prod) {
//        int index=0;
//        for(int i=0; i<products.size();i++){
//            if(products.get(i).getProdId()==prod.getProdId()){
//                index=i;
//            }
//        }
//        products.set(index,prod);

//        with DB
        repo.save(prod);
    }

    public void deleteProduct(Product prod) {
//        int index=0;
//        for(int i=0; i<products.size();i++){
//            if(products.get(i).getProdId()==prod.getProdId()){
//                index=i;
//            }
//        }
//        products.remove(index);
        repo.delete(prod);
    }

    public void deleteProductById(int prodId) {
//        int index=0;
//        for(int i=0; i<products.size();i++){
//            if(products.get(i).getProdId()==prodId){
//                index=i;
//            }
//        }
//        products.remove(index);

        repo.deleteById(prodId);
    }
}
