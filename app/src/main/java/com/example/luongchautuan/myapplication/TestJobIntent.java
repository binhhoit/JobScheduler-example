package com.example.luongchautuan.myapplication;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.JobIntentService;
import android.util.Log;

public class TestJobIntent extends JobIntentService {
    public TestJobIntent() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("job", "create");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.e("job", "command");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(@NonNull Intent intent) {
        Log.e("job", "Bind");
        return super.onBind(intent);
    }

    @Override
    public void onDestroy() {
        Log.e("job", "Destroy");
        super.onDestroy();
    }

    @Override
    public void setInterruptIfStopped(boolean interruptIfStopped) {
        super.setInterruptIfStopped(interruptIfStopped);
    }

    @Override
    public boolean isStopped() {
        Log.e("job", "stop");
        return super.isStopped();
    }

    @Override
    public boolean onStopCurrentWork() {
        return super.onStopCurrentWork();
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Log.e("job", "work");
    }
}
