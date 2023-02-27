package org.github.swsz2.configuration;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigurationImportSelector implements DeferredImportSelector {
  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return new String[] {
      "org.github.swsz2.configuration.auto.DispatcherServletConfiguration",
      "org.github.swsz2.configuration.auto.TomcatWebServerConfiguration"
    };
  }
}
