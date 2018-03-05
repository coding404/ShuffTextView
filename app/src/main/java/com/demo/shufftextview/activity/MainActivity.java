package com.demo.shufftextview.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.demo.shufftextview.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {


    @Bind(R.id.tv_method01)
    TextView mTvMethod01;
    @Bind(R.id.tv_method02)
    TextView mTvMethod02;
    @Bind(R.id.tv_url_span)
    TextView mTvUrlSpan;
    @Bind(R.id.tv_underline_span)
    TextView mTvUnderlineSpan;
    @Bind(R.id.tv_typeface_span)
    TextView mTvTypefaceSpan;
    @Bind(R.id.tv_text_appearance_span)
    TextView mTvTextAppearanceSpan;
    @Bind(R.id.tv_tab_stop_span)
    TextView mTvTabStopSpan;
    @Bind(R.id.tv_superscript_span)
    TextView mTvSuperscriptSpan;
    @Bind(R.id.tv_subscript_span)
    TextView mTvSubscriptSpan;
    @Bind(R.id.tv_strikethrough_span)
    TextView mTvStrikethroughSpan;
    @Bind(R.id.tv_scalex_span)
    TextView mTvScalexSpan;
    @Bind(R.id.tv_style_span)
    TextView mTvStyleSpan;
    @Bind(R.id.tv_relativesize_span)
    TextView mTvRelativesizeSpan;
    @Bind(R.id.tv_quote_span)
    TextView mTvQuoteSpan;
    @Bind(R.id.tv_maskfilter_span)
    TextView mTvMaskfilterSpan;
    @Bind(R.id.tv_leadmargin_span)
    TextView mTvLeadmarginSpan;
    @Bind(R.id.tv_image_span)
    TextView mTvImageSpan;
    @Bind(R.id.tv_iconmargin_span)
    TextView mTvIconmarginSpan;
    @Bind(R.id.tv_foregroundcolor_span)
    TextView mTvForegroundcolorSpan;
    @Bind(R.id.tv_drawablemargin_span)
    TextView mTvDrawablemarginSpan;
    @Bind(R.id.tv_bullet_span)
    TextView mTvBulletSpan;
    @Bind(R.id.tv_bgcolor_span)
    TextView mTvBgcolorSpan;
    @Bind(R.id.tv_alignment_span)
    TextView mTvAlignmentSpan;
    @Bind(R.id.tv_absolutesize_span)
    TextView mTvAbsolutesizeSpan;
    @Bind(R.id.tv_clickable_span)
    TextView mTvClickableSpan;
    @Bind(R.id.tv_frame_span)
    TextView mTvFrameSpan;
    @Bind(R.id.tv_vertical_image_span)
    TextView mTvVerticalImageSpan;
    @Bind(R.id.tv_animate_forecolor_span)
    TextView mTvAnimateForecolorSpan;
    @Bind(R.id.tv_rainbow_span)
    TextView mTvRainbowSpan;
    @Bind(R.id.tv_animate_rain_span)
    TextView mTvAnimateRainSpan;
    @Bind(R.id.tv_firework_span)
    TextView mTvFireworkSpan;
    @Bind(R.id.tv_type_writer_span)
    TextView mTvTypeWriterSpan;
    @Bind(R.id.tv_about_me)
    TextView mTvAboutMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.tv_method01, R.id.tv_method02, R.id.tv_url_span, R.id.tv_underline_span,
            R.id.tv_typeface_span, R.id.tv_text_appearance_span, R.id.tv_tab_stop_span, R.id.tv_superscript_span,
            R.id.tv_subscript_span, R.id.tv_strikethrough_span, R.id.tv_scalex_span, R.id.tv_style_span, R.id.tv_relativesize_span,
            R.id.tv_quote_span, R.id.tv_maskfilter_span, R.id.tv_leadmargin_span, R.id.tv_image_span, R.id.tv_iconmargin_span,
            R.id.tv_foregroundcolor_span, R.id.tv_drawablemargin_span, R.id.tv_bullet_span, R.id.tv_bgcolor_span,
            R.id.tv_alignment_span, R.id.tv_absolutesize_span, R.id.tv_clickable_span, R.id.tv_frame_span, R.id.tv_vertical_image_span,
            R.id.tv_animate_forecolor_span, R.id.tv_rainbow_span, R.id.tv_animate_rain_span, R.id.tv_firework_span, R.id.tv_type_writer_span, R.id.tv_about_me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_method01:
                Intent intent01 = new Intent(this, Method01Activity.class);
                startActivity(intent01);
                break;
            case R.id.tv_method02:
                Intent intent02 = new Intent(this, Method02Activity.class);
                startActivity(intent02);
                break;
            case R.id.tv_url_span:
                Intent intent04 = new Intent(this, UrlSpanActivity.class);
                startActivity(intent04);
                break;
            case R.id.tv_underline_span:
                Intent intent05 = new Intent(this, UnderLineSpanActivity.class);
                startActivity(intent05);
                break;
            case R.id.tv_typeface_span:
                Intent intent06 = new Intent(this, TypeFaceSpanActivity.class);
                startActivity(intent06);
                break;
            case R.id.tv_text_appearance_span:
                Intent intent07 = new Intent(this, AppearanceSpanActivity.class);
                startActivity(intent07);
                break;
            case R.id.tv_tab_stop_span:
                Intent intent08 = new Intent(this, TabStopSpanActivity.class);
                startActivity(intent08);
                break;
            case R.id.tv_superscript_span:
                Intent intent09 = new Intent(this, SuperScriptSpanActivity.class);
                startActivity(intent09);
                break;
            case R.id.tv_subscript_span:
                Intent intent10 = new Intent(this, SubScriptSpanActivity.class);
                startActivity(intent10);
                break;
            case R.id.tv_strikethrough_span:
                Intent intent11 = new Intent(this, StrikethoughSpanActivity.class);
                startActivity(intent11);
                break;
            case R.id.tv_scalex_span:
                Intent intent12 = new Intent(this, ScaleXSpanActivity.class);
                startActivity(intent12);
                break;
            case R.id.tv_style_span:
                Intent intent13 = new Intent(this, StyleSpanActivity.class);
                startActivity(intent13);
                break;
            case R.id.tv_relativesize_span:
                Intent intent14 = new Intent(this, RelativeSizeSpanActivity.class);
                startActivity(intent14);
                break;
            case R.id.tv_quote_span:
                Intent intent15 = new Intent(this, QuoteSpanActivity.class);
                startActivity(intent15);
                break;
            case R.id.tv_maskfilter_span:
                Intent intent16 = new Intent(this, MaskFilterSpanActivity.class);
                startActivity(intent16);
                break;
            case R.id.tv_leadmargin_span:
                Intent intent17 = new Intent(this, LeadingMarginSpanActivity.class);
                startActivity(intent17);
                break;
            case R.id.tv_image_span:
                Intent intent18 = new Intent(this, ImageSpanActivity.class);
                startActivity(intent18);
                break;
            case R.id.tv_iconmargin_span:
                Intent intent19 = new Intent(this, IconMarginSpanActivity.class);
                startActivity(intent19);
                break;
            case R.id.tv_foregroundcolor_span:
                Intent intent20 = new Intent(this, ForegroundColorSpanActivity.class);
                startActivity(intent20);
                break;
            case R.id.tv_drawablemargin_span:
                Intent intent21 = new Intent(this, DrawableMarginSpanActivity.class);
                startActivity(intent21);
                break;
            case R.id.tv_bullet_span:
                Intent intent22 = new Intent(this, BulletSpanActivity.class);
                startActivity(intent22);
                break;
            case R.id.tv_bgcolor_span:
                Intent intent23 = new Intent(this, BackgroundColorSpanActivity.class);
                startActivity(intent23);
                break;
            case R.id.tv_alignment_span:
                Intent intent24 = new Intent(this, AlignmentSpanActivity.class);
                startActivity(intent24);
                break;
            case R.id.tv_absolutesize_span:
                Intent intent25 = new Intent(this, AbsoluteSizeSpanActivity.class);
                startActivity(intent25);
                break;
            case R.id.tv_clickable_span:
                Intent intent26 = new Intent(this, ClickableSpanActivity.class);
                startActivity(intent26);
                break;
            case R.id.tv_frame_span:
                Intent intent27 = new Intent(this, FrameSpanActivity.class);
                startActivity(intent27);
                break;
            case R.id.tv_vertical_image_span:
                Intent intent28 = new Intent(this, VerticalImageSpanActivity.class);
                startActivity(intent28);
                break;
            case R.id.tv_animate_forecolor_span:
                Intent intent29 = new Intent(this, AnimateForeColorSpanActivity.class);
                startActivity(intent29);
                break;
            case R.id.tv_rainbow_span:
                Intent intent30 = new Intent(this, RainbowSpanActivity.class);
                startActivity(intent30);
                break;
            case R.id.tv_animate_rain_span:
                Intent intent31 = new Intent(this, AnimateRainSpanActivity.class);
                startActivity(intent31);
                break;
            case R.id.tv_firework_span:
                Intent intent32 = new Intent(this, FireworkSpanActivity.class);
                startActivity(intent32);
                break;
            case R.id.tv_type_writer_span:
                Intent intent33 = new Intent(this, TypeWriterSpanActivity.class);
                startActivity(intent33);
                break;
            case R.id.tv_about_me:
                Intent intent = new Intent(this, AboutMeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
