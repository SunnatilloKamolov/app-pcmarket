package uz.pdp.apppcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppcmarket.entity.Computer;
import uz.pdp.apppcmarket.payload.ComputerDto;
import uz.pdp.apppcmarket.payload.Result;
import uz.pdp.apppcmarket.service.ComputerService;

import java.util.List;

@RestController
@RequestMapping("/api/computer")
public class ComputerController {
    @Autowired
    ComputerService computerService;
    @PreAuthorize(value = "hasAnyRole('superAdmin','moderator','operator')")
    @GetMapping
    List<Computer> getComputers(){
        List<Computer> computers = computerService.getComputers();
        return computers;
    }@PreAuthorize(value = "hasAnyRole('superAdmin','moderator','operator')")
    @GetMapping("/{id}")
    public Computer getComputerById(@PathVariable Integer id){
        return computerService.getComputerById(id);
    }@PreAuthorize(value = "hasAnyRole('superAdmin','moderator')")
    @PostMapping
    public Result addComputer(@RequestBody ComputerDto computerDto){
        computerService.addComputer(computerDto);
        return new Result("Computer added",true);
    }@PreAuthorize(value = "hasAnyRole('superAdmin','moderator')")
    @PutMapping("/{id}")
    public Result editComputer(@PathVariable Integer id,@RequestBody ComputerDto computerDto){
        computerService.editComputer(computerDto,id);
        return new Result("computer edited",true);
    }@PreAuthorize(value = "hasRole('superAdmin')")
    @DeleteMapping("/{id}")
    public Result deleteComputer(@PathVariable Integer id){
        computerService.deleteComputer(id);
        return new Result("computer deleted",true);
    }
}
