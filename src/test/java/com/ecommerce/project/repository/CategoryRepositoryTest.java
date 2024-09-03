package com.ecommerce.project.repository;


import com.ecommerce.project.model.Category;
import com.ecommerce.project.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    Category category;
    Product product;

    @BeforeEach
    void setUp() {
//        List<Product> productList = new ArrayList<>();
//        productList.add(new Product());
        category = new Category(1L, "Luggage");
        categoryRepository.save(category);
    }

    @AfterEach
    void tearDown() {
        category = null;
        categoryRepository.deleteAll();
    }

    // success testcase
    @Test
    void testFindByCategoryNameFound(){
        Category categoryFromDb = categoryRepository.findByCategoryName("Luggage");
        assertThat(categoryFromDb.getCategoryName()).isEqualTo(category.getCategoryName());
    }

    // failure testcase

}
