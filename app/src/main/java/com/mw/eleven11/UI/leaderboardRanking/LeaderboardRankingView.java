package com.mw.eleven11.UI.leaderboardRanking;

import com.mw.eleven11.beanOutput.RankingOutput;
import com.mw.eleven11.beanOutput.SeriesOutput;



public interface LeaderboardRankingView {

    void showLoading();

    void hideLoading();

    void showSnackBar(String message);

    void onMatchSeriesSuccess(SeriesOutput responseMatchSeries);

    void onMatchSeriesFailure(String errMsg);

    void onOverAllLeaderboardSuccess(RankingOutput responseOverallLeaderboard);

    void onOverAllLeaderboardFailure(String errMsg);
}
