package io.github.yunan9.i18n4j.translation.identity;

import java.util.Locale;
import org.jetbrains.annotations.NotNull;

final class TranslationIdentityImpl implements TranslationIdentity {

  private final String key;

  private final Locale locale;

  TranslationIdentityImpl(final @NotNull String key, final @NotNull Locale locale) {
    this.key = key;

    this.locale = locale;
  }

  @Override
  public @NotNull String key() {
    return this.key;
  }

  @Override
  public @NotNull Locale locale() {
    return this.locale;
  }
}
