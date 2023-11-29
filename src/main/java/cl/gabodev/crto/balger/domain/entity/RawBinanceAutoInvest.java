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
		name="balger_raw_binance_auto_invest",
		schema = "public"
		)
@Data
@AllArgsConstructor
public class RawBinanceAutoInvest {

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
	private ZonedDateTime dtTransaction; //Auto-Invest Date(UTC) / '2022-06-01 07:00:00
	
	@Column(name="holding _coin", insertable=true, updatable=false)
	private String holdingCoin; //Holding Coin / VET

	@Column(name="amount_per_period", insertable=true, updatable=true)
	private String amountPerPeriod; //Amount per period / 0.10000000 BUSD

	@Column(name="trading_fee", insertable=true, updatable=true)
	private String tradingFee; //Trading Fee / 0.00020000 BUSD

	@Column(name="units", insertable=true, updatable=true)
	private String units; //Units / 3.00175409 VET

	@Column(name="from", insertable=true, updatable=true)
	private String from; //From / Spot Wallet + Flexible Savings

	@Column(name="status", insertable=true, updatable=true)
	private String status; //Status / Success
	
	public RawBinanceAutoInvest(boolean processed, boolean apply, ZonedDateTime dtCreate,
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