package com.ruoyi.web.core.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ruoyi.common.config.RuoYiConfig;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2 interface configuration
 * 
 * @author ruoyi
 */
@Configuration
public class SwaggerConfig
{
    /** System base configuration */
    @Autowired
    private RuoYiConfig ruoyiConfig;

    /** Whether to turn on swagger */
    @Value("${swagger.enabled}")
    private boolean enabled;

    /** Set a uniform prefix for requests */
    @Value("${swagger.pathMapping}")
    private String pathMapping;

    /**
     * Create API
     */
    @Bean
    public Docket createRestApi()
    {
        return new Docket(DocumentationType.OAS_30)
                // Swagger enabled or not
                .enable(enabled)
                // Used to create basic information about this API to be displayed in the document's page (custom display information)
                .apiInfo(apiInfo())
                // Set which interfaces are exposed to Swagger for display
                .select()
                // Scan all annotated api's for more flexibility with this approach
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // Scan for swagger annotations in a given package
                // .apis(RequestHandlerSelectors.basePackage("com.ruoyi.project.tool.swagger"))
                // Scan all.apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                /* Set secure mode, swagger can set access token */
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .pathMapping(pathMapping);
    }

    /**
     * Secure mode, here specifying that the token is passed through the Authorization header request header
     */
    private List<SecurityScheme> securitySchemes()
    {
        List<SecurityScheme> apiKeyList = new ArrayList<SecurityScheme>();
        apiKeyList.add(new ApiKey("Authorization", "Authorization", In.HEADER.toValue()));
        return apiKeyList;
    }

    /**
     * Security Context
     */
    private List<SecurityContext> securityContexts()
    {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
                        .build());
        return securityContexts;
    }

    /**
     * Default secure upper reference
     */
    private List<SecurityReference> defaultAuth()
    {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }

    /**
     * Add summary information
     */
    private ApiInfo apiInfo()
    {
        //  Customisation with ApiInfoBuilder
        return new ApiInfoBuilder()
                // Set title
                .title("Title: Fashion Management_Interface Document")
                // Description
                .description("Description: A module for managing the personnel information of the group's companies, specifically XXX, XXX...")
                // Author Information
                .contact(new Contact(ruoyiConfig.getName(), null, null))
                // Versions
                .version("Version number:" + ruoyiConfig.getVersion())
                .build();
    }
}
