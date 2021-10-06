package org.parallel_exec;

import org.testng.annotations.Test;

public class data {
	@Test
private void tc1() {
		System.out.println(Thread.currentThread().getId());
System.out.println("test11");
}
	@Test
private void tc2() {
		System.out.println(Thread.currentThread().getId());
	System.out.println("test22");
}
}
