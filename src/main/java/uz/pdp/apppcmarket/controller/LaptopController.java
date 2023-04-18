package uz.pdp.apppcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping
    List<Laptop> getLaptop(){
        List<Laptop> laptops = laptopService.getLaptops();
        return laptops;
    }@GetMapping("/{id}")
    public Laptop getLaptopById(@PathVariable Integer id){
        return laptopService.getLaptopById(id);
    }@PostMapping
    public Result addLaptop(@RequestBody LaptopDto laptopDto){
        laptopService.addLaptop(laptopDto);
        return new Result("Laptop added",true);
    }@PutMapping("/{id}")
    public Result editLaptop(@PathVariable Integer id,@RequestBody LaptopDto laptopDto){
        laptopService.editLaptop(laptopDto,id);
        return new Result("Laptop edited",true);
    }@DeleteMapping("/{id}")
    public Result deleteLaptop(@PathVariable Integer id){
        laptopService.deleteLaptop(id);
        return new Result("Laptop deleted",true);
    }
}
