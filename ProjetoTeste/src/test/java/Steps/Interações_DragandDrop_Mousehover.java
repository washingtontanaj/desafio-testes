package Steps;

import static Core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import Core.DSL;
import Core.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class Interações_DragandDrop_Mousehover {
	private DSL dsl;

	@Before
	public void inicializa() {
		dsl = new DSL();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Dado("extendo as opções de Iterações")
	public void extendoAsOpçõesDeIterações() throws InterruptedException {
		DSL.clicarLink("Iterações");
	}

	@Quando("clicar em Drag and Drop")
	public void clicarEmDragAndDrop() throws InterruptedException {
		DSL.clicarLink("Drag And Drop");
	}

	@Então("puxar o emoticon para dentro do quadrado")
	public void puxarOEmoticonParaDentroDoQuadrado() {

		DSL.DragAndDrop(By.id("winston"), By.id("dropzone"));

	}

	@Quando("clicar em Mousehover")
	public void clicarEmMousehover() throws InterruptedException {
		DSL.clicarLink("Mousehover");
	}

	@Então("passar o mouse no lugar indicado")
	public void passarOMouseNoLugarIndicado() {
		DSL.Mousehover(By.xpath("//p[@class='activator']"));

	}

	@Então("validar com a mensagem de parabéns")
	public void validarComAMensagemDeParabéns() {
		assertEquals("Parábens", dsl.obterTexto(By.xpath("//div[text()='Parábens']")));
		DriverFactory.killDriver();
	}

}
