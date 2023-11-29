package cl.gabodev.crto.balger.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.gabodev.crto.balger.domain.entity.RawBinanceSpot;

@Repository
public interface RawBinanceSpotRepository extends JpaRepository<RawBinanceSpot, Long> {
	
}