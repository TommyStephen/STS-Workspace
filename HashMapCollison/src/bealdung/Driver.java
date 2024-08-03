package bealdung;

import java.util.HashMap;
import java.util.Map;

public class Driver {

	public static void main(String[] args) {
		
		MyKey key = new MyKey(1);
	    Map<MyKey, String> map = new HashMap<>();
	    map.put(key, "val");
	    //It can be seen that the hashcode method is called 
	    //when the MyKey object is passed as key for the entry
	    
	    

	}

}
