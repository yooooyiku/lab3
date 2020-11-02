package com.example.lab_3_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private TextView txt;
   @Override
    protected void onCreate(Bundle savedInstanceState)
   { super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     txt=findViewById(R.id.txt);
     //为文本框注册上下文菜单
     registerForContextMenu(txt);

   }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
       //装填R.menu.menu_main对应的菜单，并添加到menu中
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
   @Override public boolean onOptionsItemSelected(MenuItem mi){
       //勾选该菜单项
       if (mi.isCheckable()){
           mi.setChecked(true);
       }
       //判断单击的是哪个菜单项，并有正对性的作出相应
       switch (mi.getItemId()){
           case R.id.font_10: txt.setTextSize(10*2); break;
           case R.id.font_16: txt.setTextSize(16*2); break;
           case R.id.font_20: txt.setTextSize(20*2); break;
           case R.id.red_font: txt.setTextColor(Color.RED); break;
           case R.id.black_font: txt.setTextColor(Color.BLACK); break;
           case R.id.plain_item:
               Toast.makeText(MainActivity.this,"您点击了普通菜单项",Toast.LENGTH_SHORT)
                       .show();
               break;
       }
       return true;
   }
}
