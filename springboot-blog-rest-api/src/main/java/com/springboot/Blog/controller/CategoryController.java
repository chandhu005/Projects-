package com.springboot.Blog.controller;

import com.springboot.Blog.payLoad.CategoryDto;
import com.springboot.Blog.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    //Build add category Rest Api
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto savedCategory=categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }
    //Build get Catogry Rest APi
    @GetMapping("{id}")
    public  ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Long categoryId){
        CategoryDto categoryDto=categoryService.getCategory(categoryId);
        return  ResponseEntity.ok(categoryDto);
    }
    //build get All Categories Rest  Api
    @GetMapping
    public  ResponseEntity<List<CategoryDto>> getCategories(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }
    //update CategoryRest API
    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public  ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,
                                                       @PathVariable("id") Long categoryId){
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto,categoryId));
    }
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<String> deleteCategory(Long categoryId){
        categoryService.deleteCategory(categoryId);
        return  ResponseEntity.ok("Category Deleted SuccessFully");
    }
}
