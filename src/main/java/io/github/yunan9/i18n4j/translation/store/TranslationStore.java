package io.github.yunan9.i18n4j.translation.store;

import io.github.yunan9.i18n4j.translation.Translation;
import io.github.yunan9.i18n4j.translation.identity.TranslationIdentity;
import io.github.yunan9.i18n4j.translation.snapshot.TranslationSnapshot;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.*;

public sealed interface TranslationStore extends Translation.Holder permits TranslationStoreImpl {

  int INITIAL_TRANSLATION_STORE_CAPACITY = 64;

  float TRANSLATION_STORE_LOAD_FACTOR = .75f;

  TranslationStore GLOBAL_TRANSLATION_STORE = newConcurrentTranslationStore();

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

  @Override
  @UnmodifiableView
  @NotNull
  Collection<@NotNull TranslationSnapshot> translations();

  void installTranslations(final Translation.@NotNull Holder translationHolder);

  @UnmodifiableView
  @Nullable
  TranslationSnapshot translation(final @NotNull TranslationIdentity translationIdentity);

  @FunctionalInterface
  interface Holder {

    @NotNull
    TranslationStore translationStore();
  }
}
