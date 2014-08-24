package coo.boot.site.config;

import org.springframework.stereotype.Component;

import coo.mvc.config.AbstractFreeMarkerSettings;

/**
 * FreeMarker设置组件。
 */
@Component("coo.boot.site.config.FreeMarkerSettings")
public class FreeMarkerSettings extends AbstractFreeMarkerSettings {
	/**
	 * 构造方法。
	 */
	public FreeMarkerSettings() {
		setOrder(100);
		addTemplatePath("classpath:/coo/boot/site/actions/");
		addTemplatePath("classpath:/coo/boot/site/macros/");
		addAutoImport("system", "system.ftl");
	}
}