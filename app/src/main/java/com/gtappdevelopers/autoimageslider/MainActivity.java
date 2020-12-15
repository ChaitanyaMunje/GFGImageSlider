package com.gtappdevelopers.autoimageslider;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //we are adding fade animation between two imageviews.
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        //below 3 lines of code is to exclude action bar,title bar and navigation bar from animation.
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container), true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);
        //we are adding fade animaion for enter transition.
        getWindow().setEnterTransition(fade);
        //we are also setting fade animation for exit transition.
        getWindow().setExitTransition(fade);
        //initializing our imageview.
        final ImageView imageView = findViewById(R.id.image);

        //setting on click listner for our imageview.
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on image click we are opening new activity and adding animation between this two activities.
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //below method is used to make scene transition and adding fade animation in it.
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        MainActivity.this, imageView, ViewCompat.getTransitionName(imageView));
                // starting our activity with below method.
                startActivity(intent, options.toBundle());
            }
        });
    }


}