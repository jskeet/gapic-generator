package com.google.api.codegen.transformer.csharp;

import java.util.Arrays;
import java.util.List;

import com.google.api.codegen.TargetLanguage;
import com.google.api.codegen.config.GapicProductConfig;
import com.google.api.codegen.config.PackageMetadataConfig;
import com.google.api.codegen.transformer.ModelToViewTransformer;
import com.google.api.codegen.transformer.PackageMetadataTransformer;
import com.google.api.codegen.viewmodel.ViewModel;
import com.google.api.codegen.viewmodel.metadata.PackageMetadataView;
import com.google.api.tools.framework.model.Model;
import com.google.common.base.Preconditions;

public class CSharpProjectTransformer implements ModelToViewTransformer {
  
  private static final String PROJECT_TEMPLATE_FILENAME = "csharp/csproj.snip";
  
  private final PackageMetadataConfig packageConfig;
  private final PackageMetadataTransformer metadataTransformer = new PackageMetadataTransformer();

  public CSharpProjectTransformer(PackageMetadataConfig packageConfig) {
    this.packageConfig = Preconditions.checkNotNull(
        packageConfig,
        "Package configuration must be provided to generate C# project file");
  }

  @Override
  public List<ViewModel> transform(Model model, GapicProductConfig productConfig) {
    return Arrays.asList(createViewModel(model, productConfig));
  }

  private ViewModel createViewModel(Model model, GapicProductConfig productConfig) {
    PackageMetadataView project = metadataTransformer.generateMetadataView(packageConfig, model, PROJECT_TEMPLATE_FILENAME,
        productConfig.getPackageName() + ".csproj", TargetLanguage.CSHARP).build();
    return project;
  }

  @Override
  public List<String> getTemplateFileNames() {
    return Arrays.asList(PROJECT_TEMPLATE_FILENAME);
  }
}
