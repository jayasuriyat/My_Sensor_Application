package com.jayasuriyat.mysensorapplication;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.util.Log;
import android.widget.TextView;



public class sensor extends ActionBarActivity implements SensorEventListener{
    Sensor sense;
    SensorManager sm;
    int type=-1;
    TextView X,Y,Z,info,titles;
    String units="",title="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("zold","started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        sense=sm.getDefaultSensor(android.hardware.Sensor.TYPE_PRESSURE);
        Bundle b=getIntent().getExtras();
        if(b!=null){
            type=b.getInt("type");
        }

        switch (type){
            case 0:
                sense=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                title="ACCELEROMETER";
                units=" m/s\u00B2";
                break;
            case 1:
                sense=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
                title="LIGHT";
                units=" lx";
                break;
            case 2:
                sense=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
                title="PROXIMITY";
                units=" cms";
                break;
            case 3:
                sense=sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
                title="MAGNETIC FIELD";
                units=" \u00B5T";
                break;
            case 4:
                sense=sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
                title="GYROSCOPE";
                units=" rad/s";
        }
        titles=(TextView)findViewById(R.id.title);
        titles.setText(title);
        sm.registerListener(this,sense,SensorManager.SENSOR_DELAY_NORMAL);
        X=(TextView)findViewById(R.id.X);
        Y=(TextView)findViewById(R.id.Y);
        Z=(TextView)findViewById(R.id.Z);
        info=(TextView)findViewById(R.id.info);
    }



    @Override
    public void onSensorChanged(SensorEvent event) {
        if(type==0||type==1||type==5) {
            X.setText("X = " + Float.toString(event.values[0]) + units);
            Y.setText("Y = " + Float.toString(event.values[1]) + units);
            Z.setText("Z = " + Float.toString(event.values[2]) + units);
        }


        else{
            info.setText(Float.toString(event.values[0])+units);
        }
    }

    @Override
    public void onAccuracyChanged(android.hardware.Sensor sensor, int accuracy) {

    }
}
