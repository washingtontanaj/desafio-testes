package Steps;

import static Core.DriverFactory.getDriver;
import static Core.DriverFactory.killDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Core.DSL;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class Buscar_Elementos {
	
	private DSL dsl;

	@Before
	public void inicializa() {
		dsl = new DSL();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Dado("extendo as opções de Busca de elementos")
	public void extendoAsOpçõesDeBuscaDeElementos() throws InterruptedException {
	    DSL.clicarLink("Busca de elementos");
	}
	@Dado("clico em Links")
	public void clicoEmLinks() throws InterruptedException {
	    DSL.clicarLink("Links");
	}
	@Quando("clicar no link Sucess")
	public void clicarNoLinkSucess() throws InterruptedException {
		DSL.clicarLink("Ok 200 - Sucess");
	}
	@Então("é obtida a mensagem Sucess!!")
	public void éObtidaAMensagemSucess() {
	    assertEquals("Success!!", dsl.obterTexto(By.xpath("//h5[text()='Success!!']")));
	}
	
	@Quando("clicar no link bad request")
	public void clicarNoLinkBadRequest() throws InterruptedException {
	    DSL.clicarLink("Erro 400 - Bad Request");
	}
	@Então("é obtida a mensagem Bad Request!!")
	public void éObtidaAMensagemBadRequest() {
	    assertEquals("Bad Request!!", dsl.obterTexto(By.xpath("//h5[text()='Bad Request!!']")));
	}

	@Quando("clicar no link page not found")
	public void clicarNoLinkPageNotFound() throws InterruptedException {
	    DSL.clicarLink("Erro 404 - Page not found");
	}
	@Então("é obtida a mensagem Page Not Found!!")
	public void éObtidaAMensagemPageNotFound() {
	    assertEquals("Page Not Found!!", dsl.obterTexto(By.xpath("//h5[text()='Page Not Found!!']")));
	}
	
	@Quando("clicar no link internal server error")
	public void clicarNoLinkInternalServerError() throws InterruptedException {
		DSL.clicarLink("Erro 500 - Internal Server Error");
	}
	@Então("é obtida a mensagem Internal Server Error!!")
	public void éObtidaAMensagemInternalServerError() {
		assertEquals("Internal Server Error!!", dsl.obterTexto(By.xpath("//h5[text()='Internal Server Error!!']")));
		killDriver();
	}
	
	@Quando("clicar em Inputs e TextField")
	public void clicarEmInputsETextField() throws InterruptedException {
		DSL.clicarLink("Inputs e TextField");
	}
	@Então("preencher todos os campos")
	public void preencherTodosOsCampos() {
		DSL.escrever("first_name", "Washington");
		DSL.escrever("last_name", "Tanajura");
		DSL.escrever("password", "senha");
		DSL.escrever("email", "washluist@gmail.com");
		DSL.escrever("textarea1", "Texto");
		killDriver();
	}
	
	@Quando("clicar em Botões")
	public void clicarEmBotões() throws InterruptedException {
		DSL.clicarLink("Botões");
	}
	
	@Quando("clicar em todos botões ativos")
	public void clicarEmTodosBotõesAtivos() throws InterruptedException {
	   	DSL.clicarby(By.xpath("//a[@class='waves-light btn']"));
	    DSL.clicarby(By.xpath("//a[contains(@class,'btn-floating btn-large')]//i[1]"));
	    DSL.clicarby(By.xpath("//a[@class='waves-teal btn-flat']"));
	    DSL.clicarby(By.name("action"));
	}
	
	@Então("verificar a mensagem de Você Clicou no Botão!")
	public void verificarAMensagemDeVocêClicouNoBotão() {

		 assertEquals("Você Clicou no Botão!", dsl.obterTexto(By.xpath("//div[@id='div1']//h5[1]")));
		 assertEquals("Você Clicou no Botão!", dsl.obterTexto(By.xpath("//div[@id='div2']//h5[1]")));
		 assertEquals("Você Clicou no Botão!", dsl.obterTexto(By.xpath("//div[@id='div3']//h5[1]")));
		 assertEquals("Você Clicou no Botão!", dsl.obterTexto(By.xpath("//div[@id='div4']//h5[1]")));
		 killDriver();
	}
	
	@Quando("clicar em Radio e Checkbox")
	public void clicarEmRadioECheckbox() throws InterruptedException {
		DSL.clicarLink("Radio e Checkbox");
	}
	@Quando("selecionar o radio Red do tipo um e o radio Yellow do tipo dois")
	public void selecionarORadioRedDoTipoUmEORadioYellowDoTipoDois() throws InterruptedException {
		DSL.clicarby(By.xpath("//label[@for='red']"));
		DSL.clicarby(By.xpath("//label[@for='yellow']"));
	}
	@Quando("selecionar o checkbox purple do tipo um e o checkbox black do tipo dois")
	public void selecionarOCheckboxPurpleDoTipoUmEOCheckboxBlackDoTipoDois() throws InterruptedException {
		DSL.clicarby(By.xpath("//label[@for='purple']"));
		DSL.clicarby(By.xpath("//label[@for='black']"));
	}
	@Então("selecionar o radio Blue do tipo um e o radio Green do tipo dois")
	public void selecionarORadioBlueDoTipoUmEORadioGreenDoTipoDois() throws InterruptedException {
		DSL.clicarby(By.xpath("//label[@for='blue']"));
		DSL.clicarby(By.xpath("//label[@for='green']"));
	}
	@Então("selecionar o checkbox Grey do tipo um e o checkbox White do tipo dois")
	public void selecionarOCheckboxGreyDoTipoUmEOCheckboxWhiteDoTipoDois() throws InterruptedException {
		DSL.clicarby(By.xpath("//label[@for='grey']"));
		DSL.clicarby(By.xpath("//label[@for='white']"));
		killDriver();
	}
	
	@Quando("clicar em Dropdown e Select")
	public void clicarEmDropdownESelect() throws InterruptedException {
	    DSL.clicarLink("Dropdown e Select");
	}
	@Quando("clicar no button Mail Box")
	public void clicarNoButtonMailBox() throws InterruptedException {
	    DSL.clicarby(By.xpath("//a[@class='btn dropdown-button']"));
	}
	@Quando("clicar na opção Unread")
	public void clicarNaOpçãoUnread() throws InterruptedException {
	    DSL.clicarby(By.id("dropdown2"));
	}
	@Quando("em Desenho Favorito selecionar a opção Naruto")
	public void emDesenhoFavoritoSelecionarAOpçãoNaruto() throws InterruptedException {
	    DSL.clicarby(By.xpath("//div[@class='select-wrapper']"));
	    DSL.clicarby(By.xpath("//span[text()='Naruto']"));
	}
	@Quando("escolher os jogadores Ronaldo, Ronaldinho Gaucho e Romario")
	public void escolherOsJogadoresRonaldoRonaldinhoGauchoERomario() throws InterruptedException {
	    DSL.clicarby(By.xpath("(//div[@class='select-wrapper'])[2]"));
	    DSL.clicarby(By.xpath("//span[text()='Ronaldo']"));
	    DSL.clicarby(By.xpath("//span[text()='Ronaldinho Gaucho']"));
	    DSL.clicarby(By.xpath("//span[text()='Romario']"));
	    DSL.clicarby(By.xpath("//img[@alt='Logo b seller b4ca898efa86c88dbd2095f5d35784d95bb96c88605c81bcb7a288b1dde25eef']"));
	}
	@Quando("escolher o Pais Brasil")
	public void escolherOPaisBrasil() throws InterruptedException {
		DSL.clicarby(By.xpath("(//div[@class='select-wrapper'])[3]"));
	    DSL.clicarby(By.xpath("//span[text()='Brasil']"));
	}
	@Quando("em genero escolher a opção Homem")
	public void emGeneroEscolherAOpçãoHomem() throws InterruptedException {
		DSL.clicarby(By.xpath("//div[@class='select-wrapper icons']"));
		DSL.clicarby(By.xpath("//span[text()='Homem']"));
		
	}
	@Quando("em sexo escolher a opção Masculino")
	public void emSexoEscolherAOpçãoMasculino() throws InterruptedException {
	    DSL.clicarby(By.xpath("(//div[@class='select-wrapper icons'])[2]"));
	    DSL.clicarby(By.xpath("//span[text()='Masculino']"));
	}
	@Quando("em Browser Favorito escolher a opção Chrome")
	public void emBrowserFavoritoEscolherAOpçãoChrome() {
	    //DSL.clicarby(By.xpath("//select[@id='dropdown']"));
	    WebElement element = getDriver().findElement(By.xpath("//select[@id='dropdown']"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Chrome");
	}
	@Então("verificar a mensagem de sucesso do click em Dropdown Unread")
	public void verificarAMensagemDeSucessoDoClickEmDropdownUnread() {
	   assertEquals("Você Clicou no Dropdown Unread!", dsl.obterTexto(By.xpath("//h5[text()='Você Clicou no Dropdown Unread!']"))); 
	}
	@Quando("clicar em Tabela")
	public void clicarEmTabela() throws InterruptedException {
	    DSL.clicarLink("Tabela");
	}
	@Então("verificar o preço do feijao, arroz e carne")
	public void verificarOPreçoDoFeijaoArrozECarne() {
	    assertEquals("$2.87", dsl.obterTexto(By.xpath("(//table[@class='centered highlight']//td)[3]")));
	    assertEquals("$3.76", dsl.obterTexto(By.xpath("(//table[@class='centered highlight']//td)[6]")));
	    assertEquals("$7.00", dsl.obterTexto(By.xpath("(//table[@class='centered highlight']//td)[21]")));
	    killDriver();
	}
	
}

