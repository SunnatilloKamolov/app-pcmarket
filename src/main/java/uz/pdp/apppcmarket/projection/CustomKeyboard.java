package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Attachment;
import uz.pdp.apppcmarket.entity.Category;
import uz.pdp.apppcmarket.entity.KeyBoard;

@Projection(types = KeyBoard.class)
public interface CustomKeyboard {
    Integer getId();

    String getName();

    Category getCategory();

    Attachment getAttachment();

    double getPrice();

    Integer getGuarantee();

    String getDescription();

    String getBrand();

    String getPrimarySetColor();

    String getAdditionalSetColor();

    String getKeyBoardKeys();

    boolean getBackLight();

    String getKeyMechanism();

    String getConnectionInterface();
}
