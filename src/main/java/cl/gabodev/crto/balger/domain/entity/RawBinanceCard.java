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
		name="balger_raw_binance_card",
		schema = "public"
		)
@Data
@AllArgsConstructor
public class RawBinanceCard {

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
	private ZonedDateTime dtTransaction;

	@Column(name="method", insertable=true, updatable=true)
	private String method;

	@Column(name="amount", insertable=true, updatable=true)
	private String amount;

	@Column(name="price", insertable=true, updatable=true)
	private String price;

	@Column(name="fees", insertable=true, updatable=true)
	private String fees;

	@Column(name="final_amount", insertable=true, updatable=true)
	private String finalAmount;

	@Column(name="status", insertable=true, updatable=true)
	private String status;

	@Column(name="transaction_id", insertable=true, updatable=false)
	private String transactionId;
	
	public RawBinanceCard(boolean processed, boolean apply, ZonedDateTime dtCreate,
			String userCreate, String userUpdate) {
		this.processed = processed;
		this.apply = apply;
		this.dtCreate = dtCreate;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
	}

}