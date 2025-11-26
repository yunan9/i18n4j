package io.github.yunan9.i18n4j.translation.identity;

import io.github.yunan9.commons.key.Keyable;
import io.github.yunan9.commons.l10n.Localizable;
import java.util.Locale;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public sealed interface TranslationIdentity extends Keyable<@NotNull String>, Localizable
    permits TranslationIdentityImpl {

  @Contract(value = "_, _ -> new", pure = true)
  static @NotNull TranslationIdentity newTranslationIdentity(
      final @NotNull String key, final @NotNull Locale locale) {
    return new TranslationIdentityImpl(key, locale);
  }

  @Override
  @NotNull
  String key();

  @Override
  @NotNull
  Locale locale();
}
