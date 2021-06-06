/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.vistas;

import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import modelo.empresas.Empresa;
import mvc.controlador.ControladorEmpresa;
import mvc.controlador.ControladorPrincipal;
import mvc.dialogos.DialogoAcercaDe;
import mvc.dialogos.DialogoError;

/**
 *
 * @author David
 */
public class VentanaEmpresa extends javax.swing.JFrame {

    /**
     * Creates new form VentanaEmpresa
     */
    public VentanaEmpresa() {
        initComponents();
        initDatos();
    }
    
    public void initDatos(){
        
           jTextFieldRazonSocial.setEditable(true);
           jTextFieldDireccion.setEditable(true);
           jTextFieldTelefono.setEditable(true);
           jTextFieldCapitalSocial.setEditable(false);
           jTextFieldGananciasTotales.setEditable(false);
           
           btnBorrar.setEnabled(false);
           btnModificar.setEnabled(false);
        
        if (ControladorEmpresa.getDatosEmpresa().isPresent()){
            jTextFieldRazonSocial.setText(ControladorEmpresa.getDatosEmpresa().get().getRazonSocial());
            jTextFieldDireccion.setText(ControladorEmpresa.getDatosEmpresa().get().getDireccion());
            jTextFieldTelefono.setText(ControladorEmpresa.getDatosEmpresa().get().getTelefono());
            jTextFieldCapitalSocial.setText(String.valueOf(ControladorEmpresa.getDatosEmpresa().get().getCapitalSocial()));
            jTextFieldGananciasTotales.setText(String.valueOf(ControladorEmpresa.getDatosEmpresa().get().getGananciasBruto()));
            
            jLabelEmpresa.setText("Empresa: " + ControladorEmpresa.getDatosEmpresa().get().getRazonSocial());
            
            
            
            DefaultListModel<String> subsidiarias = new DefaultListModel<String>();
            //subsidiarias.addAll(ControladorEmpresa.getDatosEmpresa().get().getListaSubsidiarias().stream().map(es -> es.getRazonSocial()).collect(Collectors.toList()));
            subsidiarias.addAll(ControladorEmpresa.listaSubsidiarias(ControladorEmpresa.getDatosEmpresa().get()));
            jListSubsidiarias.setModel(subsidiarias);
            
            

        } else {
            
            jLabelEmpresa.setText("Empresa ");
            
            /*jTextFieldRazonSocial.getText();
            jTextFieldDireccion.getText();
            jTextFieldTelefono.getText();*/
        }
            
    }
    
