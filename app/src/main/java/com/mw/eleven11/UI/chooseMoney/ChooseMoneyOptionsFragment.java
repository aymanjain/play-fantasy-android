package com.mw.eleven11.UI.chooseMoney;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mw.eleven11.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseMoneyOptionsFragment extends BottomSheetDialogFragment {

    private ChooseMoneyPresenter chooseMoneyPresenter;
    private View mView;

    @OnClick(R.id.pud_paytm)
    void payTm() {


       if (chooseMoneyPresenter!=null)
            chooseMoneyPresenter.actionPaytmBtn(ChooseMoneyPresenter.REQUEST_CODE_PAYTM);
    }

    /*@OnClick(R.id.pud_razorPay)
    void razorPay() {
        if (chooseMoneyPresenter!=null)

            chooseMoneyPresenter.actionPaytmBtn(ChooseMoneyPresenter.REQUEST_CODE_RAZORPAY);
    }*/

    @OnClick(R.id.pud_bank)
    void wireTransfer() {

    }

    @OnClick(R.id.pud_payu)
    void payUMoney() {
       /* if (chooseMoneyPresenter != null)

            chooseMoneyPresenter.actionPayUMoneyBtn(ChooseMoneyPresenter.REQUEST_CODE_PAYUMONEY);*/
    }

    public void initCallback(ChooseMoneyCallback videoPickCallback) {
        chooseMoneyPresenter = new ChooseMoneyPresenter(videoPickCallback);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_choose_payment_options, container, false);
        ButterKnife.bind(this, mView);
        return mView;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (chooseMoneyPresenter != null)
            chooseMoneyPresenter.onActivityResult(requestCode, resultCode, data);

    }

    public void startPayment(){
        if (chooseMoneyPresenter!=null)
            chooseMoneyPresenter.actionPaytmBtn(ChooseMoneyPresenter.REQUEST_CODE_RAZORPAY);
        else
            dismiss();
    }
}
