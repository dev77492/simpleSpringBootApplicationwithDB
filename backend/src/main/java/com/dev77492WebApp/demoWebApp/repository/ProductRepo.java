package com.dev77492WebApp.demoWebApp.repository;

import com.dev77492WebApp.demoWebApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
}