    public void refresh(){
        
         ControladorEmpresa.initControladorEmpresa(Optional.empty());
         

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPanePrincipal = new javax.swing.JScrollPane();
        jPanelPrincipal = new javax.swing.JPanel();
        jPanelDatosEmpresa = new javax.swing.JPanel();
        jTextFieldRazonSocial = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldCapitalSocial = new javax.swing.JTextField();
        jTextFieldGananciasTotales = new javax.swing.JTextField();
        jLabelRazonSocial = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelCapitalSocial = new javax.swing.JLabel();
        jLabelGananciasBruto = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabelDatosEmpresa = new javax.swing.JLabel();
        jPanelSubsidiarias = new javax.swing.JPanel();
        jScrollPaneSubsidiarias = new javax.swing.JScrollPane();
        jListSubsidiarias = new javax.swing.JList<>();
        btnAnadir = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabelSubsidiaria = new javax.swing.JLabel();
        jPanelTitulo = new javax.swing.JPanel();
        jLabelEmpresa = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemNuevaEmpresa = new javax.swing.JMenuItem();
        jMenuItemGuardar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemRedo = new javax.swing.JMenuItem();
        jMenuItemUndo = new javax.swing.JMenuItem();
        jMenuInformes = new javax.swing.JMenu();
        jMenuItemInformeEmpresa = new javax.swing.JMenuItem();
        jMenuAcerca = new javax.swing.JMenu();
        jMenuItemAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelPrincipal.setBackground(new java.awt.Color(204, 255, 204));

        jPanelDatosEmpresa.setBackground(new java.awt.Color(102, 153, 255));

        jTextFieldRazonSocial.setEditable(false);

        jTextFieldDireccion.setEditable(false);

        jTextFieldTelefono.setEditable(false);

        jTextFieldCapitalSocial.setEditable(false);

        jTextFieldGananciasTotales.setEditable(false);

        jLabelRazonSocial.setLabelFor(jTextFieldRazonSocial);
        jLabelRazonSocial.setText("Razon Social");

        jLabelDireccion.setText("Direccion");

        jLabelTelefono.setText("Telefono");

        jLabelCapitalSocial.setText("Capital Social");

        jLabelGananciasBruto.setText("Ganancias totales");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabelDatosEmpresa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDatosEmpresa.setText("Datos Empresa");

        javax.swing.GroupLayout jPanelDatosEmpresaLayout = new javax.swing.GroupLayout(jPanelDatosEmpresa);
        jPanelDatosEmpresa.setLayout(jPanelDatosEmpresaLayout);
        jPanelDatosEmpresaLayout.setHorizontalGroup(
            jPanelDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosEmpresaLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabelDatosEmpresa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosEmpresaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDatosEmpresaLayout.createSequentialGroup()
                        .addGroup(jPanelDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDatosEmpresaLayout.createSequentialGroup()
                                .addGroup(jPanelDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelGananciasBruto)
                                    .addComponent(jLabelCapitalSocial))
                                .addGap(40, 40, 40)
                                .addGroup(jPanelDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldCapitalSocial, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldGananciasTotales, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))
                            .addComponent(jLabelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDatosEmpresaLayout.createSequentialGroup()
                        .addGroup(jPanelDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRazonSocial)
                            .addComponent(jLabelDireccion))
                        .addGap(64, 64, 64)
                        .addGroup(jPanelDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(206, 206, 206))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosEmpresaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(80, 80, 80)
                .addComponent(btnCancelar)
                .addGap(135, 135, 135))
        );
        jPanelDatosEmpresaLayout.setVerticalGroup(
            jPanelDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDatosEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldRazonSocial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRazonSocial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCapitalSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCapitalSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelGananciasBruto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldGananciasTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanelDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(116, 116, 116))
        );

        jPanelSubsidiarias.setBackground(new java.awt.Color(102, 153, 255));

        jListSubsidiarias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListSubsidiariasMouseClicked(evt);
            }
        });
        jScrollPaneSubsidiarias.setViewportView(jListSubsidiarias);

        btnAnadir.setText("Añadir");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLabelSubsidiaria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSubsidiaria.setText("Subsidiarias");

        javax.swing.GroupLayout jPanelSubsidiariasLayout = new javax.swing.GroupLayout(jPanelSubsidiarias);
        jPanelSubsidiarias.setLayout(jPanelSubsidiariasLayout);
        jPanelSubsidiariasLayout.setHorizontalGroup(
            jPanelSubsidiariasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubsidiariasLayout.createSequentialGroup()
                .addGroup(jPanelSubsidiariasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSubsidiariasLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanelSubsidiariasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelSubsidiariasLayout.createSequentialGroup()
                                .addComponent(btnAnadir)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar)
                                .addGap(18, 18, 18)
                                .addComponent(btnBorrar))
                            .addComponent(jScrollPaneSubsidiarias, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelSubsidiariasLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabelSubsidiaria)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanelSubsidiariasLayout.setVerticalGroup(
            jPanelSubsidiariasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubsidiariasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSubsidiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jScrollPaneSubsidiarias, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanelSubsidiariasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnadir)
                    .addComponent(btnModificar)
                    .addComponent(btnBorrar))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        jPanelTitulo.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(jLabelEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(390, Short.MAX_VALUE))
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jPanelDatosEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelSubsidiarias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(342, Short.MAX_VALUE))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelSubsidiarias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDatosEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(99, 99, 99))
        );

        jScrollPanePrincipal.setViewportView(jPanelPrincipal);

        jMenuArchivo.setText("Archivo");

        jMenuItemNuevaEmpresa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemNuevaEmpresa.setText("Nueva Empresa");
        jMenuItemNuevaEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevaEmpresaActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemNuevaEmpresa);

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

        jMenuEdit.setText("Editar");

        jMenuItemRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemRedo.setText("Redo");
        jMenuEdit.add(jMenuItemRedo);

        jMenuItemUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemUndo.setText("Undo");
        jMenuEdit.add(jMenuItemUndo);

        jMenuBar1.add(jMenuEdit);

        jMenuInformes.setText("Informes");

        jMenuItemInformeEmpresa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemInformeEmpresa.setText("Informe Empresa");
        jMenuItemInformeEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInformeEmpresaActionPerformed(evt);
            }
        });
        jMenuInformes.add(jMenuItemInformeEmpresa);

        jMenuBar1.add(jMenuInformes);

        jMenuAcerca.setText("Ayuda");
        jMenuAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAcercaActionPerformed(evt);
            }
        });

        jMenuItemAcerca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemAcerca.setText("Acerca");
        jMenuItemAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAcercaActionPerformed(evt);
            }
        });
        jMenuAcerca.add(jMenuItemAcerca);

        jMenuBar1.add(jMenuAcerca);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanePrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanePrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        ControladorEmpresa.guardar(jTextFieldRazonSocial.getText(),jTextFieldDireccion.getText(),jTextFieldTelefono.getText());
        dispose();
        //ControladorEmpresa.nuevaEmpresa( jTextFieldRazonSocial.getText(), jTextFieldDireccion.getText(), jTextFieldTelefono.getText());
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        //ControladorEmpresa.cancelar();
        dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jMenuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardarActionPerformed
        // TODO add your handling code here:
        ControladorEmpresa.guardar(jTextFieldRazonSocial.getText(),jTextFieldDireccion.getText(),jTextFieldTelefono.getText());
        dispose();
        
    }//GEN-LAST:event_jMenuItemGuardarActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        // TODO add your handling code here:
        ControladorEmpresa.cancelar();
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItemNuevaEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevaEmpresaActionPerformed
        // TODO add your handling code here:
        refresh();        
    }//GEN-LAST:event_jMenuItemNuevaEmpresaActionPerformed

    private void jListSubsidiariasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListSubsidiariasMouseClicked
        // TODO add your handling code here:
        
        btnModificar.setEnabled(true);
        btnBorrar.setEnabled(true);
    }//GEN-LAST:event_jListSubsidiariasMouseClicked

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        // TODO add your handling code here:
        //ControladorEmpresa.initVentanaSubsidiaria(ControladorEmpresa.modificar(jListSubsidiarias.getName()));
        ControladorEmpresa.nuevo();
        //System.out.println("añadir"+ Optional.of(ControladorEmpresa.getDatosEmpresa().get()));
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        ControladorEmpresa.initVentanaSubsidiaria(ControladorEmpresa.modificar(jListSubsidiarias.getSelectedValue()));
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jMenuAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAcercaActionPerformed
        // TODO add your handling code here:
        DialogoAcercaDe.acercaDe();
    }//GEN-LAST:event_jMenuAcercaActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        ControladorPrincipal.boorarSubsidiaria(jListSubsidiarias.getSelectedValue());
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void jMenuItemInformeEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInformeEmpresaActionPerformed
        // TODO add your handling code here:
                try{
                    
        ControladorEmpresa.abrirInformeEmpresa();
            
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("fallo al cargar el archivo");
            DialogoError.dialogoError();
        }
    }//GEN-LAST:event_jMenuItemInformeEmpresaActionPerformed

    private void jMenuItemAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAcercaActionPerformed
        // TODO add your handling code here:
        DialogoAcercaDe.acercaDe();
    }//GEN-LAST:event_jMenuItemAcercaActionPerformed

    /**
     * @param args the command line arguments
     */
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabelCapitalSocial;
    private javax.swing.JLabel jLabelDatosEmpresa;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelEmpresa;
    private javax.swing.JLabel jLabelGananciasBruto;
    private javax.swing.JLabel jLabelRazonSocial;
    private javax.swing.JLabel jLabelSubsidiaria;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JList<String> jListSubsidiarias;
    private javax.swing.JMenu jMenuAcerca;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuInformes;
    private javax.swing.JMenuItem jMenuItemAcerca;
    private javax.swing.JMenuItem jMenuItemGuardar;
    private javax.swing.JMenuItem jMenuItemInformeEmpresa;
    private javax.swing.JMenuItem jMenuItemNuevaEmpresa;
    private javax.swing.JMenuItem jMenuItemRedo;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenuItem jMenuItemUndo;
    private javax.swing.JPanel jPanelDatosEmpresa;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelSubsidiarias;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPanePrincipal;
    private javax.swing.JScrollPane jScrollPaneSubsidiarias;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField jTextFieldCapitalSocial;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldGananciasTotales;
    private javax.swing.JTextField jTextFieldRazonSocial;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}