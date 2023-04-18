package uz.pdp.apppcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize(value = "hasAnyRole('superAdmin','moderator','operator')")
    @GetMapping
    List<Printer> getPrinters(){
        List<Printer> printers = printerService.getPrinter();
        return printers;
    } @PreAuthorize(value = "hasAnyRole('superAdmin','moderator','operator')")
    @GetMapping("/{id}")
    public Printer getPrinterById(@PathVariable Integer id){
        return printerService.getPrinterById(id);
    } @PreAuthorize(value = "hasAnyRole('superAdmin','moderator')")
    @PostMapping
    public Result addPrinter(@RequestBody PrinterDto printerDto){
        printerService.addPrinter(printerDto);
        return new Result("Printer added",true);
    } @PreAuthorize(value = "hasAnyRole('superAdmin','moderator')")
    @PutMapping("/{id}")
    public Result editPrinter(@PathVariable Integer id,@RequestBody PrinterDto printerDto){
        printerService.editPrinter(printerDto,id);
        return new Result("Printer edited",true);
    } @PreAuthorize(value = "hasRole('superAdmin')")
    @DeleteMapping("/{id}")
    public Result deletePrinter(@PathVariable Integer id){
        printerService.deletePrinter(id);
        return new Result("Printer deleted",true);
    }
}
