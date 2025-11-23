package io.github.yunan9.i18n4j.translation.mapper;

import io.github.yunan9.i18n4j.translation.snapshot.TranslationSnapshot;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface TranslationMapper<T> {

  T map(final @NotNull TranslationSnapshot translationSnapshot);
}
