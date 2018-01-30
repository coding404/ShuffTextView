package com.demo.shufftextview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TextAppearanceSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.shufftextview.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AppearanceSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.iv_back)
    ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appearance_span);
        ButterKnife.bind(this);
        mTvTitle.setText(R.string.text_appeance_span);
        String content = getString(R.string.text_content);
        SpannableString styledText = new SpannableString(content);
        styledText.setSpan(new TextAppearanceSpan(this, R.style.style_black), 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        styledText.setSpan(new TextAppearanceSpan(this, R.style.style_red), 3, styledText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvContent.setText(styledText);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
