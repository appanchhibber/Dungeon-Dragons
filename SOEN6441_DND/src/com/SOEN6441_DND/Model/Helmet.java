package com.SOEN6441_DND.Model;

public class Helmet extends ItemModel{

	private AbilitiyModel abilitiyModel;
	
	public void enchantIntelligence(int value){
		abilitiyModel = new AbilitiyModel();
		abilitiyModel.setIntelligence(abilitiyModel.getIntelligence()+ value);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}



}
