package com.Clothing.BackendClothings.Repository;

import com.Clothing.BackendClothings.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {



    @Query(value= "SELECT p FROM Product p WHERE p.description LIKE %:searchValue% OR p.productName LIKE %:searchValue%")
    List<Product> searchProductByValue(@Param("searchValue") String searchValue);


    List<Product> getProductByCategoryId(int categoryId);

    Product getProductByProductId(int productId);

    Boolean deleteByProductId(int deleteProductId);
}
