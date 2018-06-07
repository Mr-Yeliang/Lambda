package com.example.demo;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 使用Supplier和Stream.generate生成斐波那契数列
 * @author Loner
 *
 */
public class SupplierExample implements Supplier<Integer> {

	int a1 = 0;
	int a2 = 1;

	public Integer get() {
		int a3 = a1 + a2;
		a1 = a2;
		a2 = a3;
		return a3;
	}

	public static void main(String[] args) {

		Stream.generate(new SupplierExample()).limit(10).forEach(System.out::println);

		System.out.println("=========================");

		Stream.iterate(new int[] { 1, 2 }, t -> new int[] { t[1], t[0] + t[1] }).limit(10).map(t -> t[0])
				.forEach(System.out::println);
	}

}
