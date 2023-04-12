package uz.pdp.apppcmarket.entity.template;

import jakarta.persistence.*;
import lombok.Data;
import uz.pdp.apppcmarket.entity.Attachment;
import uz.pdp.apppcmarket.entity.Category;

@Data
@MappedSuperclass
public abstract class AbsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    private Category category;
    @OneToOne
    private Attachment attachment;
    private  double price;
    private Integer guarantee;
    private String description;
}
