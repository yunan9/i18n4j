package io.github.yunan9.i18n4j.translation;

import io.github.yunan9.i18n4j.translation.snapshot.TranslationSnapshot;
import io.github.yunan9.pointer.store.PointerStore;
import org.jetbrains.annotations.NotNull;

final class TranslationImpl implements Translation {

  private final PointerStore pointerStore;

  TranslationImpl(
      final @NotNull PointerStore pointerStore,
      final @NotNull TranslationSnapshot translationSnapshot) {
    this.pointerStore = pointerStore;
    this.pointerStore.registerPointer(TRANSLATION_SNAPSHOT_POINTER_KEY, () -> translationSnapshot);
  }

  @Override
  public @NotNull PointerStore getPointerStore() {
    return this.pointerStore;
  }
}
