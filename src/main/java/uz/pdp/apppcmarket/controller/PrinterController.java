package uz.pdp.apppcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppcmarket.entity.Printer;
import uz.pdp.apppcmarket.payload.PrinterDto;
import uz.pdp.apppcmarket.payload.Result;
import uz.pdp.apppcmarket.service.PrinterService;

import java.util.List;

@RestController
@RequestMapping("/api/printer")
public class PrinterController {
    @Autowired
    PrinterService printerService;
    @GetMapping
    List<Printer> getPrinters(){
        List<Printer> printers = printerService.getPrinter();
        return printers;
    }@GetMapping("/{id}")
    public Printer getPrinterById(@PathVariable Integer id){
        return printerService.getPrinterById(id);
    }@PostMapping
    public Result addPrinter(@RequestBody PrinterDto printerDto){
        printerService.addPrinter(printerDto);
        return new Result("Printer added",true);
    }@PutMapping("/{id}")
    public Result editPrinter(@PathVariable Integer id,@RequestBody PrinterDto printerDto){
        printerService.editPrinter(printerDto,id);
        return new Result("Printer edited",true);
    }@DeleteMapping("/{id}")
    public Result deletePrinter(@PathVariable Integer id){
        printerService.deletePrinter(id);
        return new Result("Printer deleted",true);
    }
}
