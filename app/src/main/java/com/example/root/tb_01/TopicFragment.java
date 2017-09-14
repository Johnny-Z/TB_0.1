package com.example.root.tb_01;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 *我的帖子界面
 */

public class TopicFragment extends android.support.v4.app.Fragment{

    private View viewContent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewContent = inflater.inflate(R.layout.fragment_topic, null);
        ListView listView= (ListView) viewContent.findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        System.out.println("创建新帖");
                        Intent intent0 = new Intent(getActivity(),
                                NewtopicActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        System.out.println("我收藏的");
                        //跳转，传递数据到下一个页面
                        Intent intent1 = new Intent(getActivity(),
                                HistoryActivity.class);
                        intent1.putExtra("what","我收藏的");
                        startActivity(intent1);
                        break;
                    case 2:
                        System.out.println("我评论的");
                        Intent intent2 = new Intent(getActivity(),
                                HistoryActivity.class);
                        intent2.putExtra("what","我评论的");
                        startActivity(intent2);
                        break;
                    case 3:
                        System.out.println("我赞过的");
                        Intent intent3 = new Intent(getActivity(),
                                HistoryActivity.class);
                        intent3.putExtra("what","我赞过的");
                        startActivity(intent3);
                        break;
                    case 4:
                        System.out.println("浏览历史");
                        Intent intent4 = new Intent(getActivity(),
                                HistoryActivity.class);
                        intent4.putExtra("what","浏览历史");
                        startActivity(intent4);
                        break;
                    case 5:
                        System.out.println("我发布的");
                        Intent intent5 = new Intent(getActivity(),
                                HistoryActivity.class);
                        intent5.putExtra("what","我发布的");
                        startActivity(intent5);
                        break;
                    case 6:
                        System.out.println("帖子搜索");
                        Intent intent6 = new Intent(getActivity(),
                                NewtopicActivity.class);
                        startActivity(intent6);
                        break;
                    default:
                        System.out.println(i+" is something wrong!");
                }

            }
        });
        return viewContent;

    }
}
