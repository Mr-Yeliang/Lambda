package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.example.demo.entity.Car;
import com.example.demo.entity.Person;
import com.example.demo.repository.Integrable;
import com.example.demo.repository.Predicate;

public class LambdaExample {

	public static void main(String[] args) {
		// 测试一
		double d1 = integrate(x -> x, 0, 10, 1000);
		System.out.println("方程y=x的0到10的积分为：" + d1);
		double d2 = integrate(x -> x * x, 10, 100, 1000);
		System.out.println("方程y=x^2的10到100的积分为：" + d2);
		double d3 = integrate(x -> Math.pow(x, 3), 10, 100, 1000);
		System.out.println("方程y=x^3的100到100的积分为：" + d3);
		double d4 = integrate(Math::sin, 10, 100, 1000);
		System.out.println("方程y=sin x的10到100的积分为：" + d4);
		System.out.println("---------------------\n");

		List<Person> people = new ArrayList<>();
		for (int i = 2; i < 20; i = i + 2) {
			Person person = new Person(i, "张三", i * 1000);
			people.add(person);
		}
		people.add(new Person(11, "李四", 2000));

		// 测试二
		List<Person> list = findMatchPerson(people, d -> d.getId() == 10);
		System.out.println("ID为10的个人有：");
		for (Person person : list) {
			System.out.println(person);
		}
		System.out.println("---------------------\n");

		// 测试三
		List<Person> list2 = findMatchPerson(people, p -> p.getName().equals("李四"));
		System.out.println("姓名为李四的个人有：");
		for (Person person : list2) {
			System.out.println(person);
		}
		System.out.println("---------------------\n");

		// 测试四
		List<Person> list3 = findMatchPerson(people, p -> p.getSalary() > 5000);
		System.out.println("薪水大于5000的个人有：");
		for (Person person : list3) {
			System.out.println(person);
		}
		System.out.println("---------------------\n");

		// 测试五
		int i = mapSum(people, Person::getSalary);
		System.out.println("所有人的薪水总和为：" + i);
		System.out.println("---------------------\n");

		List<Car> cars = new ArrayList<>();
		cars.add(new Car(1001, "宝马320", 369800));
		cars.add(new Car(1234, "荣威RX5", 110000));
		cars.add(new Car(1568, "马自达阿特兹", 150000));
		cars.add(new Car(2005, "丰田凯美瑞", 127000));
		cars.add(new Car(2135, "英菲尼迪QX50", 286000));
		cars.add(new Car(3544, "奥迪A4L", 238000));
		cars.add(new Car(5478, "奔驰C级", 288000));

		// 测试六
		int i2 = mapSum(cars, Car::getPrice);
		System.out.println("所有汽车价格总和为：" + i2);
		System.out.println("---------------------\n");

	}

	/**
	 * 求函数积分
	 * 
	 * @param func
	 *            函数表达式
	 * @param a
	 *            下限
	 * @param b
	 *            上限
	 * @param numSilces
	 *            分割块数
	 * @return
	 */
	public static double integrate(Integrable func, double a, double b, int numSilces) {
		if (numSilces < 1)
			numSilces = 1;
		double delta = (b - a) / numSilces;
		double start = a + delta / 2.0;
		double sum = 0.0;
		for (int i = 0; i < numSilces; i++) {
			sum += delta * func.eval(start + delta * i);
		}
		return sum;
	}

	/**
	 * 使用Predicate接口
	 * 
	 * @param people
	 * @param predicate
	 * @return
	 */
	private static List<Person> findMatchPerson(List<Person> people, Predicate<Person> predicate) {
		List<Person> list = new ArrayList<>();
		for (Person person : people) {
			if (predicate.test(person)) {
				list.add(person);
			}
		}
		return list;
	}

	/**
	 * 定义Funcation,求Person的某属性值的和
	 * 
	 * @param entries
	 * @param f
	 * @return
	 */
	private static <T> int mapSum(List<T> entries, Function<T, Integer> f) {
		int sum = 0;
		for (T t : entries) {
			sum += f.apply(t);
		}
		return sum;
	}
}
