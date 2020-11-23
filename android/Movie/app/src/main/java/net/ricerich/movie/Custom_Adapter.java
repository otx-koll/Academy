package net.ricerich.movie;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom_Adapter extends BaseAdapter {
    private Activity mAct;
    LayoutInflater mInflater;
    ArrayList<UserInfo> mUserInfoObjArr;
    int mListLayout;
    private Custom_Adapter adapter;

    public Custom_Adapter(Activity a, int listlayout, ArrayList<UserInfo> userInfoArrayList) {
        mAct = a;
        mListLayout = listlayout;
        mUserInfoObjArr = userInfoArrayList;
        mInflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDatas(ArrayList<UserInfo> arrayList) { mUserInfoObjArr = arrayList; }

    @Override
    public int getCount() { return mUserInfoObjArr.size(); }

    @Override
    public Object getItem(int position) { return mUserInfoObjArr.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

//        if (view==null)
//            view = mInflater.inflate(mListLayout, viewGroup, false);
//
//        final TextView tvID = (TextView) view.findViewById(R.id.tv_id);
//        tvID.setText(mUserInfoObjArr.get(position).id);
//
//        final TextView tvName = (TextView) view.findViewById(R.id.tv_name);
//        tvName.setText(mUserInfoObjArr.get(position).name);
//
//        final TextView tvPhone = (TextView) view.findViewById(R.id.tv_password);
//        tvPhone.setText(mUserInfoObjArr.get(position).password);
//
//        final TextView tvWriteTime = (TextView) view.findViewById(R.id.tv_write_time);
//        tvWriteTime.setText(mUserInfoObjArr.get(position).writeTime);
//
//        final View[] viewBtn = {view};

        return view;
    }
}
