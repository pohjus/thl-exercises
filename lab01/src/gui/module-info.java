module gui {
    requires utilities;
    requires java.logging;

    requires javafx.graphics;
    requires javafx.controls;
    requires java.net.http;

    exports mypackage.gui to javafx.graphics;

    uses random.MyRandom;
}