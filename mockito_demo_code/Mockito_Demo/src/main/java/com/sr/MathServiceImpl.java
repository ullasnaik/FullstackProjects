package com.sr;

public class MathServiceImpl implements MathService {

	@Override
	public int square(int n1) {
			return n1*n1;
	}

	@Override
	public int character_count(String name) {
		return name.length();
	}

	@Override
	public long addition(long... nums) {
		    int sum = 0;
	        for (long a : nums) sum += a;
	        return sum;
	}

}
