/**
 * 
 */
package com.alphasystem.ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * @author sali
 * 
 */
public abstract class AbstractTableCellRenderer extends JLabel implements
		TableCellRenderer {

	private static final long serialVersionUID = 7169432117882606816L;

	public AbstractTableCellRenderer() {
		// MUST do this for background to show up.
		setOpaque(true);
		setHorizontalAlignment(CENTER);
		setHorizontalTextPosition(CENTER);
		setVerticalAlignment(CENTER);
		setVerticalTextPosition(CENTER);
	}

	protected abstract void updateLabelText(Object value);

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		updateLabelText(value);
		Color foreground = table.getForeground();
		Color background = table.getBackground();
		if (isSelected) {
			foreground = table.getSelectionForeground();
			background = table.getSelectionBackground();
		}
		setForeground(foreground);
		setBackground(background);
		return this;
	}

}
