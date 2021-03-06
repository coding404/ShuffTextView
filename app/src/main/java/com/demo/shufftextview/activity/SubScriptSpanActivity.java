package com.demo.shufftextview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.SubscriptSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.shufftextview.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SubScriptSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.iv_back)
    ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_script_span);
        ButterKnife.bind(this);
        mTvTitle.setText(R.string.sub_script_span);
        String content = getString(R.string.text_content);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        ssb.replace(0, 3, "Save6");
        Parcel parcel = Parcel.obtain();
        parcel.writeInt(6);
        int sixPosition = ssb.toString().indexOf("6");
        ssb.setSpan(new SubscriptSpan(parcel), sixPosition, sixPosition + 1, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        parcel.recycle();
        mTvContent.setText(ssb);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
