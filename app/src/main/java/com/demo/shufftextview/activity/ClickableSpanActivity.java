package com.demo.shufftextview.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Browser;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.demo.shufftextview.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ClickableSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickable_span);
        ButterKnife.bind(this);
        String content = getString(R.string.url_span);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        SpanClickableSpan spanClickableSpan = new SpanClickableSpan(0xffFF4081, new ClickableSpanNoUnderline.OnClickListener<SpanClickableSpan>() {
            /**
             * ClickableSpan被点击
             *
             * @param widget widget
             * @param span   span
             */
            @Override
            public void onClick(View widget, SpanClickableSpan span) {
                String urlString = span.getUrlString();
                if (TextUtils.isEmpty(urlString))
                    return;
                Uri uri = Uri.parse(urlString);
                Context context = widget.getContext();
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.getPackageName());
                try {
                    context.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.w("URLSpan", "Activity was not found for intent, " + intent.toString());
                }
            }
        });
        spanClickableSpan.setUrlString("https://github.com/coding404");
        ssb.setSpan(spanClickableSpan, 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvContent.setText(ssb);
// 在单击链接时凡是有要执行的动作，都必须设置MovementMethod对象
        mTvContent.setMovementMethod(LinkMovementMethod.getInstance());
// 设置点击后的颜色，这里涉及到ClickableSpan的点击背景
        mTvContent.setHighlightColor(0x00000000);

    }

    public static class ClickableSpanNoUnderline extends ClickableSpan {

        private static final String TAG = "ClickableSpan";

        private static final int NO_COLOR = -206;
        private int color;

        private OnClickListener onClickListener;

        public ClickableSpanNoUnderline(int color, OnClickListener onClickListener) {
            super();
            this.color = color;
            this.onClickListener = onClickListener;
        }

        public ClickableSpanNoUnderline(OnClickListener onClickListener) {
            this(NO_COLOR, onClickListener);
        }

        /**
         * Makes the text underlined and in the link color.
         *
         * @param ds
         */
        @Override
        public void updateDrawState(@NonNull TextPaint ds) {
            super.updateDrawState(ds);
            // 设置文字颜色
            if (this.color == NO_COLOR) {
                ds.setColor(ds.linkColor);
            } else {
                ds.setColor(this.color);
            }
            ds.clearShadowLayer();
            // 去除下划线
            ds.setUnderlineText(false);
            ds.bgColor = Color.TRANSPARENT;
        }

        /**
         * Performs the click action associated with this span.
         *
         * @param widget widget
         */
        @Override
        public void onClick(View widget) {
            if (this.onClickListener != null) {
                this.onClickListener.onClick(widget, this);
            } else {
                Log.w(TAG, "listener was null");
            }
        }

        /**
         * 回调接口，回调自身的onClick事件
         * 告诉外部 是否被点击
         */
        public interface OnClickListener<T extends ClickableSpanNoUnderline> {
            /**
             * ClickableSpan被点击
             *
             * @param widget widget
             * @param span   span
             */
            void onClick(View widget, T span);
        }

    }

    private class SpanClickableSpan extends ClickableSpanNoUnderline {

        private String urlString;

        public String getUrlString() {
            return urlString;
        }

        public void setUrlString(String urlString) {
            this.urlString = urlString;
        }

        public SpanClickableSpan(int color, OnClickListener onClickListener) {
            super(color, onClickListener);
        }

        public SpanClickableSpan(OnClickListener onClickListener) {
            super(onClickListener);
        }

    }
}
