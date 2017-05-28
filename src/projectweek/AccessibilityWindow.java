/**
 *
 * Copyright (c) 2005 University of Kent
 * Computing Laboratory, Canterbury, Kent, CT2 7NP, U.K
 *
 * @author Tom Elliott
 * 
 * Handles the Accessibility Dialog for users to change accessibility settings,
 * in particular thr ability to switch the magnifiying glass on/off and altering font sizes.
 * (Note: This window opens every time that the user opens HEAT so that they can access the 
 * Accessibility Features or Information about the Accessibility Features immediately).
 *
 */

package view.windows;

import managers.ActionManager;
import managers.SettingsManager;
import managers.WindowManager;
import utils.Settings;
import view.dialogs.FileDialogs;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import Accessibility.Audio;

public class AccessibilityWindow {
  
    private JPanel panelAccessibility;
    private JComboBox jcbOutputFontSize;
    private JComboBox jcbCodeFontSize;
    private JDialog dialog;
    private JTextArea infoPanel;

    private SettingsManager sm = SettingsManager.getInstance();
    private WindowManager wm = WindowManager.getInstance();


  /**
   * Creates a new AccessibilityWindow object.
   */
  public AccessibilityWindow() {
    try {
    	createAccessibilityWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  /*
   * This method initiates the creation of the Accessibility Window.
   * This method is called from the constructor of the AccessibilityWindow class.
   */
  private void createAccessibilityWindow() throws Exception {
   
      // panel for setting font sizes
      JPanel panelFontSizes = new JPanel(new GridLayout(0,1));
      jcbOutputFontSize = new JComboBox();
      jcbCodeFontSize = new JComboBox();
   /* Populate the font size combo boxes 
      increased the max size you can have the font to 40.
      changed the dropdown so that it increments by two and not by one.*/
      for (int i = 10; i < 41; i = i+2) {
        jcbOutputFontSize.addItem(String.valueOf(i));
        jcbCodeFontSize.addItem(String.valueOf(i));
      }
      JPanel editorFontSize = new JPanel();
      editorFontSize.add(new JLabel("Editor font size: "));
      editorFontSize.add(jcbCodeFontSize);
      JPanel interpreterFontSize = new JPanel();
      interpreterFontSize.add(new JLabel("Interpreter font size:"));
      interpreterFontSize.add(jcbOutputFontSize);
      panelFontSizes.add(editorFontSize);
      panelFontSizes.add(interpreterFontSize);
      
      //adding box for information about accessibility features.
      infoPanel = new JTextArea();
      // adding message to the window introducing accessibility features
      infoPanel.setText("Welcome to the HEAT Accessibility Manager. "
      		+ ""
      		+ "\n\n Shortcuts:\n- Accessibility Window: Ctrl/Cmd + Y\n"
      		+ "- Read Line from Console Window: Ctrl/Cmd + 9\n"
      		+ "- Read Line from Editor Window: Ctrl/Cmd + 0\n");
      infoPanel.setLineWrap(true);
      infoPanel.setEditable(false); // do not allow text within the text box to be altered by user.
      
      // buttons for applying options and cancellation
      JButton buttonApply = new JButton("Apply");
      buttonApply.setAction(ActionManager.getInstance().getSaveAccessibilityAction());
      JButton buttonCancel = new JButton("Cancel");
      buttonCancel.setToolTipText("Close without applying any changes");
      buttonCancel.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            close();
          }
        });
      JPanel panelButtons = new JPanel();
      panelButtons.add(buttonApply);
      panelButtons.add(buttonCancel);
      
      // put all together
      panelAccessibility = new JPanel(new BorderLayout());
      panelAccessibility.add(panelFontSizes,BorderLayout.CENTER);
      panelAccessibility.add(infoPanel, BorderLayout.NORTH);
      panelAccessibility.add(panelButtons,BorderLayout.PAGE_END);
  }
  

  
  /**
   * Displays the Accessibility window
   */
  public void show() {
    getProperties();
    dialog = new JDialog(wm.getMainScreenFrame(), "Accessibility Options");
    dialog.setModal(true);
    dialog.getContentPane().add(panelAccessibility);
    dialog.setMinimumSize(new Dimension(350,250));
    dialog.setMaximumSize(new Dimension(350,250));
    dialog.setSize(500, 320);
    dialog.setLocationRelativeTo(wm.getMainScreenFrame());
    dialog.setVisible(true);
  }
  

  /**
   * Closes the Accessibility window
   */
  public void close() {
    if (dialog != null)
      dialog.dispose();
  }

  /**
   * Gets the properties from the properties file, and sets them in the display
   */
  public void getProperties() {
    jcbOutputFontSize.setSelectedItem(sm.getSetting(Settings.OUTPUT_FONT_SIZE));
    jcbCodeFontSize.setSelectedItem(sm.getSetting(Settings.CODE_FONT_SIZE));
  }
  
  /**
   * Returns the desired font size for output/interpreter window
   *
   * @return the output/interpreter window font size
   */
  public String getOuputFontSize() {
    return (String) jcbOutputFontSize.getSelectedItem();
  }

  /**
   * Returns the desired font size for display/editor window
   *
   * @return the display/editor window font size
   */
  public String getCodeFontSize() {
    return (String) jcbCodeFontSize.getSelectedItem();
  }

}
