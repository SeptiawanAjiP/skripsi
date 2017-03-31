/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  android.location.Location
 */
package com.example.septiawanajipradan.kanibal.sensorkit;

import android.location.Location;

import com.example.septiawanajipradan.kanibal.sensorkit.enums.PSKDeviceOrientation;

public interface PSKEventListener {
    public void onLocationChangedEvent(Location var1);

    public void onDeviceOrientationChanged(PSKDeviceOrientation var1);
}

