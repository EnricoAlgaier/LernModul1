package GuiElements;

import java.awt.Color;

import javax.swing.JRadioButton;

public class CRadioButtons {
	private JRadioButton[] radioButtons;

	private int number;
	
	private Color color = new Color(10,28,43);

	public CRadioButtons(int number) {
		this.number = number;
		radioButtons = new JRadioButton[number];
	}

	public void createRadioButtons(int posX, int posY, int weight, int height, int distance, String position) {
		for (int create = 0; create < number; create++) {
			radioButtons[create] = new JRadioButton();
			radioButtons[create].setBounds(posX, posY, weight, height);
			radioButtons[create].setBackground(color);
			
			
			if("posX".equals(position)) {
				posX += distance;
				
			} else if("posY".equals(position)) {
				posY += distance;
			}
		}
	}
	
	public JRadioButton[] getRadioButtons() {
		return radioButtons;
	}
}