package com.example.demo;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 构建Stream的常用方法
 * 
 * @author Loner
 *
 */
public class StreamExample {
	public static void main(String[] args) {
		IntStream.of(5, 10).forEach(System.out::println);
		System.out.println("----------------------\n");
		
		Stream.of("1", "3", "5").mapToInt(Integer::parseInt).forEach(System.out::println);
		System.out.println("----------------------\n");
		
		IntStream.builder().add(1).add(2).add(3).build().forEach(System.out::println);
		System.out.println("----------------------\n");
		
		IntStream.concat(IntStream.builder().add(1).build(), IntStream.builder().add(1).build())
				.forEach(System.out::println);
		System.out.println("----------------------\n");
		
		IntStream emptyStream = IntStream.empty();
		
		IntStream.generate(() -> 1).limit(30).forEach(System.out::println);
		System.out.println("----------------------\n");
		
		IntStream.iterate(0, n -> n + 3).limit(3).boxed().collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("----------------------\n");
		
		IntStream.range(30, 50).forEach(System.out::println);
		System.out.println("----------------------\n");
		
		IntStream.rangeClosed(30, 50).forEach(System.out::println);

	}

}
