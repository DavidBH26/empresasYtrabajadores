/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.vistas;

import almacenes.CategoriaEnum;
import debug.GeneracionAtributosAleatorios;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import modelo.sueldos.EstrategiaSueldos;
import mvc.controlador.ControladorEmpresa;
import mvc.controlador.ControladorTrabajador;
import mvc.dialogos.DialogoAcercaDe;

/**
 *
 * @author David
 */
public class VentanaTrabajador extends javax.swing.JFrame {

    /**
     * Creates new form VentanaTrabajador
     */
    public VentanaTrabajador() {
        initComponents();
        initDatos();
    }
    
    public void initDatos(){
        if (ControladorTrabajador.getTrabajador().isPresent()){
            
            jTextFieldNombre.setText(ControladorTrabajador.getTrabajador().get().getNombre());
            jTextFieldEdad.setText(String.valueOf(ControladorTrabajador.getTrabajador().get().getEdad()));
            jTextFieldSueldoBase.setText(String.valueOf(Math.round(ControladorTrabajador.getTrabajador().get().getSueldo()*100.0)/100.0));
            jTextFieldSueldoHora.setEditable(false);
            jTextFieldNumHoras.setEditable(false);
            jComboBoxCategoria.addItem(ControladorTrabajador.getTrabajador().get().getCategoriaE().getNombre());
            jComboBoxAntiguedad.addItem(ControladorTrabajador.getTrabajador().get().getAntiE().getNombre());
            jTextFieldDireccion.setText(ControladorTrabajador.getTrabajador().get().getDireccion());
            jTextFieldSueldo.setText(String.valueOf(Math.round(ControladorTrabajador.getTrabajador().get().getSueldoFuncion()*100.0)/100.0));
            
            if (ControladorTrabajador.getTrabajador().get().getCategoriaE()==CategoriaEnum.CATEGORIA_FREE_LANCE){
                jTextFieldSueldoHora.setText(String.valueOf(GeneracionAtributosAleatorios.sueldoHora()));
                jTextFieldNumHoras.setText(String.valueOf(GeneracionAtributosAleatorios.numHoras()));
                jTextFieldSueldoBase.setText("0.0");
                jTextFieldSueldo.setText(String.valueOf(EstrategiaSueldos.sueldoFreelance(Double.parseDouble(jTextFieldSueldoHora.getText()),Double.parseDouble(jTextFieldSueldoHora.getText()))));
            }
            
            
            
           
            
            
        } else {
            DefaultComboBoxModel<String> categoria = new DefaultComboBoxModel<>();
            categoria.addAll(ControladorEmpresa.listaTrab().stream().map(t -> t.getCategoriaE().getNombre()).distinct().collect(Collectors.toList()));
            jComboBoxCategoria.setModel(categoria);
            
            DefaultComboBoxModel<String> antiguedad = new DefaultComboBoxModel<>();
            antiguedad.addAll(ControladorEmpresa.listaTrab().stream().map(t -> t.getAntiE().getNombre()).distinct().collect(Collectors.toList()));
            jComboBoxAntiguedad.setModel(antiguedad);
            
            jTextFieldSueldoHora.setEditable(false);
            jTextFieldNumHoras.setEditable(false);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelTrabajador = new javax.swing.JPanel();
        jPanelFondoTrabajador = new javax.swing.JPanel();
        jPanelTitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelDatos1 = new javax.swing.JPanel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldEdad = new javax.swing.JTextField();
        jTextFieldSueldoBase = new javax.swing.JTextField();
        jTextFieldSueldoHora = new javax.swing.JTextField();
        jTextFieldNumHoras = new javax.swing.JTextField();
        jLabelSueldoHora = new javax.swing.JLabel();
        jLabelNumeroHoras = new javax.swing.JLabel();
        jLabelSueldoBase = new javax.swing.JLabel();
        jLabelEdad = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jPanelDatos2 = new javax.swing.JPanel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jComboBoxAntiguedad = new javax.swing.JComboBox<>();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldSueldo = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabelSueldo = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelAntiguedad = new javax.swing.JLabel();
        jLabelCategoria = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemNuevoTrab = new javax.swing.JMenuItem();
        jMenuItemGuardar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuEditar = new javax.swing.JMenu();
        jMenuItemRedo = new javax.swing.JMenuItem();
        jMenuItemUndo = new javax.swing.JMenuItem();
        jMenuInformes = new javax.swing.JMenu();
        jMenuItemInfoEmpSub = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelFondoTrabajador.setBackground(new java.awt.Color(204, 255, 204));
        jPanelFondoTrabajador.setForeground(new java.awt.Color(204, 255, 204));

        jPanelTitulo.setBackground(new java.awt.Color(204, 204, 255));

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTitulo.setText("Trabajador");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(230, 230, 230))
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelTitulo)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanelDatos1.setBackground(new java.awt.Color(102, 153, 255));

