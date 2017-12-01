package com.demo.shufftextview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.TypefaceSpan;
import android.widget.TextView;

import com.demo.shufftextview.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TypeFaceSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_face_span);
        ButterKnife.bind(this);
        String content = getString(R.string.url_span);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        ssb.setSpan(new TypefaceSpan("serif"), 0, 3, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        ssb.setSpan(new TypefaceSpan("serif"), 4, 9, Spanned.SPAN_COMPOSING);
        ssb.setSpan(new TypefaceSpan("serif"), 13, 17, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mTvContent.setText(ssb);
    }
}
