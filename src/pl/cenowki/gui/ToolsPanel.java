package pl.cenowki.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ToolsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public ToolsPanel() {
		super();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JRadioButton rdbtnNazwaTowaru = new JRadioButton("Nazwa towaru");
		GridBagConstraints gbc_rdbtnNazwaTowaru = new GridBagConstraints();
		gbc_rdbtnNazwaTowaru.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNazwaTowaru.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNazwaTowaru.gridx = 0;
		gbc_rdbtnNazwaTowaru.gridy = 0;
		add(rdbtnNazwaTowaru, gbc_rdbtnNazwaTowaru);
		
		JRadioButton rdbtnProducent = new JRadioButton("Producent");
		GridBagConstraints gbc_rdbtnProducent = new GridBagConstraints();
		gbc_rdbtnProducent.anchor = GridBagConstraints.WEST;
		gbc_rdbtnProducent.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnProducent.gridx = 0;
		gbc_rdbtnProducent.gridy = 1;
		add(rdbtnProducent, gbc_rdbtnProducent);
		
		JRadioButton rdbtnKodKreskowy = new JRadioButton("Kod kreskowy");
		GridBagConstraints gbc_rdbtnKodKreskowy = new GridBagConstraints();
		gbc_rdbtnKodKreskowy.anchor = GridBagConstraints.WEST;
		gbc_rdbtnKodKreskowy.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnKodKreskowy.gridx = 0;
		gbc_rdbtnKodKreskowy.gridy = 2;
		add(rdbtnKodKreskowy, gbc_rdbtnKodKreskowy);
		
		JRadioButton rdbtnCenaDetaliczna = new JRadioButton("Cena detaliczna");
		GridBagConstraints gbc_rdbtnCenaDetaliczna = new GridBagConstraints();
		gbc_rdbtnCenaDetaliczna.anchor = GridBagConstraints.WEST;
		gbc_rdbtnCenaDetaliczna.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnCenaDetaliczna.gridx = 0;
		gbc_rdbtnCenaDetaliczna.gridy = 3;
		add(rdbtnCenaDetaliczna, gbc_rdbtnCenaDetaliczna);
		
		JRadioButton rdbtnCenaPromocyjna = new JRadioButton("Cena promocyjna");
		GridBagConstraints gbc_rdbtnCenaPromocyjna = new GridBagConstraints();
		gbc_rdbtnCenaPromocyjna.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnCenaPromocyjna.gridx = 0;
		gbc_rdbtnCenaPromocyjna.gridy = 4;
		add(rdbtnCenaPromocyjna, gbc_rdbtnCenaPromocyjna);
		
		JRadioButton rdbtnCenaNetto = new JRadioButton("Cena netto");
		GridBagConstraints gbc_rdbtnCenaNetto = new GridBagConstraints();
		gbc_rdbtnCenaNetto.anchor = GridBagConstraints.WEST;
		gbc_rdbtnCenaNetto.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnCenaNetto.gridx = 0;
		gbc_rdbtnCenaNetto.gridy = 5;
		add(rdbtnCenaNetto, gbc_rdbtnCenaNetto);
		
		JRadioButton rdbtnVat = new JRadioButton("VAT");
		GridBagConstraints gbc_rdbtnVat = new GridBagConstraints();
		gbc_rdbtnVat.anchor = GridBagConstraints.WEST;
		gbc_rdbtnVat.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnVat.gridx = 0;
		gbc_rdbtnVat.gridy = 6;
		add(rdbtnVat, gbc_rdbtnVat);
		
		JRadioButton rdbtnGramatura = new JRadioButton("Gramatura");
		GridBagConstraints gbc_rdbtnGramatura = new GridBagConstraints();
		gbc_rdbtnGramatura.anchor = GridBagConstraints.WEST;
		gbc_rdbtnGramatura.gridx = 0;
		gbc_rdbtnGramatura.gridy = 7;
		add(rdbtnGramatura, gbc_rdbtnGramatura);
	}

}
