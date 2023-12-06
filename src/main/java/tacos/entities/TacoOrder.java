package tacos.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TacoOrder {
	
	private String deliveryName;
	private String deliveryStreet;
	private String deliveryCity;
	private String deliveryState;
	private String deliveryZip;
	private String ccNumber;
	private String ccExpiry;
	private String ccCVV;

	private List<Taco> tacos;;
	
	public TacoOrder() {
		this.setDeliveryName("");
		this.setDeliveryStreet("");
		this.setDeliveryCity("");
		this.setDeliveryState("");
		this.setDeliveryZip("");
		this.setCcNumber("");
		this.setCcExpiry("");
		this.setCcCVV("");
		this.tacos = new ArrayList<>();
	}
	
	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryStreet() {
		return deliveryStreet;
	}

	public void setDeliveryStreet(String deliveryStreet) {
		this.deliveryStreet = deliveryStreet;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public String getDeliveryZip() {
		return deliveryZip;
	}

	public void setDeliveryZip(String deliveryZip) {
		this.deliveryZip = deliveryZip;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcExpiry() {
		return ccExpiry;
	}

	public void setCcExpiry(String ccExpiry) {
		this.ccExpiry = ccExpiry;
	}

	public String getCcCVV() {
		return ccCVV;
	}

	public void setCcCVV(String ccCVV) {
		this.ccCVV = ccCVV;
	}
	
	public List<Taco> getTacos() {
		return this.tacos;
	}
	
	public void addTaco(Taco taco) {
		this.tacos.add(taco);
	}
	
	@Override
	public String toString() {
		String result = "";
		result += "\n" + "{deliveryName: " + this.deliveryName + ",";
		result += "\n" + "deliveryStreet: " + this.deliveryStreet + ",";
		result += "\n" + "deliveryCity: " + this.deliveryCity + ",";
		result += "\n" + "deliveryState: " + this.deliveryState + ",";
		result += "\n" + "deliveryZip: " + this.deliveryZip + ",";
		result += "\n" + "ccNumber: " + this.ccNumber + ",";
		result += "\n" + "ccExpiry: " + this.ccExpiry + ",";
		result += "\n" + "ccCVV: " + this.ccCVV + ",";
		result += "\n" + "tarcos: [";
		for (int i = 0; i < this.tacos.size(); i++) {
			result += this.tacos.get(i).toString();
		}
		result += "\n" + "]}";
		return result;
	}

}
