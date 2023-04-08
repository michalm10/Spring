package ug.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ug.app.domain.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {
}
