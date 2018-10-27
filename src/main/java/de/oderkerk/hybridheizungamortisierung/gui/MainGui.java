package de.oderkerk.hybridheizungamortisierung.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.oderkerk.hybridheizungamortisierung.rechner.Rechner;

public class MainGui {

	private JFrame frmAmortisierungsrechner;
	private JTextField textFieldHeizoelpreis;
	private JTextField textFieldStrompreis;
	private JTextField textFieldVerbrauch;
	private JTextField textFieldOelPreisKWH;
	private JLabel lblPrimrenergiebedarf;
	private JTextField textFieldPrimaerEnergie;
	private JLabel lblHeizkostenNur;
	private JTextField textFieldHeizkostenJahrBislang;
	private JLabel lblVerhltnisWrmepumpeZu;
	private JSlider slider;
	private JLabel lblZul;
	private JLabel lblNewLabelWaermepumpeproz;
	private JLabel lbloelproz;
	private JLabel lblNewLabelWaermePumpekwh;
	private JLabel lblNewLabeloelKwh;
	private JLabel lblJaz;
	private JTextField textFieldJAZ;
	private JLabel lblStromkostenWrmepumpe;
	private JLabel lblHeizkostenlheizung;
	private JLabel lblSummeHeizkostenGesamt;
	private JLabel lblDifferenzZuBisherigen;
	private JTextField textFieldStromkostenWaerme;
	private JTextField textFieldBrennwert;
	private JTextField textFieldSumme;
	private JTextField textFieldDifferenz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
					window.frmAmortisierungsrechner.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Rechner rechner;
	DecimalFormat df = new DecimalFormat("######.##");
	private final JLabel lblKostenIn = new JLabel("Kosten in \u20AC");
	private JLabel label;
	private JLabel label_1;

