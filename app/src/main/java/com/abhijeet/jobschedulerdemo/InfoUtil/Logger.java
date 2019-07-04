
package com.abhijeet.jobschedulerdemo.InfoUtil;

import android.util.Log;

import com.abhijeet.jobschedulerdemo.BuildConfig;

/**
 * Logger class to log system level events
 */

public class Logger {
    /**
     * @param tag     is the log generator class name
     * @param log     event text
     * @param logType type of log event
     *                DEBUG
     *                ERROR
     *                or INFO
     */
    public static void log(String tag, String log, LogType logType) {

        if (BuildConfig.DEBUG) {
            switch (logType) {
                case ERROR: {
                    Log.e(tag, "e: " + log);
                    break;
                }
                case INFO: {
                    Log.i(tag, "i: " + log);
                    break;
                }
                default: {
                    Log.d(tag, "d: " + log);
                    break;
                }
            }
        }
    }

    /**
     * @param tag is the  log generator class name
     * @param log event text
     */
    public static void log(String tag, String log) {
        log(tag, log, LogType.DEBUG);
    }

    /**
     * LogType class to differentiate
     * DEBUG
     * ERROR
     * INFO
     */
    public enum LogType {
        DEBUG, ERROR, INFO
    }
}
