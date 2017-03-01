package com.SOEN6441_DND.Model;

import java.io.File;


public class Play {
private static Play currentPlay;
	
	
	public static Play currentPlay()
	{
		if(currentPlay==null)
		{
			currentPlay=new Play();
		}
		return currentPlay;
	}
	public static void setPlay(Play play){
		currentPlay = play;
	}
	
	public static void destroy(){
		currentPlay = null;
	}
	private MapModel map;


	public MapModel getMap() {
		return map;
	}
	public void setMap(MapModel map) {
		this.map = map;
	}
	
	
	private File sourceFile;
	
	public File getSourceFile() {
		return sourceFile;
	}
	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}

}
