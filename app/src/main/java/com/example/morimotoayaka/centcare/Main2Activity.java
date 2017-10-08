package com.example.morimotoayaka.centcare;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    CountDownTimer countDownTimer;  // タイマー本体
    long time = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        countDownTimer = new CountDownTimer(time, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                // 0.1秒毎にTextView更新
                time = millisUntilFinished;
                int t = (int) millisUntilFinished / 1000;
                ((TextView) findViewById(R.id.tv)).setText("あと" + t + "秒");
            }

            @Override
            public void onFinish() {
                // 画面を切り替え
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);
                // PlayActivity終了
                finish();
            }
        }.start();
    }

    // 画面非表示に実行 ////////////////////////////////
    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
        countDownTimer = null;
    }
}