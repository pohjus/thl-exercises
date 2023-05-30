module utilities {
    requires java.logging;

    exports random;
    provides random.MyRandom with implementations.MyRandomImpl1;
    uses random.MyRandom; 
}