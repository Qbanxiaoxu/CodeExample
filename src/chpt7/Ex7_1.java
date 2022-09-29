package chpt7;

class Product<T,V> {
	private T type;
	private V ID;
	
	Product(T ty, V id)
	{
		this.type = ty;
		this.ID = id;
	}
	
	public T getType(){
		return type;
	}
	public V getID(){
		return ID;
	}
}
public class Ex7_1{
	public static void main(String[] args){
		Product<String, Integer> apple = new Product<String,Integer>("ipad2",12);
		System.out.println("Product type:"+apple.getType());
		System.out.println("Product ID:"+apple.getID());	
	}
}