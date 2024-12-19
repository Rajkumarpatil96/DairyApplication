package com.dairyapplication.dairyApplication.repository;

import com.dairyapplication.dairyApplication.entity.RateChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RateChartRepository extends JpaRepository<RateChart,Long> {
    @Query(value = "SELECT * FROM rate_chart WHERE animal_type = :animalType AND session = :session ", nativeQuery = true)
    Optional<RateChart> findActiveRateChart(@Param("animalType") String animalType,
                                            @Param("session") String session);
}
