package ${package};

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import ${package}.widget.Widget;
import ${package}.widget.WidgetDto;


/**
 * Unit test for the App class.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void widgetCanBeAdded() throws URISyntaxException {
    final String baseUrl = "http://localhost:"+port+"/widgets";
    URI uri = new URI(baseUrl);
    Widget widget = new Widget("LeRoy", "Lee fits America");

    HttpHeaders headers = new HttpHeaders();
    HttpEntity<Widget> request = new HttpEntity<>(widget, headers);
    ResponseEntity entity = testRestTemplate.postForEntity(uri, request, WidgetDto.class);

    Assert.assertTrue(entity != null);
    Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
  }

  @Test
  public void shouldReturn200WhenWidgetExists() throws Exception {
    String value = "Lee fits America";

    ResponseEntity<List<WidgetDto>> response = testRestTemplate.exchange(
      "http://localhost:" + port + "/widgets/value/" + value,
      HttpMethod.GET,
      null,
      new ParameterizedTypeReference<List<WidgetDto>>() {});
    List<WidgetDto> widgets = response.getBody();

    Assert.assertEquals(widgets.size(), 1);
    Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  /**
   * Insert here your mocks
   */
  @Mock
  private List mockList;

  /**
   * Sample test with given-when-then structure using MockitoBDD and AssertJ
   */
  @Test
  public void listDoesWorkWithMocks() {
    given(mockList.size()).willReturn(10);

    final int sizeOfTheList = mockList.size();

    assertThat(sizeOfTheList).isEqualTo(10);
  }
}
