package com.demo.shufftextview.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.shufftextview.R;
import com.demo.shufftextview.customspan.FireWorkGroup;
import com.demo.shufftextview.customspan.MutableForegroundColorSpan;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FireworkSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.iv_back)
    ImageView mIvBack;

    private FireWorkGroup mGroup;
    private SpannableString mSpannableString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firework_span);
        ButterKnife.bind(this);
        mTvTitle.setText(R.string.fireworks_span);
        mGroup = new FireWorkGroup();
        String content = getString(R.string.long_span);
        mSpannableString = new SpannableString(content);
        for (int index = 0; index < content.length(); index++) {
            MutableForegroundColorSpan span = new MutableForegroundColorSpan(0, Color.BLACK);
            mGroup.addSpan(span);
            mSpannableString.setSpan(span, index, index + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        mGroup.init();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mGroup, FireWorkGroup.FIREWORKS_GROUP_PROGRESS_PROPERTY, 0.0f, 1.0f);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //refresh
                mTvContent.setText(mSpannableString);
            }
        });
        objectAnimator.setDuration(2000);
        objectAnimator.start();

    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
