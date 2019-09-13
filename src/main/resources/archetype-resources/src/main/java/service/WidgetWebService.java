package ${package}.service;

import ${package}.widget.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WidgetWebService {

  private WidgetService widgetService;

  @Autowired
  public WidgetWebService(WidgetService widgetService) {
    this.widgetService = widgetService;
  }

  @ResponseBody
  @PostMapping("/widgets")
  public WidgetDto addWidget(@RequestBody Widget widget) {
    widgetService.addWidget(widget);
    return transform(widget);
  }

  @ResponseBody
  @GetMapping("/widgets/name/{name}")
  public WidgetDto getName(@PathVariable("name") String name) throws Exception {
    Widget widget = widgetService.getWidget(name);
    if (widget != null)
      return transform(widget);
    throw new WidgetNotFoundException(String.format("We can't find any wdigets with the name: %s.%n", name));
  }

  @ResponseBody
  @GetMapping("/widgets")
  public List<WidgetDto> getWidgets() throws Exception {
    List<Widget> widgets = widgetService.getAllWidgets();
    if (widgets != null)
      return transform(widgets);
    throw new WidgetNotFoundException(String.format("Please excuse us! Our widgets have gone for a walk."));
  }

  @ResponseBody
  @GetMapping("/widgets/value/{value}")
  public List<WidgetDto> getWidgetsByValue(@PathVariable("value") String value) throws Exception {
    List<Widget> widgets = widgetService.getWidgetsByValue(value);
    if (widgets != null)
      return transform(widgets);
    throw new WidgetNotFoundException(String.format("Please excuse us! Our widgets for value %s have had their limit - they appear to have approached zero.", value));
  }

  private WidgetDto transform(Widget widget) {
    WidgetDto dto = new WidgetDto();
    dto.setName(widget.getName());
    dto.setValue(widget.getValue());
    return dto;
  }

  private List<WidgetDto> transform(List<Widget> widgets) {
    List<WidgetDto> dtos = widgets.stream().map(w -> {
      WidgetDto dto = new WidgetDto();
      dto.setName(w.getName());
      dto.setValue(w.getValue());
      return dto;
    }).collect(Collectors.toList());

    return dtos;
  }

}

