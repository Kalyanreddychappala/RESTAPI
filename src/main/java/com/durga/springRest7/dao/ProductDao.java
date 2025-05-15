package com.durga.springRest7.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.durga.springRest7.beans.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

}
