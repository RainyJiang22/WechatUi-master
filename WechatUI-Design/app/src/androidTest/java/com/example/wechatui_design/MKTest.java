package com.example.wechatui_design;

import android.app.Instrumentation;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.view.KeyEvent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by Jacky on 2018/10/13.
 */

@RunWith(AndroidJUnit4.class)
public class MKTest {

    private Instrumentation minstrumentation;
    private UiDevice uiDevice;


    @Before
   public void  setup(){
        minstrumentation = InstrumentationRegistry.getInstrumentation();
        uiDevice = UiDevice.getInstance(minstrumentation);

    }

    @Test
   public void  DemoTest() throws RemoteException {
        //初始化出现手机进程
     //   uiDevice.pressRecentApps();

        //初始化手机进行滑动解锁
//        uiDevice.swipe(519,1505,519,306,10);
//        uiDevice.pressKeyCode(KeyEvent.KEYCODE_HOME);
//        uiDevice.pressKeyCode(KeyEvent.KEYCODE_HOME);
//
//
//        //点击手机输入密码进行解锁
//        uiDevice.click(840,1241);
//        uiDevice.click(840,684);
//        uiDevice.click(237,674);
//        uiDevice.click(542,688);
//        uiDevice.click(840,1241);

        //点击计算机图标，进入计算机
//        uiDevice.findObject(By.text("计算机")).click();
          uiDevice.click(415,1107);
    }
}
