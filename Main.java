public class Main {
	public static void main(String args[]){		    
		FixedSizeHashMap map = new FixedSizeHashMap(1);
		boolean success;
		success = map.set("A", 1);
		System.out.println("Add status: " + success);
		System.out.println("Load of the map is " + map.load());
		success = map.set("B", 2);
		System.out.println("Add status: " + success);
		System.out.println("Load of the map is " + map.load());
		success = map.set("C", 3);
		System.out.println("Add status: " + success);
		System.out.println("Load of the map is " + map.load());
		success = map.set("D", 4);
		System.out.println("Add status: " + success);
		System.out.println("Load of the map is " + map.load());
		success = map.set("E", 5);
		System.out.println("Add status: " + success);
		System.out.println("Load of the map is " + map.load());
		success = map.set("F", 6);
		System.out.println("Add status: " + success);
		System.out.println("Load of the map is " + map.load());
		success = map.set("G", 7);
		System.out.println("Add status: " + success);
		System.out.println("Load of the map is " + map.load());
		success = map.set("H", 8);
		System.out.println("Add status: " + success);
		System.out.println("Load of the map is " + map.load());
		success = map.set("I", 9);
		System.out.println("Add status: " + success);
		System.out.println("Load of the map is " + map.load());
		success = map.set("J", 10);
		System.out.println("Add status: " + success);
		System.out.println("Load of the map is " + map.load());
		success = map.set("K", 11);
		System.out.println("Add status: " + success);
		System.out.println("Load of the map is " + map.load());
		success = map.set("L", 12);
		System.out.println("Add status: " + success);
		System.out.println("Load of the map is " + map.load());
		success = map.set("M", 13);
		System.out.println("Add status: " + success);
		System.out.println("Load of the map is " + map.load());
		System.out.println(map.get("A"));
		System.out.println(map.get("K"));
		System.out.println(map.get("L"));
		
		try {
			Object obj = map.delete("L");
			System.out.println("Delete key 'L' with value " + obj.toString());
		} catch (IllegalArgumentException e){
			System.out.println("Cannot delete the key " + e.toString());
		}
		
		try {
			Object obj = map.delete("A");
			System.out.println("Deleted key 'A' with value " + obj.toString());
		} catch (IllegalArgumentException e){
			System.out.println("Cannot delete the key " + e.toString());
		}
		System.out.println("Load of the map is " + map.load());
		success = map.set("L", 12);
		System.out.println("Add status: " + success);
		System.out.println("Load of the map is " + map.load());

	}	
}
