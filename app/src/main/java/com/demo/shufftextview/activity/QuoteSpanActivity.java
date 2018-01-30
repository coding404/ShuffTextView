package com.demo.shufftextview.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.QuoteSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.shufftextview.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuoteSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.iv_back)
    ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_span);
        ButterKnife.bind(this);
        mTvTitle.setText(R.string.quote_span);
        String content = getString(R.string.text_content);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        ssb.setSpan(new QuoteSpan(Color.RED), 0, 3, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTvContent.setText(ssb);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
