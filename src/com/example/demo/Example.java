package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentSupplier;

public class Example {
	public static void main(String[] args) {

		List<Student> list = new ArrayList<>();
		Object[] students = Stream.generate(new StudentSupplier()).limit(50).toArray();
		for (Object object : students) {
			list.add((Student) object);
		}

		Map<Integer, List<Student>> map = new HashMap<>();
		map = groupingByScore(list);
		for (Integer i : map.keySet()) {
			System.out.printf("%d分的学生有%d人，分别是：\n", i, map.get(i).size());
			System.out.println("学号\t姓名");

			map.get(i).stream().forEach(x -> System.out.println(x.getId() + "\t" + x.getName()));
			System.out.println("======================");

		}

	}

	private static Map<Integer, List<Student>> groupingByScore(List<Student> list) {
		return list.stream().collect(Collectors.groupingBy(x -> x.getScore()));

	}

}
