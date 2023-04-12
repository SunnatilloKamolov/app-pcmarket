package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Attachment;
import uz.pdp.apppcmarket.entity.Category;
import uz.pdp.apppcmarket.entity.Laptop;

@Projection(types = Laptop.class)
public interface CustomMonitor {
    Integer getId();

    String getName();

    Category getCategory();

    Attachment getAttachment();

    double getPrice();

    Integer getGuarantee();

    String getDescription();

    String getBrand();

    String getScreenResolution();

    String getVideoConnectors();

    String getMatrix();

    Double getDiagonalScreen();

    boolean getCurvedScreen();

    Integer getScreenRefreshRate();

    String getResponseTime();
}
