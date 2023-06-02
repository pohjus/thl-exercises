
import java.util.*;

class Main {
    public static void main(String [] args) {
        var a = new ArrayList<String>();        
        var b = List.of("a", "b", "c");                
        var c = "Hello";

        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());                        
        System.out.println(c.getClass().getName());                        
    }
}
