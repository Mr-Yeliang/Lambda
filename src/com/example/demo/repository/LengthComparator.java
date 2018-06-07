package com.example.demo.repository;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		return Integer.compare(s1.length(), s2.length());
	}

}
