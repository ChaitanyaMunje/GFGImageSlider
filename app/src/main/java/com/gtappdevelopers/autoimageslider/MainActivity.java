package com.gtappdevelopers.autoimageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Urls of our images.
    String url1="https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png";
    String url2="https://qphs.fs.quoracdn.net/main-qimg-8e203d34a6a56345f86f1a92570557ba.webp";
    String url3="https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // we are creating array list for storing our image urls.
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.slider);
        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));
        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);
        //below method is used to set auto cycle direction in left to right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        //below method is used to setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);
        //below method is use to set scroll time in seconds.
        sliderView.setScrollTimeInSec(3);
        //to set it scrollable automatically we use below method.
        sliderView.setAutoCycle(true);
        //to start autocycle below method is used.
        sliderView.startAutoCycle();
    }
}