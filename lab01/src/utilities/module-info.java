module utilities {
    requires java.logging;
    requires transitive data;
    exports random;
    provides random.MyRandom with implementations.MyRandomImpl1;
    uses random.MyRandom; 
}