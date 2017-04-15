package com.SOEN6441_DND.Controller;

import java.awt.Dimension;
import java.awt.Window;

import javax.swing.JFrame;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Views.LogWindow;
import com.SOEN6441_DND.Views.MainScene;
import com.SOEN6441_DND.Views.Windows;

/**
 * The main method for starting the game 
 * @author Appan Chhibber
 * @author Ehab Amar
 */
public class Game {
	
	
	/**
	 * Method main.
	 * 
	 * @param args
	 *            String[]
	 */
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		Logger logger = Logger.getLogger(Game.class);
		logger.info("Singleton pattern - Game initiated !!");
		GameController gameController = new GameController();
	}	
	

}
