/**
 * 
 */
package com.alphasystem.ui;

import com.jidesoft.swing.JideTabbedPane;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import static com.alphasystem.util.Utils.USER_HOME_DIR;
import static com.jidesoft.plaf.LookAndFeelFactory.installDefaultLookAndFeelAndExtension;
import static java.awt.BorderLayout.CENTER;
import static java.lang.Integer.parseInt;
import static javax.swing.JFileChooser.DIRECTORIES_ONLY;
import static javax.swing.JFileChooser.FILES_ONLY;
import static javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT;
import static javax.swing.SwingConstants.TOP;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;
import static javax.swing.UIManager.setLookAndFeel;

/**
 * @author sali
 * 
 */
public class UIUtilities {

	public static JideTabbedPane createTabPane() {
		return createTabPane(TOP);
	}

	public static JideTabbedPane createTabPane(
			boolean useDefaultShowCloseButtonOnTab, boolean showCloseButton,
			boolean showCloseButtonOnTab, boolean showCloseButtonOnSelectedTab,
			boolean boldActiveTab) {
		return createTabPane(TOP, SCROLL_TAB_LAYOUT,
				useDefaultShowCloseButtonOnTab, showCloseButton,
				showCloseButtonOnTab, showCloseButtonOnSelectedTab,
				boldActiveTab);
	}

	public static JideTabbedPane createTabPane(int tabPlacement) {
		return createTabPane(tabPlacement, SCROLL_TAB_LAYOUT);
	}

	public static JideTabbedPane createTabPane(int tabPlacement,
			int tabLayoutPolicy) {
		return createTabPane(tabPlacement, tabLayoutPolicy, false, false,
				false, false, true);
	}

	public static JideTabbedPane createTabPane(int tabPlacement,
			int tabLayoutPolicy, boolean useDefaultShowCloseButtonOnTab,
			boolean showCloseButton, boolean showCloseButtonOnTab,
			boolean showCloseButtonOnSelectedTab, boolean boldActiveTab) {
		JideTabbedPane tabPane = new JideTabbedPane(tabPlacement,
				tabLayoutPolicy);
		tabPane.setUseDefaultShowCloseButtonOnTab(useDefaultShowCloseButtonOnTab);
		tabPane.setShowCloseButton(showCloseButton);
		tabPane.setShowCloseButtonOnTab(showCloseButtonOnTab);
		tabPane.setShowCloseButtonOnSelectedTab(showCloseButtonOnSelectedTab);
		tabPane.setBoldActiveTab(boldActiveTab);
		return tabPane;
	}

	public static Point getCenter(Component parent) {
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - parent.getWidth()) / 2;
		final int y = (screenSize.height - parent.getHeight()) / 2;
		return new Point(x, y);
	}

	public static JFileChooser initFileChooser(String extension) {
		return initFileChooser(extension, USER_HOME_DIR);
	}

	public static JFileChooser initFileChooser(String extension,
			File currentDirectory) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(FILES_ONLY);
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setFileFilter(new FileChooserFilter(extension));
		if (currentDirectory == null) {
			currentDirectory = USER_HOME_DIR;
		}
		fileChooser.setCurrentDirectory(currentDirectory);
		return fileChooser;
	}

	public static JFileChooser initFolderChooser() {
		return initFolderChooser(null);
	}

	public static JFileChooser initFolderChooser(File currentDirectory) {
		JFileChooser folderChooser = new JFileChooser();
		if (currentDirectory == null) {
			currentDirectory = USER_HOME_DIR;
		}
		folderChooser.setCurrentDirectory(currentDirectory);
		folderChooser.setFileSelectionMode(DIRECTORIES_ONLY);
		folderChooser.setMultiSelectionEnabled(false);
		return folderChooser;
	}

	public static void wrapInFrame(JPanel panel){
		JFrame frame = new JFrame("Test");
		frame.setContentPane(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static JPanel wrapInPanel(JComponent component) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(component, CENTER);
		return panel;
	}

	public static Color hex2Rgb(String colorStr){
		return new Color(parseInt(colorStr.substring(1, 3), 16),
				parseInt(colorStr.substring(3, 5), 16),
				parseInt(colorStr.substring(5, 7), 16));
	}

	public static void initLookAndFeel(){
		installDefaultLookAndFeelAndExtension();
		try {
			setLookAndFeel(getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
	}
}
