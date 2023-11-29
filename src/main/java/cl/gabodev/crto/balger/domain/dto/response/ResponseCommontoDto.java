package cl.gabodev.crto.balger.domain.dto.response;

import lombok.Data;

@Data
public class ResponseCommontoDto {

  private boolean result;
  private int statusCode;
  private String statusMessage;

  public ResponseCommontoDto(boolean result, int statusCode, String statusMessage) {
	  this.result = result;
	  this.statusCode = statusCode;
	  this.statusMessage = statusMessage; 
  }
  
}