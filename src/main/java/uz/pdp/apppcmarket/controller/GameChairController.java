package uz.pdp.apppcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppcmarket.entity.GameChair;
import uz.pdp.apppcmarket.payload.GameChairDto;
import uz.pdp.apppcmarket.payload.Result;
import uz.pdp.apppcmarket.service.GameChairService;

import java.util.List;

@RestController
@RequestMapping("/api/gameChair")
public class GameChairController {
    @Autowired
    GameChairService gameChairService;
    @PreAuthorize(value = "hasAnyRole('superAdmin','moderator','operator')")
    @GetMapping
    List<GameChair> getGameChair(){
        List<GameChair> GameChairs = gameChairService.getGameChairs();
        return GameChairs;
    } @PreAuthorize(value = "hasAnyRole('superAdmin','moderator','operator')")
    @GetMapping("/{id}")
    public GameChair getGameChairById(@PathVariable Integer id){
        return gameChairService.getGameChairById(id);
    } @PreAuthorize(value = "hasAnyRole('superAdmin','moderator')")
    @PostMapping
    public Result addGameChair(@RequestBody GameChairDto gameChairDto){
        gameChairService.addGamaChair(gameChairDto);
        return new Result("GameChair added",true);
    } @PreAuthorize(value = "hasAnyRole('superAdmin','moderator')")
    @PutMapping("/{id}")
    public Result editGameChair(@PathVariable Integer id,@RequestBody GameChairDto gameChairDto){
        gameChairService.editGameChair(gameChairDto,id);
        return new Result("GameChair edited",true);
    } @PreAuthorize(value = "hasRole('superAdmin')")
    @DeleteMapping("/{id}")
    public Result deleteGameChair(@PathVariable Integer id){
        gameChairService.deleteGameChair(id);
        return new Result("GameChair deleted",true);
    }
}
