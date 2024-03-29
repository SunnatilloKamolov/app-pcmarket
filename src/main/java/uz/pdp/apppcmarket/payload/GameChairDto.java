package uz.pdp.apppcmarket.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameChairDto {
    private String name;
    private Integer CategoryId;
    private String color;

    private String forPeopleLength;

    private double load;

    private String gasLiftClass;

    private double weight;

    private String frameMaterial;

    private String size; //60x80x120

    private String movementType;
}