	/**
	 * Create the application.
	 */
	public MainGui() {
		rechner = new Rechner();
		initialize();
		recalculate();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmortisierungsrechner = new JFrame();
		frmAmortisierungsrechner.setTitle("Amortisierungsrechner");
		frmAmortisierungsrechner.setBounds(100, 100, 683, 583);
		frmAmortisierungsrechner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frmAmortisierungsrechner.getContentPane().setLayout(gridBagLayout);

		label = new JLabel("          ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		frmAmortisierungsrechner.getContentPane().add(label, gbc_label);

		JLabel lblAktuellerHeizlpreisl = new JLabel("Aktueller Heiz\u00F6lpreis 100L");
		GridBagConstraints gbc_lblAktuellerHeizlpreisl = new GridBagConstraints();
		gbc_lblAktuellerHeizlpreisl.insets = new Insets(0, 0, 5, 5);
		gbc_lblAktuellerHeizlpreisl.gridx = 1;
		gbc_lblAktuellerHeizlpreisl.gridy = 2;
		frmAmortisierungsrechner.getContentPane().add(lblAktuellerHeizlpreisl, gbc_lblAktuellerHeizlpreisl);

		textFieldHeizoelpreis = new JTextField();
		textFieldHeizoelpreis.setText("80.0");
		textFieldHeizoelpreis.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				recalculate();
			}
		});

		lblAktuellerHeizlpreisl.setLabelFor(textFieldHeizoelpreis);
		textFieldHeizoelpreis.setToolTipText("Heiz\u00F6lpreis");
		GridBagConstraints gbc_textFieldHeizoelpreis = new GridBagConstraints();
		gbc_textFieldHeizoelpreis.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldHeizoelpreis.anchor = GridBagConstraints.WEST;
		gbc_textFieldHeizoelpreis.gridx = 3;
		gbc_textFieldHeizoelpreis.gridy = 2;
		frmAmortisierungsrechner.getContentPane().add(textFieldHeizoelpreis, gbc_textFieldHeizoelpreis);
		textFieldHeizoelpreis.setColumns(10);

		JLabel lblNewLabel = new JLabel("Aktueller Strompreis kw/h");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		frmAmortisierungsrechner.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		textFieldStrompreis = new JTextField();
		textFieldStrompreis.setText("0.26");
		textFieldStrompreis.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				recalculate();
			}
		});
		lblNewLabel.setLabelFor(textFieldStrompreis);
		GridBagConstraints gbc_textFieldStrompreis = new GridBagConstraints();
		gbc_textFieldStrompreis.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldStrompreis.anchor = GridBagConstraints.WEST;
		gbc_textFieldStrompreis.gridx = 3;
		gbc_textFieldStrompreis.gridy = 3;
		frmAmortisierungsrechner.getContentPane().add(textFieldStrompreis, gbc_textFieldStrompreis);
		textFieldStrompreis.setColumns(10);

		JLabel lblJahresverbrauchHeizlIn = new JLabel("Jahresverbrauch Heiz\u00F6l in l");
		GridBagConstraints gbc_lblJahresverbrauchHeizlIn = new GridBagConstraints();
		gbc_lblJahresverbrauchHeizlIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblJahresverbrauchHeizlIn.gridx = 1;
		gbc_lblJahresverbrauchHeizlIn.gridy = 4;
		frmAmortisierungsrechner.getContentPane().add(lblJahresverbrauchHeizlIn, gbc_lblJahresverbrauchHeizlIn);

		textFieldVerbrauch = new JTextField();
		textFieldVerbrauch.setText("3000");
		textFieldVerbrauch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				recalculate();

			}

		});
		lblJahresverbrauchHeizlIn.setLabelFor(textFieldVerbrauch);
		GridBagConstraints gbc_textFieldVerbrauch = new GridBagConstraints();
		gbc_textFieldVerbrauch.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldVerbrauch.anchor = GridBagConstraints.WEST;
		gbc_textFieldVerbrauch.gridx = 3;
		gbc_textFieldVerbrauch.gridy = 4;
		frmAmortisierungsrechner.getContentPane().add(textFieldVerbrauch, gbc_textFieldVerbrauch);
		textFieldVerbrauch.setColumns(10);

		lblJaz = new JLabel("JAZ");
		GridBagConstraints gbc_lblJaz = new GridBagConstraints();
		gbc_lblJaz.insets = new Insets(0, 0, 5, 5);
		gbc_lblJaz.gridx = 1;
		gbc_lblJaz.gridy = 5;
		frmAmortisierungsrechner.getContentPane().add(lblJaz, gbc_lblJaz);

		textFieldJAZ = new JTextField();
		textFieldJAZ.setText("3");
		textFieldJAZ.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				recalculate();

			}

		});
		GridBagConstraints gbc_textFieldJAZ = new GridBagConstraints();
		gbc_textFieldJAZ.anchor = GridBagConstraints.WEST;
		gbc_textFieldJAZ.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldJAZ.gridx = 3;
		gbc_textFieldJAZ.gridy = 5;
		frmAmortisierungsrechner.getContentPane().add(textFieldJAZ, gbc_textFieldJAZ);
		textFieldJAZ.setColumns(10);

		JLabel lblHeizlpreisProKwh = new JLabel("Heiz\u00F6lpreis pro kw/h");
		GridBagConstraints gbc_lblHeizlpreisProKwh = new GridBagConstraints();
		gbc_lblHeizlpreisProKwh.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeizlpreisProKwh.gridx = 1;
		gbc_lblHeizlpreisProKwh.gridy = 7;
		frmAmortisierungsrechner.getContentPane().add(lblHeizlpreisProKwh, gbc_lblHeizlpreisProKwh);

		textFieldOelPreisKWH = new JTextField();
		textFieldOelPreisKWH.setEditable(false);
		GridBagConstraints gbc_textFieldOelPreisKWH = new GridBagConstraints();
		gbc_textFieldOelPreisKWH.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldOelPreisKWH.anchor = GridBagConstraints.WEST;
		gbc_textFieldOelPreisKWH.gridx = 3;
		gbc_textFieldOelPreisKWH.gridy = 7;
		frmAmortisierungsrechner.getContentPane().add(textFieldOelPreisKWH, gbc_textFieldOelPreisKWH);
		textFieldOelPreisKWH.setColumns(10);

		lblPrimrenergiebedarf = new JLabel("Prim\u00E4renergiebedarf");
		GridBagConstraints gbc_lblPrimrenergiebedarf = new GridBagConstraints();
		gbc_lblPrimrenergiebedarf.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimrenergiebedarf.gridx = 1;
		gbc_lblPrimrenergiebedarf.gridy = 8;
		frmAmortisierungsrechner.getContentPane().add(lblPrimrenergiebedarf, gbc_lblPrimrenergiebedarf);

		textFieldPrimaerEnergie = new JTextField();
		textFieldPrimaerEnergie.setEditable(false);
		GridBagConstraints gbc_textFieldPrimaerEnergie = new GridBagConstraints();
		gbc_textFieldPrimaerEnergie.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPrimaerEnergie.anchor = GridBagConstraints.WEST;
		gbc_textFieldPrimaerEnergie.gridx = 3;
		gbc_textFieldPrimaerEnergie.gridy = 8;
		frmAmortisierungsrechner.getContentPane().add(textFieldPrimaerEnergie, gbc_textFieldPrimaerEnergie);
		textFieldPrimaerEnergie.setColumns(10);

		lblHeizkostenNur = new JLabel("Heizkosten ( nur Heiz\u00F6lpreis)");
		GridBagConstraints gbc_lblHeizkostenNur = new GridBagConstraints();
		gbc_lblHeizkostenNur.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeizkostenNur.gridx = 1;
		gbc_lblHeizkostenNur.gridy = 9;
		frmAmortisierungsrechner.getContentPane().add(lblHeizkostenNur, gbc_lblHeizkostenNur);

		textFieldHeizkostenJahrBislang = new JTextField();
		textFieldHeizkostenJahrBislang.setEditable(false);
		GridBagConstraints gbc_textFieldHeizkostenJahrBislang = new GridBagConstraints();
		gbc_textFieldHeizkostenJahrBislang.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldHeizkostenJahrBislang.anchor = GridBagConstraints.WEST;
		gbc_textFieldHeizkostenJahrBislang.gridx = 3;
		gbc_textFieldHeizkostenJahrBislang.gridy = 9;
		frmAmortisierungsrechner.getContentPane().add(textFieldHeizkostenJahrBislang,
				gbc_textFieldHeizkostenJahrBislang);
		textFieldHeizkostenJahrBislang.setColumns(10);

		lblVerhltnisWrmepumpeZu = new JLabel("Verh\u00E4ltnis W\u00E4rmepumpe");
		GridBagConstraints gbc_lblVerhltnisWrmepumpeZu = new GridBagConstraints();
		gbc_lblVerhltnisWrmepumpeZu.insets = new Insets(0, 0, 5, 5);
		gbc_lblVerhltnisWrmepumpeZu.gridx = 1;
		gbc_lblVerhltnisWrmepumpeZu.gridy = 11;
		frmAmortisierungsrechner.getContentPane().add(lblVerhltnisWrmepumpeZu, gbc_lblVerhltnisWrmepumpeZu);

		lblZul = new JLabel("zu \u00D6l");
		GridBagConstraints gbc_lblZul = new GridBagConstraints();
		gbc_lblZul.insets = new Insets(0, 0, 5, 0);
		gbc_lblZul.gridx = 3;
		gbc_lblZul.gridy = 11;
		frmAmortisierungsrechner.getContentPane().add(lblZul, gbc_lblZul);

		lblNewLabelWaermepumpeproz = new JLabel("50 %");
		GridBagConstraints gbc_lblNewLabelWaermepumpeproz = new GridBagConstraints();
		gbc_lblNewLabelWaermepumpeproz.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelWaermepumpeproz.gridx = 1;
		gbc_lblNewLabelWaermepumpeproz.gridy = 12;
		frmAmortisierungsrechner.getContentPane().add(lblNewLabelWaermepumpeproz, gbc_lblNewLabelWaermepumpeproz);

		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				recalculate();
			}
		});
		lblNewLabelWaermepumpeproz.setLabelFor(slider);
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.insets = new Insets(0, 0, 5, 5);
		gbc_slider.gridx = 2;
		gbc_slider.gridy = 12;
		frmAmortisierungsrechner.getContentPane().add(slider, gbc_slider);

		lbloelproz = new JLabel("50 %");
		GridBagConstraints gbc_lbloelproz = new GridBagConstraints();
		gbc_lbloelproz.insets = new Insets(0, 0, 5, 0);
		gbc_lbloelproz.gridx = 3;
		gbc_lbloelproz.gridy = 12;
		frmAmortisierungsrechner.getContentPane().add(lbloelproz, gbc_lbloelproz);

		lblNewLabelWaermePumpekwh = new JLabel("... kw/h");
		GridBagConstraints gbc_lblNewLabelWaermePumpekwh = new GridBagConstraints();
		gbc_lblNewLabelWaermePumpekwh.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelWaermePumpekwh.gridx = 1;
		gbc_lblNewLabelWaermePumpekwh.gridy = 13;
		frmAmortisierungsrechner.getContentPane().add(lblNewLabelWaermePumpekwh, gbc_lblNewLabelWaermePumpekwh);

		lblNewLabeloelKwh = new JLabel("... kw/h");
		GridBagConstraints gbc_lblNewLabeloelKwh = new GridBagConstraints();
		gbc_lblNewLabeloelKwh.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabeloelKwh.gridx = 3;
		gbc_lblNewLabeloelKwh.gridy = 13;
		frmAmortisierungsrechner.getContentPane().add(lblNewLabeloelKwh, gbc_lblNewLabeloelKwh);

		label_1 = new JLabel("         ");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 14;
		frmAmortisierungsrechner.getContentPane().add(label_1, gbc_label_1);
		GridBagConstraints gbc_lblKostenIn = new GridBagConstraints();
		gbc_lblKostenIn.insets = new Insets(0, 0, 5, 0);
		gbc_lblKostenIn.gridx = 3;
		gbc_lblKostenIn.gridy = 15;
		frmAmortisierungsrechner.getContentPane().add(lblKostenIn, gbc_lblKostenIn);

		lblStromkostenWrmepumpe = new JLabel("Stromkosten W\u00E4rmepumpe");
		GridBagConstraints gbc_lblStromkostenWrmepumpe = new GridBagConstraints();
		gbc_lblStromkostenWrmepumpe.insets = new Insets(0, 0, 5, 5);
		gbc_lblStromkostenWrmepumpe.gridx = 1;
		gbc_lblStromkostenWrmepumpe.gridy = 16;
		frmAmortisierungsrechner.getContentPane().add(lblStromkostenWrmepumpe, gbc_lblStromkostenWrmepumpe);

		textFieldStromkostenWaerme = new JTextField();
		textFieldStromkostenWaerme.setEditable(false);
		GridBagConstraints gbc_textFieldStromkostenWaerme = new GridBagConstraints();
		gbc_textFieldStromkostenWaerme.anchor = GridBagConstraints.WEST;
		gbc_textFieldStromkostenWaerme.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldStromkostenWaerme.gridx = 3;
		gbc_textFieldStromkostenWaerme.gridy = 16;
		frmAmortisierungsrechner.getContentPane().add(textFieldStromkostenWaerme, gbc_textFieldStromkostenWaerme);
		textFieldStromkostenWaerme.setColumns(10);

		lblHeizkostenlheizung = new JLabel("Heizkosten Brennwert");
		GridBagConstraints gbc_lblHeizkostenlheizung = new GridBagConstraints();
		gbc_lblHeizkostenlheizung.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeizkostenlheizung.gridx = 1;
		gbc_lblHeizkostenlheizung.gridy = 17;
		frmAmortisierungsrechner.getContentPane().add(lblHeizkostenlheizung, gbc_lblHeizkostenlheizung);

		textFieldBrennwert = new JTextField();
		textFieldBrennwert.setEditable(false);
		GridBagConstraints gbc_textFieldBrennwert = new GridBagConstraints();
		gbc_textFieldBrennwert.anchor = GridBagConstraints.WEST;
		gbc_textFieldBrennwert.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldBrennwert.gridx = 3;
		gbc_textFieldBrennwert.gridy = 17;
		frmAmortisierungsrechner.getContentPane().add(textFieldBrennwert, gbc_textFieldBrennwert);
		textFieldBrennwert.setColumns(10);

		lblSummeHeizkostenGesamt = new JLabel("Summe Heizkosten gesamt");
		GridBagConstraints gbc_lblSummeHeizkostenGesamt = new GridBagConstraints();
		gbc_lblSummeHeizkostenGesamt.insets = new Insets(0, 0, 5, 5);
		gbc_lblSummeHeizkostenGesamt.gridx = 1;
		gbc_lblSummeHeizkostenGesamt.gridy = 18;
		frmAmortisierungsrechner.getContentPane().add(lblSummeHeizkostenGesamt, gbc_lblSummeHeizkostenGesamt);

		textFieldSumme = new JTextField();
		textFieldSumme.setEditable(false);
		GridBagConstraints gbc_textFieldSumme = new GridBagConstraints();
		gbc_textFieldSumme.anchor = GridBagConstraints.WEST;
		gbc_textFieldSumme.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldSumme.gridx = 3;
		gbc_textFieldSumme.gridy = 18;
		frmAmortisierungsrechner.getContentPane().add(textFieldSumme, gbc_textFieldSumme);
		textFieldSumme.setColumns(10);

		lblDifferenzZuBisherigen = new JLabel("Differenz zu bisherigen Heizkosten");
		GridBagConstraints gbc_lblDifferenzZuBisherigen = new GridBagConstraints();
		gbc_lblDifferenzZuBisherigen.insets = new Insets(0, 0, 0, 5);
		gbc_lblDifferenzZuBisherigen.gridx = 1;
		gbc_lblDifferenzZuBisherigen.gridy = 19;
		frmAmortisierungsrechner.getContentPane().add(lblDifferenzZuBisherigen, gbc_lblDifferenzZuBisherigen);

		textFieldDifferenz = new JTextField();
		textFieldDifferenz.setEditable(false);
		GridBagConstraints gbc_textFieldDifferenz = new GridBagConstraints();
		gbc_textFieldDifferenz.anchor = GridBagConstraints.WEST;
		gbc_textFieldDifferenz.gridx = 3;
		gbc_textFieldDifferenz.gridy = 19;
		frmAmortisierungsrechner.getContentPane().add(textFieldDifferenz, gbc_textFieldDifferenz);
		textFieldDifferenz.setColumns(10);
	}

	private void recalculate() {
		if (textFieldJAZ.getText().trim().length() > 0) {
			textFieldJAZ.setText(textFieldJAZ.getText().replace(',', '.'));
		}
		if (textFieldStrompreis.getText().trim().length() > 0) {
			textFieldStrompreis.setText(textFieldStrompreis.getText().replace(',', '.'));
		}
		if (textFieldHeizoelpreis.getText().trim().length() > 0) {
			textFieldHeizoelpreis.setText(textFieldHeizoelpreis.getText().replace(',', '.'));

			textFieldOelPreisKWH.setText(String
					.valueOf(df.format(rechner.getPreis1kwhHeizoel(Float.parseFloat(textFieldHeizoelpreis.getText()))))
					.replace(',', '.'));
		}
		if (textFieldVerbrauch.getText().trim().length() > 0) {
			textFieldVerbrauch.setText(textFieldVerbrauch.getText().replace(',', '.'));
		}
		if (textFieldJAZ.getText().trim().length() > 0 && textFieldStrompreis.getText().trim().length() > 0
				&& textFieldHeizoelpreis.getText().trim().length() > 0
				&& textFieldVerbrauch.getText().trim().length() > 0) {
			textFieldPrimaerEnergie.setText(String
					.valueOf(df.format(rechner.getPrimaerenergieBedarf(Float.parseFloat(textFieldVerbrauch.getText())))
							.replace(',', '.')));

			textFieldHeizkostenJahrBislang.setText(String
					.valueOf(df.format(
							rechner.getHeizkosten(Float.parseFloat(textFieldPrimaerEnergie.getText().replace(',', '.')),
									Float.parseFloat(textFieldOelPreisKWH.getText().replace(',', '.')))))
					.replace(',', '.'));

			lblNewLabelWaermepumpeproz.setText(String.valueOf(slider.getValue()) + " % ");
			lbloelproz.setText(String.valueOf(100 - slider.getValue() + " % "));
			lblNewLabelWaermePumpekwh.setText(String.valueOf((df.format(
					Float.valueOf(textFieldPrimaerEnergie.getText().replace(',', '.')) * (slider.getValue()) / 100))
							.replace(',', '.'))
					+ " kw/h");
			lblNewLabeloelKwh.setText(
					String.valueOf((df.format(Float.valueOf(textFieldPrimaerEnergie.getText().replace(',', '.'))
							* (100 - slider.getValue()) / 100)).replace(',', '.')) + " kw/h");

			float waermepumpenkosten = rechner.getWaermepumpenKosten(
					Float.parseFloat(lblNewLabelWaermePumpekwh.getText().replaceAll("kw/h", "")),
					Float.parseFloat(textFieldStrompreis.getText()));
			float heizoelkosten = rechner.getOelheizungKosten(
					Float.parseFloat(lblNewLabeloelKwh.getText().replaceAll("kw/h", "")),
					Float.parseFloat(textFieldOelPreisKWH.getText()));

			float summe = waermepumpenkosten + heizoelkosten;
			float diff = summe - Float.parseFloat(textFieldHeizkostenJahrBislang.getText());

			textFieldStromkostenWaerme.setText(df.format(waermepumpenkosten).replace(',', '.'));
			textFieldBrennwert.setText(df.format(heizoelkosten).replace(',', '.'));
			textFieldSumme.setText(df.format(summe).replace(',', '.'));
			textFieldDifferenz.setText(df.format(diff).replace(',', '.'));
			if (diff < 0) {
				textFieldDifferenz.setForeground(Color.GREEN);
				textFieldDifferenz.setBackground(Color.BLACK);
			} else {
				textFieldDifferenz.setForeground(Color.RED);
			}

		}

	}

}
