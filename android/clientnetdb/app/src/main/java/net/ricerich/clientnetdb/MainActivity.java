package net.ricerich.clientnetdb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import net.ricerich.clientnetdb.Network.NetworkGet;
import net.ricerich.clientnetdb.Network.NetworkInsert;
import net.ricerich.clientnetdb.Network.NetworkSearch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button refreshBtn, addBtn, btnSearch;
    private ListView listView;
    private Custom_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        adapter = new Custom_Adapter(MainActivity.this, R.layout.adapter_userinfo, new ArrayList<UserInfo>()); // 여기서 arrayList : 갯수
        listView.setAdapter(adapter);

        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText)findViewById(R.id.edtSearch)).getText().toString();
                new NetworkSearch(adapter).execute(name);
            }
        });

        refreshBtn = (Button) findViewById(R.id.btnRefresh);
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NetworkGet((Custom_Adapter) listView.getAdapter()).execute(""); // 전체 불러오기
            }
        });

        addBtn = (Button) findViewById(R.id.btn_add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View v = getLayoutInflater().inflate(R.layout.dialog_add, null);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("멤버 추가")
                        .setView(v)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String id = ((EditText)v.findViewById(R.id.edtID)).getText().toString();
                                String name = ((EditText)v.findViewById(R.id.edtName)).getText().toString();
                                String phone = ((EditText)v.findViewById(R.id.edtPhone)).getText().toString();
                                String grade = ((EditText)v.findViewById(R.id.edtGrade)).getText().toString();

                                new NetworkInsert(adapter).execute(id, name, phone, grade);
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setCancelable(false)
                        .show();
            }
        });
        new NetworkGet((Custom_Adapter) listView.getAdapter()).execute("");
    }
}