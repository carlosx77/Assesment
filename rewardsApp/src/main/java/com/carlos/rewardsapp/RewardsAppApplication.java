package com.carlos.rewardsapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementPortType;
import org.springframework.boot.actuate.endpoint.ExposableEndpoint;
import org.springframework.boot.actuate.endpoint.web.EndpointLinksResolver;
import org.springframework.boot.actuate.endpoint.web.EndpointMapping;
import org.springframework.boot.actuate.endpoint.web.EndpointMediaTypes;
import org.springframework.boot.actuate.endpoint.web.ExposableWebEndpoint;
import org.springframework.boot.actuate.endpoint.web.WebEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.annotation.ServletEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.servlet.WebMvcEndpointHandlerMapping;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.StringUtils;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories
@EnableSwagger2
public class RewardsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardsAppApplication.class, args);
	}


	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("com.carlos.rewardsapp"))
				.paths(PathSelectors.any()).build();
	}
	
	@Bean
	public WebMvcEndpointHandlerMapping webEndpointServletHandlerMapping(
	    WebEndpointsSupplier webEndpointsSupplier,
	    ServletEndpointsSupplier servletEndpointsSupplier, ControllerEndpointsSupplier controllerEndpointsSupplier,
	    EndpointMediaTypes endpointMediaTypes, CorsEndpointProperties corsProperties,
	    WebEndpointProperties webEndpointProperties, Environment environment) {
	  List<ExposableEndpoint<?>> allEndpoints = new ArrayList<>();
	  Collection<ExposableWebEndpoint> webEndpoints = webEndpointsSupplier.getEndpoints();
	  allEndpoints.addAll(webEndpoints);
	  allEndpoints.addAll(servletEndpointsSupplier.getEndpoints());
	  allEndpoints.addAll(controllerEndpointsSupplier.getEndpoints());
	  String basePath = webEndpointProperties.getBasePath();
	  EndpointMapping endpointMapping = new EndpointMapping(basePath);
	  boolean shouldRegisterLinksMapping = shouldRegisterLinksMapping(webEndpointProperties, environment, basePath);
	  return new WebMvcEndpointHandlerMapping(endpointMapping, webEndpoints, endpointMediaTypes,
	      corsProperties.toCorsConfiguration(), new EndpointLinksResolver(allEndpoints, basePath),
	      shouldRegisterLinksMapping);
	}
	
	private boolean shouldRegisterLinksMapping (WebEndpointProperties webEndpointProperties, Environment environment, String basePath) {
		return webEndpointProperties.getDiscovery().isEnabled() && (StringUtils.hasText(basePath) || ManagementPortType.get(environment).equals(ManagementPortType.DIFFERENT));
	}

}
