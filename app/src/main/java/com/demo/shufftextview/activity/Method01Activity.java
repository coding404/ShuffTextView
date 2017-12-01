package com.demo.shufftextview.activity;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import com.demo.shufftextview.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Method01Activity extends Activity {

    @Bind(R.id.tv_clock)
    TextView mTvClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method01);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_clock)
    public void onViewClicked() {
        startAnimation();
    }

    private void startAnimation() {
        Drawable[] drawables = mTvClock.getCompoundDrawables();
        for (Drawable drawable : drawables) {
            if (drawable != null && drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            }
        }
    }

}
