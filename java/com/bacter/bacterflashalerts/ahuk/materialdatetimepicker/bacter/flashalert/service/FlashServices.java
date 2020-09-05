package com.bacter.bacterflashalerts.bacter.flashalert.service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.camera2.CameraAccessException;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.RequiresApi;

import com.bacter.bacterflashalerts.bacter.flashalert.utils.FlashLight;
import com.bacter.bacterflashalerts.bacter.flashalert.utils.Utils;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class FlashServices extends Service {

    private SharedPreferences mSharePre;

    FlashLight flashLight = new FlashLight();

    public FlashServices() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate() {
        mSharePre = this.getSharedPreferences(Utils.SETTING, MODE_PRIVATE);
        try {
            FlashLight.flashOn(getApplicationContext());
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        super.onCreate();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDestroy() {
        try {
            FlashLight.flashOff();
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }
}