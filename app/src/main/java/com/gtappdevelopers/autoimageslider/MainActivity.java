package com.gtappdevelopers.autoimageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //Creating variables for text view, sensor manager and our sensor.
    TextView sensorStatusTV;
    SensorManager sensorManager;
    Sensor proximitySensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorStatusTV = findViewById(R.id.sensorStatusTV);
        //calling sensor service.
        sensorManager = (SensorManager) getSystemService(
                Context.SENSOR_SERVICE);
        //from sensor service we are calling proximity sensor
        proximitySensor = sensorManager.getDefaultSensor(
                Sensor.TYPE_PROXIMITY);
        //handling the case if the proximity sensor is not present in users device.
        if (proximitySensor == null) {
            Toast.makeText(this, "No proximity sensor found in device.", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            //regestering our sensor with sensor manager.
            sensorManager.registerListener(proximitySensorEventListener,
                    proximitySensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    //calling the sensor event class to detect the change in data when sensor starts working.
    SensorEventListener proximitySensorEventListener
            = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // method to check accuaracy changed in sensor.
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            //check if the sensor type is proximity sensor.
            if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                if (event.values[0] == 0) {
                    //here we are setting our status to our textview..
                    //if sensor event return 0 then object is closed to sensor else object is away from sensor.
                    sensorStatusTV.setText("Near");
                } else {
                    sensorStatusTV.setText("Away");
                }
            }
        }


    };

}