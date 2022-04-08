package com.mw.eleven11.utility;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.File;

import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomTextView;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;


public class ViewUtils {

    public static float pxToDp(float px) {
        float densityDpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        return px / (densityDpi / 160f);
    }

    public static int dpToPx(int dp) {
        float density = Resources.getSystem().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    public static void hideKeyboardOnStartActivity(Context context) {
        ((Activity) context).getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    public static void setImageTintList(ImageView imageView, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imageView.setImageTintList(colorStateList);
        } else {
            Drawable drawable = imageView.getDrawable();

            if (drawable != null) {
                Drawable wrapped = DrawableCompat.wrap(drawable);
                DrawableCompat.setTintList(wrapped, colorStateList);
                imageView.setImageDrawable(wrapped);
            }
        }
    }

    public static void hideKeyboard(Context context) {
        View view = ((Activity) context).getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void hideStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT < 16) {
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    public static void setUnderline(CustomTextView customTextView) {
        SpannableString content = new SpannableString(customTextView.getText().toString());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        customTextView.setText(content);
        customTextView.setLinkTextColor(Color.parseColor("#636ED8"));
    }

    public static void setColorUnderline(CustomTextView customTextView, int color) {
        SpannableString content = new SpannableString(customTextView.getText().toString());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        customTextView.setText(content);
        customTextView.setLinkTextColor(color);
    }

    public static void doColorSpanForFirstString(CustomTextView txtSpan, String colorCode, String firstString, String lastString) {

        String changeString = (firstString != null ? firstString : "");
        String totalString = changeString + lastString;
        Spannable spanText = new SpannableString(totalString);
        spanText.setSpan(new ForegroundColorSpan(Color.parseColor(colorCode)), 0, changeString.length(), 0);
        txtSpan.setText(spanText);
    }

    public static void doColorSpanForFirstString(CustomTextView txtSpan, String firstString, String lastString) {

        String changeString = (firstString != null ? firstString : "");
        String totalString = changeString + lastString;
        Spannable spanText = new SpannableString(totalString);
        spanText.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, changeString.length(), 0);
        txtSpan.setText(spanText);
    }

    public static void doStyleSpanForFirstString(CustomTextView txtSpan, String firstString, String lastString) {
        String changeString = (firstString != null ? firstString : "");
        String totalString = changeString + lastString;
        Spannable spanText = new SpannableString(totalString);
        spanText.setSpan(new StyleSpan(Typeface.BOLD), 0, changeString.length(), 0);
        txtSpan.setText(spanText);
    }

    public static void makeLinks(CustomTextView textView, String[] links, ClickableSpan[] clickableSpans, String colorCode) {
        SpannableString spannableString = new SpannableString(textView.getText());

        for (int i = 0; i < links.length; i++) {
            ClickableSpan clickableSpan = clickableSpans[i];
            String link = links[i];

            int startIndexOfLink = textView.getText().toString().indexOf(link);
            spannableString.setSpan(new StyleSpan(Typeface.BOLD), startIndexOfLink, startIndexOfLink + link.length(), 0);
            spannableString.setSpan(clickableSpan, startIndexOfLink, startIndexOfLink + link.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(colorCode)), startIndexOfLink, startIndexOfLink + link.length(), 0);

        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString, CustomTextView.BufferType.SPANNABLE);
    }

    public static String getSortTeamName(String name) {
        if (TextUtils.isEmpty(name)) return "";

        String[] fname = name.split(" ");
        if (fname != null && fname.length > 1) {
            return ("(" + fname[0].charAt(0) + "").toUpperCase() + fname[1] + ")";
        }

        return name;
    }


    public static String getPlayerName(String name) {
        if (TextUtils.isEmpty(name)) return "";

        String[] fname = name.trim().split(" ");
        if (fname != null && fname.length > 1) {
            return (fname[0].charAt(0) + ".").toUpperCase() + " " + fname[1];
        }

        return name;
    }

    public static String getScore(String in1, String in2) {
        String score = "";
        if (!in1.equals("0")) {
            score = in1;
        }
        if (!in2.equals("0")) {
            if (!TextUtils.isEmpty(score))
                score = score + " & " + in2;
            else score = in2;
        }
        return score;
    }

