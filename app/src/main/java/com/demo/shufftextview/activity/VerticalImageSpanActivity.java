package com.demo.shufftextview.activity;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.shufftextview.R;
import com.demo.shufftextview.customspan.VerticalImageSpan;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VerticalImageSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.iv_back)
    ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_image_span);
        ButterKnife.bind(this);
        mTvTitle.setText(R.string.vertical_image_span);
        String content = getString(R.string.long_span);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        Drawable drawable = getDrawable(R.mipmap.ic_launcher);
        ssb.setSpan(new VerticalImageSpan(drawable), 10, 15, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTvContent.setText(ssb);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
