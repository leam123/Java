import java.util.*;

public class Generics<T,E>{
	private	T obj1;
	private	E obj2;
	public Generics(T obj1,E obj2){
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	public T getObject1(){
		return this.obj1;
	}
	public E getObject2(){
		return this.obj2;
	}

	//generic method
	/*public static <E> void printArray(E[] elements){
		for(E e: elements){
			System.out.println(e);
		}
	}*/
}