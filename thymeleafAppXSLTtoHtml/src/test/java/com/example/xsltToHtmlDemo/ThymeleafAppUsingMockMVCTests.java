package com.example.xsltToHtmlDemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.javarefresh.xsltToHtml.ThymeleafAppXSLTtoHtml;
import com.javarefresh.xsltToHtml.XsltController;

/**
 * Junit for checking
 * 
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
//@SpringBootTest - Note - Configuration error: found multiple declarations of @BootstrapWith

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ThymeleafAppXSLTtoHtml.class)
@WebMvcTest(XsltController.class)
public class ThymeleafAppUsingMockMVCTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	//Note - If not specify @Autowired for MockMvc then it will give java.lang.NullPointerException
	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void homePageTest() throws Exception {
		mockMvc.perform(get("http://localhost:8080/javaRefresh/home")).andExpect(status().isOk());
	}

}

/* Test run successfully and logs as below
17:42:56.345 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating CacheAwareContextLoaderDelegate from class [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
17:42:56.358 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating BootstrapContext using constructor [public org.springframework.test.context.support.DefaultBootstrapContext(java.lang.Class,org.springframework.test.context.CacheAwareContextLoaderDelegate)]
17:42:56.404 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating TestContextBootstrapper for test class [com.example.xsltToHtmlDemo.ThymeleafAppMockMVCTests] from class [org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper]
17:42:56.435 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.example.xsltToHtmlDemo.ThymeleafAppMockMVCTests]: class path resource [com/example/xsltToHtmlDemo/ThymeleafAppMockMVCTests-context.xml] does not exist
17:42:56.436 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.example.xsltToHtmlDemo.ThymeleafAppMockMVCTests]: class path resource [com/example/xsltToHtmlDemo/ThymeleafAppMockMVCTestsContext.groovy] does not exist
17:42:56.436 [main] INFO org.springframework.test.context.support.AbstractContextLoader - Could not detect default resource locations for test class [com.example.xsltToHtmlDemo.ThymeleafAppMockMVCTests]: no resource found for suffixes {-context.xml, Context.groovy}.
17:42:56.497 [main] DEBUG org.springframework.test.context.support.ActiveProfilesUtils - Could not find an 'annotation declaring class' for annotation type [org.springframework.test.context.ActiveProfiles] and class [com.example.xsltToHtmlDemo.ThymeleafAppMockMVCTests]
17:42:56.525 [main] DEBUG org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper - @TestExecutionListeners is not present for class [com.example.xsltToHtmlDemo.ThymeleafAppMockMVCTests]: using defaults.
17:42:56.526 [main] INFO org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper - Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPublishingTestExecutionListener]
17:42:56.535 [main] DEBUG org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper - Skipping candidate TestExecutionListener [org.springframework.test.context.transaction.TransactionalTestExecutionListener] due to a missing dependency. Specify custom listener classes or make the default listener classes and their required dependencies available. Offending class: [org/springframework/transaction/TransactionDefinition]
17:42:56.536 [main] DEBUG org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper - Skipping candidate TestExecutionListener [org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener] due to a missing dependency. Specify custom listener classes or make the default listener classes and their required dependencies available. Offending class: [org/springframework/transaction/interceptor/TransactionAttribute]
17:42:56.536 [main] INFO org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper - Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@3eb25e1a, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@477b4cdf, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@77c2494c, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@f5958c9, org.springframework.test.context.support.DirtiesContextTestExecutionListener@233795b6, org.springframework.test.context.event.EventPublishingTestExecutionListener@3eb738bb, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@5bda8e08, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener@1e800aaa, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@185a6e9, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@6f03482, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@9d5509a]
17:42:56.540 [main] DEBUG org.springframework.test.context.support.AbstractDirtiesContextTestExecutionListener - Before test class: context [DefaultTestContext@79079097 testClass = ThymeleafAppMockMVCTests, testInstance = [null], testMethod = [null], testException = [null], mergedContextConfiguration = [WebMergedContextConfiguration@4d1c00d0 testClass = ThymeleafAppMockMVCTests, locations = '{}', classes = '{class com.javarefresh.xsltToHtml.ThymeleafAppXSLTtoHtml}', contextInitializerClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper=true}', contextCustomizers = set[[ImportsContextCustomizer@4b2bac3f key = [org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration, org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration, org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration, org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration, org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration, org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration, org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration, org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration, org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration, org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration, org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration, org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration, org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration, org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration, org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration, org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcWebClientAutoConfiguration, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcWebDriverAutoConfiguration, org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration, org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcSecurityConfiguration]], org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@1ea9f6af, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@7193666c, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.autoconfigure.OverrideAutoConfigurationContextCustomizerFactory$DisableAutoConfigurationContextCustomizer@384ad17b, org.springframework.boot.test.autoconfigure.filter.TypeExcludeFiltersContextCustomizer@87116b7b, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@16b9b819, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizerFactory$Customizer@1623b78d], resourceBasePath = 'src/main/webapp', contextLoader = 'org.springframework.boot.test.context.SpringBootContextLoader', parent = [null]], attributes = map[[empty]]], class annotated with @DirtiesContext [false] with mode [null].
17:42:56.558 [main] DEBUG org.springframework.test.context.support.DependencyInjectionTestExecutionListener - Performing dependency injection for test context [[DefaultTestContext@79079097 testClass = ThymeleafAppMockMVCTests, testInstance = com.example.xsltToHtmlDemo.ThymeleafAppMockMVCTests@69453e37, testMethod = [null], testException = [null], mergedContextConfiguration = [WebMergedContextConfiguration@4d1c00d0 testClass = ThymeleafAppMockMVCTests, locations = '{}', classes = '{class com.javarefresh.xsltToHtml.ThymeleafAppXSLTtoHtml}', contextInitializerClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper=true}', contextCustomizers = set[[ImportsContextCustomizer@4b2bac3f key = [org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration, org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration, org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration, org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration, org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration, org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration, org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration, org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration, org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration, org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration, org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration, org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration, org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration, org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration, org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration, org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcWebClientAutoConfiguration, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcWebDriverAutoConfiguration, org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration, org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcSecurityConfiguration]], org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@1ea9f6af, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@7193666c, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.autoconfigure.OverrideAutoConfigurationContextCustomizerFactory$DisableAutoConfigurationContextCustomizer@384ad17b, org.springframework.boot.test.autoconfigure.filter.TypeExcludeFiltersContextCustomizer@87116b7b, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@16b9b819, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizerFactory$Customizer@1623b78d], resourceBasePath = 'src/main/webapp', contextLoader = 'org.springframework.boot.test.context.SpringBootContextLoader', parent = [null]], attributes = map[[empty]]]].
17:42:56.660 [main] DEBUG org.springframework.test.context.support.TestPropertySourceUtils - Adding inlined properties to environment: {spring.jmx.enabled=false, org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper=true, server.port=-1}

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.4.RELEASE)

2020-01-20 17:42:57.037  INFO 5012 --- [           main] c.e.x.ThymeleafAppMockMVCTests           : Starting ThymeleafAppMockMVCTests on user-To-be-filled-by-O-E-M with PID 5012 (started by user in /home/user/Documents/sts_workspace/xsltToHtmlDemo.zip_expanded/xsltToHtmlDemo)
2020-01-20 17:42:57.043  INFO 5012 --- [           main] c.e.x.ThymeleafAppMockMVCTests           : No active profile set, falling back to default profiles: default
2020-01-20 17:42:59.117  INFO 5012 --- [           main] pertySourcedRequestMappingHandlerMapping : Mapped URL path [/v2/api-docs] onto method [springfox.documentation.swagger2.web.Swagger2Controller#getDocumentation(String, HttpServletRequest)]
2020-01-20 17:42:59.387  INFO 5012 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-01-20 17:42:59.763  INFO 5012 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2020-01-20 17:42:59.763  INFO 5012 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2020-01-20 17:42:59.782  INFO 5012 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 18 ms
2020-01-20 17:42:59.815  INFO 5012 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed
2020-01-20 17:42:59.851  INFO 5012 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found 1 custom documentation plugin(s)
2020-01-20 17:42:59.886  INFO 5012 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2020-01-20 17:43:00.219  INFO 5012 --- [           main] c.e.x.ThymeleafAppMockMVCTests           : Started ThymeleafAppMockMVCTests in 3.549 seconds (JVM running for 4.613)
Inside the home
2020-01-20 17:43:00.723  INFO 5012 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
*/
