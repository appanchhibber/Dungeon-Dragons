package com.SOEN6441_DND.Controller;

import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

/**
 * 
 * @author Punit Trivedi
 * @author Appan Chhibber
 *
 */
public class TransferHandlerController {
	

	public ValueExportTransferHandler valueExportCreator(String value){
		 return new ValueExportTransferHandler(value);
	}
	public ValueImportTransferHandler valueImportCreator(){
	return	new ValueImportTransferHandler();
	}
	public static class ValueExportTransferHandler extends TransferHandler {

		public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;
		private String value;

		public ValueExportTransferHandler(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		@Override
		public int getSourceActions(JComponent c) {			
			return DnDConstants.ACTION_COPY_OR_MOVE;
		}

		@Override
		protected Transferable createTransferable(JComponent c) {
			Transferable t = new StringSelection(getValue());
			return t;
		}

		@Override
		protected void exportDone(JComponent source, Transferable data,
				int action) {
			super.exportDone(source, data, action);
			// Decide what to do after the drop has been accepted
		}

	}

	public static class ValueImportTransferHandler extends TransferHandler {

		public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;

		public ValueImportTransferHandler() {
		}

		@Override
		public boolean canImport(TransferHandler.TransferSupport support) {
			return support.isDataFlavorSupported(SUPPORTED_DATE_FLAVOR);
		}

		@Override
		public boolean importData(TransferHandler.TransferSupport support) {
			boolean accept = false;
			if (canImport(support)) {
				try {
					Transferable t = support.getTransferable();
					Object value = t.getTransferData(SUPPORTED_DATE_FLAVOR);
					if (value instanceof String) {
						Component component = support.getComponent();
						if (component instanceof JButton) {
						ImageIcon	image= new ImageIcon(new ImageIcon(value.toString()).getImage().getScaledInstance(component.getWidth(), component.getHeight(),java.awt.Image.SCALE_SMOOTH ));
						((JButton) component).setIcon(image);
						((JButton) component).setText(((JButton) component).getName());
						((JButton) component).setFont(new Font("Calibri", Font.PLAIN,0));
						String[] name=value.toString().split("/");
						((JButton) component).setName(name[1].replaceAll(".jpg","").trim());
						
							accept = true;
						}
					}
				} catch (Exception exp) {
					exp.printStackTrace();
				}
			}
			return accept;
		}
	}
}
