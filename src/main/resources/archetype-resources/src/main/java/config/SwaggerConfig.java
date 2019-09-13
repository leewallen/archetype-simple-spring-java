package ${package}.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import static java.util.Collections.emptyList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(apiInfo())
      .select()
      .apis(RequestHandlerSelectors.any())
      .paths(PathSelectors.any())
      .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfo(
      "${groupId}",
      "WidgetService REST API",
      "1.0",
      "Terms of service",
      new Contact("CodeCognition", "http://www.codecognition.org", "lee@codecognition.org"),
      "MIT", "https://opensource.org/licenses/MIT", emptyList());
  }
}
