module gui {
    requires utilities;

    requires javafx.graphics;
    requires javafx.controls;


    exports mypackage.gui to javafx.graphics;
}