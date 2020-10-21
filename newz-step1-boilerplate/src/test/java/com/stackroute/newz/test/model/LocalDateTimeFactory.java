package com.stackroute.newz.test.model;

import org.meanbean.lang.Factory;

import java.time.LocalDateTime;

@SuppressWarnings("PMD")
public class LocalDateTimeFactory implements Factory<LocalDateTime> {
    @Override
    public LocalDateTime create() {
        return LocalDateTime.now();
    }
}
