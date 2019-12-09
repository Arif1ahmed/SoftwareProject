import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextArea;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class notepadd extends JFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					notepadd frame = new notepadd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public notepadd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 447);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmHh = new JMenuItem("Open");
		mntmHh.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0)
			{
				
			}
		});
		mnFile.add(mntmHh);
		
		JMenuItem mntmC = new JMenuItem("Save");
		mnFile.add(mntmC);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mnFile.add(mntmSaveAs);
		
		JMenuItem mntmPageSetup = new JMenuItem("Page Setup");
		mnFile.add(mntmPageSetup);
		
		JMenuItem mntmPrint = new JMenuItem("Print");
		mnFile.add(mntmPrint);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu(" Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmUndo = new JMenuItem("Undo");
		mnEdit.add(mntmUndo);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mntmCut.setEnabled(false);
		mntmCut.setSelected(true);
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.setEnabled(false);
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mntmPaste.setEnabled(false);
		mnEdit.add(mntmPaste);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.setEnabled(false);
		mnEdit.add(mntmDelete);
		
		JMenuItem mntmFind = new JMenuItem("Find ");
		mntmFind.setEnabled(false);
		mnEdit.add(mntmFind);
		
		JMenuItem mntmFindNext = new JMenuItem("Find Next");
		mntmFindNext.setEnabled(false);
		mnEdit.add(mntmFindNext);
		
		JMenuItem mntmReplace = new JMenuItem("Replace");
		mnEdit.add(mntmReplace);
		
		JMenuItem mntmGoto = new JMenuItem("Goto");
		mnEdit.add(mntmGoto);
		
		JMenuItem mntmSelectAll = new JMenuItem("Select All");
		mnEdit.add(mntmSelectAll);
		
		JMenuItem mntmTimedate = new JMenuItem("Time/Date");
		mnEdit.add(mntmTimedate);
		
		JMenu mnFormat = new JMenu("Format");
		menuBar.add(mnFormat);
		
		JMenuItem mntmWordWrap = new JMenuItem("Word Wrap");
		mnFormat.add(mntmWordWrap);
		
		JMenuItem mntmFont = new JMenuItem("Font");
		mnFormat.add(mntmFont);
		
		JMenu mnLanguage = new JMenu("View");
		menuBar.add(mnLanguage);
		
		JMenuItem mntmStatusBar = new JMenuItem("Status Bar");
		mnLanguage.add(mntmStatusBar);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmViewHelp = new JMenuItem("View Help");
		mnHelp.add(mntmViewHelp);
		
		JMenuItem mntmAboutNotepad = new JMenuItem("About Notepad");
		mnHelp.add(mntmAboutNotepad);
		
		JTextArea textArea = new JTextArea();
		
		JTextArea textArea_1 = new JTextArea();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblYtyg = new JLabel("ytyg");
		GroupLayout groupLayout_1 = new GroupLayout(getContentPane());
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGap(55)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGap(256)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGap(409)
							.addComponent(lblYtyg)))
					.addContainerGap(497, Short.MAX_VALUE))
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGap(20)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(93)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(lblYtyg)
					.addContainerGap(327, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout_1);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 696, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 387, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
	}
}