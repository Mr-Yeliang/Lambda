package com.example.demo.repository;

@FunctionalInterface
public interface Predicate<T> {
	boolean test(T t);
}
