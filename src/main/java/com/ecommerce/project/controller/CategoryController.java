package com.ecommerce.project.controller;

import com.ecommerce.project.config.AppConstants;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/echo")
    public ResponseEntity<String> echoMessage(@RequestParam(name = "message", defaultValue = "Hello World!") String message){
        return new ResponseEntity<>("Echoed message: " + message, HttpStatus.OK);
    }


//    @GetMapping("/public/categories")
    @RequestMapping(value ="/public/categories", method = RequestMethod.GET)
    public ResponseEntity<CategoryResponse> getAllCategories(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_CATEGORIES_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder
    ){
        CategoryResponse categoryResponse = categoryService.getAllCategories(pageNumber, pageSize, sortBy, sortOrder);
        // Object to JSON : Jackson is a Java library for serialisation and de-serialisation
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }


//    @PostMapping("/public/categories")
    @RequestMapping(value = "/public/categories", method = RequestMethod.POST)
//    @Valid check valid inputs, if fails Spring will throw suitable error
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        CategoryDTO savedCategoryDTO = categoryService.createCategory(categoryDTO);
//        return "Category added Successfully";
//        return new ResponseEntity<>("Category added successfully", HttpStatus.CREATED);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }


//    @DeleteMapping("/admin/categories/{categoryId}")
    @RequestMapping( value = "/admin/categories/{categoryId}", method = RequestMethod.DELETE)
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId){
//        try{
            CategoryDTO deletedCategoryDTO = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(deletedCategoryDTO, HttpStatus.OK);
//            return ResponseEntity.ok(status);
//            return ResponseEntity.status(HttpStatus.OK).body(status);
//        }
//        catch (ResponseStatusException e){
//            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
//        }
    }

//    @PutMapping("/public/categories/{categoryId}")
    @RequestMapping(value = "/public/categories/{categoryId}", method = RequestMethod.PUT)
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,
                                                 @PathVariable Long categoryId){
//        try{
            CategoryDTO savedCategoryDTO = categoryService.updateCategory(categoryDTO, categoryId);
            return new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);
//        }
//        catch (ResponseStatusException e){
//            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
//        }
    }
}
