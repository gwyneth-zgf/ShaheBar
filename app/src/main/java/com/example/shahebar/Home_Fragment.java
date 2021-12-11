package com.example.shahebar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Home_Fragment extends Fragment implements AdapterView.OnItemClickListener{
    ListView listView;
    ListView listView2;
    SimpleAdapter simpleAdapter;
    SimpleAdapter simpleAdapter2;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);

        listView = view.findViewById(R.id.list);
        //listView2 = view.findViewById(R.id.list);

        simpleAdapter = new SimpleAdapter(getActivity(),getData(),R.layout.my_menu,new String[]{"title","image","author","content"},new int[]{R.id.myMenu_title,R.id.myMenu_image,R.id.myMenu_author,R.id.myMenu_content});
        //simpleAdapter2 = new SimpleAdapter(getActivity(),getData2(),R.layout.my_menu,new String[]{"author","content"},new int[]{R.id.myMenu_author,R.id.myMenu_content});
        listView.setAdapter(simpleAdapter);
        //listView2.setAdapter(simpleAdapter2);

        listView.setOnItemClickListener(this);
        //listView2.setOnItemClickListener(this);

        return view;
    }

    private List<Map<String,Object>> getData() {
        String [] title={"帖子1","帖子2","帖子3","帖子4","帖子5"};
        int [] image={R.drawable.post_0,R.drawable.post_1,R.drawable.post_2,R.drawable.post_3,
                R.drawable.post_4};
        String [] author={"作者1","作者2","作者3","作者4","作者5"};
        String [] content={"内容1","内容2","内容3","内容4","内容5"};
        List<Map<String,Object>> list= new ArrayList<>();
        for(int i=0;i<5;i++){
            Map  map = new HashMap();
            map.put("title",title[i]);
            map.put("image",image[i]);
            map.put("author",author[i]);
            map.put("content",content[i]);
            list.add(map);
        }
        return list;
    }
    private List<Map<String,Object>> getData2() {
        String [] author={"作者1","作者2","作者3","作者4","作者5"};
        String [] content={"内容1","内容2","内容3","内容4","内容5"};
        List<Map<String,Object>> list2= new ArrayList<>();
        for(int i=0;i<5;i++){
            Map  map2 = new HashMap();
            map2.put("author",author[i]);
            map2.put("content",content[i]);
            list2.add(map2);
        }
        return list2;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String text = listView.getAdapter().getItem(position).toString();
        String text2 = listView2.getAdapter().getItem(position).toString();
    }


}
