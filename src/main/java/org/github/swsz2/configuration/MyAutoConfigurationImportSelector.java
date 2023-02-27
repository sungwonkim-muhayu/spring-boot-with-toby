package org.github.swsz2.configuration;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class MyAutoConfigurationImportSelector implements DeferredImportSelector {

  private final ClassLoader classLoader;

  public MyAutoConfigurationImportSelector(ClassLoader classLoader) {
    this.classLoader = classLoader;
  }

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    List<String> autoConfigurations = new ArrayList<>();
    ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(autoConfigurations::add);
    return autoConfigurations.toArray(new String[0]);
  }
}
