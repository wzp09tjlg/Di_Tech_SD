package com.wuzp.didi.di_tech_sd.rx;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.wuzp.didi.di_tech_sd.R;
import com.wuzp.didi.di_tech_sd.databinding.ActivityRxBinding;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * just to rx's activity with databind
 * 1.hope to test databind and find some new tech to our team;
 * 2.use rxjava to improve ourteam tech;
 * 3.ananlynise some new code to improve our team;
 */
public class RxActivity extends AppCompatActivity {

    private ActivityRxBinding binding;

    Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_rx);
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_rx, null, false);
        initView();
    }

    private void initView() {
        binding.btnTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RxActivity.this, "hello rxjava", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        testRxjava();
    }

    private void testRxjava() {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("hello");
                e.onNext("rx");
            }
        });

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(String value) {
                show(value);
            }

            @Override
            public void onError(Throwable e) {
                show("error:" + e.getMessage());
            }

            @Override
            public void onComplete() {
                show("compelele");
            }
        };

        //绑定有很多方式
        observable.subscribe(observer);
    }

    private void show(String msg) {
        Log.e("wzp", "msg:" + msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        disposable.dispose();
    }
}
