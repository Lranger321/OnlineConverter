package main.peristanse.repository;

import main.peristanse.entity.Conversion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRepository extends CrudRepository<Conversion,Integer> {
}
