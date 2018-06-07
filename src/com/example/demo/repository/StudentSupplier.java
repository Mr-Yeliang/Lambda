package com.example.demo.repository;

import java.util.function.Supplier;
import com.example.demo.entity.Student;

/**
 * 使用Supplier生成Student实例
 * 
 * @author Loner
 *
 */
public class StudentSupplier implements Supplier<Student> {

	int id = 1000;
	int i=-1;
	int[] scores = { 60, 70, 75, 80, 85, 90, 95, 100 };
	String[] names = { "张吉惟", "林国瑞", "林玟书", "林雅南", "江奕云", "刘柏宏", "阮建安", "林子帆", "夏志豪", "吉茹定", "李中冰", "黄文隆", "谢彦文", "傅智翔",
			"洪振霞", "刘姿婷", "荣姿康", "吕致盈", "方一强", "黎芸贵", "郑伊雯", "雷进宝", "吴美隆", "吴心真", "王美珠", "郭芳天", "李雅惠", "陈文婷", "曹敏侑",
			"王依婷", "陈婉璇", "吴美玉", "蔡依婷", "郑昌梦", "林家纶", "黄丽昆", "李育泉", "黄芸欢", "吴韵如", "李肇芬", "卢木仲", "李成白", "方兆玉", "刘翊惠",
			"丁汉臻", "吴佳瑞", "舒绿珮", "周白芷", "张姿妤", "张虹伦" };

	public Student get() {
		int id2 = id + 1;
		id = id2;
		i++;
		return new Student(id2, names[i], scores[(int) (Math.random() * 8)]);
	}

}
