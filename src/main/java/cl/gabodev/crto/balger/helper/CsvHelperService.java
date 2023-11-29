package cl.gabodev.crto.balger.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cl.gabodev.crto.balger.domain.entity.RawBinanceP2p;
import cl.gabodev.crto.balger.exception.FileLoadException;
import cl.gabodev.crto.balger.util.Constants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvHelperService {
	//public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	//static String[] HEADERs = { "Id", "Title", "Description", "Published" };
	//static String SHEET = "Tutorials";

	static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


	private CsvHelperService() {
		throw new IllegalStateException("Utility class");
	}

	public static boolean hasCsvFormat(MultipartFile file) {
		return (Constants.FILE_TYPE_CSV.equals(file.getContentType()));
	}

	public static List<RawBinanceP2p> csvToListRawBinanceP2p(InputStream is, final String user) throws FileLoadException {

		List<RawBinanceP2p> rawBinanceP2pList = new ArrayList<>();

		//BufferedReader br;
		List<String> result = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is))){

			String line;
			//InputStream is = multipart.getInputStream();
			//br = new BufferedReader(new InputStreamReader(is));
			
			RawBinanceP2p rawBinanceP2p;
			ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
			int columnIdx = 0;			
			while ((line = br.readLine()) != null) {
				log.info("line: "+line);
				//result.add(line);
				try {
					String[] arrayData = line.split(",");
					
					rawBinanceP2p = new RawBinanceP2p(false, false, zonedDateTime, user, user);
					
					columnIdx = 0;
					
					//Order Number / 20359548691858124800
					rawBinanceP2p.setOrderNumber(arrayData[columnIdx++]);
					
					//Order Type / Buy
					rawBinanceP2p.setOrderType(arrayData[columnIdx++]);
					
					//Asset Type / BUSD
					rawBinanceP2p.setAssetType(arrayData[columnIdx++]);
					
					//Fiat Type / CLP
					rawBinanceP2p.setFiatType(arrayData[columnIdx++]);
					
					//Total Price / 87500.00000000
					rawBinanceP2p.setTotalPrice(arrayData[columnIdx++]);
					
					//Price / 875.00000000
					rawBinanceP2p.setPrice(arrayData[columnIdx++]);
					
					//Quantity / 100.00000000
					rawBinanceP2p.setQuantity(arrayData[columnIdx++]);
					
					//Couterparty / VentasCcS
					rawBinanceP2p.setCouterparty(arrayData[columnIdx++]);
					
					//Status / Completed
					rawBinanceP2p.setStatus(arrayData[columnIdx++]);
					
					//Created Time / 2022-05-16 16:04:52 UTC+0
					final String dateComplete = arrayData[columnIdx++];
					final String date = dateComplete.substring(0, dateComplete.indexOf("UTC")).trim();
					final String zone = dateComplete.substring(dateComplete.indexOf("UTC"), dateComplete.length()).trim();
					
					rawBinanceP2p.setCreatedTime(ZonedDateTime.parse(date, formatter.withZone(ZoneId.of(zone))));
					
				} catch (Exception e) {
					log.error("Exception::ErrorProcessLine :"+line+", Exception: "+e);
				}
			}

		} catch (IOException e) {
			log.error("IOException :"+e);
			throw new FileLoadException("fail to parse Excel file: " + e.getMessage());      
		}

		return rawBinanceP2pList;
		
		/*

		try (Workbook workbook = new XSSFWorkbook(is)) {
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			List<RawBinanceCard> rawBinanceCardList = new ArrayList<>();
			int rowNumber = 0;
			int cellIdx = 0;
			String zoneStr = "UTC";
			ZoneId zone = ZoneId.of(zoneStr);
			RawBinanceCard rawBinanceCard;
			ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				// skip header
				if (rowNumber == 0) {
					Pattern utcPattern = Pattern.compile("\\((?<utc>[^()]*[^()]*)\\)");
					Matcher utcMatcher = utcPattern.matcher(currentRow.getCell(0).getStringCellValue());
					if(utcMatcher.find()) {
						zoneStr = utcMatcher.group("utc");
					}
					zone = ZoneId.of(zoneStr);
					rowNumber++;
					continue;
				}

				rawBinanceCard = new RawBinanceCard(false, false, zonedDateTime, user, user);

				cellIdx = 0;

				//Date(UTC-4) '2021-11-01 22:21:55				
				rawBinanceCard.setDtTransaction(ZonedDateTime.parse(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue(), formatter.withZone(zone)));

				//Method Credit Card
				rawBinanceCard.setMethod(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());

				//Amount 35.00 USD
				rawBinanceCard.setAmount(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());

				//Price 1.02597078 USDT/USD
				rawBinanceCard.setPrice(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());

				//Fees 0.71 USD
				rawBinanceCard.setFees(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());

				//Final Amount 33.42200458 USDT
				rawBinanceCard.setFinalAmount(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());

				//Status Completed
				rawBinanceCard.setStatus(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());

				//Transaction ID N01151858829746060288110209
				rawBinanceCard.setTransactionId(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());


				rawBinanceCardList.add(rawBinanceCard);
			}

			return rawBinanceCardList;
		} catch (IOException e) {
			throw new FileLoadException("fail to parse Excel file: " + e.getMessage());
		} 
		*/
	}
}