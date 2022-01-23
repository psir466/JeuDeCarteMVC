package org.psi.vue;

import java.awt.Component;
import java.awt.Container;
import java.util.Map.Entry;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.psi.controleur.Deroulementpartie;
import org.psi.metier.Carte;
import org.psi.metier.IJoueur;
import org.psi.metier.Regle;
import org.psi.metier.RegleMin;

public class VueSwing implements Ivue {

	JTextArea textArea;
	JFrame frame;
	
	public VueSwing() {
		this.createAndShowGUI();
	}

	public void createAndShowGUI() {

		// create main frame
		frame = new JFrame("MVC-SOLID-Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);

		// display vertically
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		addControllerCommandTracker(contentPane);

		frame.setVisible(true);
	}

	// a simple place to display what the controller is telling us
	// very similar to our command line version
	private void addControllerCommandTracker(Container contentPane) {
		textArea = new JTextArea("Game Status\n", 100, 1);
		JScrollPane scrollPane = new JScrollPane(textArea);
		addCenteredComponent(scrollPane, contentPane);
		textArea.setSize(500, 500);
	}

	// all controls are added so they are centered horizontally in the area
	private void addCenteredComponent(JComponent component, Container contentPane) {
		component.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(component);
	}

	private void appendText(String text) {
		textArea.append(text + "\n");
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

	public void saisieJoueur() {

		String result = (String) JOptionPane.showInputDialog(frame, "Add a player", "Player", JOptionPane.PLAIN_MESSAGE,
				null, null, "");

		Deroulementpartie.creerJoueur(result);

		int addMore = JOptionPane.showConfirmDialog(frame, "Add more players ?", "More players",
				JOptionPane.YES_NO_OPTION);

		if (addMore == JOptionPane.NO_OPTION) {
			Deroulementpartie.startGame();
		}

	};

	public void distribuerCartes() {

		appendText("Cartes distribuées");

		Deroulementpartie.distribuerCarteJoueurs();

	};

	public void voirCartes() {

		for (Entry<IJoueur, Carte> entry : Deroulementpartie.voirCarteJoueur().entrySet()) {

			appendText("Joueur : " + entry.getKey().getNom() + " Carte " + entry.getValue().getCouleur()
					+ entry.getValue().getType());

		}

	};

	public void voirWinner() {

		appendText("Winner!\n" + Deroulementpartie.winner().getNom());
	};

	public boolean newPartie() {

		int newPart = JOptionPane.showConfirmDialog(frame, "New Party ?", "", JOptionPane.YES_NO_OPTION);

		if (newPart == JOptionPane.NO_OPTION) {
			return false;
		}

		return true;
	};

	public void choixPartie() {

		String result = (String) JOptionPane.showInputDialog(frame, "Gagnant carte la plus élevée / la moins élevée",
				"Choix", JOptionPane.PLAIN_MESSAGE, null, null, "");

		if (result.equals("plus")) {

			/// PAS TERRIBLE !!!!!!!!!!!! MAIS U MOIN ON NE MODIFIE PAS LE CONTROLEUR

			Deroulementpartie.getPartie().setRegle(new Regle());

		} else {

			Deroulementpartie.getPartie().setRegle(new RegleMin());
		}

	};

}
