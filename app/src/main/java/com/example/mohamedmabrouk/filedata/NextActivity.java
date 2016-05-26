package com.example.mohamedmabrouk.filedata;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_activity);

        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment=fragmentManager.findFragmentById(R.id.Fragment_Container);
        if (fragment==null){
            fragment=new NextFragment();
            fragmentManager.beginTransaction().add(R.id.Fragment_Container,fragment).commit();
        }


    }
}
