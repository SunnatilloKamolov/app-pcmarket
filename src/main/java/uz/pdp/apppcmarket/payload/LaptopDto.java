package uz.pdp.apppcmarket.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaptopDto {
    private String name;
    private Integer parentCategoryId;
    private String screenResolution;

    private String cpu;

    private String ram;

    private String hardDisk;

    private String ssd;

    private String operationSystem;
}
