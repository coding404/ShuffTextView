package com.demo.shufftextview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.TabStopSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.shufftextview.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TabStopSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.iv_back)
    ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_stop_span);
        ButterKnife.bind(this);
        mTvTitle.setText(R.string.tab_stop_span);
        String content = getString(R.string.text_content);
        String[] subs = content.split(" ");
        SpannableStringBuilder ssb = new SpannableStringBuilder();
/**
 * TabStopSpan. Standard related to \t and \n
 * TabStopSpan.Standard 跟 \t 和 \n 有关系
 */
        for (String sub1 : subs) {
            ssb.append("\t").append(sub1).append(" ");
            ssb.append("\n");
        }
        ssb.setSpan(new TabStopSpan.Standard(126), 0, ssb.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTvContent.setText(ssb);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
