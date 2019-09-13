package ${package}.widget;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WidgetService {
  private static final Logger logger = LoggerFactory.getLogger(WidgetService.class);
  private WidgetRepository repository;

  @Autowired
  public WidgetService(WidgetRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public Widget getWidget(@PathVariable("name") String name) {
    return repository.getWidget(name);
  }

  @GetMapping
  public List<Widget> getWidgetsByValue(@PathVariable("value") String value) {
    return repository.getWidgetsByValue(value);
  }

  @GetMapping
  public List<Widget> getAllWidgets() {
    Collection<Widget> widgets = repository.getAll();
    return widgets == null ? null : widgets.stream().collect(Collectors.toList());
  }

  @PostMapping
  public Widget addWidget(@RequestBody Widget widget) {
    if (repository.getWidget(widget.getName()) != null)
      throw new WidgetNotAllowedException("This widget already exists in the inventory.");
    repository.addWidget(widget);
    return widget;
  }

  /**
   * Populates the widget repository with static data
   *
   * @throws IOException
   */
  @PostConstruct
  public void populateWidgets() throws IOException {

    HashMap<String, Widget> data = new HashMap<>();
    data.put("foo", new Widget("foo", "bar"));
    data.put("zoo", new Widget("zoo", "gar"));
    data.put("goo", new Widget("goo", "bar"));
    data.put("loo", new Widget("loo", "nar"));
    data.put("scoo", new Widget("scoo", "tar"));
    data.put("mar", new Widget("mar", "mar"));
    data.put("Lee", new Widget("Lee", "Lee fits America"));


    for(Widget widget : data.values()) {

      logger.info(widget.toString());
      repository.addWidget(widget);

    }
    logger.info("Widgets loaded into widget repositories");
  }

}
