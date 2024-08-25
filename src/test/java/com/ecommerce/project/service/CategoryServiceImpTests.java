package com.ecommerce.project.service;

import com.ecommerce.project.repository.CategoryRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryServiceImpTests {

    @Autowired
    private CategoryRepository categoryRepository;


    @MockBean
    private CategoryService categoryService;


    public void getAllCategoriesTest(){

    }

}
