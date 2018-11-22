package com.example.luongchautuan.myapplication;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

public class TestJobService extends JobService {
    private static final String TAG = "SyncService";
    private int count;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onStartJob(JobParameters params) {
       /* Intent service = new Intent(getApplicationContext(), SensorService.class);
        startForegroundService(service);
        Service.startForeground();
*/
        count++;
        Log.e("run job", "-------------------->   " + count);
        Util.scheduleJob(getApplicationContext()); // reschedule the job

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.e("stop job", "-------------------->   " + count);
        jobFinished(params,true);
        return true;
    }

    @Override
    public boolean stopService(Intent name) {
        return super.stopService(name);
    }

    public TestJobService() {
        super();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("destroy job", "-------------------->   " + count);
    }
}