package uz.pdp.apppcmarket.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrinterDto {
    private String name;
    private String brand;

    private String printColor;

    private String deviceFeatures;

    private String technology;

    private String maxFormat;

    private String twoSpeedPrinting;
}
