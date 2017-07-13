
package com.example.intents.time;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;
import android.widget.Toast;
import android.os.Bundle;

public class MyBroadcastReceiver extends BroadcastReceiver {
    Context context;
    int ms,me,he,hs;

    public MyBroadcastReceiver(Context context){
        this.context = context;
    }
    public void onReceive(Context context, Intent intent) {
    //    Toast.makeText(context, "Don't panik but your time is up!!!!.",
     //           Toast.LENGTH_LONG).show();
        Log.d("BRoadCast","BroadCastRecie");
        System.out.print("BroadCAst");
        // Vibrate the mobile phone
       /* Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);*/
        AudioManager am = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
        am.setStreamVolume(AudioManager.STREAM_RING,0,0);
        am.setStreamVolume(AudioManager.STREAM_NOTIFICATION,0,0);
        am.setStreamVolume(AudioManager.STREAM_ALARM,0,0);
        am.setStreamVolume(AudioManager.STREAM_MUSIC,0,0);


    }



}