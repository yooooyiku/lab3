package com.example.lab_3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private String[] names=new String[]{"Lion","Tiger","Monkey","Dog",
            "Cat","Elephant"};
    private int[] image=new int[]{R.drawable.lion,R.drawable.tiger,
    R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //引用布局文件
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> ListItems=new ArrayList<Map<String, Object>>();
        for (int i=0;i<names.length;i++){
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("header",names[i]);
            listItem.put("images",image[i]);
            //加上list集合
            ListItems.add(listItem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,ListItems,
                R.layout.simple_item,new String[]{"header","images"},
                new int[]{R.id.header,R.id.images});
        ListView list=findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view,
                     int position, long id){
                int flag=0;
                System.out.println(names[position]+position+"被单击");
                switch (flag){
                    case 0:
                        view.setSelected(true);
                        CharSequence text=names[position];
                        int duration=Toast.LENGTH_SHORT;
                        Toast toast=Toast .makeText(MainActivity.this,text,duration);
                        toast.show();
                        flag=1;
                        break;
                    case 1:
                        view.setSelected(false);
                        CharSequence text1=names[position];
                        int duration1=Toast.LENGTH_SHORT;
                        Toast toast1=Toast.makeText(MainActivity.this,text1,duration1);
                        toast1.show();
                        flag=0;
                        break;
                }
            }
        });
        //选中函数
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent,View view,
                                       int position,long id){
                System.out.println(names[position]+"选中");
            }
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
    }
}
