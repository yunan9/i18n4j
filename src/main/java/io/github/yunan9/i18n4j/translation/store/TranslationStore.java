package io.github.yunan9.i18n4j.translation.store;

import static java.util.Objects.requireNonNull;

import io.github.yunan9.i18n4j.translation.identity.TranslationIdentity;
import io.github.yunan9.i18n4j.translation.snapshot.TranslationSnapshot;
import io.github.yunan9.i18n4j.translation.source.TranslationSource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.*;

public sealed interface TranslationStore permits TranslationStoreImpl {

  int INITIAL_TRANSLATION_STORE_CAPACITY = 64;

  float TRANSLATION_STORE_LOAD_FACTOR = 0.75f;

  @Contract(value = "_ -> new", pure = true)
  static @NotNull TranslationStore newTranslationStore(
      final @NotNull Map<@NotNull TranslationIdentity, @NotNull TranslationSnapshot> translations) {
    return new TranslationStoreImpl(translations);
  }

  static @NotNull TranslationStore newTranslationStore() {
    return newTranslationStore(
        new HashMap<>(INITIAL_TRANSLATION_STORE_CAPACITY, TRANSLATION_STORE_LOAD_FACTOR));
  }

  static @NotNull TranslationStore newConcurrentTranslationStore() {
    return newTranslationStore(
        new ConcurrentHashMap<>(INITIAL_TRANSLATION_STORE_CAPACITY, TRANSLATION_STORE_LOAD_FACTOR));
  }

  @UnmodifiableView
  @NotNull
  Collection<@NotNull TranslationSnapshot> getTranslations();

  @ApiStatus.NonExtendable
  default void installTranslations(final @NotNull TranslationSource translationSource) {
    this.installTranslations(requireNonNull(translationSource).getTranslations());
  }

  @ApiStatus.NonExtendable
  default void installTranslations(final @NotNull TranslationStore translationStore) {
    this.installTranslations(requireNonNull(translationStore).getTranslations());
  }

  void installTranslations(
      final @UnmodifiableView @NotNull Collection<@NotNull TranslationSnapshot> translations);

  @UnmodifiableView
  @Nullable
  TranslationSnapshot getTranslation(final @NotNull TranslationIdentity translationIdentity);
}
