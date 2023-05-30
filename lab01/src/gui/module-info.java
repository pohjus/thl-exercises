module gui {
    requires utilities;
    requires java.logging;

    requires javafx.graphics;
    requires javafx.controls;


    exports mypackage.gui to javafx.graphics;

    uses random.MyRandom;
}