package net.ricerich.clientnetdb;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.ricerich.clientnetdb.Network.NetworkDelete;
import net.ricerich.clientnetdb.Network.NetworkUpdate;

import java.util.ArrayList;

public class Custom_Adapter extends BaseAdapter {
    private Activity mAct;
    LayoutInflater mInflater;
    ArrayList<UserInfo> mUserInfoObjArr;
    int mListLayout;
    private Custom_Adapter adapter;

    public Custom_Adapter(Activity a, int listLayout, ArrayList<UserInfo> userInfoObjArrayListT) {
        mAct = a;
        mListLayout = listLayout;
        mUserInfoObjArr = userInfoObjArrayListT;
        mInflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDatas(ArrayList<UserInfo> arrayList) {
        mUserInfoObjArr = arrayList;
    }

    @Override
    public int getCount() {
        return mUserInfoObjArr.size();
    }

    @Override
    public Object getItem(int position) {
        return mUserInfoObjArr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view==null)
           view = mInflater.inflate(mListLayout, viewGroup, false);

        final TextView tvID = (TextView) view.findViewById(R.id.tv_id);
        tvID.setText(mUserInfoObjArr.get(position).id);

        final TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        tvName.setText(mUserInfoObjArr.get(position).name);

        final TextView tvPhone = (TextView) view.findViewById(R.id.tv_phone);
        tvPhone.setText(mUserInfoObjArr.get(position).phone);

        final TextView tvGrade = (TextView) view.findViewById(R.id.tv_grade);
        tvGrade.setText(mUserInfoObjArr.get(position).grade);

        final TextView tvWriteTime = (TextView) view.findViewById(R.id.tv_write_time);
        tvWriteTime.setText(mUserInfoObjArr.get(position).writeTime);

        final View[] viewBtn = {view};

        Button updateButton = (Button) view.findViewById(R.id.btnUpdate);
        updateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final View view = mAct.getLayoutInflater().inflate(R.layout.dialog_add, null);
                final EditText edtId, edtName, edtPhone, edtGrade;
                edtId = (EditText)view.findViewById(R.id.edtID);
                edtName = (EditText)view.findViewById(R.id.edtName);
                edtPhone = (EditText)view.findViewById(R.id.edtPhone);
                edtGrade = (EditText)view.findViewById(R.id.edtGrade);

                edtId.setText(tvID.getText());
                edtName.setText(tvName.getText());
                edtPhone.setText(tvPhone.getText());
                edtGrade.setText(tvGrade.getText());

                edtId.setFocusable(false);

                new AlertDialog.Builder((Context)mAct)
                        .setTitle("수정")
                        .setView(view)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String id = edtId.getText().toString();
                                String name = edtName.getText().toString();
                                String phone = edtPhone.getText().toString();
                                String grade = edtGrade.getText().toString();

                                new NetworkUpdate(Custom_Adapter.this).execute(id, name, phone, grade);
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setCancelable(false).show();
            }
        });

        Button deleteButton = (Button) view.findViewById(R.id.btn_delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = tvID.getText().toString();
                AlertDialog.Builder ad = new AlertDialog.Builder(mAct);
                ad.setTitle("삭제하기");
                ad.setMessage("사용자 ID: " + userID + "를(을) 정말 삭제하시겠습니까?");

                ad.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new NetworkDelete(Custom_Adapter.this).execute(tvID.getText().toString());
                        Toast.makeText(mAct, "삭제하였습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

                ad.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mAct, "취소하였습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                ad.show();
            }
        });

        return view;
    }
}

