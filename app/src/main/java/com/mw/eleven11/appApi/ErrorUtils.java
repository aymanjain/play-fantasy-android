package com.mw.eleven11.appApi;

import android.util.Log;

import com.mw.eleven11.R;
import com.mw.eleven11.utility.AppUtils;

import java.lang.annotation.Annotation;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * manage api response errors.
 */
public class ErrorUtils {
    public static APIError parseError(Response<?> response) {
        Converter<ResponseBody, APIError> converter = ServiceGenerator.getRetrofit().responseBodyConverter(APIError.class, new Annotation[0]);
        APIError error = new APIError();
        error.setStatus_code(010);

        try {
            Log.e("ErrorUtils", "Service Error Body : " + response.body().toString());
            error = converter.convert(response.errorBody());
        } catch (Exception e) {
            APIError networkError = new APIError();
            if (response.code() == 404) {
                networkError.setStatus_code(404);
                networkError.setMessage(AppUtils.getStrFromRes(R.string.pageNotFound));
                return networkError;
            } else if (response.code() == 400) {
                networkError.setStatus_code(400);
                networkError.setMessage(AppUtils.getStrFromRes(R.string.OAuthException));
                return networkError;
            } else if (response.code() == 403) {
                networkError.setStatus_code(403);
                networkError.setMessage(AppUtils.getStrFromRes(R.string.pageNotFound));
                return networkError;
            } else if (response.code() == 405) {
                networkError.setStatus_code(405);
                networkError.setMessage(AppUtils.getStrFromRes(R.string.invalidSession));
                return networkError;
            } else if (response.code() == 500) {
                networkError.setStatus_code(500);
                networkError.setMessage(AppUtils.getStrFromRes(R.string.internalErrorTryAgain));
                return networkError;
            } else if (e.getCause() instanceof SocketTimeoutException) {
                networkError.setStatus_code(000);
                networkError.setMessage(AppUtils.getStrFromRes(R.string.poorConnection));
                return networkError;
            } else if (e.getCause() instanceof UnknownHostException || e.getCause() instanceof ConnectException) {
                networkError.setStatus_code(000);
                networkError.setMessage(AppUtils.getStrFromRes(R.string.noConnection));
                return networkError;
            } else {
                networkError.setStatus_code(000);
                networkError.setMessage(AppUtils.getStrFromRes(R.string.tryAgain));
                return networkError;
            }
        }
        return error;
    }
}
