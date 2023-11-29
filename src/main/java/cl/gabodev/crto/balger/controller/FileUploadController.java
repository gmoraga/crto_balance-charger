package cl.gabodev.crto.balger.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cl.gabodev.crto.balger.domain.dto.response.ResponseCommontoDto;
import cl.gabodev.crto.balger.helper.CsvHelperService;
import cl.gabodev.crto.balger.helper.ExcelHelperService;
import cl.gabodev.crto.balger.services.ChargerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/file-upload")
@Slf4j
public class FileUploadController {
	
	private static final String C_ERROR_FILE_FORMAT = "Error file format.";
	
	@Autowired
	private ChargerService chargerService;

	@PostMapping(path = "/card", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> handleFileUploadCard(
			@RequestParam("file") @NotNull MultipartFile file,
			@RequestParam("user") @NotNull String user) {

		log.info("handleFileUploadCard: "+file.getOriginalFilename());
		
		ResponseEntity<String> result;
		
		if (ExcelHelperService.hasExcelFormat(file)) {
			final ResponseCommontoDto responseCommontoDto = this.chargerService.saveChargerCard(file, user);
			if (responseCommontoDto.isResult()) {
				result = ResponseEntity.status(HttpStatus.CREATED).body(responseCommontoDto.getStatusMessage());		
			} else {
				result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseCommontoDto.getStatusMessage());	
			}

		} else {
			result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(C_ERROR_FILE_FORMAT);
		}
		
		return result;
	}

	@PostMapping(path = "/p2p", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> handleFileUploadP2p(
			@RequestParam("file") @NotNull MultipartFile file,
			@RequestParam("user") @NotNull String user) {

		log.info("handleFileUploadP2p: "+file.getOriginalFilename());
		
		ResponseEntity<String> result;
		
		log.info("file.getName(): "+file.getName());
		log.info("file.getOriginalFilename(): "+file.getOriginalFilename());
		log.info("file.getSize(): "+file.getSize());
		log.info("file.getContentType(): "+file.getContentType());
		log.info("file.getResource(): "+file.getResource());
		
		if (CsvHelperService.hasCsvFormat(file)) {
			final ResponseCommontoDto responseCommontoDto = this.chargerService.saveChargerP2p(file, user);
			if (responseCommontoDto.isResult()) {
				result = ResponseEntity.status(HttpStatus.CREATED).body(responseCommontoDto.getStatusMessage());		
			} else {
				result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseCommontoDto.getStatusMessage());	
			}

		} else {
			result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(C_ERROR_FILE_FORMAT);
		}
		
		return result;
	}

	@PostMapping(path = "/spot", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> handleFileUploadSpot(
			@RequestParam("file") @NotNull MultipartFile file,
			@RequestParam("user") @NotNull String user) {

		log.info("handleFileUploadSpot: "+file.getOriginalFilename());
		
		ResponseEntity<String> result;
		
		log.info("file.getName(): "+file.getName());
		log.info("file.getOriginalFilename(): "+file.getOriginalFilename());
		log.info("file.getSize(): "+file.getSize());
		log.info("file.getContentType(): "+file.getContentType());
		log.info("file.getResource(): "+file.getResource());
		
		if (ExcelHelperService.hasExcelFormat(file)) {
			final ResponseCommontoDto responseCommontoDto = this.chargerService.saveChargerSpot(file, user);
			if (responseCommontoDto.isResult()) {
				result = ResponseEntity.status(HttpStatus.CREATED).body(responseCommontoDto.getStatusMessage());		
			} else {
				result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseCommontoDto.getStatusMessage());	
			}

		} else {
			result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(C_ERROR_FILE_FORMAT);
		}
		
		return result;
	}


	@PostMapping(path = "/auto-invest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> handleFileUploadAutoInvest(
			@RequestParam("file") @NotNull MultipartFile file,
			@RequestParam("user") @NotNull String user) {

		log.info("handleFileUploadAutoInvest: "+file.getOriginalFilename());
		
		ResponseEntity<String> result;
		
		log.info("file.getName(): "+file.getName());
		log.info("file.getOriginalFilename(): "+file.getOriginalFilename());
		log.info("file.getSize(): "+file.getSize());
		log.info("file.getContentType(): "+file.getContentType());
		log.info("file.getResource(): "+file.getResource());
		
		if (ExcelHelperService.hasExcelFormat(file)) {
			final ResponseCommontoDto responseCommontoDto = this.chargerService.saveChargerSpot(file, user);
			if (responseCommontoDto.isResult()) {
				result = ResponseEntity.status(HttpStatus.CREATED).body(responseCommontoDto.getStatusMessage());		
			} else {
				result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseCommontoDto.getStatusMessage());	
			}

		} else {
			result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(C_ERROR_FILE_FORMAT);
		}
		
		return result;
	}
	
	@PostMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public String handleFileUpload() {

		log.info("message You successfully uploaded ");
		
		//return new ResponseEntity<>("Hello World!", HttpStatus.OK);
        //return new ResponseEntity<>("Year of birth cannot be in the future", HttpStatus.BAD_REQUEST);
		//return new ResponseEntity<>("Your age is " + calculateAge(yearOfBirth), HttpStatus.OK);
		
		/*
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Custom-Header", "foo");  
	    return new ResponseEntity<>("Custom header set", headers, HttpStatus.OK);
		*/
		
		//return ResponseEntity.ok("Hello World!");
		
		//return ResponseEntity.badRequest().body("Year of birth cannot be in the future");
		
		//return ResponseEntity.status(HttpStatus.OK).body("Your age is " + calculateAge(yearOfBirth));
		
		//return ResponseEntity.ok().header("Custom-Header", "foo").body("Custom header set");
		
		return "TEST";
	}

}