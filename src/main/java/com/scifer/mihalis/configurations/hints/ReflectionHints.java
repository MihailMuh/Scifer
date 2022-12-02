package com.scifer.mihalis.configurations.hints;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

import java.time.Instant;
import java.time.ZonedDateTime;

public class ReflectionHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.reflection()
                .registerType(Instant[].class)
                .registerType(ZonedDateTime[].class);
    }
}
