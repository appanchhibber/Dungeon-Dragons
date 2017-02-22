package com.SOEN6441_DND.Controller;

import java.awt.Dimension;
import java.awt.Window;

import javax.swing.JFrame;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Views.Windows;

/**
 * @author Appan Chhibber
 * @author Ehab Amar
 */
public class Game {
	
	private static 	Windows window;
	/**
	 * Method main.
	 * 
	 * @param args
	 *            String[]
	 */
	public static void main(String[] args) {
	 window = new Windows();
		int width = ApplicationStatics.WINDOW_WIDTH;
		int height = ApplicationStatics.WINDOW_HEIGHT;
		window.setVisible(true);
		window.setPreferredSize(new Dimension(width, height));
		window.setMaximumSize(new Dimension(width, height));
		window.setMinimumSize(new Dimension(width, height));
		window.setResizable(false);
		window.setLocationRelativeTo(null); // center window on the screen
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static Windows getInstance(){
		if(window==null){
			window=new Windows();
		}
		return window;
	}

}
