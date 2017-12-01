package com.demo.shufftextview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BulletSpan;
import android.widget.TextView;

import com.demo.shufftextview.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BulletSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bullet_span);
        ButterKnife.bind(this);
        String content = getString(R.string.url_span);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        ssb.setSpan(new BulletSpan(66, 0xff303F9F), 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvContent.setText(ssb);
    }
}
