package vml.junit.script.def;

import java.util.Enumeration;

import org.junit.runner.notification.Failure;

import junit.framework.TestFailure;
import junit.framework.TestResult;

public class OverridenCls {

	public void method(String s) {
		System.out.println("Overriden class");
		//// ImpTestCase x=new ImpTestCase("MethodName");
		//// x.run();
		// junit.framework.TestSuite newSuite = new junit.framework.TestSuite();
		// newSuite.addTest(new ImpCase("MethodName"));
		// newSuite.addTest(new ImpCase("MethodName2"));
		// TestResult ts=new TestResult();
		// newSuite.run(ts);
		// System.out.println("Result=="+ ts.wasSuccessful());
		// int tr=ts.failureCount();
		// Enumeration<TestFailure> e = ts.failures();
		// while (e.hasMoreElements()) {
		// TestFailure param = e.nextElement();
		// System.out.println(param.toString());
		// }
	}

	public static void main(String args[]) {
		OverridenCls ab = new OverrideSbCls();
		ab.method("str");
	}
}

class OverrideSbCls extends OverridenCls {
	@Override
	public void method() {
		System.out.println("Overriden class");
	}

}