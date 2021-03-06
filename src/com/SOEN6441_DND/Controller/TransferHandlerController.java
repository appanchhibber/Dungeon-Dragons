package com.SOEN6441_DND.Controller;

import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

/**
 * This controller is responsible for handling the drag and drop data in the map
 * View
 * 
 * @author Punit Trivedi
 * @author Appan Chhibber
 *
 */
public class TransferHandlerController {
	/**
	 * method for handling the export of dragged component
	 * 
	 * @param value
	 * @return
	 */
	public ValueExportTransferHandler valueExportCreator(String value) {
		return new ValueExportTransferHandler(value);
	}

	/**
	 * method for handling the export of dragged component
	 * 
	 * @param value
	 * @param parent
	 * @return
	 */
	public ValueExportTransferHandler valueExportCreator(String value,
			String parent) {
		return new ValueExportTransferHandler(value, parent);
	}

	/**
	 * method for handling the import of dragged component
	 * 
	 * @return
	 */
	public ValueImportTransferHandler valueImportCreator() {
		return new ValueImportTransferHandler();
	}

	/**
	 * This is a static class that extends TransferHandler and allows the value
	 * to be exported from one component to the other
	 * 
	 * @author Appan Chhibber
	 * @author Punit Trivedi
	 */
	public static class ValueExportTransferHandler extends TransferHandler {

		public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;
		private String value;
		private String parentValue;

		public ValueExportTransferHandler(String value) {
			this.value = value;
		}

		public ValueExportTransferHandler(String value, String parent) {
			this.value = value;
			this.parentValue = parent;
		}

		public String getValue() {
			return value;
		}

		public String getParentValue() {
			return parentValue;
		}

		@Override
		public int getSourceActions(JComponent c) {
			return DnDConstants.ACTION_COPY_OR_MOVE;
		}

		@Override
		protected Transferable createTransferable(JComponent c) {
			Transferable t = null;
			if (c.getName() == null) {
				t = new StringSelection(getValue());
			} else {
				t = new StringSelection(getValue() + ":" + getParentValue());
			}
			return t;
		}

		@Override
		protected void exportDone(JComponent source, Transferable data,
				int action) {
			super.exportDone(source, data, action);
			// Decide what to do after the drop has been accepted
		}

	}

	/**
	 * This is a static class and extends TransferHandler and is responsible for
	 * importing the value from the dragged and dropped component
	 * 
	 * @author Appan Chhibber
	 * @author Punit Trivedi
	 *
	 */
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
							if (!component.getName().contains(",")) {
								accept = false;
							} else {
								if (value.toString().contains(":")) {
									String[] arr = value.toString().split(":");
									String btnName = arr[1];
									String imagePath = arr[0];
									ImageIcon image = new ImageIcon(
											new ImageIcon(imagePath)
													.getImage()
													.getScaledInstance(
															component
																	.getWidth(),
															component
																	.getHeight(),
															java.awt.Image.SCALE_SMOOTH));
									((JButton) component).setIcon(image);
									((JButton) component)
											.setText(((JButton) component)
													.getName());
									((JButton) component).setFont(new Font(
											"Calibri", Font.PLAIN, 0));
									((JButton) component).setName(btnName);

									accept = true;
								} else {
									ImageIcon image = new ImageIcon(
											new ImageIcon(value.toString())
													.getImage()
													.getScaledInstance(
															component
																	.getWidth(),
															component
																	.getHeight(),
															java.awt.Image.SCALE_SMOOTH));
									((JButton) component).setIcon(image);
									((JButton) component)
											.setText(((JButton) component)
													.getName());
									((JButton) component).setFont(new Font(
											"Calibri", Font.PLAIN, 0));

									String[] name = value.toString().split("/");
									((JButton) component).setName(name[1]
											.replaceAll(".jpg", "").trim());
									accept = true;
								}

							}
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
