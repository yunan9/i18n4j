package io.github.yunan9.i18n4j.translation.source;

import io.github.yunan9.i18n4j.translation.Translation;
import io.github.yunan9.i18n4j.translation.snapshot.TranslationSnapshot;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

@FunctionalInterface
public interface TranslationSource extends Translation.Holder {

  @Override
  @UnmodifiableView
  @NotNull
  Collection<@NotNull TranslationSnapshot> translations();
}
