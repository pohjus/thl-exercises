
import java.util.*;

class Main {
    public static void main(String [] args) {
        ArrayList<String> a = new ArrayList<String>();        
        List<String> b = List.of("a", "b", "c");                
        String c = "Hello";

        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());                        
        System.out.println(c.getClass().getName());                        
    }
}
