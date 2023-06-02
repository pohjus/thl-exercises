
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

record Customer(String name) {}

class Main {
    public static void main(String [] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            List<Customer> customers = new ArrayList<Customer>();

            String name = "";
            while((name = reader.readLine()) != null) {
                Customer customer = new Customer(name);
                customers.add(customer);
            }

            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }
}
