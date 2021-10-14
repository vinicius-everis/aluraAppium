package com.alura.appium.AluraAppium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CadastroPageObject extends PageObject{
	
	private MobileElement campoNome;
	private MobileElement campoSenha;
	private MobileElement campoConfimarSenha;
	private MobileElement botaoCadastrar;
	private MobileElement mensagemErro;
	
	private final By erroID;
	private final By campoNomeID;
	private final By campoSenhaID;
	private final By campoConfirmarSenhaID;
	private final By botaoCadastrarID;

	public CadastroPageObject(AppiumDriver driver) {
		super(driver);
		erroID = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
		campoNomeID = By.id("br.com.alura.aluraesporte:id/input_nome");
		campoSenhaID = By.id("br.com.alura.aluraesporte:id/input_senha");
		campoConfirmarSenhaID = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
		botaoCadastrarID = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
	}
	
	@Override
	public void buscarElementos() {
		campoNome = (MobileElement)driver.findElement(campoNomeID);
    	campoSenha = (MobileElement)driver.findElement(campoSenhaID);
    	campoConfimarSenha = (MobileElement)driver.findElement(campoConfirmarSenhaID);
    	botaoCadastrar = (MobileElement)driver.findElement(botaoCadastrarID);
	}
	
	private void preencherFormulario(String usuario, String senha, String confirmacao) {
		campoNome.setValue(usuario);
    	campoSenha.setValue(senha);
    	campoConfimarSenha.setValue(confirmacao);
	}

	public LoginPageObject cadastrar(String usuario, String senha, String confirmacao) {
		preencherFormulario(usuario, senha, confirmacao);
		botaoCadastrar.click();
		return new LoginPageObject(driver);
	}

	public String verificarMensagemDeErro() {
		WebDriverWait espera = new WebDriverWait(driver, 10);
		espera.until(ExpectedConditions.presenceOfElementLocated(erroID));
		mensagemErro = (MobileElement)driver.findElement(erroID);
		return mensagemErro.getText();
	}
}
