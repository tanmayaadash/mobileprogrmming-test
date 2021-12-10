package com.example.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.pojo.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
