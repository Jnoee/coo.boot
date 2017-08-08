package coo.boot.demo.config;

import org.springframework.stereotype.Component;

import coo.boot.demo.enums.Interest;
import coo.boot.demo.enums.Sex;
import coo.mvc.freemarker.AbstractFreeMarkerSettings;

/**
 * FreeMarker设置组件。
 */
@Component("coo.boot.demo.config.FreeMarkerSettings")
public class FreeMarkerSettings extends AbstractFreeMarkerSettings {
  /**
   * 构造方法。
   */
  public FreeMarkerSettings() {
    setOrder(100);
    addTemplatePath("classpath:/coo/boot/demo/actions/");
    addEnumClass(Sex.class, Interest.class);
  }
}
