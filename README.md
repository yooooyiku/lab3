### 实验3 UI组件

一、实验内容

Android ListView、AlertDialog、XML定义菜单、上下文菜单

二、实验截图、代码

（1）

```
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
```

[![BrX174.png](https://s1.ax1x.com/2020/11/03/BrX174.png)](https://imgchr.com/i/BrX174)

（2）

```
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button bn=(Button)findViewById(R.id.clickme);
    LayoutInflater inflater=MainActivity.this.getLayoutInflater();
    View v= inflater.inflate(R.layout.alerdialog,null,false);
    Context context=MainActivity.this;
    AlertDialog.Builder builder=new AlertDialog.Builder(context);
    builder.setView(v);
    builder.setCancelable(false);
    final AlertDialog alertDialog=builder.create();
    bn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){
            alertDialog.show();
        }
    });
    v.findViewById(R.id.cancle).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Toast.makeText(MainActivity.this,"cancle",Toast.LENGTH_LONG).show();
            alertDialog.dismiss();
        }
    });
    v.findViewById(R.id.signin).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Toast.makeText(MainActivity.this,"Sign in",Toast.LENGTH_LONG).show();
            alertDialog.dismiss();
        }
    });
}
```

[![BrXlBF.png](https://s1.ax1x.com/2020/11/03/BrXlBF.png)](https://imgchr.com/i/BrXlBF)

（3）

```
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:title="字体大小">
        <menu>
            <!-- 定义一组单选菜单项-->
            <group android:checkableBehavior="single">
                <!-- 定义多个菜单项-->
                <item
                    android:id="@+id/font_10"
                    android:title="10号字体"
                    />
                <item
                    android:id="@+id/font_16"
                    android:title="16号字体"/>
                <item
                    android:id="@+id/font_20"
                    android:title="20号字体"/>
            </group>
        </menu>
    </item>
    <!-- 定义一个普通菜单项-->
    <item android:title="普通菜单项"
          android:id="@+id/plain_item">
    </item>
    <item android:title="字体颜色">
        <menu>
            <!-- 定义一组普通菜单项-->
            <group>
                <!-- 定义三个菜单项-->
                <item
                    android:id="@+id/red_font"
                    android:title="红色"/>
                <item
                    android:id="@+id/black_font"
                    android:title="黑色"/>

            </group>
        </menu>
    </item>

</menu>
```

[![BrXQnU.png](https://s1.ax1x.com/2020/11/03/BrXQnU.png)](https://imgchr.com/i/BrXQnU)

[![BrXKXT.png](https://s1.ax1x.com/2020/11/03/BrXKXT.png)](https://imgchr.com/i/BrXKXT)

(4)

```
ActionMode.Callback callback = new ActionMode.Callback() {

    @Override
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }
    //显示已选择n项
    @Override
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        actionMode.setTitle("已选择"+ selected_items + " 项");
        return true;
    }
    @Override
    public void onDestroyActionMode(ActionMode actionMode) {

    }
};
```

[![DgfOXR.png](https://s3.ax1x.com/2020/11/30/DgfOXR.png)](https://imgchr.com/i/DgfOXR)