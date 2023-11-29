package cl.gabodev.crto.balger.services;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cl.gabodev.crto.balger.domain.dto.response.ResponseCommontoDto;
import cl.gabodev.crto.balger.domain.entity.RawBinanceAutoInvest;
import cl.gabodev.crto.balger.domain.entity.RawBinanceCard;
import cl.gabodev.crto.balger.domain.entity.RawBinanceP2p;
import cl.gabodev.crto.balger.domain.entity.RawBinanceSpot;
import cl.gabodev.crto.balger.exception.FileLoadException;
import cl.gabodev.crto.balger.helper.CsvHelperService;
import cl.gabodev.crto.balger.helper.ExcelHelperService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChargerService {
	
	private static final String UNDEFINED = "Undefined";
	private static final String IO_EXCEPTION = "IOException: ";
	private static final String FILE_EXCEPTION = "FileLoadException: ";
	
	private static final String MSG_SAVE_DATA = "Save data.";
	private static final String MSG_ERROR_INPUT_FILE = "Error input file.";
	private static final String MSG_ERROR_PROCESS_FILE = "Error process file.";


	@Autowired
	RawBinanceCardService rawBinanceCardService;
	
	@Autowired
	RawBinanceP2pService rawBinanceP2pService;
	
	@Autowired
	RawBinanceSpotService rawBinanceSpotService;
	
	@Autowired
	RawBinanceAutoInvestService rawBinanceAutoInvestService;


	public ResponseCommontoDto saveChargerCard(MultipartFile file, final String user) {
		
		ResponseCommontoDto responseCommontoDto = new ResponseCommontoDto(false, 500, UNDEFINED);
				
		this.logSaveCharger(file);
		
		try {
			final List<RawBinanceCard> rawBinanceCardList  = ExcelHelperService.excelToListRawBinanceCard(file.getInputStream(), user);				
			log.info("rawBinanceCardList::Size: "+rawBinanceCardList.size());
			log.info("rawBinanceCardList:TransactionIds: "+rawBinanceCardList.stream().map(RawBinanceCard::getTransactionId)
					.collect(Collectors.joining(";")));
			
			final List<RawBinanceCard> rawBinanceCardListOut = this.rawBinanceCardService.saveAll(rawBinanceCardList);
			log.info("rawBinanceCardListOut::Size: "+rawBinanceCardListOut.size());
			log.info("rawBinanceCardListOut:TransactionIds: "+rawBinanceCardListOut.stream().map(RawBinanceCard::getTransactionId)
					.collect(Collectors.joining(";")));
		    
			responseCommontoDto.setResult(true);
			responseCommontoDto.setStatusCode(201);
			responseCommontoDto.setStatusMessage(MSG_SAVE_DATA);
		} catch (IOException e) {
			log.error(IO_EXCEPTION+e);
			responseCommontoDto.setStatusMessage(MSG_ERROR_INPUT_FILE);
		} catch (FileLoadException e) {
			log.error(FILE_EXCEPTION+e);
			responseCommontoDto.setStatusMessage(MSG_ERROR_PROCESS_FILE);
		}
		
		return responseCommontoDto;
	}

	public ResponseCommontoDto saveChargerP2p(MultipartFile file, final String user) {
		
		ResponseCommontoDto responseCommontoDto = new ResponseCommontoDto(false, 500, UNDEFINED);
				
		this.logSaveCharger(file);
		
		try {
			final List<RawBinanceP2p> rawBinanceP2pList  = CsvHelperService.csvToListRawBinanceP2p(file.getInputStream(), user);				
			log.info("rawBinanceP2pList::Size: "+rawBinanceP2pList.size());
			log.info("rawBinanceP2pList:TransactionIds: "+rawBinanceP2pList.stream().map(RawBinanceP2p::getOrderNumber)
					.collect(Collectors.joining(";")));
			
			
			final List<RawBinanceP2p> rawBinanceP2pListOut = this.rawBinanceP2pService.saveAll(rawBinanceP2pList);
			log.info("rawBinanceP2pListOut::Size: "+rawBinanceP2pListOut.size());
			log.info("rawBinanceP2pListOut:TransactionIds: "+rawBinanceP2pListOut.stream().map(RawBinanceP2p::getOrderNumber)
					.collect(Collectors.joining(";")));
			
			
			responseCommontoDto.setResult(true);
			responseCommontoDto.setStatusCode(201);
			responseCommontoDto.setStatusMessage(MSG_SAVE_DATA);
		} catch (IOException e) {
			log.error(IO_EXCEPTION+e);
			responseCommontoDto.setStatusMessage(MSG_ERROR_INPUT_FILE);
		} catch (FileLoadException e) {
			log.error(FILE_EXCEPTION+e);
			responseCommontoDto.setStatusMessage(MSG_ERROR_PROCESS_FILE);
		}
		
		return responseCommontoDto;
	}
	
	public ResponseCommontoDto saveChargerSpot(MultipartFile file, final String user) {
		
		ResponseCommontoDto responseCommontoDto = new ResponseCommontoDto(false, 500, UNDEFINED);
				
		this.logSaveCharger(file);
		
		try {
			final List<RawBinanceSpot> rawBinanceSpotList  = ExcelHelperService.excelToListRawBinanceSpot(file.getInputStream(), user);				
			log.info("rawBinanceSpotList::Size: "+rawBinanceSpotList.size());
			log.info("rawBinanceSpotList:TransactionIds: "+rawBinanceSpotList.stream().map(RawBinanceSpot::getstrDtTransaction)
					.collect(Collectors.joining(";")));
			
			final List<RawBinanceSpot> rawBinanceSpotListOut = this.rawBinanceSpotService.saveAll(rawBinanceSpotList);
			log.info("rawBinanceSpotListOut::Size: "+rawBinanceSpotListOut.size());
			log.info("rawBinanceSpotListOut:TransactionIds: "+rawBinanceSpotListOut.stream().map(RawBinanceSpot::getstrDtTransaction)
					.collect(Collectors.joining(";")));
		    
			responseCommontoDto.setResult(true);
			responseCommontoDto.setStatusCode(201);
			responseCommontoDto.setStatusMessage(MSG_SAVE_DATA);
		} catch (IOException e) {
			log.error(IO_EXCEPTION+e);
			responseCommontoDto.setStatusMessage(MSG_ERROR_INPUT_FILE);
		} catch (FileLoadException e) {
			log.error(FILE_EXCEPTION+e);
			responseCommontoDto.setStatusMessage(MSG_ERROR_PROCESS_FILE);
		}
		
		return responseCommontoDto;
	}
	
	public ResponseCommontoDto saveChargerAutoInvest(MultipartFile file, final String user) {
		
		ResponseCommontoDto responseCommontoDto = new ResponseCommontoDto(false, 500, UNDEFINED);
						
		this.logSaveCharger(file);
		
		try {
			final List<RawBinanceAutoInvest> rawBinanceAutoInvestList  = ExcelHelperService.excelToListRawBinanceAutoInvest(file.getInputStream(), user);				
			log.info("rawBinanceAutoInvestList::Size: "+rawBinanceAutoInvestList.size());
			log.info("rawBinanceAutoInvestList:TransactionIds: "+rawBinanceAutoInvestList.stream().map(RawBinanceAutoInvest::getstrDtTransaction)
					.collect(Collectors.joining(";")));
			
			final List<RawBinanceAutoInvest> rawBinanceAutoInvestListOut = this.rawBinanceAutoInvestService.saveAll(rawBinanceAutoInvestList);
			log.info("rawBinanceAutoInvestListOut::Size: "+rawBinanceAutoInvestListOut.size());
			log.info("rawBinanceAutoInvestListOut:TransactionIds: "+rawBinanceAutoInvestListOut.stream().map(RawBinanceAutoInvest::getstrDtTransaction)
					.collect(Collectors.joining(";")));
		    
			responseCommontoDto.setResult(true);
			responseCommontoDto.setStatusCode(201);
			responseCommontoDto.setStatusMessage(MSG_SAVE_DATA);
		} catch (IOException e) {
			log.error(IO_EXCEPTION+e);
			responseCommontoDto.setStatusMessage(MSG_ERROR_INPUT_FILE);
		} catch (FileLoadException e) {
			log.error(FILE_EXCEPTION+e);
			responseCommontoDto.setStatusMessage(MSG_ERROR_PROCESS_FILE);
		}
		
		return responseCommontoDto;
	}
	
	private void logSaveCharger(MultipartFile file) {
		log.info("file.getName(): "+file.getName());
		log.info("file.getOriginalFilename(): "+file.getOriginalFilename());
		log.info("file.getSize(): "+file.getSize());
		log.info("file.getContentType(): "+file.getContentType());
		log.info("file.getResource(): "+file.getResource());
	}
	
}