package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import MainComponents.CSVReader;
import MainComponents.MainInterface;

public class ActionListenerMain implements ActionListener {
	private MainInterface maininterface;
	private CSVReader reader;

	public ActionListenerMain(MainInterface maininterface, CSVReader reader) {
		this.maininterface = maininterface;
		this.reader = reader;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonID = ((JButton) e.getSource()).getActionCommand();

		if ("next".equals(buttonID)) {

			if (maininterface.getIsClicked() == true) {

				maininterface.removeLabels();
			}
			maininterface.setLabelname(reader.getValues());
			maininterface.createLabels();
		}
	}

}