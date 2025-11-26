package io.github.yunan9.i18n4j.translation;

import io.github.yunan9.i18n4j.translation.snapshot.TranslationSnapshot;
import io.github.yunan9.pointer.key.PointerKey;
import io.github.yunan9.pointer.store.PointerStore;
import java.util.Collection;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

public sealed interface Translation extends PointerStore.Holder permits TranslationImpl {

  PointerKey<TranslationSnapshot> TRANSLATION_SNAPSHOT_POINTER_KEY =
      PointerKey.newPointerKey("translation_snapshot", TranslationSnapshot.class);

  @Contract("_, _ -> new")
  static @NotNull Translation newTranslation(
      final @NotNull PointerStore pointerStore,
      final @NotNull TranslationSnapshot translationSnapshot) {
    return new TranslationImpl(pointerStore, translationSnapshot);
  }

  @Contract("_ -> new")
  static @NotNull Translation newTranslation(
      final @NotNull TranslationSnapshot translationSnapshot) {
    return newTranslation(PointerStore.newConcurrentPointerStore(), translationSnapshot);
  }

  @Override
  @NotNull
  PointerStore getPointerStore();

  @FunctionalInterface
  interface Holder {

    @UnmodifiableView
    @NotNull
    Collection<@NotNull TranslationSnapshot> translations();
  }
}
