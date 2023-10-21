package uk.co.spirallight.wordcounter.api.v1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

  @Bean
  public OpenAPI myOpenAPI() {

    Contact contact = new Contact();
    contact.setEmail("tjc@spiral-light.co.uk");
    contact.setName("Anthony Cunningham");

    Info info = new Info()
        .title("Word Counter Exercise")
        .version("1.0")
        .contact(contact)
        .description("This API exposes endpoints to the word counter library.");

    return new OpenAPI().info(info);
  }
}