package com.example.ramonsantos.baseexpandableteste;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.ramonsantos.baseexpandableteste.ecowalkapp.ImgAdapter;

public class ActivityViewPager extends AppCompatActivity {
    private int[] carros = {R.drawable.ferrari_laferrari, R.drawable.bugatti_veyron, R.drawable.pagani_zonda,
            R.drawable.porsche_911, R.drawable.mclaren, R.drawable.maserati_gran_turismo,
            R.drawable.lamborghini_veneno};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new ImgAdapter(this, carros));
    }

}
