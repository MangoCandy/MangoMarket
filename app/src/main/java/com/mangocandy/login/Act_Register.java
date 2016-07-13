package com.mangocandy.login;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.bumptech.glide.Glide;
import com.mangocandy.base.MActivity;
import com.mangocandy.mangomarket.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Act_Register extends MActivity {
    Context context = this;
    @BindView(R.id.backimage)
    ImageView backimage;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.maintext)
    TextView maintext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        initView();
    }

    public void initView(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setToolbar(toolbar, true);
        maintext = (TextView) findViewById(R.id.maintext);
        backimage = (ImageView) findViewById(R.id.backimage);
        getImage();
    }

    public void getImage() {//
        AVQuery<AVObject> query = new AVQuery<>("WeImage");
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                AVObject object = list.get(0);
                String path = object.getAVFile("Url").getUrl();
                maintext.setBackgroundColor(Color.parseColor(object.getString("textColor")));
                Glide.with(context).load(path).animate(R.anim.circle_s2b).into(backimage);
            }
        });
    }
}
