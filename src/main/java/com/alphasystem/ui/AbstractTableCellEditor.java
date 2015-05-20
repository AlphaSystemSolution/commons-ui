/**
 * 
 */
package com.alphasystem.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 * @author sali
 * 
 */
public abstract class AbstractTableCellEditor extends AbstractCellEditor
		implements TableCellEditor, ActionListener {

	private static final long serialVersionUID = -6375973477015194265L;

	private static final String EDIT = "edit";

	protected JButton editorComponent;

	protected JFrame frame;

	/**
	 * @param frame
	 */
	public AbstractTableCellEditor(JFrame frame) {
		this.frame = frame;

		// Set up the editor (from the table's point of view), which is a
		// button. This button brings up the dialog, which
		// is the editor from the user's point of view.
		editorComponent = new JButton();
		editorComponent.setActionCommand(EDIT);
		editorComponent.addActionListener(this);
		editorComponent.setBorderPainted(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (EDIT.equals(actionCommand)) {
			showDialog();
			fireEditingStopped();
		}
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		setValue(value);
		return editorComponent;
	}

	protected abstract void setValue(Object value);

	protected abstract void showDialog();

}
