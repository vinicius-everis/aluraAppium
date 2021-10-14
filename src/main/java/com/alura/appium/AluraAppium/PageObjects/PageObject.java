package com.alura.appium.AluraAppium.PageObjects;

import io.appium.java_client.AppiumDriver;

public abstract class PageObject {
	
	protected final AppiumDriver driver;
	
	protected PageObject(AppiumDriver driver) {
		this.driver = driver;
	}
	
	public abstract void buscarElementos();
}
