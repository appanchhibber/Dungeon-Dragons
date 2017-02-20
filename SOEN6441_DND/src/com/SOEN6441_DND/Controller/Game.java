package com.SOEN6441_DND.Controller;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Views.Windows;

public class Game {

	public static void main(String[] args) {
		System.out.println("Hello");
		Windows window=new Windows();
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

}
