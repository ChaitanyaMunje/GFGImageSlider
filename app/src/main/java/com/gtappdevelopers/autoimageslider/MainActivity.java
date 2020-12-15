package com.gtappdevelopers.autoimageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.jmedeisis.draglinearlayout.DragLinearLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //below lines is to initialize our Drag linear layout
        DragLinearLayout dragLinearLayout = findViewById(R.id.container);

        //we are creating for loop for dragging and dropping of child items.
        for (int i = 0; i < dragLinearLayout.getChildCount(); i++) {
            //below is the child inside dragger layout
            View child = dragLinearLayout.getChildAt(i);
            // set all children draggable except the first (the header)
            dragLinearLayout.setViewDraggable(child, child);
            //the child is its own drag handle.
        }
    }
}