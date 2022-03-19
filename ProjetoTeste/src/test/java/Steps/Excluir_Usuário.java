package Steps;

import static Core.DriverFactory.getDriver;
import static Core.DriverFactory.killDriver;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import Core.DSL;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class Excluir_Usuário {

	private DSL dsl;

	@Before
	public void inicializa() {
		dsl = new DSL();
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	String email = "criandoteste@washington.com";

	@Dado("pesquisar pelo email do usuário entre as páginas")
	public void pesquisarPeloEmailDoUsuárioEntreAsPáginas() {
		DSL.listarpaginas("https://automacaocombatista.herokuapp.com/users?page=", "Próximo ›", email);
	}

	@Quando("clicar no botão de excluir usuário e confirmar o alert")
	public void clicar_no_botão_de_excluir_usuário_e_confirmar_o_alert() {

		DSL.clicarEmExcluirUserNaTabela("Email", email);
		DSL.alertaAceita();

	}

	@Então("a conta é excluida com uma mensagem de sucesso na operação")
	public void aContaÉExcluidaComUmaMensagemDeSucessoNaOperação() {

		assertEquals("Seu Usuário foi removido com sucesso!", dsl.obterTexto("notice"));
		killDriver();
	}
}