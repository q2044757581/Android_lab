package com.cyp.lab3_2;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.FadeInAnimator;
import jp.wasabeef.recyclerview.animators.OvershootInLeftAnimator;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Bundle infos1=new Bundle();
        final int[]click_goods=new int[100];
        final int index=0;
        final RecyclerView mRecylerview=(RecyclerView)findViewById(R.id.recycler_view);
        mRecylerview.setLayoutManager(new LinearLayoutManager(this));
        /*  为每一项数据创建一个对象，并添加在List中  */
        final List<information> Infos = new ArrayList<information>() {{
            add(new information(R.drawable.enchatedforest,"Enchated Forest","作者","Johanna Basford","¥ 5.00"));
            add(new information(R.drawable.arla,"Arla Milk","产地","德国","¥ 59.00"));
            add(new information(R.drawable.devondale,"Devondale Milk","产地","澳大利亚","¥ 79.00"));
            add(new information(R.drawable.kindle,"Kindle Oasis","版本","Johanna Basford","¥ 2399.00"));
            add(new information(R.drawable.waitrose,"waitrose 早餐麦片","重量","2Kg","¥ 179.00"));
            add(new information(R.drawable.mcvitie, "Mcvitie's 饼干","产地","英国","¥ 14.90"));
            add(new information(R.drawable.ferrero, "Ferrero Rocher","重量","300g","¥ 132.59"));
            add(new information(R.drawable.maltesers,"Maltesers","重量","118g","¥ 141.43"));
            add(new information(R.drawable.lindt,"Lindt","重量","249g","¥ 139.43"));
            add(new information(R.drawable.borggreve,"Borggreve","重量","640g","¥ 28.90"));
        }};
        final List<item> itemList = new ArrayList<item>(10);
        List<item2> shoppingList = new ArrayList<item2>(10);
        String[] primeletter={"E","A","D","K","W","M","F","M","L","B"};
        String[] things={"Enchated Forest","Arla Milk","Devondale Milk","Kindle Oasis", "waitrose 早餐麦片","Mcvitie's 饼干",
                "Ferrero Rocher", "Maltesers","Lindt","Borggreve"};
        String[] prices={"¥ 5.00","¥ 59.00","¥ 79.00","¥ 2399.00","¥ 179.00","¥ 14.90","¥ 132.59","¥ 141.43","¥ 139.43","¥ 28.90"};

        for(int i=0;i<10;i++)
        {
            item temp = new item(things[i],primeletter[i]);
            itemList.add(temp);
        }

        final CommonAdapter commonAdapter = new CommonAdapter(this,R.layout.item,itemList) {
            @Override
            public void convert(ViewHolder holder, item item) {
                TextView name = holder.getView(R.id.goodname);
                name.setText(item.getName());
                TextView first = holder.getView(R.id.cycle);
                first.setText(item.getPrime());
            }
        };
        commonAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener(){
            @Override
            public Boolean onLongClick(int position) {
                int i=position;
                String[] number={"1","2","3","4","5","6","7","8","9","10"};
                Toast.makeText(MainActivity.this,"移除第"+number[i]+"个商品",Toast.LENGTH_SHORT).show();
                itemList.remove(position);
                commonAdapter.notifyDataSetChanged();
                return true;
            }

            @Override
            public void onClick(int position){
                Intent intent = new Intent(MainActivity.this, good.class);
                information temp = Infos.get(position);
                intent.putExtra("Info", temp);
                startActivity(intent);
            }
        });
        final ScaleInAnimationAdapter mAdapter=new ScaleInAnimationAdapter(commonAdapter);
        mAdapter.setDuration(1000);
        mRecylerview.setAdapter(mAdapter);
        mRecylerview.setItemAnimator(new OvershootInLeftAnimator());
        //mRecylerview.setAdapter(commenAdapter);

        final FloatingActionButton floatingActionButton=(FloatingActionButton)findViewById(R.id.floatButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
