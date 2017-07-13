package com.example.intents.time;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlarmManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.database.Cursor;
import java.util.Calendar;
import android.database.sqlite.SQLiteDatabase;



public class MainActivity extends AppCompatActivity {
private PendingIntent pendingIntent;
    static final int DIALOG_IDS = 0;
    static final int DIALOG_IDE = 1;
    int hour_s;
    int minute_s;
    int hour_e;
    int minute_e;

     EditText edittext;
    TextView textView;
Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void start_time(View v){
        showDialog(DIALOG_IDS);
    }

    public void end_time(View v){
        showDialog(DIALOG_IDE);
    }


    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_IDS)
            return new TimePickerDialog(this,startpick,hour_s,minute_s,false);
        if(id == DIALOG_IDE)
            return new TimePickerDialog(this,endpick,hour_e,minute_e,false);
        return null;
    }

    protected TimePickerDialog.OnTimeSetListener startpick = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            hour_s = i;
            minute_s = i1;
            Toast.makeText(MainActivity.this,hour_s+":"+minute_s,Toast.LENGTH_LONG).show();
        }
    };

    protected TimePickerDialog.OnTimeSetListener endpick = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            hour_e = i;
            minute_e = i1;
            Toast.makeText(MainActivity.this,hour_e+":"+minute_e,Toast.LENGTH_LONG).show();
        }
    };



    public void createevent(View v) {
       /* Intent i = new Intent(this, create.class);



            String hs = String.valueOf(hour_s);
            String he = String.valueOf(hour_e);
            String ms = String.valueOf(minute_s);
            String me = String.valueOf(minute_e);

            i.putExtra("minute_s", ms);
            i.putExtra("hour_s", hs);
            i.putExtra("minute_e", me);
            i.putExtra("hour_e", he);
            startActivity(i);

*/

    Calendar cal=Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,hour_s);
        cal.set(Calendar.MINUTE,minute_s);
        //cal.set(Calendar.HOUR_OF_DAY,hour_e);
        //cal.set(Calendar.MINUTE,minute_e);
        Toast.makeText(this,"Button CLicked",Toast.LENGTH_SHORT).show();
//BroadcastReceiver broadcastReceiver=new MyBroadcastReceiver(this);
  //     LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,null);

        Intent intent=new Intent(this, MainActivity.class);

       pendingIntent=PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);



    }



}





