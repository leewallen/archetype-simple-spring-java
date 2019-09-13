package ${package}.widget;

import ${package}.cache.Cache;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class WidgetRepository {

  private Map<String, Widget> widgets = new Cache<>();

  public void addWidget(Widget widget) {
    widgets.put(widget.getName(), widget);
  }

  public Widget getWidget(String name) {
    return widgets.get(name);
  }

  public List<Widget> getWidgetsByValue(String value) {
    List<Widget> results = widgets.values()
      .stream().sorted(Comparator.comparing(Widget::getName))
      .filter(w -> w.getValue().equalsIgnoreCase(value))
      .collect(Collectors.toList());

    if (results.size() == 0) return null;
    return results;
  }

  public List<Widget> getAll() {
    return widgets.values().stream().collect(Collectors.toList());
  }
}
