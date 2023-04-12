package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Attachment;
import uz.pdp.apppcmarket.entity.Category;
import uz.pdp.apppcmarket.entity.Computer;

@Projection(types = Computer.class)
public interface CustomComputer {
    Integer getId();

    String getName();

    Category getCategory();

    Attachment getAttachment();

    double getPrice();

    Integer getGuarantee();

    String getDescription();

    String getMotherBoard();

    String getCpu();

    boolean getCollingSystem();

    String getRam();

    String getSsd();

    String getPowerSupply();

    String getFrame();

    String getOperationSystem();
}
