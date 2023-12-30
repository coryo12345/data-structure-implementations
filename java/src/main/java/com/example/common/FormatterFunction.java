package com.example.common;

@FunctionalInterface
public interface FormatterFunction<T> {
    String apply(T value);
}
