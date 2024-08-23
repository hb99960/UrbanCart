package com.ecommerce.project.controller;

import com.ecommerce.project.config.AppConstants;
import com.ecommerce.project.payload.ProductDTO;
import com.ecommerce.project.payload.ProductResponse;
import com.ecommerce.project.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ProductController {

@Autowired
ProductService productService;

//return type is DTO when there is single data collection
//    return type is Response when pagination is there


@PostMapping("/admin/categories/{categoryId}/product")
public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO,
                                             @PathVariable Long categoryId){
    ProductDTO savedProductDTO = productService.addProduct(categoryId, productDTO);
    return new ResponseEntity<>(savedProductDTO, HttpStatus.CREATED);
}

@GetMapping("/public/products")
public ResponseEntity<ProductResponse> getAllProducts(
        @RequestParam(name= "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
        @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
        @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_PRODUCTS_BY, required = false) String sortBy,
        @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder){
    ProductResponse productResponse = productService.getAllProducts(pageNumber, pageSize, sortBy, sortOrder);
    return new ResponseEntity<>(productResponse, HttpStatus.OK);
}

}