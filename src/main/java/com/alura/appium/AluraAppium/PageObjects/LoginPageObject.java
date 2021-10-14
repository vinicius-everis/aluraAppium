package com.alura.appium.AluraAppium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPageObject extends PageObject{
	
	private MobileElement botaoCadastro;
	
	public LoginPageObject(AppiumDriver driver) {
		super(driver);
	}

	@Override
	public void buscarElementos() {
		botaoCadastro = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
	}

	public CadastroPageObject irParaTelaCadastro() {
		botaoCadastro.click();
		return new CadastroPageObject(this.driver);
	}
}
