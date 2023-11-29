package cl.gabodev.crto.balger.helper;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import cl.gabodev.crto.balger.domain.entity.RawBinanceAutoInvest;
import cl.gabodev.crto.balger.domain.entity.RawBinanceCard;
import cl.gabodev.crto.balger.domain.entity.RawBinanceSpot;
import cl.gabodev.crto.balger.exception.FileLoadException;
import cl.gabodev.crto.balger.util.Constants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExcelHelperService {
	//public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	//static String[] HEADERs = { "Id", "Title", "Description", "Published" };
	//static String SHEET = "Tutorials";
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private static final String PATTERN_UTC = "\\((?<utc>[^()]*[^()]*)\\)";
	private static final String UTC = "UTC";
	private static final String GROUP_UTC = "utc";
	private static final String IO_EXCEPTION = "IOException :";
	private static final String MSG_FAIL_FILE = "fail to parse Excel file: ";
	
	private ExcelHelperService() {
		throw new IllegalStateException("Utility class");
	}

	public static boolean hasExcelFormat(MultipartFile file) {
		return (Constants.FILE_TYPE_XLSX.equals(file.getContentType()));
	}

	public static List<RawBinanceCard> excelToListRawBinanceCard(InputStream is, final String user) throws FileLoadException {
		try (Workbook workbook = new XSSFWorkbook(is)) {
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			List<RawBinanceCard> rawBinanceCardList = new ArrayList<>();
			int rowNumber = 0;
			int cellIdx = 0;
			String zoneStr = UTC;
			ZoneId zone = ZoneId.of(zoneStr);
			RawBinanceCard rawBinanceCard;
			ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				// skip header
				if (rowNumber == 0) {
					Pattern utcPattern = Pattern.compile(PATTERN_UTC);
					Matcher utcMatcher = utcPattern.matcher(currentRow.getCell(0).getStringCellValue());
					if(utcMatcher.find()) {
						zoneStr = utcMatcher.group(GROUP_UTC);
					}
					zone = ZoneId.of(zoneStr);
					rowNumber++;
					continue;
				}

				rawBinanceCard = new RawBinanceCard(false, false, zonedDateTime, user, user);
				
				cellIdx = 0;
				
				//Date(UTC-4) / '2021-11-01 22:21:55				
				rawBinanceCard.setDtTransaction(ZonedDateTime.parse(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue(), formatter.withZone(zone)));

				//Method / Credit Card
				rawBinanceCard.setMethod(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());
				
				//Amount / 35.00 USD
				rawBinanceCard.setAmount(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());
				
				//Price / 1.02597078 USDT/USD
				rawBinanceCard.setPrice(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());
				
				//Fees / 0.71 USD
				rawBinanceCard.setFees(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());
				
				//Final Amount / 33.42200458 USDT
				rawBinanceCard.setFinalAmount(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());
				
				//Status / Completed
				rawBinanceCard.setStatus(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());
				
				//Transaction ID / N01151858829746060288110209
				rawBinanceCard.setTransactionId(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());
				

				rawBinanceCardList.add(rawBinanceCard);
			}
			
			return rawBinanceCardList;
		} catch (IOException e) {
			log.error(IO_EXCEPTION+e);
			throw new FileLoadException(MSG_FAIL_FILE + e.getMessage());
		}
	}
	
	public static List<RawBinanceSpot> excelToListRawBinanceSpot(InputStream is, final String user) throws FileLoadException {
		try (Workbook workbook = new XSSFWorkbook(is)) {
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			List<RawBinanceSpot> rawBinanceSpotList = new ArrayList<>();
			int rowNumber = 0;
			int cellIdx = 0;
			String zoneStr = UTC;
			ZoneId zone = ZoneId.of(zoneStr);
			RawBinanceSpot rawBinanceSpot;
			ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				// skip header
				if (rowNumber == 0) {
					Pattern utcPattern = Pattern.compile(PATTERN_UTC);
					Matcher utcMatcher = utcPattern.matcher(currentRow.getCell(0).getStringCellValue());
					if(utcMatcher.find()) {
						zoneStr = utcMatcher.group(GROUP_UTC);
					}
					zone = ZoneId.of(zoneStr);
					rowNumber++;
					continue;
				}

				rawBinanceSpot = new RawBinanceSpot(false, false, zonedDateTime, user, user);
				
				cellIdx = 0;
				
				//Date(UTC) / '2021-12-31 19:47:34				
				rawBinanceSpot.setDtTransaction(ZonedDateTime.parse(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue(), formatter.withZone(zone)));

				//Market / DOTBUSD
				rawBinanceSpot.setMarket(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());
				
				//Type / BUY
				rawBinanceSpot.setType(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());		
				
				//Price / 0.00003385
				rawBinanceSpot.setPrice(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());				

				//Amount / 17.1
				rawBinanceSpot.setAmount(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());
				
				//Total / 19.9999727
				rawBinanceSpot.setTotalPrice(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());

				//Fee / 0.000057
				rawBinanceSpot.setFee(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());
				
				//Fee Coin / BNB
				rawBinanceSpot.setFeeCoin(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());

				rawBinanceSpotList.add(rawBinanceSpot);
			}
			
			return rawBinanceSpotList;
		} catch (IOException e) {
			log.error(IO_EXCEPTION+e);
			throw new FileLoadException(MSG_FAIL_FILE + e.getMessage());
		}
	}
	
	public static List<RawBinanceAutoInvest> excelToListRawBinanceAutoInvest(InputStream is, final String user) throws FileLoadException {
		try (Workbook workbook = new XSSFWorkbook(is)) {
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			List<RawBinanceAutoInvest> rawBinanceAutoInvestList = new ArrayList<>();
			int rowNumber = 0;
			int cellIdx = 0;
			String zoneStr = UTC;
			ZoneId zone = ZoneId.of(zoneStr);
			RawBinanceAutoInvest rawBinanceAutoInvest;
			ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				// skip header
				if (rowNumber == 0) {
					Pattern utcPattern = Pattern.compile(PATTERN_UTC);
					Matcher utcMatcher = utcPattern.matcher(currentRow.getCell(0).getStringCellValue());
					if(utcMatcher.find()) {
						zoneStr = utcMatcher.group(GROUP_UTC);
					}
					zone = ZoneId.of(zoneStr);
					rowNumber++;
					continue;
				}

				rawBinanceAutoInvest = new RawBinanceAutoInvest(false, false, zonedDateTime, user, user);
				
				cellIdx = 0;
				
				//Auto-Invest Date(UTC) / '2022-06-01 07:00:00			
				rawBinanceAutoInvest.setDtTransaction(ZonedDateTime.parse(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue(), formatter.withZone(zone)));

				//Holding Coin / VET
				rawBinanceAutoInvest.setHoldingCoin(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());
				
				//Amount per period / 0.10000000 BUSD
				rawBinanceAutoInvest.setAmountPerPeriod(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());		
				
				//Trading Fee / 0.00020000 BUSD
				rawBinanceAutoInvest.setTradingFee(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());				

				//Units / 3.00175409 VET
				rawBinanceAutoInvest.setUnits(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());
				
				//From / Spot Wallet + Flexible Savings
				rawBinanceAutoInvest.setFrom(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());

				//Status / Success
				rawBinanceAutoInvest.setStatus(currentRow.getCell(cellIdx++, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());

				rawBinanceAutoInvestList.add(rawBinanceAutoInvest);
			}
			
			return rawBinanceAutoInvestList;
		} catch (IOException e) {
			log.error(IO_EXCEPTION+e);
			throw new FileLoadException(MSG_FAIL_FILE + e.getMessage());
		}
	}
	
}