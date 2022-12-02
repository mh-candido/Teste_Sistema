import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestesSistema {

    private WebDriver webDriver;

    @BeforeAll
    private void configAll(){
        System.setProperty("webDriver.chrome.driver", "src\\test\\resources\\chromedriver_win32\\chromedriver.exe");
    }

    @BeforeEach
    private void configEach(){
        this.webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public void abrirPagina(){
        webDriver.get("https://www.gov.br/pt-br");
        Assertions.assertEquals("https://www.gov.br/pt-br", webDriver.getCurrentUrl());
    }

    @Test
    public void findElementbyClassTeste(){
        webDriver.get("https://www.gov.br/pt-br");
        WebElement botao = webDriver.findElement(By.className("signed-out"));
        botao.click();
        Assertions.assertEquals("https://sso.acesso.gov.br/login?client_id=www.gov.br&authorization_id=181529e84bd",webDriver.getCurrentUrl());
    }

    @Test
    public void findElementPerfis(){
        webDriver.get("https://www.gov.br/pt-br");
        WebElement botao2 = webDriver.findElement(By.className("outstanding-link"));
        botao2.click();
        WebElement botao3 = webDriver.findElement(By.className("nome"));
        botao3.click();
        Assertions.assertEquals("https://www.gov.br/pt-br/perfil_usuario/empreendedor",webDriver.getCurrentUrl());
    }

    @Test
    public void sendKeysTeste(){
        webDriver.get("https://www.gov.br/pt-br");
        WebElement search = webDriver.findElement(By.className("aa-Input"));
        search.sendKeys("vacina");
        search.submit();
        Assertions.assertEquals("https://www.gov.br/pt-br/search?SearchableText=vacina",webDriver.getCurrentUrl());
    }

    @AfterEach
    public void closeWindow(){
        webDriver.close();
    }
}
