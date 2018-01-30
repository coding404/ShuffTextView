package com.demo.shufftextview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.shufftextview.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class UrlSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.iv_back)
    ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_span);
        ButterKnife.bind(this);
        mTvTitle.setText(R.string.url_span);
        String content = getString(R.string.text_content);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        ssb.setSpan(new URLSpan(getString(R.string.url_github_project)), 0, 3, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTvContent.setText(ssb);
// 在单击链接时凡是有要执行的动作，都必须设置MovementMethod对象
        mTvContent.setMovementMethod(LinkMovementMethod.getInstance());
// 设置点击后的颜色，这里涉及到ClickableSpan的点击背景
        mTvContent.setHighlightColor(0xff8FABCC);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
