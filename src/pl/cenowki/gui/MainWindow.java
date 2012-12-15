package pl.cenowki.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import pl.cenowki.items.Barcode;
import pl.cenowki.items.Text;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class MainWindow {

	private JFrame frame;
	private LabelEdition editLabel;

	public MainWindow() {
		initialize();
	}

	public void setVisible(boolean arg0) {
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Cenówki");
		frame.setBounds(100, 100, 846, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnPlik = new JMenu("Plik");
		menuBar.add(mnPlik);

		JMenuItem mntmOtwrz = new JMenuItem("Otw\u00F3rz");
		mnPlik.add(mntmOtwrz);

		JMenuItem mntmZapisz = new JMenuItem("Zapisz");
		mnPlik.add(mntmZapisz);

		JMenuItem mntmZapiszJako = new JMenuItem("Zapisz jako...");
		mnPlik.add(mntmZapiszJako);

		JMenuItem mntmZamknij = new JMenuItem("Zamknij");
		mnPlik.add(mntmZamknij);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton = new JButton("EAN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editLabel.setClassToDraw(Barcode.class);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nazwa towaru");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editLabel.setClassToDraw(Text.class);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 0;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Tekst");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 0;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnZmieTekst = new JButton("Zmie\u0144 tekst");
		btnZmieTekst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editLabel.openTextEditor();
			}
		});
		GridBagConstraints gbc_btnZmieTekst = new GridBagConstraints();
		gbc_btnZmieTekst.insets = new Insets(0, 0, 0, 5);
		gbc_btnZmieTekst.gridx = 4;
		gbc_btnZmieTekst.gridy = 0;
		panel.add(btnZmieTekst, gbc_btnZmieTekst);
		
		JLabel lblRozmiar = new JLabel("Rozmiar:");
		GridBagConstraints gbc_lblRozmiar = new GridBagConstraints();
		gbc_lblRozmiar.insets = new Insets(0, 0, 0, 5);
		gbc_lblRozmiar.anchor = GridBagConstraints.EAST;
		gbc_lblRozmiar.gridx = 5;
		gbc_lblRozmiar.gridy = 0;
		panel.add(lblRozmiar, gbc_lblRozmiar);
		
		final JComboBox<Integer> comboBox = new JComboBox<Integer>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.gridx = 6;
		gbc_comboBox.gridy = 0;
		panel.add(comboBox, gbc_comboBox);
		
		JButton btnNewButton_3 = new JButton("Usu\u0144");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editLabel.removeSelectedObject();
			}
		});
		
		JLabel lblTyp = new JLabel("Typ:");
		GridBagConstraints gbc_lblTyp = new GridBagConstraints();
		gbc_lblTyp.anchor = GridBagConstraints.EAST;
		gbc_lblTyp.insets = new Insets(0, 0, 0, 5);
		gbc_lblTyp.gridx = 7;
		gbc_lblTyp.gridy = 0;
		panel.add(lblTyp, gbc_lblTyp);
		
/*		JComboBox comboFontType = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 7;
		gbc_comboBox_1.gridy = 0;
		panel.add(comboFontType, gbc_comboBox_1);
		comboFontType.addItem(Font.BOLD);
		comboFontType.addItem(Font.ITALIC);*/
		
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_3.gridx = 9;
		gbc_btnNewButton_3.gridy = 0;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JPanel toolsPanel = new JPanel();
		toolsPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		frame.getContentPane().add(toolsPanel, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		toolsPanel.setLayout(gbl_panel_1);
		
		
		JRadioButton rdbtnNazwaTowaru = new JRadioButton("Nazwa towaru");
		GridBagConstraints gbc_rdbtnNazwaTowaru = new GridBagConstraints();
		gbc_rdbtnNazwaTowaru.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNazwaTowaru.gridx = 0;
		gbc_rdbtnNazwaTowaru.gridy = 0;
		toolsPanel.add(rdbtnNazwaTowaru, gbc_rdbtnNazwaTowaru);
		
		JRadioButton rdbtnStayTekst = new JRadioButton("Sta\u0142y tekst");
		GridBagConstraints gbc_rdbtnStayTekst = new GridBagConstraints();
		gbc_rdbtnStayTekst.anchor = GridBagConstraints.WEST;
		gbc_rdbtnStayTekst.gridx = 0;
		gbc_rdbtnStayTekst.gridy = 1;
		toolsPanel.add(rdbtnStayTekst, gbc_rdbtnStayTekst);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNazwaTowaru);
		bg.add(rdbtnStayTekst);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.RED);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.gridheight = 2;
		gbc_separator.insets = new Insets(0, 0, 0, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 0;
		frame.getContentPane().add(separator, gbc_separator);
		
		editLabel = new LabelEdition();
		editLabel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		editLabel.setLayout(null);
		GridBagConstraints gbc_editLabel = new GridBagConstraints();
		gbc_editLabel.fill = GridBagConstraints.BOTH;
		gbc_editLabel.gridx = 2;
		gbc_editLabel.gridy = 1;
		frame.getContentPane().add(editLabel, gbc_editLabel);
		mntmZamknij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				System.exit(0);
			}
		});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editLabel.setFontSize((int)comboBox.getSelectedItem());
			}
		});
		for(int i = 10; i < 60; ++i) {
			comboBox.addItem(i);
		}
	}
}

