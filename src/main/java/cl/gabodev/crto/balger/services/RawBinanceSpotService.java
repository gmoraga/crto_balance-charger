package cl.gabodev.crto.balger.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.gabodev.crto.balger.domain.entity.RawBinanceSpot;
import cl.gabodev.crto.balger.repository.RawBinanceSpotRepository;

@Service
public class RawBinanceSpotService {

	@Autowired
	RawBinanceSpotRepository rawBinanceSpotRepository;

	public RawBinanceSpot save(RawBinanceSpot rawBinanceSpot) {
		return rawBinanceSpotRepository.save(rawBinanceSpot);
	}

	public List<RawBinanceSpot> saveAll(List<RawBinanceSpot> rawBinanceSpotList) {
		return rawBinanceSpotRepository.saveAll(rawBinanceSpotList);
	}
}