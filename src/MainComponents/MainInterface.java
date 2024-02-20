package MainComponents;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import GuiElements.CButton;
import GuiElements.CLabel;
import GuiElements.CRadioButtons;
import GuiElements.Window;
import Listener.ActionListenerMain;

public class MainInterface extends Window {
	private final static int weight = 900;
	private final static int height = 500;
	private final static String windowName = "LearningAPP";

	private CLabel labels;
	private CButton button;
	private ActionListenerMain actionListener;
	private CSVReader reader;
	private CRadioButtons radioButtons;

	private String[] labelNames;
	private String[] buttonName = { "Nächste"};
	private String[] buttonID = { "next"};

	private boolean isClicked;


	public MainInterface() {
		super(weight, height, windowName);

		reader = new CSVReader();
		actionListener = new ActionListenerMain(this, reader);
		button = new CButton(actionListener, 1);
		labels = new CLabel(5);
		radioButtons = new CRadioButtons(4);

		button.createButtons(80, 250, 100, 30, 0, "", buttonID, buttonName);
		for (JButton buttons : button.getButtons()) {
			add(buttons);
		}
		
		radioButtons.createRadioButtons(20, 65, 20, 20, 40, "posY");
		for (JRadioButton radios : radioButtons.getRadioButtons()) {
			add(radios);
		}

		setVisible(true);
	}

	public void setLabelname(String[] labelNames) {
		this.labelNames = labelNames;
	}

	public void createLabels() {
		reader.reader();
		labels.createLabels(40, 20, 900, 30, 40, "posY", labelNames);
		for (JLabel label : labels.getLabels()) {
			add(label);
			repaint();
			isClicked = true;
		}
	}

	public void removeLabels() {
		for (JLabel label : labels.getLabels()) {
			remove(label);
		}

		repaint();
		isClicked = false;

	}
	
	public boolean getIsClicked() {
		return isClicked;
	}
}