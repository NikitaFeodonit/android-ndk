/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.cmakemodule;

import android.support.annotation.Keep;

public class NativeMethods {

    int hour = 0;
    int minute = 0;
    int second = 0;

    /*
     * A function calling from JNI to update current timer
     */
    @Keep
    private void updateTimer() {
        ++second;
        if(second >= 60) {
            ++minute;
            second -= 60;
            if(minute >= 60) {
                ++hour;
                minute -= 60;
            }
        }
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                String ticks = "" + NativeMethods.this.hour + ":" +
//                        NativeMethods.this.minute + ":" +
//                        NativeMethods.this.second;
//                NativeMethods.this.tickView.setText(ticks);
//            }
//        });
    }
    static {
        System.loadLibrary("hello-jnicallback");
    }
    public static native  String stringFromJNI();
    public static native void startTicks();
    public static native void StopTicks();
}
