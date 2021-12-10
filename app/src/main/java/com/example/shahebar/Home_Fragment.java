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
    SimpleAdapter simpleAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);

        listView = view.findViewById(R.id.list);

        simpleAdapter = new SimpleAdapter(getActivity(),getData(),R.layout.my_menu,new String[]{"title","image"},new int[]{R.id.myMenu_name,R.id.myMenu_image});
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(this);

        return view;
    }

    private List<Map<String,Object>> getData() {
        String [] title={"帖子1","帖子2","帖子3","帖子4","帖子5"};
        int [] image={R.drawable.post_0,R.drawable.post_1,R.drawable.post_2,R.drawable.post_3,
                R.drawable.post_4};
        List<Map<String,Object>> list= new ArrayList<>();
        for(int i=0;i<5;i++){
            Map  map = new HashMap();
            map.put("title",title[i]);
            map.put("image",image[i]);
            list.add(map);
        }
        return list;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String text = listView.getAdapter().getItem(position).toString();
    }


}
