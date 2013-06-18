/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uml.visual.dialogs;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.uml.model.RelationComponent;

/**
 *
 * @author Uros
 */
public class ChooseRelationPanel extends javax.swing.JPanel {

    /**
     * Creates new form ChooseRelationPanel
     */
    

    
    public ChooseRelationPanel() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        textFieldName = new javax.swing.JTextField();
        labelCardinalitySource = new javax.swing.JLabel();
        labelCardinalityTarget = new javax.swing.JLabel();
        comboBoxCardinalitySource = new javax.swing.JComboBox();
        comboBoxCardinalityTarget = new javax.swing.JComboBox();

        comboBoxRelationship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRelationshipActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ChooseRelationPanel.class, "ChooseRelationPanel.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(ChooseRelationPanel.class, "ChooseRelationPanel.jLabel2.text")); // NOI18N

        textFieldName.setText(org.openide.util.NbBundle.getMessage(ChooseRelationPanel.class, "ChooseRelationPanel.textFieldName.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelCardinalitySource, org.openide.util.NbBundle.getMessage(ChooseRelationPanel.class, "ChooseRelationPanel.labelCardinalitySource.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelCardinalityTarget, org.openide.util.NbBundle.getMessage(ChooseRelationPanel.class, "ChooseRelationPanel.labelCardinalityTarget.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addGap(79, 79, 79))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelCardinalitySource, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addComponent(labelCardinalityTarget, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(comboBoxCardinalitySource, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboBoxCardinalityTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxRelationship, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxRelationship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCardinalitySource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCardinalitySource))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCardinalityTarget)
                    .addComponent(comboBoxCardinalityTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxRelationshipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRelationshipActionPerformed

    }//GEN-LAST:event_comboBoxRelationshipActionPerformed
    public String getNameFieldValue () {
        return textFieldName.getText();
    }
    
    public RelationComponent getRelationComponent () {
         return (RelationComponent)comboBoxRelationship.getSelectedItem();       
    }
    
    public JComboBox getRelationComponents () {
        return comboBoxRelationship;
    }
    
    public JTextField getNameTextField () {
        return textFieldName;
    }
    
    public JComboBox getCardinalitySourceComboBox () {
        return comboBoxCardinalitySource;
    }
    
    public JComboBox getCardinalityTargetComboBox () {
        return comboBoxCardinalityTarget;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboBoxCardinalitySource;
    private javax.swing.JComboBox comboBoxCardinalityTarget;
    private javax.swing.JComboBox comboBoxRelationship;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelCardinalitySource;
    private javax.swing.JLabel labelCardinalityTarget;
    private javax.swing.JTextField textFieldName;
    // End of variables declaration//GEN-END:variables

}
