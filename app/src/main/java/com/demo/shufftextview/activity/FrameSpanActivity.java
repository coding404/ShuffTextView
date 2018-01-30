package com.demo.shufftextview.activity;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.shufftextview.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrameSpanActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.iv_back)
    ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_span);
        ButterKnife.bind(this);
        mTvTitle.setText(R.string.frame_span);
        String content = getString(R.string.long_span);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        ssb.setSpan(new FrameSpan(), 10, 15, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTvContent.setText(ssb);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }

    public class FrameSpan extends ReplacementSpan {

        private final Paint mPaint;
        private int mWidth;

        public FrameSpan() {
            mPaint = new Paint();
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(Color.BLUE);
            mPaint.setAntiAlias(true);
        }

        @Override
        public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
            //return text with relative to the Paint
            mWidth = (int) paint.measureText(text, start, end);
            return mWidth;
        }

        @Override
        public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
            //draw the frame with custom Paint
            canvas.drawRect(x, top, x + mWidth, bottom, mPaint);
            canvas.drawText(text, start, end, x, y, paint);
        }
    }
}
