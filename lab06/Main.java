import java.time.Year;
import java.util.stream.Stream;

enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER
}

public class Main {    
    public static void main(String [] args) {
        System.out.println("* YEAR " + getCurrentYear() + " *");
        Stream.of(Month.values())
            .forEach(Main::print);
    }

    public static int getNumberOfDays(Month month) {
        return switch(month) {
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 31;
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;
            case FEBRUARY -> (Year.isLeap(getCurrentYear())) ? 29 : 28;
        };
    }
    public static void print(Month month) {
        System.out.println(month + " has " + getNumberOfDays(month) + " days.");
    }

    public static int getCurrentYear() {
        return Year.now().getValue();
    }
}