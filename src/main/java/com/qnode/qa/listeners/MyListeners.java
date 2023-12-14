package com.qnode.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

	@Override
	public void onStart(ITestContext context) {

		System.out.println("Excution of Project Tests Started");

	}

	@Override
	public void onTestStart(ITestResult result) {

		String testName = result.getName();
		System.out.println(testName + " started excuting");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String testName = result.getName();
		System.out.println(testName + " got successfully executed");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getName();
		System.out.println(testName + " got Failed");
		System.out.println(result.getThrowable());

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String testName = result.getName();
		System.out.println(testName + " got skipped");
		System.out.println(result.getThrowable());

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

		String testName = result.getName();
		System.out.println(testName + " fail due to TimeOut");
		System.out.println(result.getThrowable());

	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("Finished excuting Project Tests");

	}

}
