package cl.gabodev.crto.balger.common;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

//@SpringBootTest
//@AutoConfigureMockMvc
@Slf4j
public class CommonTest {

	//@Autowired
	//private MockMvc mvc;

	@Test
	void testCommon() throws Exception {
		//Date(UTC-4) '2021-11-01 22:21:55
		
		String fecha = "2021-11-01 22:21:55";
		String zone = "UTC-4";
		
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC"));
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		ZonedDateTime zonedDateTime = ZonedDateTime.parse(fecha, formatter.withZone(ZoneId.of(zone)));
	
		log.info("getZone: "+zonedDateTime.getZone());
		log.info("zonedDateTime: "+zonedDateTime);
		log.info("getChronology: "+zonedDateTime.getChronology());
		log.info("getOffset: "+zonedDateTime.getOffset());
		log.info("toOffsetDateTime: "+zonedDateTime.toOffsetDateTime());
		log.info("toLocalDateTime: "+zonedDateTime.toLocalDateTime());
		
		assertTrue(true);
		
	}
	
	@Test
	void testCommon2() throws Exception {
		//Pattern phonePattern = Pattern.compile("(\\d{3})-(\\d{3})-(\\d{4})");
		//Matcher phoneMatcher = phonePattern.matcher("abcd800-555-1234wxyz");
		
		//Pattern phonePattern = Pattern.compile("\\(([^()]*[^()]*)\\)");
		Pattern phonePattern = Pattern.compile("\\((?<utc>[^()]*[^()]*)\\)");
		
		//Matcher phoneMatcher = phonePattern.matcher("Date(UTC-4)");
		Matcher phoneMatcher = phonePattern.matcher("Date(UTC-4)fdfdfdf(fdffd)(fgfg)");
		
		log.info("df: "+phoneMatcher);
		log.info("dsd: "+phoneMatcher.find());
		log.info("dsd: "+phoneMatcher.group());
		log.info("dsd: "+phoneMatcher.groupCount());
		log.info("dsd444: "+phoneMatcher.group("utc"));
		
		assertTrue(true);
		
	}
	
	@Test
	void testCommon3() throws Exception {
		
		OffsetDateTime offsetDateTime = OffsetDateTime.now(ZoneOffset.UTC);
		Instant ins = Instant.now();
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
		
		log.info("offsetDateTime: "+offsetDateTime);
		log.info("ins: "+ins);
		log.info("zonedDateTime: "+zonedDateTime);
		
		assertTrue(true);
		
	}
	
	@Test
	void testCommon4() throws Exception {
		
		String dateComplete = "2022-05-16 16:04:52 UTC+0";
		
		String date = dateComplete.substring(0, dateComplete.indexOf("UTC"));
		String zone = dateComplete.substring(dateComplete.indexOf("UTC"), dateComplete.length());
		
		log.info("date: "+date.trim());
		log.info("zone: "+zone.trim());
		
		/*
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS+s");
		
		ZonedDateTime zonedDateTime = ZonedDateTime.parse(fecha, formatter);
		
	
		log.info("zonedDateTime: "+zonedDateTime);
		*/
		
		assertTrue(true);
		
	}
	
}