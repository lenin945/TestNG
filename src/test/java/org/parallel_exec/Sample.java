package org.parallel_exec;

import org.testng.annotations.Test;

public class Sample {
	
@Test
private void tc1() {
	System.out.println(Thread.currentThread().getId());
	System.out.println("Test1");
}
@Test
private void tc2() {
	System.out.println(Thread.currentThread().getId());
	System.out.println("Test2");
}
@Test
private void tc3() {
	System.out.println(Thread.currentThread().getId());
	System.out.println("Test3");
}
}
