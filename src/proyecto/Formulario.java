/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto;
import java.awt.List;
import  java.sql.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diego
 */
public class Formulario extends javax.swing.JFrame {

    Connection con = null;
    
    ArrayList<Persona> lista = new ArrayList<>();
    ArbolBinario arbol;
     
    public Formulario() {
        initComponents();
        con = DBConexion.Conexion();
        
        try {
 
             CrearLista();
             
             arbol = new ArbolBinario();
             arbol.IngresarBalanceado(lista);
             
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       

        
//        conexion = new DBConexion();
        
  
    }
    
    public void MostrarDatos() throws SQLException
    {
        
        try {
           Statement st = con.createStatement();
           String sql = "select * from tabla_fica";
           ResultSet rs = st.executeQuery(sql);
 
            while (rs.next()) {                
                
                String cedula = rs.getString("cedula");
                String nombres = rs.getString("nombres");
                String facultad = rs.getString("facultad");
                String carrera = rs.getString("carrera");
                
                String tbData[] = {cedula, nombres, facultad, carrera};
                tableModel = (DefaultTableModel) tabla.getModel();
                tableModel.addRow(tbData);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void CrearLista()
    {
        try {
            Statement st = con.createStatement();
            String sql = "select * from tabla_fica";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String cedula = rs.getString("cedula");
                String nombres = rs.getString("nombres");
                String facultad = rs.getString("facultad");
                String carrera = rs.getString("carrera");

                Persona p = new Persona(cedula, nombres, facultad, carrera);
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

        jDialog1 = new javax.swing.JDialog();
        btnBuscar = new javax.swing.JButton();
        txtCedula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnImprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBuscar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar:");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtCedula.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        tabla.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "cedula", "nombres", "facultad", "carrera"
            }
        ));
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(1).setPreferredWidth(275);
        }

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane2.setViewportView(txtArea);

        btnImprimir.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setText("Árbol Binario de Búsqueda");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("Estudiantes FICA");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Elaborado por: Diego Recalde, Juan Ulcuango y Melanie Ullco");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnImprimir)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addGap(28, 28, 28)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel2)))
                .addGap(157, 157, 157))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnImprimir)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
    
//        Persona personaEncontrada = arbol.Buscar(txtCedula.getText());
        Persona personaEncontrada = arbol.BuscarPersona(txtCedula.getText());
        if (personaEncontrada == null) {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado...", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {

            tableModel = (DefaultTableModel) tabla.getModel();
            
            while (tableModel.getRowCount() > 0) {
                tableModel.removeRow(0);
            }
            
            String[] infoEstudiante = {personaEncontrada.getCedula(), personaEncontrada.getNombres(),
                personaEncontrada.getFacultad(), personaEncontrada.getCarrera()};
            
            tableModel.addRow(infoEstudiante);
            tabla.setModel(tableModel);
           
        }
        
        /*
                String salida = "Cedula: " + personaEncontrada.getCedula() + "\n"
                    + "Nombres: " + personaEncontrada.getNombres() + "\n"
                    + "Facultad: " + personaEncontrada.getFacultad() + "\n"
                    + "Carrera: " + personaEncontrada.getCarrera();
                  txtArea.setText(salida);
        */


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        
       // txtArea.setText(arbol.InOrder());
       txtArea.setText(arbol.InOrder());

    }//GEN-LAST:event_btnImprimirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    private DefaultTableModel tableModel;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtCedula;
    // End of variables declaration//GEN-END:variables
}
