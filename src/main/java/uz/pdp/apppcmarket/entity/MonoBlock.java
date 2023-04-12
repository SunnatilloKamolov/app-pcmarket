package uz.pdp.apppcmarket.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.apppcmarket.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class MonoBlock extends AbsEntity {
    private String videoCard;

    private double diagonalScreen;

    private String screenResolution;

    private String cpu;

    private String ram;

    private String hardDisk;

    private String ssd;

    private String operationSystem;
}
