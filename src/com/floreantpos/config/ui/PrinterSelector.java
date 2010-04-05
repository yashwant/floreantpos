/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PrinterSelector.java
 *
 * Created on Apr 5, 2010, 4:26:51 PM
 */

package com.floreantpos.config.ui;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author mshahriar
 */
public class PrinterSelector extends ConfigurationView {

    /** Creates new form PrinterSelector */
    public PrinterSelector() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbPrinters = new javax.swing.JComboBox();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPrinters, 0, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPrinters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbPrinters;
    // End of variables declaration//GEN-END:variables


	@Override
	public String getName() {
		return "Select Printer";
	}

	@Override
	public void initialize() throws Exception {
		PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        cbPrinters.setModel(new DefaultComboBoxModel(printServices));
	}

	@Override
	public boolean save() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}