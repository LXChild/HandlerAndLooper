package com.example.lxchild.handlerandlooper;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private String str = "xxx";
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String str = (String) msg.obj;
            tv.setText(str);
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv = (TextView) findViewById(R.id.tv);
        tv.setText(str);
        MyThread mt = new MyThread();
        mt.start();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                Message msg = new Message();
                msg.obj = "sssssssss";
                handler.sendMessage(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            super.run();
        }
    }
}
