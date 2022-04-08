package com.mw.eleven11.UI.favoriteTeam;

import android.content.Context;

import com.mw.eleven11.beanOutput.DefaultRespose;
import com.mw.eleven11.beanOutput.ResponseFavoriteTeam;


/**
 *
 */

public interface FavoriteTeamView {
    void showLoading();

    void hideLoading();

    void onGetFavoriteTeamSuccess(ResponseFavoriteTeam responseBanner);

    void onFavoriteTeamFailure(String errMsg);

    void onMakeFavoriteTeamSuccess(DefaultRespose responseBanner);

    void onMakeFavoriteTeamFailure(String errMsg);

    void onFavoriteTeamNotFound(String errMsg);

    void onShowSnackBar(String message);

    boolean isAttached();

    Context getContext();
}
