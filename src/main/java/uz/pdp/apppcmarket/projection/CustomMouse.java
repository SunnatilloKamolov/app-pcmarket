package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Attachment;
import uz.pdp.apppcmarket.entity.Category;
import uz.pdp.apppcmarket.entity.Mouse;

@Projection(types = Mouse.class)
public interface CustomMouse {
    Integer getId();

    String getName();

    Category getCategory();

    Attachment getAttachment();

    double getPrice();

    Integer getGuarantee();

    String getDescription();

    String getBrand();

    String getSensorResolution();

    Integer getMaxAcceleration();

    Integer getNumberOfButtons();

    String getConnectionType();

    boolean getSilentButtons();

    String getConnectionInterface();
}
