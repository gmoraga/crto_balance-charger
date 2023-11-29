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
		name="balger_raw_binance_p2p",
		schema = "public"
		)
@Data
@AllArgsConstructor
public class RawBinanceP2p {

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
		
	@Column(name="order_number", insertable=true, updatable=false)
	private String orderNumber;

	@Column(name="order_type", insertable=true, updatable=true)
	private String orderType;

	@Column(name="asset_type", insertable=true, updatable=true)
	private String assetType;

	@Column(name="fiat_type", insertable=true, updatable=true)
	private String fiatType;

	@Column(name="total_price", insertable=true, updatable=true)
	private String totalPrice;

	@Column(name="price", insertable=true, updatable=true)
	private String price;

	@Column(name="quantity", insertable=true, updatable=true)
	private String quantity;

	@Column(name="couterparty", insertable=true, updatable=true)
	private String couterparty;

	@Column(name="status", insertable=true, updatable=true)
	private String status;
	
	@Column(name="created_time", insertable=true, updatable=true)
	private ZonedDateTime createdTime;
	
	public RawBinanceP2p(boolean processed, boolean apply, ZonedDateTime dtCreate,
			String userCreate, String userUpdate) {
		this.processed = processed;
		this.apply = apply;
		this.dtCreate = dtCreate;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
	}


}