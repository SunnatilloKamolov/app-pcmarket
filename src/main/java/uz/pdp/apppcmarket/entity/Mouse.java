package uz.pdp.apppcmarket.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.apppcmarket.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Mouse extends AbsEntity {
    private String brand;

    private String sensorResolution;

    private Integer maxAcceleration;

    private Integer numberOfButtons;

    private String connectionType;

    private boolean silentButtons;

    private String connectionInterface;
}
