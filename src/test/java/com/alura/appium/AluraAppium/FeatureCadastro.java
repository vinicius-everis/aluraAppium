package com.alura.appium.AluraAppium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.alura.appium.AluraAppium.PageObjects.CadastroPageObject;
import com.alura.appium.AluraAppium.PageObjects.LoginPageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class FeatureCadastro {
  
    @Test
    public void naoDeveria_CadastrarUsuario_QuandoAsSenhasNaoConferem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
    	
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.buscarElementos();
        CadastroPageObject telaCadastro = telaLogin.irParaTelaCadastro();
    	
    	telaCadastro.buscarElementos();
    	telaCadastro.cadastrar("Vinicius", "123", "456");
    	
    	assertEquals("Senhas não conferem", telaCadastro.verificarMensagemDeErro());	
    	driver.navigate().back();
    }
    
    @Test
    public void deveria_CadastrarUsuario_QuandoAsSenhasConferem() throws NoSuchElementException {
    	AppiumDriver driver = AppiumDriverConfig.Instance().driver;
    	
    	LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.buscarElementos();
        CadastroPageObject telaCadastro = telaLogin.irParaTelaCadastro();
    	
    	telaCadastro.buscarElementos();
    	telaLogin = telaCadastro.cadastrar("Vinicius", "123", "123");
    	telaLogin.buscarElementos();
    }
    
    @Test
    public void naoDeveria_CadastrarUsuario_QuandoHouverAlgumUsuarioComOMesmoNome() throws NoSuchElementException {
    	AppiumDriver driver = AppiumDriverConfig.Instance().driver;
    	
    	LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.buscarElementos();
        CadastroPageObject telaCadastro = telaLogin.irParaTelaCadastro();
    	
    	telaCadastro.buscarElementos();
    	telaLogin = telaCadastro.cadastrar("Maria", "123", "123");
    	
    	telaLogin.buscarElementos();
        telaCadastro = telaLogin.irParaTelaCadastro();
    	telaCadastro.buscarElementos();
    	telaLogin = telaCadastro.cadastrar("Maria", "123", "123");
    	
    	assertEquals("Usuario já Cadastrado", telaCadastro.verificarMensagemDeErro());
    	driver.navigate().back();
    }
}
