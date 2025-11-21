package main;

import com.formdev.flatlaf.FlatLightLaf;
import IGU.FormInventario;

public class main {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        FormInventario Window = new FormInventario();
        Window.setVisible(true);
    }
}
