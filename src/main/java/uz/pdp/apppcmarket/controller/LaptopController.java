package uz.pdp.apppcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppcmarket.entity.Laptop;
import uz.pdp.apppcmarket.payload.LaptopDto;
import uz.pdp.apppcmarket.payload.Result;
import uz.pdp.apppcmarket.service.LaptopService;

import java.util.List;

@RestController
@RequestMapping("/api/laptop")
public class LaptopController {
    @Autowired
    LaptopService laptopService;
    @PreAuthorize(value = "hasAnyRole('superAdmin','moderator','operator')")
    @GetMapping
    List<Laptop> getLaptop(){
        List<Laptop> laptops = laptopService.getLaptops();
        return laptops;
    } @PreAuthorize(value = "hasAnyRole('superAdmin','moderator','operator')")
    @GetMapping("/{id}") public Laptop getLaptopById(@PathVariable Integer id){
        return laptopService.getLaptopById(id);
    } @PreAuthorize(value = "hasAnyRole('superAdmin','moderator')")
    @PostMapping
    public Result addLaptop(@RequestBody LaptopDto laptopDto){
        laptopService.addLaptop(laptopDto);
        return new Result("Laptop added",true);
    } @PreAuthorize(value = "hasAnyRole('superAdmin','moderator')")
    @PutMapping("/{id}")
    public Result editLaptop(@PathVariable Integer id,@RequestBody LaptopDto laptopDto){
        laptopService.editLaptop(laptopDto,id);
        return new Result("Laptop edited",true);
    } @PreAuthorize(value = "hasRole('superAdmin')")
    @DeleteMapping("/{id}")
    public Result deleteLaptop(@PathVariable Integer id){
        laptopService.deleteLaptop(id);
        return new Result("Laptop deleted",true);
    }
}
