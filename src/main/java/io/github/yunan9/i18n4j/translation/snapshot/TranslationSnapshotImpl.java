package io.github.yunan9.i18n4j.translation.snapshot;

import io.github.yunan9.i18n4j.translation.identity.TranslationIdentity;
import org.jetbrains.annotations.NotNull;

final class TranslationSnapshotImpl implements TranslationSnapshot {

  private final TranslationIdentity id;

  private final String value;

  TranslationSnapshotImpl(final @NotNull TranslationIdentity id, final @NotNull String value) {
    this.id = id;

    this.value = value;
  }

  @Override
  public @NotNull TranslationIdentity getId() {
    return this.id;
  }

  @Override
  public @NotNull String getValue() {
    return this.value;
  }
}
