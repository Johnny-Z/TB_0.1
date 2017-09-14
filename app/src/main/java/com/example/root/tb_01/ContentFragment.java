package com.example.root.tb_01;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 *用于画首页
 */

public class ContentFragment extends Fragment {

    private View viewContent;
    private int mType = 0;
    private String mTitle;
    public List<String> datas;
    private LayoutInflater inflate;
    private ListView listView;


    public void setType(int mType) {
        this.mType = mType;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewContent = inflater.inflate(R.layout.fragment_content,container,false);

        listView = (ListView) viewContent.findViewById(R.id.lv_homeitem);
//        Toast.makeText(viewContent.getContext(),"-------onCreateView------",Toast.LENGTH_SHORT).show();

        datas = new ArrayList<String>();
        SharedHelper sharedHelper =new SharedHelper(viewContent.getContext());
        sharedHelper.loadList(this.mTitle,datas);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(viewContent.getContext(),R.layout.array_item,datas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(listView.getContext(),datas.get(i),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),
                        TopicDetailActivity.class);
                intent.putExtra("Detail",datas.get(i));
                startActivity(intent);
            }
        });

        return viewContent;
    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        Toast.makeText(context,"-------onAttach------",Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        Toast.makeText(getContext(),"-------onCreate------",Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState)
//    {
//        super.onActivityCreated(savedInstanceState);
//        Toast.makeText(getContext(),"-------onActivityCreated------",Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    public void onStart()
//    {
//        super.onStart();
//        Toast.makeText(getContext(),"-------onStart------",Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    public void onResume()
//    {
//        super.onResume();
//        Toast.makeText(getContext(),"-------onResume------",Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    public void onPause()
//    {
//        super.onPause();
//        Toast.makeText(getContext(),"-------onPause------",Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    public void onStop()
//    {
//        super.onStop();
//        Toast.makeText(getContext(),"-------onStop------",Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    public void onDestroyView()
//    {
//        super.onDestroyView();
//        Toast.makeText(getContext(),"-------onDestroyView------",Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    public void onDestroy()
//    {
//        super.onDestroy();
//        Toast.makeText(getContext(),"-------onDestroy------",Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    public void onDetach()
//    {
//        super.onDetach();
//        Toast.makeText(getContext(),"-------onDetach------",Toast.LENGTH_SHORT).show();
//    }
}
