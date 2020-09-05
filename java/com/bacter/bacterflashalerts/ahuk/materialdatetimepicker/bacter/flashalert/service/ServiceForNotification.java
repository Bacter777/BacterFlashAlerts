package com.bacter.bacterflashalerts.bacter.flashalert.service;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.widget.Toast;
import com.bacter.bacterflashalerts.bacter.flashalert.db.Database;
import com.bacter.bacterflashalerts.bacter.flashalert.db.Pack;
import com.bacter.bacterflashalerts.bacter.flashalert.receiver.IncomingCallAndSMS;

import java.util.ArrayList;

public class ServiceForNotification extends NotificationListenerService {

    private Context context;
    private boolean check = true;
    private static int ID_NOTIFICATION = 001;
    private ArrayList<Pack> mListPack;
    private Database mDb;
    private IncomingCallAndSMS mReceiverCallOrSMS;
    private IntentFilter mFilter;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        mReceiverCallOrSMS = new IncomingCallAndSMS();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        mDb = new Database(context);
        mListPack = new ArrayList<>();
        mListPack.addAll(mDb.getListPack());

        String pack = sbn.getPackageName();
        if(mListPack.size() > 0){
            String pk = mListPack.get(0).getPack();
        }
        Toast.makeText(context, "" + pack, Toast.LENGTH_SHORT).show();
        for(int i = 0; i<mListPack.size(); i++){
            if(pack.equals(mListPack.get(i).getPack())){
                Intent inten = new Intent("notify");
                sendBroadcast(inten);
            }
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        super.onNotificationRemoved(sbn);
    }

}
