package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Business logic

@Service
public class CategoryServiceImp implements CategoryService{

//    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
//        return categories;
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
//        categories.add(category);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        // Java Streams API - Java 8
        // ResponseEntity class : Handling status codes (now it is in our control)
        Optional<Category> savedCategoryOptional = categoryRepository.findById(categoryId);
        Category savedCategory = savedCategoryOptional
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));

        categoryRepository.delete(savedCategory);
        return "Category with category Id: " + categoryId + " deleted Successfully!!";
//        List<Category> categories = categoryRepository.findAll();
//        Category category = categories.stream()
//                .filter(c -> c.getCategoryId().equals(categoryId))
//                .findFirst()
//                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
////        if (category == null)
////            return "Category not found!!";
//
////        categories.remove(category);
//        categoryRepository.delete(category);
//        return "Category with category Id: " + categoryId + " deleted Successfully!!";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

//        List<Category> categories = categoryRepository.findAll();
        Optional<Category> savedCategoryOptional = categoryRepository.findById(categoryId);

        // save otherwise throw error
        Category savedCategory = savedCategoryOptional
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));

        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory;

//        Optional<Category> optionalCategory = categories.stream()
//                .filter(c -> c.getCategoryId().equals(categoryId))
//                .findFirst();
//
//        if( optionalCategory.isPresent()){
//            Category existingCategory = optionalCategory.get();
//            existingCategory.setCategoryName(category.getCategoryName());
//            Category savedCategory = categoryRepository.save(existingCategory);
////            return existingCategory;
//            return savedCategory;
//        }
//        else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
//        }
    }
}