        jLabelSueldoHora.setText("Sueldo Hora");

        jLabelNumeroHoras.setText("Numero de horas");

        jLabelSueldoBase.setText("Sueldo Base");

        jLabelEdad.setText("Edad");

        jLabelNombre.setText("Nombre");

        javax.swing.GroupLayout jPanelDatos1Layout = new javax.swing.GroupLayout(jPanelDatos1);
        jPanelDatos1.setLayout(jPanelDatos1Layout);
        jPanelDatos1Layout.setHorizontalGroup(
            jPanelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatos1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatos1Layout.createSequentialGroup()
                        .addGroup(jPanelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEdad)
                            .addComponent(jLabelNombre))
                        .addGap(120, 120, 120)
                        .addGroup(jPanelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDatos1Layout.createSequentialGroup()
                                .addComponent(jTextFieldEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 82, Short.MAX_VALUE))
                            .addComponent(jTextFieldNombre)))
                    .addGroup(jPanelDatos1Layout.createSequentialGroup()
                        .addGroup(jPanelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSueldoBase)
                            .addComponent(jLabelSueldoHora)
                            .addComponent(jLabelNumeroHoras))
                        .addGap(75, 75, 75)
                        .addGroup(jPanelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNumHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSueldoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSueldoHora, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDatos1Layout.setVerticalGroup(
            jPanelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatos1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombre))
                .addGap(26, 26, 26)
                .addGroup(jPanelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEdad))
                .addGap(26, 26, 26)
                .addGroup(jPanelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSueldoBase)
                    .addComponent(jTextFieldSueldoBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105)
                .addGroup(jPanelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSueldoHora)
                    .addComponent(jTextFieldSueldoHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumeroHoras)
                    .addComponent(jTextFieldNumHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDatos2.setBackground(new java.awt.Color(102, 153, 255));

        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabelSueldo.setText("Sueldo");

        jLabelDireccion.setText("Direccion");

        jLabelAntiguedad.setText("Antiguedad");

        jLabelCategoria.setText("Categoria");

        javax.swing.GroupLayout jPanelDatos2Layout = new javax.swing.GroupLayout(jPanelDatos2);
        jPanelDatos2.setLayout(jPanelDatos2Layout);
        jPanelDatos2Layout.setHorizontalGroup(
            jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatos2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatos2Layout.createSequentialGroup()
                        .addComponent(jLabelSueldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatos2Layout.createSequentialGroup()
                        .addComponent(jLabelDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatos2Layout.createSequentialGroup()
                        .addGroup(jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCategoria)
                            .addComponent(jLabelAntiguedad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatos2Layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar))
                            .addComponent(jComboBoxAntiguedad, 0, 175, Short.MAX_VALUE)
                            .addComponent(jComboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanelDatos2Layout.setVerticalGroup(
            jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatos2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCategoria)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAntiguedad)
                    .addComponent(jComboBoxAntiguedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDireccion)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSueldo)
                    .addComponent(jTextFieldSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(jPanelDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanelFondoTrabajadorLayout = new javax.swing.GroupLayout(jPanelFondoTrabajador);
        jPanelFondoTrabajador.setLayout(jPanelFondoTrabajadorLayout);
        jPanelFondoTrabajadorLayout.setHorizontalGroup(
            jPanelFondoTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoTrabajadorLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanelFondoTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelFondoTrabajadorLayout.createSequentialGroup()
                        .addComponent(jPanelDatos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelDatos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanelFondoTrabajadorLayout.setVerticalGroup(
            jPanelFondoTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoTrabajadorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFondoTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelDatos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDatos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelTrabajadorLayout = new javax.swing.GroupLayout(jPanelTrabajador);
        jPanelTrabajador.setLayout(jPanelTrabajadorLayout);
        jPanelTrabajadorLayout.setHorizontalGroup(
            jPanelTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrabajadorLayout.createSequentialGroup()
                .addComponent(jPanelFondoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelTrabajadorLayout.setVerticalGroup(
            jPanelTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrabajadorLayout.createSequentialGroup()
                .addComponent(jPanelFondoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 110, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanelTrabajador);

        jMenuArchivo.setText("Archivo");

        jMenuItemNuevoTrab.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemNuevoTrab.setText("Nuevo Trabajador");
        jMenuItemNuevoTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevoTrabActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemNuevoTrab);

        jMenuItemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemGuardar.setText("Guardar");
        jMenuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardarActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemGuardar);
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

        jMenuEditar.setText("Editar");

        jMenuItemRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemRedo.setText("Redo");
        jMenuEditar.add(jMenuItemRedo);

        jMenuItemUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemUndo.setText("Undo");
        jMenuEditar.add(jMenuItemUndo);

        jMenuBar1.add(jMenuEditar);

        jMenuInformes.setText("Informes");

        jMenuItemInfoEmpSub.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemInfoEmpSub.setText("Informe Empresa");
        jMenuInformes.add(jMenuItemInfoEmpSub);

        jMenuBar1.add(jMenuInformes);

        jMenuAyuda.setText("Ayuda");

        jMenuItemAcerca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemAcerca.setText("Acerca");
        jMenuItemAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAcercaActionPerformed(evt);
            }
        });
        jMenuAyuda.add(jMenuItemAcerca);

        jMenuBar1.add(jMenuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
        // TODO add your handling code here:
        if (jComboBoxCategoria.getSelectedItem().toString() == "FREE LANCE"){
             jTextFieldSueldoHora.setEditable(true);
            jTextFieldNumHoras.setEditable(true);
    }
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jMenuItemNuevoTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevoTrabActionPerformed
        // TODO add your handling code here:
        ControladorTrabajador.initTrabajador(Optional.empty());
    }//GEN-LAST:event_jMenuItemNuevoTrabActionPerformed

    private void jMenuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenuItemGuardarActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItemAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAcercaActionPerformed
        // TODO add your handling code here:
        DialogoAcercaDe.acercaDe();
    }//GEN-LAST:event_jMenuItemAcercaActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> jComboBoxAntiguedad;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabelAntiguedad;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelEdad;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNumeroHoras;
    private javax.swing.JLabel jLabelSueldo;
    private javax.swing.JLabel jLabelSueldoBase;
    private javax.swing.JLabel jLabelSueldoHora;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEditar;
    private javax.swing.JMenu jMenuInformes;
    private javax.swing.JMenuItem jMenuItemAcerca;
    private javax.swing.JMenuItem jMenuItemGuardar;
    private javax.swing.JMenuItem jMenuItemInfoEmpSub;
    private javax.swing.JMenuItem jMenuItemNuevoTrab;
    private javax.swing.JMenuItem jMenuItemRedo;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenuItem jMenuItemUndo;
    private javax.swing.JPanel jPanelDatos1;
    private javax.swing.JPanel jPanelDatos2;
    private javax.swing.JPanel jPanelFondoTrabajador;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JPanel jPanelTrabajador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldEdad;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNumHoras;
    private javax.swing.JTextField jTextFieldSueldo;
    private javax.swing.JTextField jTextFieldSueldoBase;
    private javax.swing.JTextField jTextFieldSueldoHora;
    // End of variables declaration//GEN-END:variables
}