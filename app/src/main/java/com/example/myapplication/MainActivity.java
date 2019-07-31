package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.hololo.tutorial.library.PermissionStep;
import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;



public class MainActivity extends TutorialActivity {


    @Override
    public void currentFragmentPosition(int a){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addFragment(new Step.Builder().setTitle("my items")
                .setContent("   ")
                .setBackgroundColor(Color.parseColor("#424242")) // int background color
                .setDrawable(R.drawable.initialslider) // int top drawable
                .setSummary("")
                .build());

        addFragment(new Step.Builder().setTitle("idea")
                .setContent("   ")
                .setBackgroundColor(Color.parseColor("#424242")) // int background color
                .setDrawable(R.drawable.slider2) // int top drawable
                .setSummary("")
                .build());

        addFragment(new Step.Builder().setTitle("Done..!!")
                .setContent("  ")
                .setBackgroundColor(Color.parseColor("#424242")) // int background color
                .setDrawable(R.drawable.endslider) // int top drawable
                .setSummary("")
                .build());
    }
    @Override
    public void finishTutorial() {
        // Your implementation
        Intent intent2=new Intent(this,LoginActivity.class);
        startActivity(intent2);
    }
}
