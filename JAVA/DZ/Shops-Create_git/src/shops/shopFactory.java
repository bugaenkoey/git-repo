package shops;

import java.util.List;

@SuppressWarnings("hiding")
public abstract class shopFactory <Object>{
	public abstract List<Object> getAllShop();
	public abstract void addShop(Object shop);
	public abstract Object getShopId(int id);
	
//	public abstract 
}
