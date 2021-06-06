/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.vistas;

import java.util.ArrayList;
import java.util.List;
import static java.util.Locale.filter;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.trabajadores.Trabajador;
import mvc.controlador.ControladorTrabajador;

/**
 *
 * @author David
 */
public class VentanaTrabajadores extends javax.swing.JFrame {

    /**
     * Creates new form VentanaTrabajadores
     */
    RowSorter ordenar;
    
     TableRowSorter filtro;
     String busqueda;
    public VentanaTrabajadores() {
        initComponents();
        grupoBotones();
        initDatos();
    }
    
    public void grupoBotones(){
        buttonGroupOrdenacion.add(jRadioNombre);
        buttonGroupOrdenacion.add(jRadioAntiguedad);
        buttonGroupOrdenacion.add(jRadioCategoria);
        buttonGroupOrdenacion.add(jRadioSueldo);
    }
    
    public void initDatos(){
        if ( ControladorTrabajador.getListaTrabajadores().isPresent()){
            
             
             //btnBuscar.setEnabled(false);

            List<Trabajador> trabajadores = ControladorTrabajador.getListaTrabajadores().get();
            DefaultTableModel tabla = new DefaultTableModel();
            
            tabla.addColumn("Nombre", ControladorTrabajador.getListaTrabajadores().get().stream().map(t -> t.getNombre()).toArray());
            tabla.addColumn("edad", ControladorTrabajador.getListaTrabajadores().get().stream().map(t -> t.getEdad()).toArray());
            tabla.addColumn("Antiguedad", ControladorTrabajador.getListaTrabajadores().get().stream().map(t -> t.getAntiE().getNombre()).toArray());
            tabla.addColumn("Categoria", ControladorTrabajador.getListaTrabajadores().get().stream().map(t -> t.getCategoriaE().getNombre()).toArray());
            tabla.addColumn("Sueldo", ControladorTrabajador.getListaTrabajadores().get().stream().map(t -> Math.round(t.getSueldoFuncion()*100.0)/100.0).toArray());
            
            jTableTrabajadores.setModel(tabla);
            
             filtro = new TableRowSorter(jTableTrabajadores.getModel());
             jTableTrabajadores.setRowSorter(filtro);

             
        }
    }
    
    public void busqueda(){
        busqueda = jTextFieldBusqueda.getText();
        filtro.setRowFilter(RowFilter.regexFilter(busqueda, 0));
        
    }

