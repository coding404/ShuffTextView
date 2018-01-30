package com.demo.shufftextview.activity;

import android.app.Activity;
import android.graphics.BlurMaskFilter;
import android.graphics.EmbossMaskFilter;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.MaskFilterSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.shufftextview.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MaskFilterSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.iv_back)
    ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mask_filter_span);
        ButterKnife.bind(this);
        mTvTitle.setText(R.string.mask_filter_span);
        String content = getString(R.string.text_content);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        MaskFilterSpan embossMaskFilterSpan = new MaskFilterSpan(new EmbossMaskFilter(new float[]{3, 3, 9}, 3.0f, 12, 16));
        ssb.setSpan(embossMaskFilterSpan, 0, 3, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTvContent.setText(ssb);
        String you = "any";
        int indexYou = content.indexOf(you);
        MaskFilterSpan blurMaskFilterSpan = new MaskFilterSpan(new BlurMaskFilter(3, BlurMaskFilter.Blur.OUTER));
        ssb.setSpan(blurMaskFilterSpan, indexYou, indexYou + you.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTvContent.setText(ssb);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
