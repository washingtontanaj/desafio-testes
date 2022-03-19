package Steps;

import static Core.DriverFactory.getDriver;
import static Core.DriverFactory.killDriver;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import Core.DSL;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class Criar_Usuário {

	private DSL dsl;

	@Before
	public void inicializa() {
		dsl = new DSL();
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	String newnome = "Conta";
	String nome = "Chris";
	String newultimonome = "Washington Tanajura";
	String ultimonome = "Redfield";
	String newemail = "criandoteste@washington.com";
	String email = "chrisredfield@re5.com.br";
	String newendereco = "Rua do Washington, Washlândia";
	String endereco = "California";
	String newuniversidade = "UNIVERSIDADE DE ARARAQUARA";
	String universidade = "MIT";
	String newprofissao = "Quality Assurance";
	String profissao = "Matador de Zumbi";
	String newgenero = "Masculino";
	String genero = "Masculino";
	String newidade = "24 anos";
	String idade = "40 anos";

	@Dado("^que eu acesso a página inicial do site Automação com Batista$")
	public void que_eu_acesso_a_página_inicial_do_site_Automação_com_Batista() throws Throwable {
		DSL.acessarpagina("https://automacaocombatista.herokuapp.com/treinamento/home");
	}

	@Dado("^extendo as opções de formulário$")
	public void extendo_as_opções_de_formulário() throws Throwable {
		DSL.clicarby(By.className("collapsible-header"));
	}

	@Dado("^clico no link para criação de um novo usuário$")
	public void clico_no_link_para_criação_de_um_novo_usuário() throws Throwable {
		DSL.clicarby(By.xpath("//a[@href='/users/new']"));
	}

	@Quando("^preencher todos os dados necessários$")
	public void eu_preencher_todos_os_dados_necessários() throws Throwable {
		DSL.escrever("user_name", nome);
		DSL.escrever("user_lastname", ultimonome);
		DSL.escrever("user_email", email);
		DSL.escrever("user_address", endereco);
		DSL.escrever("user_university", universidade);
		DSL.escrever("user_profile", profissao);
		DSL.escrever("user_gender", genero);
		DSL.escrever("user_age", idade);
	}

	@Quando("^clicar no botão Criar$")
	public void clicar_no_botão_Criar() throws Throwable {
		DSL.clicarby(By.name("commit"));
	}

	@Então("^o cadastro de novo usuário é finalizado com uma mensagem de sucesso$")
	public void o_cadastro_de_novo_usuário_é_finalizado_com_uma_mensagem_de_sucesso() throws Throwable {
		assertEquals("Usuário Criado com sucesso", dsl.obterTexto("notice"));
	}

	@Então("^se obtem todas as informações preenchidas$")
	public void se_obtem_todas_as_informações_preenchidas() throws Throwable {
		assertEquals("Nome:", dsl.obterTexto(By.xpath("//div[contains(@class,'col s12')]//p[1]/strong")));
		assertEquals("Ultimo Nome:", dsl.obterTexto(By.xpath("//div[contains(@class,'col s12')]//p[2]/strong")));
		assertEquals("Email:", dsl.obterTexto(By.xpath("//div[contains(@class,'col s12')]//p[3]/strong")));
		killDriver();
	}

	@Dado("clico no link para listagem de usuários")
	public void clico_no_link_para_listagem_de_usuários() throws InterruptedException {
		DSL.clicarby(By.xpath("//a[@href='/users']"));
	}

	@Quando("procurar pelo email do usuário entre as páginas")
	public void procurar_pelo_email_do_usuário_entre_as_páginas() {
		DSL.listarpaginas("https://automacaocombatista.herokuapp.com/users?page=", "Próximo ›", email);
	}

	@Quando("clicar no botão de editar usuário")
	public void clicarNoBotãoDeEditarInformações() {
		DSL.clicarEmEditarUserNaTabela("Email", email);
	}

	@Quando("alterar as informações incorretas")
	public void alterarAsInformaçõesIncorretas() {
		DSL.escrever("user_name", newnome);
		DSL.escrever("user_lastname", newultimonome);
		DSL.escrever("user_email", newemail);
		DSL.escrever("user_address", newendereco);
		DSL.escrever("user_university", newuniversidade);
		DSL.escrever("user_profile", newprofissao);
		DSL.escrever("user_gender", newgenero);
	}

	@Então("verificar se foi recebido mensagem de cadastro atualizado com sucesso")
	public void verificarSeFoiRecebidoMensagemDeCadastroAtualizadoComSucesso() {
		assertEquals("Seu Usuário foi Atualizado!", dsl.obterTexto("notice"));
//		killDriver();
	}
}