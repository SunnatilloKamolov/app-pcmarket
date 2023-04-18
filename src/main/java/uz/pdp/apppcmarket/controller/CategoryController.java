package uz.pdp.apppcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppcmarket.entity.Category;
import uz.pdp.apppcmarket.payload.CategoryDto;
import uz.pdp.apppcmarket.payload.Result;
import uz.pdp.apppcmarket.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PreAuthorize(value = "hasAnyRole('superAdmin','moderator')")
    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto){
        Result result = categoryService.addCategory(categoryDto);
        return result;
    }  @PreAuthorize(value = "hasAnyRole('superAdmin','moderator','operator')")
    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }
    @PreAuthorize(value = "hasAnyRole('superAdmin','moderator','operator')")
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id){
        Category category = categoryService.getCategory(id);
        return category;
    }
    @PreAuthorize(value = "hasRole('superAdmin')")
    @DeleteMapping
    public Result deleteCategory(@PathVariable Integer id){
        Result result = categoryService.deleteCategory(id);
        return result;
    }@PreAuthorize(value = "hasAnyRole('superAdmin','moderator')")
    @PutMapping
    public Result editCategory(@PathVariable Integer id,@RequestBody CategoryDto categoryDto){
        Result result = categoryService.editCategory(categoryDto, id);
        return result;
    }
}
