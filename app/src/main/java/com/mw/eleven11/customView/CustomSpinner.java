package com.mw.eleven11.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

import com.mw.eleven11.beanOutput.StatesBean;
import com.rey.material.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.mw.eleven11.R;


/**
 * Created by mobiweb on 17/8/17.
 */

public class CustomSpinner extends Spinner {

    private Context mContext;
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<String> value = new ArrayList<>();

    public CustomSpinner(Context context) {
        super(context);
        mContext = context;
    }

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        setAdapter(attrs);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        setAdapter(attrs);
    }

    private void setAdapter(AttributeSet attrs) {
        final TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.CustomSpinner);
        int resourseFileName = a.getResourceId(R.styleable.CustomSpinner_optionJsonArray, -1);
        if (resourseFileName == -1) {
            return;
        }
        setArrayList(resourseFileName);
        if (title != null && value != null) {
            ArrayAdapter<String> spinnerMenu = new ArrayAdapter<String>(mContext, R.layout.item_spinner_header, title);
            spinnerMenu.setDropDownViewResource(R.layout.item_spinner);
            setAdapter(spinnerMenu);
            a.recycle();
        }
    }

    public void setCustomResource(int resourceFileId, int headerLayout, int dropDownLayout) {
        final TypedArray a = mContext.obtainStyledAttributes(R.styleable.CustomSpinner);
        if (title != null && value != null) {
            title.clear();
            value.clear();
            setArrayList(resourceFileId);
            if (spinnerMenu == null) {
                spinnerMenu = new ArrayAdapter<String>(mContext, headerLayout, title);
                spinnerMenu.setDropDownViewResource(dropDownLayout);
                setAdapter(spinnerMenu);
            } else {
                spinnerMenu.notifyDataSetChanged();
            }
            a.recycle();
            if (title.size() > 0)
                setSelection(0);
        }
    }

    ArrayAdapter<String> spinnerMenu = null;

    public void setCustomResource(ArrayList<HashMap<String, String>> values) {
        final TypedArray a = mContext.obtainStyledAttributes(R.styleable.CustomSpinner);
        if (title != null && value != null) {
            title.clear();
            value.clear();
            setCustomArrayList(values);
            if (spinnerMenu == null) {
                spinnerMenu = new ArrayAdapter<String>(mContext, R.layout.item_spinner_header, title);
                spinnerMenu.setDropDownViewResource(R.layout.item_spinner);
                setAdapter(spinnerMenu);
            } else {
                spinnerMenu.notifyDataSetChanged();
            }
            a.recycle();
            if (title.size() > 0)
                setSelection(0);
        }
    }

    public void setJsonResource(StatesBean mStatesBean) {
        final TypedArray a = mContext.obtainStyledAttributes(R.styleable.CustomSpinner);
        if (title != null && value != null) {
            title.clear();
            value.clear();
            setStateArrayList(mStatesBean);
            if (spinnerMenu == null) {
                spinnerMenu = new ArrayAdapter<String>(mContext, R.layout.item_spinner_header, title);
                spinnerMenu.setDropDownViewResource(R.layout.item_spinner);
                setAdapter(spinnerMenu);
            } else {
                spinnerMenu.notifyDataSetChanged();
            }
            a.recycle();
            if (title.size() > 0)
                setSelection(0);
        }
    }

    public void setCustomResource(ArrayList<HashMap<String, String>> values, int headerLayout, int dropDownLayout) {
        final TypedArray a = mContext.obtainStyledAttributes(R.styleable.CustomSpinner);
        if (title != null && value != null) {
            title.clear();
            value.clear();
            setCustomArrayList(values);
            if (spinnerMenu == null) {
                spinnerMenu = new ArrayAdapter<String>(mContext, headerLayout, title);
                spinnerMenu.setDropDownViewResource(dropDownLayout);
                setAdapter(spinnerMenu);
            } else {
                spinnerMenu.notifyDataSetChanged();
            }
            a.recycle();
            if (title.size() > 0)
                setSelection(0);
        }
    }




    private void setCustomArrayList(ArrayList<HashMap<String, String>> values) {
        if (values == null) return;
        for (int i = 0; i < values.size(); i++) {
            title.add(values.get(i).get("title"));
            value.add(values.get(i).get("value"));
        }
    }
    private void setStateArrayList(StatesBean mStatesBean) {
        if (mStatesBean == null) return;
        for (int i = 0; i < mStatesBean.getState().size(); i++) {
            title.add(mStatesBean.getState().get(i).getName());
            value.add(mStatesBean.getState().get(i).getCode());
        }
    }

    private void setArrayList(int resId) {
        InputStream inputStream = getResources().openRawResource(resId);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int ctr;
        try {
            ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JSONArray jsonArray = new JSONArray(byteArrayOutputStream.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                title.add(jsonObject.getString("title"));
                value.add(jsonObject.getString("value"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            title.clear();
            value.clear();
        }
    }

    public int getSize() {
        if (value == null) return 0;
        return value.size();
    }

    public String getSelectedValue() {
        if (getSize() == 0) return "";
        return value.get(getSelectedItemPosition());
    }

    public int getSelectedValueInt() {
        if (getSize() == 0) return 0;
        return TextUtils.isEmpty(value.get(getSelectedItemPosition())) ? 0 : Integer.parseInt(value.get(getSelectedItemPosition()));
    }

    public String getSelectedTitle() {
        if (getSize() == 0) return "";
        return title.get(getSelectedItemPosition());
    }

    public void setValue(String v) {
        try {
            for (int i = 0; i < value.size(); i++) {
                if (value.get(i).equals(v)) {
                    setSelection(i);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTitle(String t1) {
        try {
            for (int i = 0; i < title.size(); i++) {
                if (title.get(i).equals(t1)) {
                    setSelection(i);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
