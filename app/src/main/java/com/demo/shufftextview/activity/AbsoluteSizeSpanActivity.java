package com.demo.shufftextview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.shufftextview.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AbsoluteSizeSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.iv_back)
    ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absolute_size_span);
        ButterKnife.bind(this);
        mTvTitle.setText(R.string.absolute_size_span);
        String content = getString(R.string.text_content);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        ssb.setSpan(new AbsoluteSizeSpan(26, true), 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvContent.setText(ssb);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
