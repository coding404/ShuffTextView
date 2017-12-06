package com.demo.shufftextview.activity;

import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.DateUtils;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.demo.shufftextview.R;
import com.demo.shufftextview.customspan.AnimatedColorSpan;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AnimateRainSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate_rain_span);
        ButterKnife.bind(this);
        AnimatedColorSpan span = new AnimatedColorSpan(this);
        String content = getString(R.string.long_span);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        final SpannableString spannableString = new SpannableString(ssb);
        String substring = getString(R.string.short_span);
        int start = content.indexOf(substring);
        int end = start + substring.length();
        spannableString.setSpan(span, start, end, 0);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
                span, AnimatedColorSpan.ANIMATED_COLOR_SPAN_FLOAT_PROPERTY, 0, 100);
        objectAnimator.setEvaluator(new FloatEvaluator());
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mTvContent.setText(spannableString);
            }
        });
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setDuration(DateUtils.MINUTE_IN_MILLIS * 3);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.start();
    }

}
