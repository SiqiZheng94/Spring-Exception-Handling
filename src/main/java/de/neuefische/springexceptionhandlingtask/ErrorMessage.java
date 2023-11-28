package de.neuefische.springexceptionhandlingtask;

import java.time.Instant;

public record ErrorMessage(String message, Instant timestamp) {
    public ErrorMessage(String message) {
        this(message, Instant.now());
    }
}
