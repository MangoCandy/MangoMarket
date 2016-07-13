package com.mangocandy.base;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mangocandy.mangomarket.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/7/13.
 */
public  class MActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        ButterKnife.bind(this);
    }

    public  void setToolbar(Toolbar toolbar,boolean isTransparent){
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_goback);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if(isTransparent){
            toolbar.setBackgroundColor(Color.TRANSPARENT);
        }else{
            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }
    }
}
