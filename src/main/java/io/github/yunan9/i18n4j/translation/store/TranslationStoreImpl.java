package io.github.yunan9.i18n4j.translation.store;

import static java.util.Objects.requireNonNull;

import io.github.yunan9.i18n4j.translation.Translation;
import io.github.yunan9.i18n4j.translation.identity.TranslationIdentity;
import io.github.yunan9.i18n4j.translation.snapshot.TranslationSnapshot;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

final class TranslationStoreImpl implements TranslationStore {

  private final Map<@NotNull TranslationIdentity, @NotNull TranslationSnapshot> translations;

  TranslationStoreImpl(
      final @NotNull Map<@NotNull TranslationIdentity, @NotNull TranslationSnapshot> translations) {
    this.translations = translations;
  }

  @Override
  public @UnmodifiableView @NotNull Collection<@NotNull TranslationSnapshot> getTranslations() {
    return Collections.unmodifiableCollection(this.translations.values());
  }

  @Override
  public void installTranslations(final Translation.@NotNull Holder translationHolder) {
    final var translations = requireNonNull(translationHolder).getTranslations();
    if (translations.isEmpty()) {
      return;
    }

    translations.forEach(translation -> this.translations.put(translation.getId(), translation));
  }

  @Override
  public @UnmodifiableView @Nullable TranslationSnapshot getTranslation(
      final @NotNull TranslationIdentity translationIdentity) {
    return this.translations.get(requireNonNull(translationIdentity));
  }
}
