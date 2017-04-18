package com.SOEN6441_DND.Controller;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Views.CharacterScene;
import com.SOEN6441_DND.Views.LogWindow;
import com.SOEN6441_DND.Views.MainScene;
import com.SOEN6441_DND.Views.View;
import com.SOEN6441_DND.Views.Windows;

/**
 * This Class is the controller class of Main Scene and intercepts actions generated on view. 
 * @author Ehab Amar
 *@version 1.0.0
 */
public class GameController {
	public 
	Windows mainFrame;
	LogWindow logScreen;
	CharacterScene character;
	MainScene homeScreen;
	
	/**
	 * Forcing single instance of the game therefore using the singleton pattern.
	 */
	private static GameController gameController;
	public static GameController getInstance()
	{
		if(gameController==null)
		{
			gameController=new GameController();
		}
		return gameController;
	}
	/**
	 * constructor for game controller
	 */
	public GameController()
	{
		gameController=this;
		mainFrame=new Windows();
		int width = ApplicationStatics.WINDOW_WIDTH;
		int height = ApplicationStatics.WINDOW_HEIGHT;
		mainFrame.setVisible(true);
		mainFrame.setPreferredSize(new Dimension(width, height));
		mainFrame.setMaximumSize(new Dimension(width, height));
		mainFrame.setMinimumSize(new Dimension(width, height));
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null); // center window on the screen
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeScreen = new MainScene();
		mainFrame.setView(homeScreen);
		
	
		logScreen = new LogWindow();
		logScreen.setVisible(true);
		logScreen.setSize(500, 700);
		logScreen.setResizable(true);
		logScreen.setLocation(mainFrame.getX()+mainFrame.getWidth(), mainFrame.getY()); // center window on the screen
		logScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}

