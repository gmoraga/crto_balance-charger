package cl.gabodev.crto.balger.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.gabodev.crto.balger.domain.entity.RawBinanceP2p;
import cl.gabodev.crto.balger.repository.RawBinanceP2pRepository;

@Service
public class RawBinanceP2pService {

	@Autowired
	RawBinanceP2pRepository rawBinanceP2pRepository;

	public RawBinanceP2p save(RawBinanceP2p rawBinanceP2p) {
		return rawBinanceP2pRepository.save(rawBinanceP2p);
	}

	public List<RawBinanceP2p> saveAll(List<RawBinanceP2p> rawBinanceP2pList) {
		return rawBinanceP2pRepository.saveAll(rawBinanceP2pList);
	}
}