package com.cyp.lab3_2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.FadeInAnimator;
import jp.wasabeef.recyclerview.animators.OvershootInLeftAnimator;

public class SecondActivity extends AppCompatActivity {
    static List<item2> shoplist=new ArrayList<item2>(100);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //购物车
        setContentView(R.layout.shopping);//设置布局文件t
        final List<item2>data=new ArrayList<item2>();
        for(int i=0;i<shoplist.size();i++){
            data.add(shoplist.get(i));
        }
        ListView listView=(ListView)findViewById(R.id.lv2);
        final information p = (information) getIntent().getSerializableExtra("Info2");
        final mylistAdapter mlistAdapter = new mylistAdapter(SecondActivity.this,data);
        listView.setAdapter(mlistAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                    AlertDialog.Builder message = new AlertDialog.Builder(SecondActivity.this);
                    message.setTitle("移除商品");
                    message.setMessage("从购物车移除" + shoplist.get(position).getName()+"?");
                    message.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            shoplist.remove(position);
                            data.remove(position);
                            mlistAdapter.notifyDataSetChanged();
                        }
                    });
                    message.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    message.create().show();
                    return true;
                }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SecondActivity.this, good.class);
                intent.putExtra("Info", p);
                startActivity(intent);
            }
        });
        final FloatingActionButton floatingActionButton=(FloatingActionButton)findViewById(R.id.floatButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
