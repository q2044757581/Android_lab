package com.cyp.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.FadeInAnimator;
import jp.wasabeef.recyclerview.animators.OvershootInLeftAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import static com.cyp.lab3_2.SecondActivity.shoplist;

public class good extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //购物车
        setContentView(R.layout.infos);//设置布局文件
        final information p = (information) getIntent().getSerializableExtra("Info");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Top);
        Button shop = (Button) findViewById(R.id.logo);
        Button back = (Button) findViewById(R.id.Back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView info1 = (TextView) findViewById(R.id.info1);
        info1.setText(p.getInfo1());
        TextView info2 = (TextView) findViewById(R.id.info2);
        info2.setText(p.getInfo2());
        TextView price = (TextView) findViewById(R.id.price);
        price.setText(p.getPrice());

        TextView name = (TextView) findViewById(R.id.Name);
        name.setText(p.getname());

        ImageView img = (ImageView) findViewById(R.id.img);
        img.setImageResource(p.getimageId());

        List<Map<String,Object>> data = new ArrayList<>();
        //List<String> operations1 = new ArrayList<String>(4);
        String[] operations2 = new String[]{"  一键下单", "  分享商品", "  不感兴趣", "  查看更多商品促销信息"};
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.more, operations2);
        for(int i=0;i<4;i++){
            Map<String,Object> temp = new LinkedHashMap<>();
            temp.put("operations2",operations2[i]);
            data.add(temp);
        }
        ListView listView = (ListView) findViewById(R.id.lv);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,data,R.layout.more,new String[]{"operations2","operations2"},new int[] {R.id.choose,R.id.btn});
        listView.setAdapter(simpleAdapter);
        //listView.setAdapter(arrayAdapter);
        /*  星星的切换 */
        final Button star = (Button) findViewById(R.id.star);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!tag) {
                    star.setBackground(getDrawable(R.drawable.full_star));
                    tag = true;
                } else {
                    star.setBackground(getDrawable(R.drawable.empty_star));
                    tag = false;
                }
            }
        });
        ////////
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=p.getname();
                String price=p.getPrice();
                int a=0;
                String prime=name.substring(a,a);
                item2 temp=new item2(name,prime,price);
                shoplist.add(temp);
                Toast.makeText(good.this, "商品已添加到购物车", Toast.LENGTH_SHORT).show();
                //////
                Intent intent = new Intent(good.this, SecondActivity.class);
                intent.putExtra("Info2",p);
                startActivity(intent);
                //////
            }
        });
        //////
    }

    private boolean tag = false;

}