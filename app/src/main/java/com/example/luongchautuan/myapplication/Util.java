package com.example.luongchautuan.myapplication;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.JobIntentService;

public class Util {

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void scheduleJob(Context context) {
        ComponentName serviceComponent = new ComponentName(context, TestJobService.class);
        JobInfo.Builder builder = new JobInfo.Builder(0, serviceComponent);
        builder.setMinimumLatency(5 * 1000); // wait at least
        builder.setOverrideDeadline(5 * 1000); // maximum delay
        //builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED); // require unmetered network
        //builder.setRequiresDeviceIdle(true); // device should be idle
        //builder.setRequiresCharging(false); // we don't care if the device is charging or not
        JobScheduler jobScheduler = context.getSystemService(JobScheduler.class);
        jobScheduler.schedule(builder.build());
    }


    private static final int JOB_ID_UPDATE = 0x1000;

    @RequiresApi(api = Build.VERSION_CODES.O)
    static void setUpdateJob(Context context) {
        // 대용량 데이터를 업데이트하기 위한 적정 조건 설정 // Đặt điều kiện thích hợp để cập nhật dữ liệu lớn
        JobInfo job =
                new JobInfo.Builder(
                        // Job에 설정할 Id 값 Giá trị id để đặt cho công việc
                        JOB_ID_UPDATE,
                        // 조건 만족 시 UpdateDataByWiFiService가 실행 Thực hiện UpdateDataByWiFiService khi điều kiện được thỏa mãn
                        new ComponentName(context, TestJobService.class)
                )
                        // 충분한 저장 공간이 있고,
                        .setRequiresStorageNotLow(true)
                        // WiFi 등의 비과금 네트워크를 사용 중이며
                        //.setRequiredNetworksCapabilities(JobInfo.NETWORK_TYPE_UNMETERED)
                        // 충전 중 일 때
                        .setRequiresCharging(true)
                        .build();

        // JobScheduler 서비스
        JobScheduler mJobService = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);

        // Job을 등록한다.
        mJobService.schedule(job);
    }


}


