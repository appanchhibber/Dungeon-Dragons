package com.SOEN6441_DND.Views;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;

public class Windows extends JFrame {
	
	static Container container;
	/**
	 * Create the frame.
	 */
	public Windows() {
		container=getContentPane();
		MainScene mainScene=new MainScene();
        container.add(mainScene);
    /*    
		ImageIcon image = new ImageIcon("image/gameBk.jpg");
		JLabel label = new JLabel(new ImageIcon(
				((image.getImage().getScaledInstance(
						ApplicationStatics.WINDOW_WIDTH,
						(ApplicationStatics.WINDOW_HEIGHT - 45),
						java.awt.Image.SCALE_SMOOTH)))));
        */
  /*      container.setComponentZOrder(mainScene.getComponent(2),0);
        container.setComponentZOrder(mainScene.getComponent(0),1);*/
		setResizable(false);
		setSize(860,645);
		setLocationRelativeTo(null); // center window on the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setVisible(true);

	}

}
