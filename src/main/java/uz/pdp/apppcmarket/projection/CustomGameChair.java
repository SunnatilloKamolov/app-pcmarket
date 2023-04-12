package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Attachment;
import uz.pdp.apppcmarket.entity.Category;
import uz.pdp.apppcmarket.entity.GameChair;

@Projection(types = GameChair.class)
public interface CustomGameChair {
    Integer getId();

    String getName();

    Category getCategory();

    Attachment getAttachment();

    double getPrice();

    Integer getGuarantee();

    String getDescription();

    String getColor();

    String getForPeopleLength();

    double getLoad();

    String getGasLiftClass();

    double getWeight();

    String getFrameMaterial();

    String getSize(); //60x80x120

    String getMovementType();

}
