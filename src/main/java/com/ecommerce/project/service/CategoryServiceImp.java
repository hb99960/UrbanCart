package com.ecommerce.project.service;

import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Business logic, handle exceptions

@Service
public class CategoryServiceImp implements CategoryService{

//    private List<Category> categories = new ArrayList<>();
//    private Long nextId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getAllCategories() {
//        return categories;
        List<Category> savedCategories = categoryRepository.findAll();
        if(savedCategories.isEmpty())
            throw new APIException("No Category exists!!!");

        // refer modelMapper.org
        List<CategoryDTO> categoryDTOS = savedCategories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);

        return categoryResponse;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category categoryFromDb = categoryRepository.findByCategoryName(category.getCategoryName());
        if(categoryFromDb != null)
            throw new APIException("Category with the name " + category.getCategoryName() + " already exists !!!");
//        category.setCategoryId(nextId++);
//        categories.add(category);
        Category savedCategory = categoryRepository.save(category);
        CategoryDTO savedCategoryDTO = modelMapper.map(savedCategory, CategoryDTO.class);
        return savedCategoryDTO;
    }

    @Override
    public CategoryDTO deleteCategory(Long categoryId) {
        // Java Streams API - Java 8
        // ResponseEntity class : Handling status codes (now it is in our control)
        Optional<Category> savedCategoryOptional = categoryRepository.findById(categoryId);
        Category savedCategory = savedCategoryOptional
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));

        categoryRepository.delete(savedCategory);
        CategoryDTO deleteDTO = modelMapper.map( savedCategory, CategoryDTO.class);

        return deleteDTO;
//        return "Category with category Id: " + categoryId + " deleted Successfully!!";
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
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {

//        List<Category> categories = categoryRepository.findAll();
        Category category = modelMapper.map(categoryDTO, Category.class);
        Optional<Category> savedCategoryOptional = categoryRepository.findById(categoryId);

        // save otherwise throw error
        Category savedCategory = savedCategoryOptional
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));

        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        CategoryDTO savedCategoryDTO = modelMapper.map(savedCategory, CategoryDTO.class);
        return savedCategoryDTO;

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
