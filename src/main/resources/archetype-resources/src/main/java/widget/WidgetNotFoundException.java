package ${package}.widget;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WidgetNotFoundException extends RuntimeException {
  public WidgetNotFoundException(String exception) {
    super(exception);
  }
}
