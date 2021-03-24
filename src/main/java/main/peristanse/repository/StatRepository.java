package main.peristanse.repository;

import main.peristanse.entity.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatRepository extends JpaRepository<Conversion, Integer> {

    @Query(value = "SELECT distinct conv.toValue  FROM Conversion conv WHERE conv.usdValue > 100000")
    List<Long> getUserMoreConversion();

    @Query(value = "SELECT conv.id FROM Conversion conv WHERE sum(conv.usdValue) > 10000 GROUP BY conv.id")
    List<Long> getUsersSummaryMoreConversion();
}
