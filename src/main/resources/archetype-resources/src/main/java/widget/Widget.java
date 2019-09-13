package ${package}.widget;

import java.util.Objects;

public class Widget {
  private String name;
  private String value;

  public Widget() {}

  public Widget(String name, String value) {
    this.name = name;
    this.value = value;
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.format("{'name':'%s', 'value':'%s'}", name, value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Widget widget = (Widget) o;
    return name.equals(widget.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
