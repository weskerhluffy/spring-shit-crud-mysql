package crap.shit;

//XXX:https://g00glen00b.be/spring-boot-selenium/
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = com.websystique.springboot.SpringBootCRUDApp.class)
// @SpringBootTest(classes = com.websystique.springboot.SpringBootCRUDApp.class)
// @WebAppConfiguration
public class SpringCrudCrapTest extends FluentTest {
	private static final String FIRST_ITEM_DESCRIPTION = "First item";
	private static final String SECOND_ITEM_DESCRIPTION = "Second item";
	private static final String THIRD_ITEM_DESCRIPTION = "Third item";

	// @Value("${server.port}")
	@LocalServerPort
	private int serverPort;
	@Value("${server.contextPath}")
	private String contexto;
	private WebDriver webDriver = new PhantomJSDriver();

	@Before
	public void setUp() {
	}

	private String getUrl() {
		String url = "http://localhost:" + serverPort + contexto;
		System.out.println("caca " + url);
		return url;
	}

	@Test
	public void hasPageTitle() {
		goTo(getUrl());
		List<FluentWebElement> mierdas = find("head title");
		for (FluentWebElement caca : mierdas) {
			System.out.println("me lleva la mierda " + caca.getText());
		}
		assertThat(find("head title").first().html()).isEqualTo("CRUD Example");
	}

	@Test
	public void hasTwoItems() {
		goTo(getUrl());
		await().atMost(60, TimeUnit.SECONDS).until(".checkbox").hasSize(2);
		assertThat(find(".checkbox").getTexts()).containsOnly(FIRST_ITEM_DESCRIPTION, SECOND_ITEM_DESCRIPTION);
		assertThat(find(".checkbox").first().find(":checked")).isNotEmpty();
		assertThat(find(".checkbox").get(1).find(":checked")).isEmpty();
	}

	@Override
	public WebDriver getDefaultDriver() {
		return webDriver;
	}
}