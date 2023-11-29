package cl.gabodev.crto.balger.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.gabodev.crto.balger.domain.entity.RawBinanceCard;
import cl.gabodev.crto.balger.repository.RawBinanceCardRepository;

@Service
public class RawBinanceCardService {

	@Autowired
	RawBinanceCardRepository rawBinanceCardRepository;

	public RawBinanceCard save(RawBinanceCard rawBinanceCard) {
		return rawBinanceCardRepository.save(rawBinanceCard);
	}

	public List<RawBinanceCard> saveAll(List<RawBinanceCard> rawBinanceCardList) {
		return rawBinanceCardRepository.saveAll(rawBinanceCardList);
	}
}