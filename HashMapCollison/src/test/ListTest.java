package test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("John");
		list.add("Balan");
		list.add("Ravi");
		
		String name = list.get(1);
		System.out.println(name);
		
		

	}

}
