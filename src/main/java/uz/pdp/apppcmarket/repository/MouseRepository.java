package uz.pdp.apppcmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.apppcmarket.entity.Mouse;
import uz.pdp.apppcmarket.projection.CustomMouse;

@RepositoryRestResource(path = "mouse",collectionResourceRel = "list",excerptProjection = CustomMouse.class)
public interface MouseRepository extends JpaRepository<Mouse,Integer> {
    @RestResource(path = "byName")
    Page<Mouse> findAllByName(@Param("name") String name, Pageable pageable);
}
