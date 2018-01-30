package com.demo.shufftextview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.shufftextview.R;
import com.demo.shufftextview.customspan.RainbowSpan;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RainbowSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.iv_back)
    ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainbow_span);
        ButterKnife.bind(this);
        mTvTitle.setText(R.string.rainbow_span);
        String content = getString(R.string.long_span);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        ssb.setSpan(new RainbowSpan(this), 10, 15, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTvContent.setText(ssb);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
