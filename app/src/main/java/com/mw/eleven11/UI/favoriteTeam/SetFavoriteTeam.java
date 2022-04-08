package com.mw.eleven11.UI.favoriteTeam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.FavoriteTeamInput;
import com.mw.eleven11.beanInput.MakeFavoriteTeamInput;
import com.mw.eleven11.beanOutput.DefaultRespose;
import com.mw.eleven11.beanOutput.ResponseFavoriteTeam;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.ItemOffsetDecoration;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SetFavoriteTeam extends BaseActivity implements FavoriteTeamView {

    FavoriteTeamPresenterImpl mFavoriteTeamPresenterImpl;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.linearlayout)
    LinearLayout mLinearLayout;

    @BindView(R.id.saveBtn)
    CustomTextView saveBtn;

    ProgressDialog mProgressDialog;

    ArrayList<String> mTeamList = new ArrayList<>();

    ArrayList<String> myList = new ArrayList<String>();

    Context mContext;
    // private Loader loader;
    FavoriteTeamAdapter adapter;
    List<ResponseFavoriteTeam.DataBean.RecordsBean> mFavoriteTeams;

    private OnItemClickListener.OnItemClickCallback onItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

        }
    };

    public static void start(Context context) {
        Intent starter = new Intent(context, SetFavoriteTeam.class);
        context.startActivity(starter);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {

        super.startActivityForResult(intent, 1);
    }

    @OnClick(R.id.back)
    void onBackClick() {

        finish();
    }

    @OnClick(R.id.saveBtn)
    void onSaveClcik() {

        for (int i=0;i<adapter.mSelectedTeamList.size();i++){
            myList.add(adapter.mSelectedTeamList.get(i));
        }

        if (adapter.mSelectedTeamList.size() != 0) {
            MakeFavoriteTeamInput makeFavoriteTeamInput = new MakeFavoriteTeamInput();

            makeFavoriteTeamInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            makeFavoriteTeamInput.setCountryTeamName(myList);

            mFavoriteTeamPresenterImpl.actionMakefavoriteTeamList(makeFavoriteTeamInput);

            Intent returnIntent = new Intent();
            returnIntent.putStringArrayListExtra("favouriteTeamsList",myList);
            setResult(Activity.RESULT_OK,returnIntent);
            finish();
        }else {
            onShowSnackBar("Please select at-least one team");
            return;
        }


    }

    @Override
    public int getLayout() {


        return R.layout.set_favorite_team;
    }

    @Override
    public void init() {

        mContext = this;
        mFavoriteTeamPresenterImpl = new FavoriteTeamPresenterImpl(this, new UserInteractor());

        callTask();

        /*if (getIntent().hasExtra("mTeamList")) {
            mTeamList = getIntent().getStringArrayListExtra("mTeamList");
        }*/

    }

    public void callTask() {

        FavoriteTeamInput mFavoriteTeamInput = new FavoriteTeamInput();

        mFavoriteTeamInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mFavoriteTeamInput.setParams(Constant.GET_FAVORITE_TEAM);
        mFavoriteTeamInput.setIsDefaultFavourite("Yes");

        mFavoriteTeamPresenterImpl.actionfavoriteTeamList(mFavoriteTeamInput);

    }

    @Override
    public void onGetFavoriteTeamSuccess(ResponseFavoriteTeam mResponseFavoriteTeam) {

        hideLoading();

        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setNestedScrollingEnabled(true);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext, 2);

        mRecyclerView.setLayoutManager(mLayoutManager);
        adapter = new FavoriteTeamAdapter(mResponseFavoriteTeam.getData().getRecords(), R.layout.item_favorite_team, mContext,
                onItemClickCallback);

        mRecyclerView.setAdapter(adapter);

    }

    @Override
    public void onFavoriteTeamFailure(String errMsg) {

        hideLoading();
        onShowSnackBar(errMsg);
    }

    @Override
    public void onMakeFavoriteTeamSuccess(DefaultRespose responseBanner) {

        hideLoading();
        onShowSnackBar(responseBanner.getMessage());

    }

    @Override
    public void onMakeFavoriteTeamFailure(String errMsg) {

        hideLoading();
        onShowSnackBar(errMsg);
    }

    @Override
    public void onFavoriteTeamNotFound(String errMsg) {
        hideLoading();
        onShowSnackBar(errMsg);
    }

    @Override
    public void onShowSnackBar(String message) {

        hideLoading();
        AppUtils.showSnackBar(this, mLinearLayout, message);
    }

    @Override
    public boolean isAttached() {
        return true;
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void showLoading() {

        if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {

        if (mProgressDialog != null) mProgressDialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        mProgressDialog.dismiss();
        super.onDestroy();
    }
}