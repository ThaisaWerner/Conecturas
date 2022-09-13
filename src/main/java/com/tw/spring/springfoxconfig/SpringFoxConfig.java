package com.tw.spring.springfoxconfig;
import javax.servlet.ServletContext;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import springfox.documentation.spi.service.RequestHandlerProvider;
import springfox.documentation.spring.web.WebMvcRequestHandler;
import springfox.documentation.spring.web.plugins.DocumentationPluginsBootstrapper;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;
import springfox.documentation.spring.web.readers.operation.HandlerMethodResolver;

import static java.util.stream.Collectors.toList;
import static springfox.documentation.spi.service.contexts.Orderings.byPatternsCondition;
import static springfox.documentation.spring.web.paths.Paths.ROOT;

@Configuration
public class SpringFoxConfig {
	
	@Bean
	public InitializingBean removeSpringFoxHandlerProvider(DocumentationPluginsBootstrapper bootstrapper) {
		return () -> bootstrapper.getHandlerProviders().removeIf(WebMvcRequestHandlerProvider.class::isInstance);
		
	}

	@Bean
	public RequestHandlerProvider customRequestHandlerProvider(Optional<ServletContext> servletContext, HandlerMethodResolver methodResolver, List<RequestMappingInfoHandlerMapping> handlerMappings) {
		String contextPath = servletContext.map(ServletContext::getContextPath).orElse(ROOT);
		return () -> handlerMappings.stream()
				.filter(mapping -> !mapping.getClass().getSimpleName().equals("IntegrationRequestMappingHandlerMapping"))
				.map(mapping -> mapping.getHandlerMethods().entrySet())
				.flatMap(Set::stream)
				.map(entry -> new WebMvcRequestHandler(contextPath, methodResolver, tweakInfo(entry.getKey()), entry.getValue()))
				.sorted(byPatternsCondition())
				.collect(toList());
	}
	
	RequestMappingInfo tweakInfo(RequestMappingInfo info) {
		if(info.getPathPatternsCondition() == null) return info;
		String[] patterns = info.getPathPatternsCondition().getPatternValues().toArray(String[]::new);
		return info.mutate().options(new RequestMappingInfo.BuilderConfiguration()).paths(patterns).build();
	}
}
