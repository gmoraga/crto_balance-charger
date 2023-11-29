package cl.gabodev.crto.balger.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.gabodev.crto.balger.domain.entity.RawBinanceP2p;

@Repository
public interface RawBinanceP2pRepository extends JpaRepository<RawBinanceP2p, Long> {
	
}