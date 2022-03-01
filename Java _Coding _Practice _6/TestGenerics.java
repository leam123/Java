import java.util.*;

public class TestGenerics{
	public static void main(String[] args){
		Generics<String,String> gen1 = new Generics<String,String>("Leamor","Garcia");
		System.out.println(gen1.getObject1() + gen1.getObject2());
		Generics<String,Float> gen2 = new Generics<String,Float>("Leamor",4.3f);
		System.out.println(gen2.getObject1() + gen2.getObject2());
	}
}