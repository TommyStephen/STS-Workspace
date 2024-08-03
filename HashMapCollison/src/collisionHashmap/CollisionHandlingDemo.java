package collisionHashmap;

import java.util.HashMap;
import java.util.Map;

public class CollisionHandlingDemo {

	public static void main(String[] args) {

		 Map<Key, String> map = new HashMap<>();
		// Adding entries that will cause hash collisions
        map.put(new Key("Key1"), "Value1");
        map.put(new Key("Key2"), "Value2");
        map.put(new Key("Key3"), "Value3");
        map.put(new Key("Key4"), "Value4");

        // Displaying the map entries
        for (Map.Entry<Key, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
        
        System.out.println(map);

        // Retrieving values to see if collision handling works correctly
        System.out.println("Retrieving values:");
        System.out.println("Key1 => " + map.get(new Key("Key1")));
        System.out.println("Key2 => " + map.get(new Key("Key2")));
        System.out.println("Key3 => " + map.get(new Key("Key3")));
        System.out.println("Key4 => " + map.get(new Key("Key4")));
	}

}
