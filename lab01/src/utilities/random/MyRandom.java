
package random;
import java.util.*;

public interface MyRandom {
    public String getRandomWord(String... args);

    public static MyRandom getInstance() {
        ServiceLoader<MyRandom> services = ServiceLoader.load(MyRandom.class);
        return services.findFirst().get();
    }
}
