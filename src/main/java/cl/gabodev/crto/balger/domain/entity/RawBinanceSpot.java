package cl.gabodev.crto.balger.domain.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(
		name="balger_raw_binance_spot",
		schema = "public"
		)
@Data
@AllArgsConstructor
public class RawBinanceSpot {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="processed", insertable=false, updatable=true)
	private boolean processed;

	@Column(name="apply", insertable=false, updatable=true)
	private boolean apply;

	@Column(name="dt_create", insertable=false, updatable=false)
	private ZonedDateTime dtCreate;

	@Column(name="dt_update", insertable=false, updatable=true)
	private ZonedDateTime dtUpdate;

	@Column(name="user_create", insertable=true, updatable=false)
	private String userCreate;

	@Column(name="user_update", insertable=true, updatable=true)
	private String userUpdate;
	
	@Column(name="dt_transaction", insertable=true, updatable=false)
	private ZonedDateTime dtTransaction; //Date(UTC) '2021-12-31 19:47:34
	
	@Column(name="market", insertable=true, updatable=false)
	private String market; //Market DOTBUSD

	@Column(name="type", insertable=true, updatable=true)
	private String type; //Type BUY 

	@Column(name="price", insertable=true, updatable=true)
	private String price; //Price 0.00003385

	@Column(name="amount", insertable=true, updatable=true)
	private String amount; //Amount 17.1

	@Column(name="total_price", insertable=true, updatable=true)
	private String totalPrice; //Total 19.9999727

	@Column(name="fee", insertable=true, updatable=true)
	private String fee; //Fee 0.000057

	@Column(name="fee_coin", insertable=true, updatable=true)
	private String feeCoin; //Fee Coin BNB
	
	public RawBinanceSpot(boolean processed, boolean apply, ZonedDateTime dtCreate,
			String userCreate, String userUpdate) {
		this.processed = processed;
		this.apply = apply;
		this.dtCreate = dtCreate;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
	}

	public String getstrDtTransaction() {
		return this.getDtTransaction().toString();
	}
	
	
}