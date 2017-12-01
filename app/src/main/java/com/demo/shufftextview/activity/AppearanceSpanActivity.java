package com.demo.shufftextview.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.demo.shufftextview.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AppearanceSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appearance_span);
        ButterKnife.bind(this);
        // TODO: 2017/11/30 先看看再做
      /*  String content = getString(R.string.url_span);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        ColorStateList colorStateList = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            colorStateList = this.getColorStateList(R.color.selector_apperarance_span);
        } else {
            try {
                colorStateList = ColorStateList.createFromXml(this.getResources(), this.getResources().getXml(R.color.selector_apperarance_span));
            } catch (XmlPullParserException | IOException e) {
                e.printStackTrace();
            }
        }
        ssb.setSpan(new TextAppearanceSpan("serif", Typeface.BOLD_ITALIC, this.getResources().getDimensionPixelSize(R.dimen.text_appearance_span),
                colorStateList, colorStateList), 0, 5, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTvContent.setText(ssb);*/
    }
}
