/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.dopanic.panicsensorkit.PSKApplication
 */
package com.example.septiawanajipradan.kanibal.ARKit;

import com.example.septiawanajipradan.kanibal.sensorkit.PSKApplication;

public class PARApplication
extends PSKApplication {
    public void onCreate() {
        super.onCreate();
        PARController.getInstance().init(PSKApplication.getAppContext(), this.setApiKey());
    }

    public String setApiKey() {
        return "Override the setApiKey method in your PARApplication class!";
    }
}

