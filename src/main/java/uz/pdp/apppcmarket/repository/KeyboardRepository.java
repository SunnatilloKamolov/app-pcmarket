package uz.pdp.apppcmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.apppcmarket.entity.KeyBoard;
import uz.pdp.apppcmarket.projection.CustomKeyboard;

@RepositoryRestResource(path = "keyboard",collectionResourceRel = "list",excerptProjection = CustomKeyboard.class)
public interface KeyboardRepository extends JpaRepository<KeyBoard,Integer> {
    @RestResource(path = "byName")
    Page<KeyBoard> findAllByName(@Param("name") String name, Pageable pageable);
}
