package com.demo.shufftextview.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.demo.shufftextview.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Method02Activity extends Activity {

    @Bind(R.id.tv_content01)
    TextView mTvContent01;
    @Bind(R.id.tv_content02)
    TextView mTvContent02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method02);
        ButterKnife.bind(this);
        String html01 = getString(R.string.different_color_text);
        mTvContent01.setText(Html.fromHtml(html01));
        String html = getString(R.string.from_html_text);
        mTvContent02.setText(Html.fromHtml(html));
        /*让链接可点击*/
        mTvContent02.setMovementMethod(LinkMovementMethod.getInstance());
/*ResouroceImageGetter用来处理TextView中的图片*/
        mTvContent02.setText(Html.fromHtml(html, new ResouroceImageGetter(this), null));
    }

    private static class ResouroceImageGetter implements Html.ImageGetter {

        private Context mContext;

        public ResouroceImageGetter(Context context) {
            mContext = context.getApplicationContext();
        }

        // Constructor takes a Context
        public Drawable getDrawable(String source) {
            int path = mContext.getResources().getIdentifier(source, "drawable", "");
            Drawable drawable = mContext.getResources().getDrawable(path);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            return drawable;
        }
    }
}
