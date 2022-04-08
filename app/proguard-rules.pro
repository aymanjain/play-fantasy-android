# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


-ignorewarnings
-keep class * {      public private *;  }
-keep class java.awt.event.** { *; }
-keep class org.apache.** { *; }
-keep class org.gradle.** { *; }
-keep class groovy.lang.** { *; }
-keep class javax.swing.** { *; }



#
#-optimizationpasses 5
#-dontusemixedcaseclassnames
#-dontskipnonpubliclibraryclasses
#-dontpreverify
#-verbose
#-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

#-dontwarn com.facebook.animated.gif.GifImage
#-dontwarn com.razorpay.B$$J$$1
#-dontwarn com.razorpay.B$$J$$2
#-dontwarn com.razorpay.B_$q$
#-dontwarn com.razorpay.B_$q$$10
#-dontwarn com.razorpay.B_$q$$14
#-dontwarn com.razorpay.B_$q$$2
#-dontwarn com.razorpay.B_$q$$3
#-dontwarn com.razorpay.B_$q$$5
#-dontwarn com.razorpay.B_$q$$6
#-dontwarn com.razorpay.B_$q$$9
#-dontwarn com.razorpay.C__D$
#-dontwarn com.razorpay.J$_0_$9
#-dontwarn com.razorpay.L$$C_
#-dontwarn com.razorpay.MagicBridge
#-dontwarn com.razorpay.N$$J$
#-dontwarn com.razorpay.T__j$$3
#-dontwarn com.razorpay.T__j$$3
#-dontwarn com.razorpay.T__j$$5
#-dontwarn com.razorpay.T__j$$5
#-dontwarn com.razorpay.U$_z$
#-dontwarn com.razorpay.c__C_
#-dontwarn com.razorpay.n__T$
#-dontwarn org.joda.time.DateMidnight
#-dontwarn org.joda.time.DateTime
#-dontwarn org.joda.time.DateTimeZone
#-dontwarn org.joda.time.DateTimeZone
#-dontwarn org.joda.time.Days
#-dontwarn org.joda.time.Days
#-dontwarn org.joda.time.Duration
#-dontwarn org.joda.time.Hours
#-dontwarn org.joda.time.Hours
#-dontwarn org.joda.time.Instant
#-dontwarn org.joda.time.LocalDate
#-dontwarn org.joda.time.LocalDate
#-dontwarn org.joda.time.LocalDateTime
#-dontwarn org.joda.time.LocalDateTime
#-dontwarn org.joda.time.LocalTime
#-dontwarn org.joda.time.LocalTime
#-dontwarn org.joda.time.Minutes
#-dontwarn org.joda.time.Minutes
#-dontwarn org.joda.time.MonthDay
#-dontwarn org.joda.time.MonthDay
#-dontwarn org.joda.time.Months
#-dontwarn org.joda.time.Months
#-dontwarn org.joda.time.MutableDateTime
#-dontwarn org.joda.time.MutablePeriod
#-dontwarn org.joda.time.Period
#-dontwarn org.joda.time.Seconds
#-dontwarn org.joda.time.Seconds
#-dontwarn org.joda.time.Weeks
#-dontwarn org.joda.time.Weeks
#-dontwarn org.joda.time.YearMonth
#-dontwarn org.joda.time.YearMonth
#-dontwarn org.joda.time.Years
#-dontwarn org.joda.time.Years
#-dontwarn org.joda.time.base.AbstractDateTime
#-dontwarn org.joda.time.base.AbstractDuration
#-dontwarn org.joda.time.base.AbstractInstant
#-dontwarn org.joda.time.base.AbstractPeriod
#-dontwarn retrofit2.Platform$Java8
#
#-keep class com.squareup.okhttp.** { *; }
#-keep class retrofit.** { *; }
#-keep interface com.squareup.okhttp.** { *; }
#
#-dontwarn com.squareup.okhttp.**
#-dontwarn okio.**
#-dontwarn retrofit.**
#-dontwarn rx.**
#
#-keepclasseswithmembers class * {
#    @retrofit.http.* <methods>;
#}
#
## If in your rest service interface you use methods with Callback argument.
#-keepattributes Exceptions
#
## If your rest service methods throw custom exceptions, because you've defined an ErrorHandler.
#-keepattributes Signature
#
#
#
## Proguard configuration for amazon Jackson 2.x (fasterxml package instead of codehaus package)
#
#-keep class com.amazonaws.** { *; }
#-keepnames class com.amazonaws.** { *; }
#-dontwarn com.amazonaws.**
#-dontwarn com.fasterxml.**
#
#
#-keep public class com.google.android.gms.* { public *; }
#-dontwarn com.google.android.gms.**
#
#-dontwarn org.mockito.**
#-dontwarn sun.reflect.**
#-dontwarn android.test.**
#
#
#
#-dontwarn org.hamcrest.**
#-dontwarn android.test.**
#-dontwarn android.support.test.**
#
#-keep class org.hamcrest.** {
#   *;
#}
#
#-keep class org.junit.** { *; }
#-dontwarn org.junit.**
#
#-keep class junit.** { *; }
#-dontwarn junit.**
#
#-keep class sun.misc.** { *; }
#-dontwarn sun.misc.**
#
#
#-keep public class android.net.http.SslError
#-keep public class android.webkit.WebViewClient
#
#-dontwarn android.webkit.WebView
#-dontwarn android.net.http.SslError
#-dontwarn android.webkit.WebViewClient
#
#
#-keep class org.apache.http.** { *; }
#-dontwarn org.apache.http.**


