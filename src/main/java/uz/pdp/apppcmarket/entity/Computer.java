package uz.pdp.apppcmarket.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.apppcmarket.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Computer extends AbsEntity {
    private String motherBoard;

    private String cpu;

    private boolean collingSystem;

    private String ram;

    private String ssd;

    private String powerSupply;

    private String frame;

    private String operationSystem;


}