    public static int getPercentage(float joined, int total) {
        float per = (100 * joined) / total;
        return per > 0 && per < 1 ? 1 : (int) per;
    }

    public static void setImageUrl(CustomImageView imageView, String url) {
        try {
            if (url != null) {
                if (FileUtil.isValidUrl(url)) {
                    Uri uri = Uri.parse(url);
                    ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                            .setCacheChoice(ImageRequest.CacheChoice.DEFAULT)
                            .build();
                    imageView.setController(
                            Fresco.newDraweeControllerBuilder()
                                    .setOldController(imageView.getController())
                                    .setImageRequest(request)
                                    .build());
                } else {
                    setImagePath(imageView, url);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setImagePath(CustomImageView imageView, String path) {
        try {
            Uri uri = Uri.fromFile(new File(path));
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                    .setCacheChoice(ImageRequest.CacheChoice.DEFAULT)
                    .build();
            imageView.setController(
                    Fresco.newDraweeControllerBuilder()
                            .setOldController(imageView.getController())
                            .setImageRequest(request)
                            .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setImageUri(SimpleDraweeView imageView, Uri path) {
        try {
            DraweeController controller =
                    Fresco.newDraweeControllerBuilder()
                            .setUri(path)
                            .setAutoPlayAnimations(true)
                            .build();

            imageView.setController(controller);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Drawable generateBackgroundWithShadow(View view, @ColorRes int backgroundColor,
                                                        @DimenRes int cornerRadius,
                                                        @ColorRes int shadowColor,
                                                        @DimenRes int elevation,
                                                        int shadowGravity) {
        float cornerRadiusValue = view.getContext().getResources().getDimension(cornerRadius);
        int elevationValue = (int) view.getContext().getResources().getDimension(elevation);
        int shadowColorValue = ContextCompat.getColor(view.getContext(), shadowColor);
        int backgroundColorValue = ContextCompat.getColor(view.getContext(), backgroundColor);

        float[] outerRadius = {cornerRadiusValue, cornerRadiusValue, cornerRadiusValue,
                cornerRadiusValue, cornerRadiusValue, cornerRadiusValue, cornerRadiusValue,
                cornerRadiusValue};

        Paint backgroundPaint = new Paint();
        backgroundPaint.setStyle(Paint.Style.FILL);
        backgroundPaint.setShadowLayer(cornerRadiusValue, 0, 0, 0);

        Rect shapeDrawablePadding = new Rect();
        shapeDrawablePadding.left = elevationValue;
        shapeDrawablePadding.right = elevationValue;

        int DY;
        switch (shadowGravity) {
            case Gravity.CENTER:
                shapeDrawablePadding.top = elevationValue;
                shapeDrawablePadding.bottom = elevationValue;
                DY = 0;
                break;
            case Gravity.TOP:
                shapeDrawablePadding.top = elevationValue * 2;
                shapeDrawablePadding.bottom = elevationValue;
                DY = -1 * elevationValue / 3;
                break;
            default:
            case Gravity.BOTTOM:
                shapeDrawablePadding.top = elevationValue;
                shapeDrawablePadding.bottom = elevationValue * 2;
                DY = elevationValue / 3;
                break;
        }

        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setPadding(shapeDrawablePadding);

        shapeDrawable.getPaint().setColor(backgroundColorValue);
        shapeDrawable.getPaint().setShadowLayer(cornerRadiusValue / 3, 0, DY, shadowColorValue);

        view.setLayerType(View.LAYER_TYPE_SOFTWARE, shapeDrawable.getPaint());

        shapeDrawable.setShape(new RoundRectShape(outerRadius, null, null));

        LayerDrawable drawable = new LayerDrawable(new Drawable[]{shapeDrawable});
        drawable.setLayerInset(0, elevationValue, elevationValue * 2, elevationValue, elevationValue * 2);

        return drawable;

    }

    public static void load(@NotNull String url, @NotNull ImageView view, CircleTransform transformation) {
        if (url.isEmpty())
            return;
        Picasso.get().load(url).transform((com.squareup.picasso.Transformation) transformation).into(view);
    }


    public static void load(@NotNull String url, @NotNull ImageView view) {
        if (url.isEmpty())
            return;
        Picasso.get().load(url).into(view);
    }
}
