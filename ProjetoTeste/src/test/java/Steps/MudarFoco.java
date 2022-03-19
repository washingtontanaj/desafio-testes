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

public class MudarFoco {

	private DSL dsl;

	@Before
	public void inicializa() {
		dsl = new DSL();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Dado("extendo as opções de Mudança de foco")
	public void extendoAsOpçõesDeMudançaDeFoco() throws InterruptedException {
		DSL.clicarLink("Mudança de foco");
	}

	@Quando("clicar em Alert")
	public void clicarEmAlert() throws InterruptedException {
		DSL.clicarLink("Alert");
	}

	@Então("clicar no button CLIQUE PARA JS ALERT")
	public void clicarNoButtonCLIQUEPARAJSALERT() throws InterruptedException {
		DSL.clicarby(By.xpath("(//div[@class='example']//button)[1]"));
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Então("confirmar o alert e fazer a assertiva no result")
	public void confirmarOAlertEFazerAAssertivaNoResult() {
		DSL.alertaAceita();
		assertEquals("Você clicou no alerta com sucesso!!", dsl.obterTexto("result"));
	}

	@Então("clicar no button CLIQUE PARA JS CONFIRM")
	public void clicarNoButtonCLIQUEPARAJSCONFIRM() throws InterruptedException {
		DSL.clicarby(By.xpath("(//div[@class='example']//button)[2]"));
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Então("confirmar o alert e fazer a validação no result")
	public void confirmarOAlertEFazerAValidaçãoNoResult() {
		DSL.alertaAceita();
		assertEquals("Você clicou: Ok", dsl.obterTexto("result"));
	}

	@Então("clicar no button CLIQUE PARA JS PROMPT")
	public void clicarNoButtonCLIQUEPARAJSPROMPT() throws InterruptedException {
		DSL.clicarby(By.xpath("(//div[@class='example']//button)[3]"));
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Então("digitar validado e fazer a assertiva no result")
	public void digitarValidadoEFazerAAssertivaNoResult() {
		dsl.alertaEscrever("Validado");
		assertEquals("Você digitou: Validado", dsl.obterTexto("result"));
	}

	@Quando("clicar em IFrame")
	public void clicarEmIFrame() throws InterruptedException {
		DSL.clicarby(By.xpath("//a[@href='/mudancadefoco/iframe']"));
	}

	@Então("dentro do iframe preencher as informações")
	public void dentroDoIframePreencherAsInformações() {
		DSL.entrarnoiframe("id_do_iframe");
		dsl.preenchercampo(By.id("first_name"), "Washington");
		dsl.preenchercampo(By.id("last_name"), "Tanajura");
		dsl.preenchercampo(By.id("password"), "s3nh@f0rt3");
		dsl.preenchercampo(By.id("email"), "washluist@gmail.com");
		dsl.preenchercampo(By.id("textarea1"), "Validado");
		DSL.sairdoiframe();
	}

	@Então("clicar no botão voltar fora do iFrame")
	public void clicarNoBotãoVoltarForaDoIFrame() throws InterruptedException {
		DSL.clicarby(By.xpath("//a[@class='btn red']"));
	}

	@Quando("clicar em Janela")
	public void clicarEmJanela() throws InterruptedException {
		DSL.clicarLink("Janela");
	}

	@Então("clicar em Abra uma nova Janela")
	public void clicarEmAbraUmaNovaJanela() throws InterruptedException {
		DSL.clicarby(By.xpath("(//a[@href='/mudancadefoco/newwindow'])[2]"));
	}

	@Então("validar na nova janela aberta a mensagem Você Abriu uma nova janela!!")
	public void validarNaNovaJanelaAbertaAMensagemVocêAbriuUmaNovaJanela() {
		DSL.trocarjanela();
		assertEquals("Você Abriu uma nova janela!!",
				dsl.obterTexto(By.xpath("//h5[contains(@class,'red-text text-darken-1')]")));
	}

	@Quando("clicar em Modal")
	public void clicarEmModal() throws InterruptedException {
		DSL.clicarLink("Modal");
	}

	@Então("clicar no botão Abrir")
	public void clicarNoBotãoAbrir() throws InterruptedException {
		DSL.clicarby(By.xpath("//a[@href='#modal1']"));
	}

	@Então("validar o titulo do Modal como Modal Teste")
	public void validarOTituloDoModalComoModalTeste() {
		assertEquals("Modal Teste", dsl.obterTexto(By.xpath("//h4[text()='Modal Teste']")));
		DriverFactory.killDriver();
	}

}
