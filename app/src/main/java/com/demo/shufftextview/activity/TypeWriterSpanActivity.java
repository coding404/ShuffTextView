package com.demo.shufftextview.activity;

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
import com.demo.shufftextview.customspan.TypeWriterSpanGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TypeWriterSpanActivity extends Activity {

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
        setContentView(R.layout.activity_type_writer_span);
        ButterKnife.bind(this);
        mTvTitle.setText(R.string.typewriter_span);
        mSmoothInterpolator = new AccelerateDecelerateInterpolator();
        String content = getString(R.string.long_span);
        final TypeWriterSpanGroup group = new TypeWriterSpanGroup(0);
        final SpannableString spannableString = new SpannableString(content);
        for (int index = 0; index < content.length(); index++) {
            MutableForegroundColorSpan span = new MutableForegroundColorSpan(0, Color.BLACK);
            group.addSpan(span);
            spannableString.setSpan(span, index, index + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(group, TYPE_WRITER_GROUP_ALPHA_PROPERTY, 0.0f, 1.0f);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //refresh
                mTvContent.setText(spannableString);
            }
        });
        objectAnimator.setInterpolator(mSmoothInterpolator);
        objectAnimator.setDuration(15000);
        objectAnimator.start();
    }

    private final Property<TypeWriterSpanGroup, Float> TYPE_WRITER_GROUP_ALPHA_PROPERTY =new Property<TypeWriterSpanGroup, Float>(Float.class, "TYPE_WRITER_GROUP_ALPHA_PROPERTY") {

                @Override
                public void set(TypeWriterSpanGroup spanGroup, Float value) {
                    spanGroup.setAlpha(value);
                }

                @Override
                public Float get(TypeWriterSpanGroup spanGroup) {
                    return spanGroup.getAlpha();
                }
            };

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
