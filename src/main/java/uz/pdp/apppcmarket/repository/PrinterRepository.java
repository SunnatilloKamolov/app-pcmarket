package uz.pdp.apppcmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.apppcmarket.entity.Printer;
import uz.pdp.apppcmarket.projection.CustomPrinter;

@RepositoryRestResource(path = "printer",collectionResourceRel = "list",excerptProjection = CustomPrinter.class)
public interface PrinterRepository extends JpaRepository<Printer,Integer> {
    @RestResource(path = "byName")
    Page<Printer> findAllByName(@Param("name") String name, Pageable pageable);
}
