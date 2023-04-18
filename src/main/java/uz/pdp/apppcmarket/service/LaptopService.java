package uz.pdp.apppcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apppcmarket.entity.Category;
import uz.pdp.apppcmarket.entity.Laptop;
import uz.pdp.apppcmarket.payload.LaptopDto;
import uz.pdp.apppcmarket.payload.Result;
import uz.pdp.apppcmarket.repository.CategoryRepository;
import uz.pdp.apppcmarket.repository.LaptopRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {
    @Autowired
    LaptopRepository laptopRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<Laptop> getLaptops() {
        List<Laptop> laptops =laptopRepository.findAll();
        return laptops;
    }

    public Laptop getLaptopById(Integer id) {
        Optional<Laptop> optionalLaptop = laptopRepository.findById(id);
        return optionalLaptop.orElse(null);
    }

    public Result addLaptop(LaptopDto laptopDto) {
        boolean existsByName =laptopRepository.existsByName(laptopDto.getName());
        if (existsByName)
            return new Result("Laptop already exist",false);
        Category category = new Category();
        category.setName(laptopDto.getName());
        Category savedCategory = categoryRepository.save(category);
        Laptop laptop=new Laptop();
        laptop.setCpu(laptopDto.getCpu());
        laptop.setSsd(laptopDto.getSsd());
        laptop.setRam(laptopDto.getRam());
        laptop.setOperationSystem(laptopDto.getOperationSystem());
        laptop.setHardDisk(laptopDto.getHardDisk());
        laptop.setScreenResolution(laptopDto.getScreenResolution());
        laptop.setCategory(savedCategory);
        laptopRepository.save(laptop);
        return new Result("Laptop added",true);
    }   public Result editLaptop(LaptopDto laptopDto,Integer id){
        Optional<Laptop> optionalLaptop = laptopRepository.findById(id);
        if (!optionalLaptop.isPresent())
            return new Result("Laptop not found",false);
        Laptop laptop=new Laptop();
        laptop.setCpu(laptopDto.getCpu());
        laptop.setSsd(laptopDto.getSsd());
        laptop.setRam(laptopDto.getRam());
        laptop.setOperationSystem(laptopDto.getOperationSystem());
        laptop.setHardDisk(laptopDto.getHardDisk());
        laptop.setScreenResolution(laptopDto.getScreenResolution());
        laptop.setCategory(laptop.getCategory());
        laptopRepository.save(laptop);
        return new Result("Laptop edited",true);
    }   public Result deleteLaptop(Integer id){
        laptopRepository.deleteById(id);
        return new Result("Laptop deleted",true);
    }
}
