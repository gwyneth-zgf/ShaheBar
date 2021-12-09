package com.example.shahebar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
//新增了一行注释，看看成不
public class MainActivity extends FragmentActivity implements View.OnClickListener {
    //声明四个Tab的布局文件
    private LinearLayout tabHome;
    private LinearLayout tabMap;
    private LinearLayout tabMe;

    //声明四个Tab的ImageButton
    private ImageButton igHome;
    private ImageButton igMap;
    private ImageButton igMe;

    //声明四个Tab分别对应的Fragment
    private Fragment fragHome;
    private Fragment fragMap;
    private Fragment fragMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();//初始化控件
        initEvents();//初始化事件
        selectTab(0);//默认选中第一个Tab
    }
    private void initEvents() {
        //初始化四个Tab的点击事件
        tabHome.setOnClickListener(this);
        tabMap.setOnClickListener(this);
        tabMe.setOnClickListener(this);
    }

    private void initViews() {
        //初始化四个Tab的布局文件
        tabHome = (LinearLayout) findViewById(R.id.tab1);
        tabMap = (LinearLayout) findViewById(R.id.tab2);
        tabMe = (LinearLayout) findViewById(R.id.tab3);

        //初始化四个ImageButton
        igHome = (ImageButton) findViewById(R.id.tab1_img);
        igMap = (ImageButton) findViewById(R.id.tab2_img);
        igMe = (ImageButton) findViewById(R.id.tab3_img);
    }

    //处理Tab的点击事件
    @Override
    public void onClick(View v) {
        resetImgs(); //先将四个ImageButton置为灰色
        switch (v.getId()) {
            case R.id.tab1:
                selectTab(0);
                break;
            case R.id.tab2:
                selectTab(1);
                break;
            case R.id.tab3:
                selectTab(2);
                break;
        }

    }

    //进行选中Tab的处理
    private void selectTab(int i) {
        //获取FragmentManager对象
        FragmentManager manager = getSupportFragmentManager();
        //获取FragmentTransaction对象
        FragmentTransaction transaction = manager.beginTransaction();
        //先隐藏所有的Fragment
        hideFragments(transaction);
        switch (i) {
            //当选中点击的是第一页的Tab时
            case 0:
                //设置第一页的ImageButton为绿色
                igHome.setImageResource(R.mipmap.icon1);
                //如果第一页对应的Fragment没有实例化，则进行实例化，并显示出来
                if (fragHome == null) {
                    fragHome = new Home_Fragment();
                    transaction.add(R.id.id_content, fragHome);
                } else {
                    //如果第一页对应的Fragment已经实例化，则直接显示出来
                    transaction.show(fragHome);
                }
                break;
            case 1:
                igMap.setImageResource(R.mipmap.icon1);
                if (fragMap == null) {
                    fragMap = new Post_Fragment();
                    transaction.add(R.id.id_content, fragMap);
                } else {
                    transaction.show(fragMap);
                }
                break;
            case 2:
                igMe.setImageResource(R.mipmap.icon1);
                if (fragMe == null) {
                    fragMe = new Me_Fragment();
                    transaction.add(R.id.id_content, fragMe);
                } else {
                    transaction.show(fragMe);
                }
                break;
        }
        //不要忘记提交事务
        transaction.commit();
    }
    //将四个的Fragment隐藏
    private void hideFragments(FragmentTransaction transaction) {
        if (fragHome != null) {
            transaction.hide(fragHome);
        }
        if (fragMap != null) {
            transaction.hide(fragMap);
        }
        if (fragMe != null) {
            transaction.hide(fragMe);
        }
    }

    //将四个ImageButton置为灰色
    private void resetImgs() {
        igHome.setImageResource(R.mipmap.icon2);
        igMap.setImageResource(R.mipmap.icon2);
        igMe.setImageResource(R.mipmap.icon2);
    }

}