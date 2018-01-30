package com.demo.shufftextview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AlignmentSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.shufftextview.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AlignmentSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.iv_back)
    ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alignment_span);
        ButterKnife.bind(this);
        mTvTitle.setText(R.string.alignment_span);
        String content = getString(R.string.text_content);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        ssb.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, ssb.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvContent.setText(ssb);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
