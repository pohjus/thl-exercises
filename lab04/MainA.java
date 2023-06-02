
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

record Customer(String name) {}

class Main {
    public static void main(String [] args) throws Exception {
        try (var reader = new BufferedReader(new FileReader("file.txt"))) {
            var customers = new ArrayList<Customer>();

            var name = "";
            while((name = reader.readLine()) != null) {
                var customer = new Customer(name);
                customers.add(customer);
            }

            for (var customer : customers) {
                System.out.println(customer);
            }
        }
    }
}
