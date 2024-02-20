package GuiElements;

import Listener.ActionListenerMain;

public class CButton {
	private ActionListenerMain actionListener;

	private CustomButtonRect[] buttons;
	
	private int number;

	private String color1 = "#0a1c2b";
	private String color2 = "#c2c7dd";
	
	public CButton(ActionListenerMain actionListener,  int number) {
		this.actionListener = actionListener;
		this.number = number;
		buttons = new CustomButtonRect[number];
	}
	
	public void createButtons(int posX, int posY, int weight, int height, int distance, String position, String[] buttonID, String[] buttonName){
		for(int create = 0; create < number; create++) {
			buttons[create] = new CustomButtonRect(color1, color2, buttonName[create]);
			buttons[create].setBounds(posX, posY, weight, height);
			buttons[create].setActionCommand(buttonID[create]);
			buttons[create].addActionListener(actionListener);
			buttons[create].setFocusPainted(false);
			
			if(position.equals("posX")) {
				posX += distance;
			}
			else if(position.equals("posY")) {
				posY += distance;
			}
		}
	}
	
	public CustomButtonRect[] getButtons() {
		return buttons;
	}
}