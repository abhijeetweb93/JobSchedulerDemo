package com.abhijeet.jobschedulerdemo.WorkSchedule;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.HandlerThread;

import com.abhijeet.jobschedulerdemo.InfoUtil.Logger;

public class MyJobService extends JobService {
    private static final String TAG = MyJobService.class.getSimpleName();

    @Override
    public boolean onStartJob(final JobParameters params) {

        HandlerThread handlerThread = new HandlerThread("SomeOtherThread");
        handlerThread.start();

        Handler handler = new Handler(handlerThread.getLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Logger.log(TAG, "Running!!!!!!!!!!!!!");
                jobFinished(params, true);
            }
        });

        return true;
    }

    @Override
    public boolean onStopJob(final JobParameters params) {
        Logger.log(TAG, "onStopJob() was called");
        return true;
    }
}
