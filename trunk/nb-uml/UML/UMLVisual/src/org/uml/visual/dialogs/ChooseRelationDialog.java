/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uml.visual.dialogs;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarFile;
import org.netbeans.api.visual.widget.Widget;
import org.openide.util.Exceptions;
import org.uml.model.ImplementsRelationComponent;
import org.uml.model.RelationComponent;
import org.uml.visual.widgets.ClassDiagramScene;
import org.uml.visual.widgets.ComponentWidgetBase;

/**
 *
 * @author Uros
 */
public class ChooseRelationDialog extends javax.swing.JDialog {

    /**
     * Creates new form ChooseRelationDialog
     */
    
    Widget sourceWidget;
    Widget targetWidget;

    
    public ChooseRelationDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public ChooseRelationDialog(java.awt.Frame parent,Widget sourceWidget,Widget targetWidget, boolean modal) {
        super(parent, modal);
        initComponents();
        this.sourceWidget = sourceWidget;
        this.targetWidget = targetWidget;
        fillCombo(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxRelationship = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        buttonOK = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textFieldName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        comboBoxRelationship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRelationshipActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ChooseRelationDialog.class, "ChooseRelationDialog.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonOK, org.openide.util.NbBundle.getMessage(ChooseRelationDialog.class, "ChooseRelationDialog.buttonOK.text")); // NOI18N
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(buttonCancel, org.openide.util.NbBundle.getMessage(ChooseRelationDialog.class, "ChooseRelationDialog.buttonCancel.text")); // NOI18N
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(ChooseRelationDialog.class, "ChooseRelationDialog.jLabel2.text")); // NOI18N

        textFieldName.setText(org.openide.util.NbBundle.getMessage(ChooseRelationDialog.class, "ChooseRelationDialog.textFieldName.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(buttonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(buttonCancel)
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxRelationship, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxRelationship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonOK)
                            .addComponent(buttonCancel)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void comboBoxRelationshipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRelationshipActionPerformed
        if (comboBoxRelationship.getSelectedItem() instanceof ImplementsRelationComponent) {
            textFieldName.setEnabled(false);
        }
    }//GEN-LAST:event_comboBoxRelationshipActionPerformed

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
       RelationComponent relation = (RelationComponent) comboBoxRelationship.getSelectedItem();
       relation.setName(textFieldName.getText());     
       if((sourceWidget instanceof ComponentWidgetBase)&&(targetWidget instanceof ComponentWidgetBase)) {
            ClassDiagramScene scene= (ClassDiagramScene)sourceWidget.getScene();
            ComponentWidgetBase source= (ComponentWidgetBase) sourceWidget;
            ComponentWidgetBase target= (ComponentWidgetBase) targetWidget;
            relation.setSource(source.getComponent());
            relation.setTarget(target.getComponent());
            scene.addEdge(relation);
            scene.setEdgeSource(relation,source.getComponent());
            scene.setEdgeTarget(relation,target.getComponent());
            this.dispose();
        }
    }//GEN-LAST:event_buttonOKActionPerformed

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
            java.util.logging.Logger.getLogger(ChooseRelationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseRelationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseRelationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseRelationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChooseRelationDialog dialog = new ChooseRelationDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonOK;
    private javax.swing.JComboBox comboBoxRelationship;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField textFieldName;
    // End of variables declaration//GEN-END:variables

    private void fillCombo(boolean isProject) {
         
        try {
            JarFile jar;
            if(isProject){
            jar = new JarFile(new File("build/cluster/modules/org-uml-model.jar"));
            }
            else {
            jar = new JarFile(new File("../build/cluster/modules/org-uml-model.jar"));
            }
            Enumeration entries= jar.entries();
            while(entries.hasMoreElements()) {
                String fullUrl = entries.nextElement().toString();
                if(fullUrl.startsWith("org/uml/model/")&& fullUrl.contains("RelationComponent")&&!fullUrl.equals("org/uml/model/RelationComponent.class")) {
                    try {
                        fullUrl= fullUrl.replace(".class", "");
                        fullUrl= fullUrl.replace("/", ".");
                        Class<? extends RelationComponent> forName= (Class<? extends RelationComponent>) Class.forName(fullUrl);
                        comboBoxRelationship.addItem(forName.newInstance());
                    } catch (        InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                }
            }
        } catch (IOException ex) {
            fillCombo(false);
        }
    }
}
