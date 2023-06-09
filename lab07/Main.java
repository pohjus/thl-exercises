

public class Main {    
    public static void main(String [] args) {
        print(get(new Circle()));
        print(get(new Rectangle()));
    }


    public static int get(Drawable drawable) {
        // if(drawable instanceof Circle) {
        //     return ((Circle) drawable).radius;
        // } else if (drawable instanceof Rectangle) {
        //     return ((Rectangle) drawable).height;
        // } else {
        //     throw new RuntimeException();
        // }


        // if(drawable instanceof Circle circle) {
        //     return circle.radius;
        // } else if (drawable instanceof Rectangle rectangle) {
        //     return rectangle.height;
        // } else {
        //     throw new RuntimeException();
        // }

        return switch(drawable) {
            case Circle c -> c.radius;
            case Rectangle r -> r.height;
        };
     }


    public static void print(Object o) {
        System.out.println(o);   
    }
}