package br.com.empiricus.configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer",
        description = "Utilize o token para acessar o IndicAtivo"
)
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(
                new Info()
                        .title("IndicAtivo API RESTful")
                        .version("v1")
                        .description("API RESTful do IndicAtivo")
                        .termsOfService("link do repositorio do projeto")
                        .license(
                                new License()
                                        .name("Apache License 2.0")
                                        .url("https://www.apache.org/licenses/LICENSE-2.0")
                        )
                        .contact(
                                new Contact()
                                        .name("IndicAtivo")
                                        .email("email")
                                        .url("swagger-ui do projeto")
                        )
                        .summary(
                                "Descrição"
                        )
        );
    }
}