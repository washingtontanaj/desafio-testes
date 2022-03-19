package Core;

import static Core.DriverFactory.getDriver;
import static Core.DriverFactory.killDriver;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DSL {
	
	public static void scroll(int quant) {
		JavascriptExecutor scroll = (JavascriptExecutor)getDriver();
		scroll.executeScript("scroll(0, "+quant+")", "");
	}

	public static void UploadFile(String endereço, By by) {
	
		// ########// UPLOAD //########// UPLOAD //########// UPLOAD //########//
		
		getDriver().findElement(by).sendKeys(endereço);
	
	}
	
	// ########// ACTIONS //########// ACTIONS //########// ACTIONS //########//
	
	public static void DragAndDrop(By byfrom, By byto) {

		WebElement de = getDriver().findElement(byfrom);
		WebElement para = getDriver().findElement(byto);

		Actions act = new Actions(getDriver());
		act.dragAndDrop(de, para).build().perform();
	}

	public static void Mousehover(By by) {
		
		WebElement mousehover = getDriver().findElement(by);
		
		Actions act = new Actions(getDriver());
		act.moveToElement(mousehover).perform();
	}

	// ########// JANELA //########// JANELA //########// JANELA //########// JANELA

	public static void trocarjanela() {
		getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[1]);
	}

	public static void voltarnajanela() {
		getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[0]);
	}

	// ########// FRAMES //########// FRAMES //########// FRAMES //########// FRAMES

	public static void entrarnoiframe(String id) {
		getDriver().switchTo().frame(id);
	}

	public static void sairdoiframe() {
		getDriver().switchTo().defaultContent();
	}

	// ########// ALERTS //########// ALERTS //########// ALERTS //########// ALERTS

//	public static void alertaObterTexto() {
//		Alert alert = getDriver().switchTo().alert();
//	}

	public static void alertaAceita() {
		Alert alert = getDriver().switchTo().alert();
		alert.accept();
	}

	public String alertaNega() {
		Alert alert = getDriver().switchTo().alert();
		alert.dismiss();
		return null;
	}

	public void alertaEscrever(String valor) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}

//########// TEXTO //########// TEXTO //########// TEXTO //########// TEXTO 

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}

	public void preenchercampo(By by, String text) {
		getDriver().findElement(by).sendKeys(text);

	}

//########// CLICAR //########// CLICAR //########// CLICAR //########// CLICAR 

	public static void clicarLink(String link) throws InterruptedException {
		getDriver().findElement(By.linkText(link)).click();
		Thread.sleep(100);
	}

	public static void clicarby(By by) throws InterruptedException {
		getDriver().findElement(by).click();
		Thread.sleep(100);
	}

	public String clicarbyid(String id) throws InterruptedException {
		getDriver().findElement(By.id(id)).click();
		Thread.sleep(100);
		return id;
	}

//########// TEXTFIELD //########// TEXTAREA //########// TEXTFIELD //########// TEXTAREA 

	public static void escrever(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}

	public static void escrever(String id_campo, String texto) {
		escrever(By.id(id_campo), texto);
	}

	public static String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
//########// PÁGINAS //########// PÁGINAS //########// PÁGINAS //########// PÁGINAS 

	public static void acessarpagina(String url) {

		getDriver().get(url);

	}

	public static void listarpaginaseexcluir(String urlindexpages, String textnext, String valueemail) {

		String pageSource = getDriver().getPageSource();
		boolean result = pageSource.contains(valueemail);
		int index = 2;
		String pageindex = urlindexpages;

		if (result != true) {

			String pagesSource = getDriver().getPageSource();
			boolean results = pagesSource.contains(valueemail);
			while (results != true) {
				getDriver().findElement(By.linkText(textnext)).click();
				killDriver();
				int prox = index++;
				getDriver().get(pageindex + prox);
				String pagesSource2 = getDriver().getPageSource();
				boolean assertiva = pagesSource2.contains(valueemail);
				if (assertiva == true) {
					clicarEmExcluirUserNaTabela("Email", valueemail);
					getDriver().switchTo().alert().accept();
					break;
				}
			}

		}
	}

	public static void listarpaginas(String urlindexpages, String textnext, String valueemail) {

		String pageSource = getDriver().getPageSource();
		boolean result = pageSource.contains(valueemail);
		int index = 2;
		String pageindex = urlindexpages;

		if (result != true) {

			String pagesSource = getDriver().getPageSource();
			boolean results = pagesSource.contains(valueemail);
			while (results != true) {
				getDriver().findElement(By.linkText(textnext)).click();
				killDriver();
				int prox = index++;
				getDriver().get(pageindex + prox);
				String pagesSource2 = getDriver().getPageSource();
				boolean assertiva = pagesSource2.contains(valueemail);
				if (assertiva == true) {
					break;
				}
			}

		}

	}

//########// TABELAS //########// TABELAS //########// TABELAS //########// TABELAS 

	public static void buscarInformacaoNaTabela(String colunaBusca, String valor) {

		WebElement tabela = getDriver().findElement(By.xpath("//*[@class='highlight striped responsive-table']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);

		int idLinha = obterIndiceLinha(valor, tabela, idColuna);

		WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[9]"));
		celula.findElement(By.xpath(".//a")).click();

	}

	public static void clicarEmEditarUserNaTabela(String colunaBusca, String valor) {

		WebElement tabela = getDriver().findElement(By.xpath("//*[@class='highlight striped responsive-table']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);

		int idLinha = obterIndiceLinha(valor, tabela, idColuna);

		WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[10]"));
		celula.findElement(By.xpath(".//a")).click();

	}

	public static void clicarEmExcluirUserNaTabela(String colunaBusca, String valor) {

		WebElement tabela = getDriver().findElement(By.xpath("//*[@class='highlight striped responsive-table']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);

		int idLinha = obterIndiceLinha(valor, tabela, idColuna);

		WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[11]"));
		celula.findElement(By.xpath(".//a")).click();

	}

	public static void pegarInformacaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {

		WebElement tabela = getDriver().findElement(By.xpath("//*[@class='highlight striped responsive-table']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);

		int idLinha = obterIndiceLinha(valor, tabela, idColuna);

		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

		WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));

		celula.getText();

	}

	protected static int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath(".//tr/td[" + idColuna + "]"));
		int idLinha = -1;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).getText().equals(valor)) {
				idLinha = i + 1;
				break;
			}
		}
		return idLinha;
	}

	protected static int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for (int i = 0; i < colunas.size(); i++) {
			if (colunas.get(i).getText().equals(coluna)) {
				idColuna = i + 1;
				break;
			}
		}
		return idColuna;
	}
}