    public void ordenar(int columna){
        jTableTrabajadores.getRowSorter().toggleSortOrder(columna);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupOrdenacion = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelPrincipal = new javax.swing.JPanel();
        jPanelBusqueda = new javax.swing.JPanel();
        jLabelBusqueda = new javax.swing.JLabel();
        jTextFieldBusqueda = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jPanelOrdenacion = new javax.swing.JPanel();
        jLabelOrdenacion = new javax.swing.JLabel();
        jRadioSueldo = new javax.swing.JRadioButton();
        jRadioCategoria = new javax.swing.JRadioButton();
        jRadioAntiguedad = new javax.swing.JRadioButton();
        jRadioNombre = new javax.swing.JRadioButton();
        jPanelTitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jScrollPaneTableTrabajadores = new javax.swing.JScrollPane();
        jTableTrabajadores = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemNuevoTrabajador = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelPrincipal.setBackground(new java.awt.Color(204, 255, 204));

        jPanelBusqueda.setBackground(new java.awt.Color(102, 153, 255));

        jLabelBusqueda.setText("Busqueda");

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBusquedaLayout = new javax.swing.GroupLayout(jPanelBusqueda);
        jPanelBusqueda.setLayout(jPanelBusquedaLayout);
        jPanelBusquedaLayout.setHorizontalGroup(
            jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusquedaLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabelBusqueda)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBusquedaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addContainerGap())
        );
        jPanelBusquedaLayout.setVerticalGroup(
            jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusquedaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBusqueda)
                    .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnBuscar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanelOrdenacion.setBackground(new java.awt.Color(102, 153, 255));

        jLabelOrdenacion.setText("Ordenacion");

        jRadioSueldo.setText("Sueldo");
        jRadioSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioSueldoActionPerformed(evt);
            }
        });

        jRadioCategoria.setText("Categoria");
        jRadioCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioCategoriaActionPerformed(evt);
            }
        });

        jRadioAntiguedad.setText("Antiguedad");
        jRadioAntiguedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAntiguedadActionPerformed(evt);
            }
        });

        jRadioNombre.setText("Nombre");
        jRadioNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOrdenacionLayout = new javax.swing.GroupLayout(jPanelOrdenacion);
        jPanelOrdenacion.setLayout(jPanelOrdenacionLayout);
        jPanelOrdenacionLayout.setHorizontalGroup(
            jPanelOrdenacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOrdenacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelOrdenacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelOrdenacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioSueldo)
                    .addComponent(jRadioCategoria)
                    .addComponent(jRadioAntiguedad)
                    .addComponent(jRadioNombre))
                .addGap(32, 32, 32))
        );
        jPanelOrdenacionLayout.setVerticalGroup(
            jPanelOrdenacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOrdenacionLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelOrdenacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOrdenacion)
                    .addComponent(jRadioNombre))
                .addGap(18, 18, 18)
                .addComponent(jRadioAntiguedad)
                .addGap(18, 18, 18)
                .addComponent(jRadioCategoria)
                .addGap(18, 18, 18)
                .addComponent(jRadioSueldo)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanelTitulo.setBackground(new java.awt.Color(204, 204, 255));

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTitulo.setText("Trabajadores de subsidiaria");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addGap(376, 376, 376)
                .addComponent(jLabelTitulo)
                .addContainerGap(372, Short.MAX_VALUE))
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelTitulo)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTableTrabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableTrabajadores.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTableTrabajadoresAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTableTrabajadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTrabajadoresMouseClicked(evt);
            }
        });
        jScrollPaneTableTrabajadores.setViewportView(jTableTrabajadores);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnModificar)
                            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanelOrdenacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPaneTableTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jPanelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelOrdenacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneTableTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanelPrincipal);

        jMenuArchivo.setText("Archivo");

        jMenuItemNuevoTrabajador.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemNuevoTrabajador.setText("Nuebo Trabajador");
        jMenuItemNuevoTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevoTrabajadorActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemNuevoTrabajador);
        jMenuArchivo.add(jSeparator1);

        jMenuItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemSalir);

        jMenuBar1.add(jMenuArchivo);

        jMenuAyuda.setText("Ayuda");

        jMenuItemAcerca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemAcerca.setText("Acerca");
        jMenuAyuda.add(jMenuItemAcerca);

        jMenuBar1.add(jMenuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

       busqueda();
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        busqueda = " ";
        jTextFieldBusqueda.setText(" ");
        initDatos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jRadioNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioNombreActionPerformed
        // TODO add your handling code here:
       ordenar(0);
        
        
    }//GEN-LAST:event_jRadioNombreActionPerformed

    private void jRadioAntiguedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioAntiguedadActionPerformed
        // TODO add your handling code here:
        ordenar(2);
        
    }//GEN-LAST:event_jRadioAntiguedadActionPerformed

    private void jRadioCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioCategoriaActionPerformed
        // TODO add your handling code here:
        ordenar(3);
        
    }//GEN-LAST:event_jRadioCategoriaActionPerformed

    private void jRadioSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioSueldoActionPerformed
        // TODO add your handling code here:
        ordenar(4);
        
    }//GEN-LAST:event_jRadioSueldoActionPerformed

    private void jTableTrabajadoresAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTableTrabajadoresAncestorAdded
        // TODO add your handling code here:
        //int fila = jTableTrabajadores.getSelectedRow();
        //jTableTrabajadores.getValueAt(ERROR, NORMAL)
        
    }//GEN-LAST:event_jTableTrabajadoresAncestorAdded

    private void jTableTrabajadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTrabajadoresMouseClicked
        // TODO add your handling code here:
        btnModificar.setEnabled(true);
    }//GEN-LAST:event_jTableTrabajadoresMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int fila = jTableTrabajadores.getSelectedRow();
        String nombre = jTableTrabajadores.getValueAt(fila, 0).toString();
        ControladorTrabajador.initTrabajador(ControladorTrabajador.setTrabajador(nombre));
        //System.out.println(fila + nombre);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jMenuItemNuevoTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevoTrabajadorActionPerformed
        // TODO add your handling code here:
        ControladorTrabajador.initTrabajador(Optional.empty());
    }//GEN-LAST:event_jMenuItemNuevoTrabajadorActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroupOrdenacion;
    private javax.swing.JLabel jLabelBusqueda;
    private javax.swing.JLabel jLabelOrdenacion;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAcerca;
    private javax.swing.JMenuItem jMenuItemNuevoTrabajador;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JPanel jPanelBusqueda;
    private javax.swing.JPanel jPanelOrdenacion;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JRadioButton jRadioAntiguedad;
    private javax.swing.JRadioButton jRadioCategoria;
    private javax.swing.JRadioButton jRadioNombre;
    private javax.swing.JRadioButton jRadioSueldo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneTableTrabajadores;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTableTrabajadores;
    private javax.swing.JTextField jTextFieldBusqueda;
    // End of variables declaration//GEN-END:variables
}
