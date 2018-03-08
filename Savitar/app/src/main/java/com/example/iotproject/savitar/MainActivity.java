package com.example.iotproject.savitar;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    Button light,magnet,aclrn;
    SensorManager sm = null;
    List list1,list2,list3;
    String st,dk,ts;

    SensorEventListener sel = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            //textView1.setText("x: "+values[0]+"\ny: "+values[1]+"\nz: "+values[2]);
            st = values[0]+" lx";
        }
    };
    SensorEventListener sel1 = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            double mag;

            mag = Math.sqrt(values[0]*values[0]+values[1]*values[1]+values[2]*values[2]);
            dk=""+mag+" μT";
        }
    };
    SensorEventListener sel2 = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            double acl;

            acl = Math.sqrt(values[0]*values[0]+values[1]*values[1]+values[2]*values[2]);
            ts=""+acl+" m/s2";
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        light = (Button)findViewById(R.id.blight);
        magnet = (Button)findViewById(R.id.bmagnet);
        aclrn = (Button)findViewById(R.id.baccl);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);

        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Client.class);
                intent.putExtra("valueObtained",st);
                startActivity(intent);


            }
        });
        magnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Client.class);
                intent.putExtra("valueObtained",dk);
                startActivity(intent);


            }
        });
        aclrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Client.class);
                intent.putExtra("valueObtained",ts);
                startActivity(intent);

            }
        });

        list1 = sm.getSensorList(Sensor.TYPE_LIGHT);
        if(list1.size()>0){
            sm.registerListener(sel, (Sensor) list1.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            Toast.makeText(getBaseContext(), "Error: No Light.", Toast.LENGTH_LONG).show();
        }
        list2 = sm.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        if(list2.size()>0){
            sm.registerListener(sel1, (Sensor) list2.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            Toast.makeText(getBaseContext(), "Error: No Magnetic Field.", Toast.LENGTH_LONG).show();
        }
        list3 = sm.getSensorList(Sensor.TYPE_LINEAR_ACCELERATION);
        if(list3.size()>0){
            sm.registerListener(sel2, (Sensor) list3.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            Toast.makeText(getBaseContext(), "Error: Acceleration.", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onStop() {
        if(list1.size()>0){
            sm.unregisterListener(sel);
        }
        super.onStop();
        if(list2.size()>0){
            sm.unregisterListener(sel1);
        }
        super.onStop();
        if(list3.size()>0){
            sm.unregisterListener(sel2);
        }
        super.onStop();
    }

}


