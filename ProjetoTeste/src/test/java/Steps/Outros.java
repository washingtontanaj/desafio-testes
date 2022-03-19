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

public class Outros {

	private DSL dsl;

	@Before
	public void inicializa() {
		dsl = new DSL();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Dado("extendo as opções de Outros")
	public void extendoAsOpçõesDeOutros() throws InterruptedException {
		DSL.clicarLink("Outros");
	}

	@Quando("clicar em Upload de Arquivo")
	public void clicarEmUploadDeArquivo() throws InterruptedException {
		DSL.clicarLink("Upload de Arquivo");
	}

	@Então("enviar uma imagem da pasta imagens")
	public void enviarUmaImagemDaPastaImagens() {
		DSL.UploadFile(" " +System.getProperty("user.dir") + "/src/test/resources/bwc.png", By.xpath("//input[@type='file']"));
	}

	@Então("clicar Basic Auth e fazer autenticação básica")
	public void fazerAutenticaçãoBásica() throws InterruptedException {
		getDriver().get("https://admin:admin@automacaocombatista.herokuapp.com/basicauth/home");
	}

	@Então("verificar a mensagem de autentificação bem sucedida")
	public void verificarAMensagemDeAutentificaçãoBemSucedida() {
		assertEquals("Você se autenticou com sucesso!!",
				dsl.obterTexto(By.xpath("//div[@class='tamanhodiv2']//h5[1]")));
	}

	@Quando("clicar em Scroll")
	public void clicarEmScroll() throws InterruptedException {
		DSL.clicarLink("Scroll");
	}

	@Então("rolar até o fim do texto")
	public void rolarAtéOFimDoTexto() throws InterruptedException {
		DSL.scroll(30000);
		Thread.sleep(3000);
	}

	@Então("esperar {int} segundo e subir para o inicio do texto")
	public void esperarSegundoESubirParaOInicioDoTexto(Integer int1) throws InterruptedException {
		DSL.scroll(-30000);
		Thread.sleep(3000);
		DriverFactory.killDriver();
	}

}
