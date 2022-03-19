package Steps;

import static Core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import Core.DSL;
import Core.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class Widgets {
	private DSL dsl;

	@Before
	public void inicializa() {
		dsl = new DSL();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Dado("extendo as opções de Widgets")
	public void extendoAsOpçõesDeWidgets() throws InterruptedException {
		DSL.clicarLink("Widgets");
	}

	@Quando("clicar em Accordion")
	public void clicarEmAccordion() throws InterruptedException {
		DSL.clicarLink("Accordion");
	}

	@Então("clicar no accordion first e validar a mensagem de Primeiro Texto")
	public void clicarNoAccordionFirstEValidarAMensagemDePrimeiroTexto() throws InterruptedException {
		DSL.clicarby(By.xpath("//div[text()='First']"));
		Thread.sleep(1000);
		assertEquals("Primeiro Texto.", dsl.obterTexto(By.xpath("//span[text()='Primeiro Texto.']")));
//	    System.out.println(dsl.obterTexto(By.xpath("//li[@class='active']//div[2]")));
	}

	@Então("clicar no accordion second e validar a mensagem de Segundo Texto")
	public void clicarNoAccordionSecondEValidarAMensagemDeSegundoTexto() throws InterruptedException {
		DSL.clicarby(By.xpath("//div[text()='Second']"));
		Thread.sleep(1000);
		assertEquals("Segundo Texto.", dsl.obterTexto(By.xpath("//span[text()='Segundo Texto.']")));
	}

	@Então("clicar no accordion third e validar a mensagem de Terceiro Texto")
	public void clicarNoAccordionThirdEValidarAMensagemDeTerceiroTexto() throws InterruptedException {
		DSL.clicarby(By.xpath("//div[text()='Third']"));
		Thread.sleep(1000);
		assertEquals("Terceiro Texto.", dsl.obterTexto(By.xpath("//span[text()='Terceiro Texto.']")));
	}

	@Quando("clicar em Autocomplete")
	public void clicarEmAutocomplete() throws InterruptedException {
		DSL.clicarLink("Autocomplete");
	}

	@Então("digitar no campo de estado a Letra S")
	public void digitarNoCampoDeEstadoALetraS() {
		DSL.escrever("autocomplete-input", "S");
	}

	@Então("clicar na opção São Paulo")
	public void clicarNaOpçãoSãoPaulo() {
		WebElement autocomplete = getDriver().findElement(By.id("autocomplete-input"));
		autocomplete.sendKeys(Keys.ARROW_DOWN);
		autocomplete.sendKeys(Keys.ARROW_DOWN);
		autocomplete.sendKeys(Keys.ENTER);
	}

	@Quando("clicar em Datapicker")
	public void clicarEmDatapicker() throws InterruptedException {
		DSL.clicarLink("Datapicker");
	}

	@Então("clicar no campo de Data")
	public void clicarNoCampoDeData() throws InterruptedException {
		DSL.clicarby(By.id("datepicker"));
	}

	@Então("escolher a data do Natal de {int}")
	public void escolherADataDoNatalDe(Integer int1) throws InterruptedException {
		DSL.clicarby(By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[2]"));
		DSL.clicarby(By.xpath("//span[text()='" + int1 + "']"));
		DSL.clicarby(By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[1]"));
		DSL.clicarby(By.xpath("//span[text()='December']"));
		DSL.clicarby(By.xpath("//button[@data-pika-day='25']"));
		DSL.clicarby(By.xpath("//button[contains(@class,'btn-flat datepicker-done')]"));
		DriverFactory.killDriver();
	}

}
