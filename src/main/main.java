package main;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import IGU.FormInventario;

public class main {
    public static void main(String[] args) {
        FlatArcOrangeIJTheme.setup();
        FormInventario Window = new FormInventario();
        Window.setVisible(true);
        Window.setSize(850, 670);
        Window.setLocationRelativeTo(null);
    }
}
