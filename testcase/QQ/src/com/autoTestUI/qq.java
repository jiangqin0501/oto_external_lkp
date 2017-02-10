package com.autoTestUI;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.RemoteException;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class qq extends UiAutomatorTestCase {
	
	public static String apppackage = "com.tencent.mobileqq";
	public static String appactivity = "com.tencent.mobileqq.activity.RegisterGuideActivity";
	public static String appName = "com.tencent.mobileqq/com.tencent.mobileqq.activity.RegisterGuideActivity";
	public static String port = "5555";
	
	public void testqq() throws UiObjectNotFoundException, RemoteException,
			IOException, InterruptedException {
		otoDisplayRun otoTest;
		otoTest = new otoDisplayRun(getUiDevice());
		otoTest.mydevice.wakeUp();
		assertTrue("screen on :can't wakeup", otoTest.mydevice.isScreenOn());
		//启动时间
		Date starttime;
		Date endtime;
		long launchTime;	
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		
		starttime = new Date();
		System.out.println("----------Start time： " +  format.format(starttime));
		System.out.println("starttime:" +  System.currentTimeMillis());
		otoDisplayRun.execCmdNoSave("am start -n " + appName);
		
		endtime = new Date();
		System.out.println("----------结束时间： " +  format.format(endtime));
		System.out.println("endtime:" +  System.currentTimeMillis());
		
		launchTime = endtime.getTime() - starttime.getTime();
		System.out.println("----------APP launch 时间： " + launchTime +"ms");
		sleep(2000);
		
		//关闭温馨提示弹窗
		otoTest.ClickById("android:id/button1");
		sleep(1000);
		window_lib.windowtest(otoTest.mydevice,appName );
		// 最大化
		otoDisplayRun.execCmdNoSave("am start -n " + appName);
		otoTest.ClickById("android:id/mwMaximizeBtn");
		otoTest.ClickById("android:id/mwMaximizeBtn");
		// 关闭程序
		otoTest.ClickById("android:id/mwCloseBtn");
		// 重新启动程序
		otoDisplayRun.execCmdNoSave("am start -n " + appName);
		//执行其他操作，如：登录等
		otoTest.ClickById("com.tencent.mobileqq:id/btn_login");
		
		UiObject username=new UiObject(new UiSelector().className("android.widget.EditText"));
		otoTest.ClickByClassname("android.widget.EditText");
		username.setText("3050840977");
		
		UiObject passwd=new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/password"));
		otoTest.ClickById("com.tencent.mobileqq:id/password");
		passwd.setText("abc123");
		
		otoTest.ClickById("com.tencent.mobileqq:id/login");
		//最小化
		otoTest.ClickById("android:id/mwMinimizeBtn");
		//强制关闭程序
		otoDisplayRun.execCmdNoSave("am force-stop " + appName.substring(0, appName.indexOf("/")));
	}
	
}