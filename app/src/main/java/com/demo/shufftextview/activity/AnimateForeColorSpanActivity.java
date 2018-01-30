package com.demo.shufftextview.activity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.Property;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.shufftextview.R;
import com.demo.shufftextview.customspan.MutableForegroundColorSpan;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimateForeColorSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    private AccelerateDecelerateInterpolator mSmoothInterpolator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate_fore_color_span);
        ButterKnife.bind(this);
        mTvTitle.setText(R.string.animate_foreground_color_span);
        mSmoothInterpolator = new AccelerateDecelerateInterpolator();
        MutableForegroundColorSpan span = new MutableForegroundColorSpan(255, Color.BLUE);
        String content = getString(R.string.long_span);
        final SpannableString spannableString = new SpannableString(content);
        spannableString.setSpan(span, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(span, MUTABLE_FOREGROUND_COLOR_SPAN_FC_PROPERTY, Color.BLACK, Color.RED, Color.BLUE);
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //refresh
                mTvContent.setText(spannableString);
            }
        });
        objectAnimator.setInterpolator(mSmoothInterpolator);
        objectAnimator.setDuration(1600);
        objectAnimator.start();
    }

    private static final Property<MutableForegroundColorSpan, Integer> MUTABLE_FOREGROUND_COLOR_SPAN_FC_PROPERTY =
            new Property<MutableForegroundColorSpan, Integer>(Integer.class, "MUTABLE_FOREGROUND_COLOR_SPAN_FC_PROPERTY") {

                @Override
                public void set(MutableForegroundColorSpan alphaForegroundColorSpanGroup, Integer value) {
                    alphaForegroundColorSpanGroup.setForegroundColor(value);
                }

                @Override
                public Integer get(MutableForegroundColorSpan span) {
                    return span.getForegroundColor();
                }
            };

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
