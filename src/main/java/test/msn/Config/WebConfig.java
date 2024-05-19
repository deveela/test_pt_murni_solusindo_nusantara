package test.msn.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "test.msn")
@Import(value = { SecurityConfig.class, HibernateConfig.class })
public class WebConfig implements WebMvcConfigurer {

	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
			"classpath:/META-INF/resources/",
			"classpath:/resources/",
			"classpath:/static/",
			"classpath:/public/"};

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
		resourceHandlerRegistry.addResourceHandler("/**")
				.addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
		resourceHandlerRegistry.addResourceHandler("/webjars/**")
				.addResourceLocations("/webjars/").resourceChain(false);
	}

	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		
		return templateResolver;
	}
	
	@Bean 
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		
		templateEngine.setTemplateResolver(this.templateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		
		return templateEngine;
	}
	
	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		ViewResolverRegistry registry = new ViewResolverRegistry(null, applicationContext);
		viewResolver.setTemplateEngine(this.templateEngine());
		registry.viewResolver(viewResolver);		
		
		return viewResolver;
	}
}
