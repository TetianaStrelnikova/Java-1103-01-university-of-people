package discussion;
import java.util.concurrent.ConcurrentHashMap;
public class ConcurrentExample {
	/**
	 * This program demonstrates the use of a ConcurrentHashMap 
	 * to store key-value pairs representing names and ages in a concurrent environment. 
	 * A ConcurrentHashMap is created to store key-value pairs, 
	 * where the keys are strings representing names and the values are integers representing ages. 
	 * Two key-value pairs are added to the ConcurrentHashMap using the put() method:
	 * - The first pair has a key of "Tati" and a value of 33.
	 * - The second pair has a key of "Oleksii" and a value of 35. 
	 * Two threads are then spawned to access the ConcurrentHashMap concurrently using lambda expressions:
	 * - The first thread accesses the value associated with the "Tati" key 
	 * using the get() method and prints the age to the console along with the name of the thread.
	 * - The second thread accesses the value associated with the "Oleksii" key 
	 * using the get() method and prints the age to the console along with the name of the thread. 
	 * Because the ConcurrentHashMap is designed to support high concurrency for read and write operations, 
	 * it is appropriate for use in a concurrent environment like this.
	 * @param args The command-line arguments passed to the program (unused in this example).
	 */
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> myConcurrentMap = new ConcurrentHashMap<>();
        myConcurrentMap.put("Tati", 33);
        myConcurrentMap.put("Oleksii", 35);
        
        // Spawn two threads to access the concurrent map concurrently
        new Thread(() -> {
            int age = myConcurrentMap.get("Tati");
            System.out.println(Thread.currentThread().getName() + " age: " + age);
        }).start();
        
        new Thread(() -> {
            int age = myConcurrentMap.get("Oleksii");
            System.out.println(Thread.currentThread().getName() + " age: " + age);
        }).start();
    }
}
