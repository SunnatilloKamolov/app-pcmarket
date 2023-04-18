package uz.pdp.apppcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppcmarket.entity.Monitor;
import uz.pdp.apppcmarket.payload.MonitorDto;
import uz.pdp.apppcmarket.payload.Result;
import uz.pdp.apppcmarket.service.MonitorService;

import java.util.List;

@RestController
@RequestMapping("/api/monitor")
public class MonitorController {
    @Autowired
    MonitorService monitorService;
    @PreAuthorize(value = "hasAnyRole('superAdmin','moderator','operator')")
    @GetMapping
    List<Monitor> getMonitors(){
        List<Monitor> monitors = monitorService.getMonitor();
        return monitors;
    } @PreAuthorize(value = "hasAnyRole('superAdmin','moderator','operator')")
    @GetMapping("/{id}")
    public Monitor getMonitorById(@PathVariable Integer id){
        return monitorService.getMonitorById(id);
    } @PreAuthorize(value = "hasAnyRole('superAdmin','moderator')")
    @PostMapping
    public Result addMonitor(@RequestBody MonitorDto monitorDto){
        monitorService.addMonitor(monitorDto);
        return new Result("Monitor added",true);
    } @PreAuthorize(value = "hasAnyRole('superAdmin','moderator')")
    @PutMapping("/{id}")
    public Result editMonitor(@PathVariable Integer id,@RequestBody MonitorDto monitorDto){
        monitorService.editMonitor(monitorDto,id);
        return new Result("Monitor edited",true);
    } @PreAuthorize(value = "hasRole('superAdmin')")
    @DeleteMapping("/{id}")
    public Result deleteMonitor(@PathVariable Integer id){
        monitorService.deleteMonitor(id);
        return new Result("Monitor deleted",true);
    }
}
