package com.mw.eleven11.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import com.mw.eleven11.utility.ViewUtils;


public abstract class BaseFragment extends Fragment {

    View view;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null)
            unbinder.unbind();
    }

    public abstract int getLayout();

    public abstract void init();

    @Override
    public void onResume() {
        super.onResume();
        ViewUtils.hideKeyboardOnStartActivity(getActivity());
    }

    public View getCurrentView() {
        return view;
    }

   /* public void setChildFragment(final Fragment fragment, final String title)
    {
        try {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (getChildFragmentManager()!=null){
                            FragmentManager fragmentManager = getChildFragmentManager();
                            // Creating a fragment transaction
                            FragmentTransaction ft = fragmentManager.beginTransaction().addToBackStack(title);
                            // Adding a fragment to the fragment transaction
                            ft.replace(R.id.frame_container_sub, fragment, title);
                            // Committing the transaction
                            ft.commit();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }, 100);
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}