#-dontwarn com.facebook.drawee.view.DraweeView
#-Keep class com.facebook.** {*;}
#-dontwarn class com.facebook.**
#-dontwarn com.facebook.drawee.view.SimpleDraweeView
#-dontwarn com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl
#-dontwarn com.facebook.login.widget.LoginButton
#-dontwarn com.facebook.login.widget.ProfilePictureView
#-dontwarn com.facebook.share.internal.LikeBoxCountView
#-dontwarn com.facebook.share.widget.LikeView
#-dontwarn com.google.android.gms.ads.identifier.AdvertisingIdClient
#-dontwarn com.google.android.gms.common.api.internal.LifecycleCallback
#-dontwarn com.google.android.gms.flags.impl.FlagProviderImpl
#-dontwarn com.google.firebase.analytics.connector.internal.AnalyticsConnectorRegistrar
#-dontwarn com.mw.eleven11.UI.SpinWheel.LuckyWheelView
#-dontwarn com.mw.eleven11.UI.SpinWheel.PielView
#-dontwarn com.mw.eleven11.customView.CustomEditText
#-dontwarn com.mw.eleven11.customView.CustomSpinner
#-dontwarn com.paytm.pgsdk.PaytmWebView
#-dontwarn com.rey.material.widget.CheckedTextView
#-dontwarn com.rey.material.widget.CircleCheckedTextView
#-dontwarn com.rey.material.widget.DatePicker
#-dontwarn com.rey.material.widget.EditText
#-dontwarn com.rey.material.widget.Slider
#-dontwarn com.rey.material.widget.Slider
#-dontwarn com.rey.material.widget.Spinner
#-dontwarn com.rey.material.widget.Spinner
#-dontwarn com.rey.material.widget.Switch
#-dontwarn com.rey.material.widget.TabIndicatorView
#-dontwarn com.rey.material.widget.TextView
#-dontwarn com.rey.material.widget.TimePicker
#-dontwarn com.rey.material.widget.YearPicker
#-dontwarn com.yalantis.ucrop.view.CropImageView
#-dontwarn com.yalantis.ucrop.view.TransformImageView
#-dontwarn com.yalantis.ucrop.view.widget.AspectRatioTextView
#-dontwarn com.yalantis.ucrop.view.widget.HorizontalProgressWheelView

