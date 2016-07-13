package com.mangocandy.login;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

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
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        image = (ImageView)findViewById(R.id.backimage);
        getImage();
    }

    public void getImage() {//
        AVQuery<AVObject> query = new AVQuery<>("WeImage");
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                String path = list.get(0).getAVFile("Url").getUrl();
                Log.e("asd",path+"");
                Glide.with(context).load(path).into(image);
            }
        });
    }
}
