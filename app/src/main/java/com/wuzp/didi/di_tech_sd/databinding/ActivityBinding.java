package com.wuzp.didi.di_tech_sd.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import com.wuzp.didi.di_tech_sd.R;

/**
 * @author wuzhenpeng03 (wuzhenpeng03@didichuxing.com)
 */
public class ActivityBinding extends AppCompatActivity {

    ViewDataBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        binding =  DataBindingUtil.inflate(inflater, R.layout.activity_binding, null, false);
    }
}
