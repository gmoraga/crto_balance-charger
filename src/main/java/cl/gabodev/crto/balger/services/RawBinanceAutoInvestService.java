package cl.gabodev.crto.balger.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.gabodev.crto.balger.domain.entity.RawBinanceAutoInvest;
import cl.gabodev.crto.balger.repository.RawBinanceAutoInvestRepository;

@Service
public class RawBinanceAutoInvestService {

	@Autowired
	RawBinanceAutoInvestRepository rawBinanceAutoInvestRepository;

	public RawBinanceAutoInvest save(RawBinanceAutoInvest rawBinanceAutoInvest) {
		return rawBinanceAutoInvestRepository.save(rawBinanceAutoInvest);
	}

	public List<RawBinanceAutoInvest> saveAll(List<RawBinanceAutoInvest> rawBinanceAutoInvestList) {
		return rawBinanceAutoInvestRepository.saveAll(rawBinanceAutoInvestList);
	}
}