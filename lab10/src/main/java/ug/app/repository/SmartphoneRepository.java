package ug.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ug.app.domain.Smartphone;

import java.util.List;

@Repository
public interface SmartphoneRepository extends CrudRepository<Smartphone, Long> {
    List<Smartphone> findByModelOrStorage(String model, int storage);
    List<Smartphone> findByModel(String model);

    @Query("Select c from Smartphone c join fetch c.brand")
    List<Smartphone> findAll();
}
