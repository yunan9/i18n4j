package io.github.yunan9.i18n4j.translation.snapshot;

import io.github.yunan9.commons.id.Identifiable;
import io.github.yunan9.commons.value.Valuable;
import io.github.yunan9.i18n4j.translation.identity.TranslationIdentity;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public sealed interface TranslationSnapshot
    extends Identifiable<@NotNull TranslationIdentity>, Valuable<@NotNull String>
    permits TranslationSnapshotImpl {

  @Contract(value = "_, _ -> new", pure = true)
  static @NotNull TranslationSnapshot newTranslationSnapshot(
      final @NotNull TranslationIdentity id, final @NotNull String value) {
    return new TranslationSnapshotImpl(id, value);
  }

  @Override
  @NotNull
  TranslationIdentity id();

  @Override
  @NotNull
  String value();
}
