package com.example.boundservice30032020;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyBoundService extends Service {

    Integer mCount = 0;
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        mCount = intent.getIntExtra("so", -1);
        for (int i = 0 ; i < 10 ; i++){
            mCount += i;
        }
        return new MyBinder();
    }
    class MyBinder extends Binder{

        public MyBoundService getService(){
            return MyBoundService.this;
        }
    }

    public Integer getCount(){
        return mCount;
    }
}
