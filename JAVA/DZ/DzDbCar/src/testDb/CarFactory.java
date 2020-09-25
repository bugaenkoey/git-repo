package testDb;

import java.util.List;

public abstract class CarFactory <T> {
	public abstract List<T> getAll();
	public abstract void addCar(T car);
	public abstract T getCarById(int id);
}


