package com.mw.eleven11.UI.facebook;

import android.os.Bundle;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.mw.eleven11.R;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.NetworkUtils;

import org.json.JSONObject;

import java.util.Arrays;


public class FacebookPresenterImpl implements IFacebookPresenter {

    FacebookView mFacebookView;
    public CallbackManager callbackManager;
    LoginButton loginButton;

    public FacebookPresenterImpl(final FacebookView mFacebookView) {
        this.mFacebookView = mFacebookView;
        callbackManager = CallbackManager.Factory.create();
        loginButton = new LoginButton(mFacebookView.getContext());
        loginButton.setReadPermissions(Arrays.asList("public_profile", "email"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                System.out.println("onSuccess");
                String accessToken = loginResult.getAccessToken().getToken();
                Log.i("accessToken", accessToken);
                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {

                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {

                        if (object != null) {
                            Log.e("facebook data", object.toString());
                            try {
                                String firstName = "", lastName = "", email = "", id = "", gender = "";
                                if (object.has("first_name"))
                                    firstName = object.getString("first_name");
                                if (object.has("last_name"))
                                    lastName = object.getString("last_name");
                                if (object.has("email"))
                                    email = object.getString("email");
                                if (object.has("id"))
                                    id = object.getString("id");
                                if (object.has("gender"))
                                    gender = object.getString("gender");


                                mFacebookView.facebookSuccess(id, firstName, lastName, email, gender);
                               // Toast.makeText(mFacebookView.getContext(), "FbLogin Success", Toast.LENGTH_SHORT).show();

                            } catch (Exception e) {
                                e.printStackTrace();
                                mFacebookView.facebookFailure(e.getMessage() + " " + object.toString());
                            }
                        } else {
                            mFacebookView.facebookFailure(AppUtils.getStrFromRes(R.string.network_error));
                        }
                        mFacebookView.hideLoading();
                        LoginManager.getInstance().logOut();
                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,first_name,last_name,email"); // Parámetros que pedimos a facebook
                request.setParameters(parameters);
                request.executeAsync();
                mFacebookView.showLoading();
            }

            @Override
            public void onError(FacebookException error) {
                mFacebookView.facebookFailure(error.getMessage() + "");
            }

            @Override
            public void onCancel() {
                mFacebookView.facebookFailure(AppUtils.getStrFromRes(R.string.action_canceled));
            }
        });

    }

    @Override
    public void actionFacebookBtn() {

        if (!NetworkUtils.isNetworkConnected(mFacebookView.getContext())) {
            mFacebookView.facebookFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            loginButton.performClick();
        }
    }
}
