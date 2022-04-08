package com.mw.eleven11.UI.changeUserAvatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.UpdateProfileInput;
import com.mw.eleven11.beanOutput.AvatarListOutput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.ResponseUpdateProfile;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.ItemOffsetDecoration;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class UserAvatarActivity extends BaseActivity implements UserAvatarView {

    UserAvatarPresenterImpl mUserAvatarPresenterImpl;
    Loader loader;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    UserAvatarAdapter adapter;
    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.ctv_join_contests)
    CustomTextView submit;
    AvatarListOutput.DataBean.RecordsBean selectedIcon = new AvatarListOutput.DataBean.RecordsBean();
    ArrayList<String> mTeamList = new ArrayList<>();
    private Context mContext;
    private OnItemClickListener.OnItemClickCallback onItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

            finishActivity();
        }
    };

    public static void start(Context context) {
        Intent starter = new Intent(context, UserAvatarActivity.class);


        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @OnClick(R.id.iv_cross)
    public void cross(View view) {
        finish();
    }

    @OnClick(R.id.ctv_join_contests)
    void onSubmit() {

        selectedIcon = adapter.selectedIcon();

        if (selectedIcon != null) {
            UpdateProfileInput mUpdateProfileInput= new UpdateProfileInput();
            mUpdateProfileInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            mUpdateProfileInput.setProfilePic(selectedIcon.getAvatarImg());

            mUserAvatarPresenterImpl.actionUpdateProfile(mUpdateProfileInput);
        } else {
            //Toast.makeText(mContext, "Please select your Avatar.", Toast.LENGTH_SHORT).show();

            AppUtils.showToast(mContext, "Please select your Avatar.");
        }

    }

    @Override
    public int getLayout() {
        return R.layout.activity_user_avatar;
    }

    @Override
    public void init() {
        mContext = this;

        loader = new Loader(this);

        mUserAvatarPresenterImpl = new UserAvatarPresenterImpl(this, new UserInteractor());


        List<AvatarListOutput.DataBean.RecordsBean> mAvatarIconList = mAvatarIconList = new ArrayList<>();


        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setNestedScrollingEnabled(true);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext, 2);

        mRecyclerView.setLayoutManager(mLayoutManager);


        adapter = new UserAvatarAdapter(mTeamList, R.layout.item_user_avatar, mContext, mAvatarIconList,
                onItemClickCallback);


        //adapter.addAllItem(mInvitedFriends);

        mRecyclerView.setAdapter(adapter);

        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryDark,
                R.color.colorPrimary,
                R.color.secondary_tab_color);

        callTask();

    }

    void callTask() {

        LoginInput loginInput= new LoginInput();
        loginInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mUserAvatarPresenterImpl.users_avatar_list(loginInput);
    }

    @Override
    public void showLoading() {
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showUpdateLoading() {
        loader.start();
    }

    @Override
    public void hideUpdateLoading() {
        loader.hide();
    }

    @Override
    public void onSuccess(AvatarListOutput responseLogin) {

        onShowSnackBar(responseLogin.getMessage());
        adapter.addAllItem(responseLogin.getData().getRecords());

    }

    @Override
    public void onAvatarUpdated(LoginResponseOut responseLogin) {

        // Toast.makeText(mContext, responseLogin.getMessage(), Toast.LENGTH_SHORT).show();

        AppUtils.showToast(mContext, responseLogin.getMessage());

        Intent in = new Intent();
        in.putExtra("selectedIcon", selectedIcon);
        setResult(RESULT_OK, in);
        finish();
    }

    @Override
    public void onUpdateSuccess(ResponseUpdateProfile updateProfile) {
        AppUtils.showToast(mContext, updateProfile.getMessage());

        Intent in = new Intent();
        in.putExtra("selectedIcon", selectedIcon);
        setResult(RESULT_OK, in);
        finish();
    }

    @Override
    public void onError(String message) {
        onShowSnackBar(message);
    }

    @Override
    public void onFailed(String message) {
        onShowSnackBar(message);
    }

    @Override
    public void onShowSnackBar(String message) {

        AppUtils.showToast(mContext, message);
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void finishActivity() {

        finish();
    }
}
