package com.demo.shufftextview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.TextView;

import com.demo.shufftextview.R;
import com.demo.shufftextview.customspan.RainbowSpan;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RainbowSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainbow_span);
        ButterKnife.bind(this);
        String content = getString(R.string.long_span);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        ssb.setSpan(new RainbowSpan(this), 10, 15, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTvContent.setText(ssb);
    }
}
