/*
 * Created by JFormDesigner on Thu Nov 20 20:03:51 ECT 2025
 */

package IGU;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import Clases.Producto;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 * @author USUARIO
 */
public class FormInventario extends JFrame {


    private DefaultTableModel modelProducts;
    private ArrayList<Producto> listaProductos = new ArrayList<>();

    public FormInventario() {
        initComponents();
        String[] columnas = {"Indice", "Nombre Producto", "Precio"};
        modelProducts = new DefaultTableModel(columnas, 0);
        TablaProductos.setModel(modelProducts);
    }

    public double D(String txt){
        double convertD = Double.parseDouble(txt);
        return convertD;
    }

    private Boolean isEmpty(){
        if(txtProducto.getText().trim().isEmpty() || txtPrecio.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Error: No Deben Haber Campos Vacios", "ERROR", JOptionPane.ERROR_MESSAGE);
            return true;
        }

        return false;
    }

    private void agregarProducto(int Indice, String nombre, double precio){
        Object [] row = {Indice, nombre, precio};
        modelProducts.addRow(row);  }

    private void agregarP(){
        if(isEmpty()){return;}

        String nombre = txtProducto.getText();
        double precio = D(txtPrecio.getText());

        int confirm = JOptionPane.showConfirmDialog(this, "Desea Agregar El Siguiente Producto? \n" +
                "Nombre: " + nombre + "\n" +
                "Precio: " + precio + "$\n", "Confirmar ", JOptionPane.YES_NO_OPTION);

        if(confirm == JOptionPane.NO_OPTION){return;}

        int count = 0, index = 0;

        listaProductos.add(new Producto(nombre, precio));
        for(Producto p: listaProductos){
            if(p.getNombre().equals(nombre)){index = count;}
            count++;
        }

        JOptionPane.showMessageDialog(this, "Productos Agregados: \n" +
                "Nombre: " + nombre + "\n" +
                "Precio: " + precio + "$\n");

        agregarProducto(index, nombre, precio);
    }

    private void editarP(){
        if(listaProductos.isEmpty()){JOptionPane.showMessageDialog(this, "ERROR: No Hay Productos Registrados",
                "ERROR", JOptionPane.ERROR_MESSAGE); return;}

        if(isEmpty()){return;}

        String nombre = txtProducto.getText();
        double precio = D(txtPrecio.getText());

        int row = TablaProductos.getSelectedRow(); // fila seleccionada

        if(row < 0){
            JOptionPane.showMessageDialog(this, "Error: Debe Seleccionar una Fila Para Poder Editar", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private void btnIngresar(ActionEvent e) {
        agregarP();
    }

    private void initComponents() {
        setTitle("Formulario - Inventario");
        setResizable(false);

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Daniel Sanchez (Anthony Lozada)
        panel1 = new JPanel();
        label1 = new JLabel();
        scrollPane2 = new JScrollPane();
        txtResultados = new JTextArea();
        panel2 = new JPanel();
        label2 = new JLabel();
        txtProducto = new JTextField();
        label3 = new JLabel();
        txtPrecio = new JTextField();
        btnEliminar = new JButton();
        btnIngresar = new JButton();
        btnEditar = new JButton();
        btnBuscar = new JButton();
        scrollPane1 = new JScrollPane();
        TablaProductos = new JTable();
        scrollPane3 = new JScrollPane();
        txtHistorial = new JTextArea();

        //======== this ========
        setMaximumSize(new Dimension(800, 670));
        setName("this");
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder(LineBorder.createBlackLineBorder());
            panel1.setName("panel1");

            //---- label1 ----
            label1.setText("Inventario Productos");
            label1.setFont(new Font("CaskaydiaMono NF SemiBold", Font.PLAIN, 22));
            label1.setName("label1");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(133, Short.MAX_VALUE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(29, Short.MAX_VALUE))
            );
        }

        //======== scrollPane2 ========
        {
            scrollPane2.setName("scrollPane2");

            //---- txtResultados ----
            txtResultados.setName("txtResultados");
            scrollPane2.setViewportView(txtResultados);
        }

        //======== panel2 ========
        {
            panel2.setBackground(Color.white);
            panel2.setBorder(LineBorder.createBlackLineBorder());
            panel2.setName("panel2");

            //---- label2 ----
            label2.setText("Nombre Producto");
            label2.setFont(new Font("CaskaydiaMono NF SemiBold", Font.PLAIN, 20));
            label2.setName("label2");

            //---- txtProducto ----
            txtProducto.setName("txtProducto");

            //---- label3 ----
            label3.setText("Precio");
            label3.setFont(new Font("CaskaydiaMono NF SemiBold", Font.PLAIN, 20));
            label3.setName("label3");

            //---- txtPrecio ----
            txtPrecio.setName("txtPrecio");

            //---- btnEliminar ----
            btnEliminar.setText("Eliminar");
            btnEliminar.setFont(new Font("CaskaydiaMono NF SemiBold", Font.PLAIN, 18));
            btnEliminar.setName("btnEliminar");

            //---- btnIngresar ----
            btnIngresar.setText("Ingresar");
            btnIngresar.setFont(new Font("CaskaydiaMono NF SemiBold", Font.PLAIN, 18));
            btnIngresar.setName("btnIngresar");
            btnIngresar.addActionListener(e -> btnIngresar(e));

            //---- btnEditar ----
            btnEditar.setText("Editar");
            btnEditar.setFont(new Font("CaskaydiaMono NF SemiBold", Font.PLAIN, 18));
            btnEditar.setName("btnEditar");

            //---- btnBuscar ----
            btnBuscar.setText("Buscar");
            btnBuscar.setFont(new Font("CaskaydiaMono NF SemiBold", Font.PLAIN, 18));
            btnBuscar.setName("btnBuscar");

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(label3))
                            .addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2)
                            .addComponent(txtProducto, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(btnIngresar, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(43, Short.MAX_VALUE))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIngresar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addContainerGap(198, Short.MAX_VALUE))
            );
        }

        //======== scrollPane1 ========
        {
            scrollPane1.setName("scrollPane1");

            //---- TablaProductos ----
            TablaProductos.setModel(new DefaultTableModel(2, 0));
            TablaProductos.setName("TablaProductos");
            scrollPane1.setViewportView(TablaProductos);
        }

        //======== scrollPane3 ========
        {
            scrollPane3.setName("scrollPane3");

            //---- txtHistorial ----
            txtHistorial.setName("txtHistorial");
            scrollPane3.setViewportView(txtHistorial);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane2)
                        .addComponent(scrollPane3)
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(635, 635, 635)
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Daniel Sanchez (Anthony Lozada)
    private JPanel panel1;
    private JLabel label1;
    private JScrollPane scrollPane2;
    private JTextArea txtResultados;
    private JPanel panel2;
    private JLabel label2;
    private JTextField txtProducto;
    private JLabel label3;
    private JTextField txtPrecio;
    private JButton btnEliminar;
    private JButton btnIngresar;
    private JButton btnEditar;
    private JButton btnBuscar;
    private JScrollPane scrollPane1;
    private JTable TablaProductos;
    private JScrollPane scrollPane3;
    private JTextArea txtHistorial;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
