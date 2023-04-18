package uz.pdp.apppcmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.apppcmarket.entity.Computer;
import uz.pdp.apppcmarket.projection.CustomComputer;

@RepositoryRestResource(path = "computer",collectionResourceRel = "list",excerptProjection = CustomComputer.class)
public interface ComputerRepository extends JpaRepository<Computer,Integer> {
    @RestResource(path = "byName")
    Page<Computer> findAllByName(@Param("name") String name, Pageable pageable);
    boolean existsByName(String name);
}
