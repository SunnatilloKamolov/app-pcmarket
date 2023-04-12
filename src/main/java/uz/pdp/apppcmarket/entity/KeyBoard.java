package uz.pdp.apppcmarket.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.apppcmarket.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class KeyBoard extends AbsEntity {
    private String brand;

    private String primarySetColor;

    private String additionalSetColor;

    private String keyBoardKeys;

    private boolean backLight;

    private String keyMechanism;

    private String connectionInterface;

}
