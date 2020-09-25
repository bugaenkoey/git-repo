package testDb;

public class MercedesCar {
	int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	String carId, model, yearManufacture, colour, price, registrationNumber;


	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYearManufacture() {
		return yearManufacture;
	}

	public void setYearManufacture(String yearManufacture) {
		this.yearManufacture = yearManufacture;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	@Override
	public String toString() {
		return "MercedesCar [id=" + id + ", carId=" + carId + ", model=" + model + ", yearManufacture="
				+ yearManufacture + ", colour=" + colour + ", price=" + price + ", registrationNumber="
				+ registrationNumber + "]";
	}

}
