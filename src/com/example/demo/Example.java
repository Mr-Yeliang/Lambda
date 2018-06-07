package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentSupplier;

/**
 * 创建50个学生实例，按照成绩进行分组，统计每组的人数，显示每组的学生信息
 * 
 * @author Loner
 *
 */
public class Example {
	public static void main(String[] args) {

		// 使用Stream.generate()创建50个学生实例并存入List
		List<Student> list = new ArrayList<>();
		Object[] students = Stream.generate(new StudentSupplier()).limit(50).toArray();
		for (Object object : students) {
			list.add((Student) object);
		}

		// 按成绩将学生分组
		Map<Integer, List<Student>> map = new HashMap<>();
		map = groupingByScore(list);
		for (Integer i : map.keySet()) {
			// 统计每组的人数
			System.out.printf("%d分的学生有%d人，分别是：\n", i, map.get(i).size());
			System.out.println("学号\t姓名");
			// 显示每组的学生信息
			map.get(i).stream().forEach(x -> System.out.println(x.getId() + "\t" + x.getName()));
			System.out.println("======================");

		}

	}

	/**
	 * 按成绩将学生分组存入Map——key为成绩，value为List<Student>
	 * 
	 * @param list
	 * @return
	 */
	private static Map<Integer, List<Student>> groupingByScore(List<Student> list) {
		return list.stream().collect(Collectors.groupingBy(x -> x.getScore()));

	}

}
