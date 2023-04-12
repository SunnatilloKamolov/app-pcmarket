package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Attachment;
import uz.pdp.apppcmarket.entity.Category;
import uz.pdp.apppcmarket.entity.Printer;

@Projection(types = Printer.class)
public interface CustomPrinter {
    Integer getId();

    String getName();

    Category getCategory();

    Attachment getAttachment();

    double getPrice();

    Integer getGuarantee();

    String getDescription();

    String getBrand();

    String getPrintColor();

    String getDeviceFeatures();

    String getTechnology();

    String getMaxFormat();

    String getTwoSpeedPrinting();

}
