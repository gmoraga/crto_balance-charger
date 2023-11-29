package cl.gabodev.crto.balger.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.gabodev.crto.balger.domain.entity.RawBinanceAutoInvest;

@Repository
public interface RawBinanceAutoInvestRepository extends JpaRepository<RawBinanceAutoInvest, Long> {
	
}