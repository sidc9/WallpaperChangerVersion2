package com.siddhanta.wallpaperchangerversion2;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Sidd.c on 5/8/2015.
 */
public class Tab1 extends Fragment {

    //Context context11 = (MainActivity) getActivity();
    Context context = getActivity();

    ListView lv;
    ArrayList<Subreddits> subredditList;
    SubredditsAdapter subAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_1, container, false);
        lv = (ListView) v.findViewById(R.id.listview);
        //displaySubredditList();
        //Toast.makeText(getContext(),"Clicked Tab 1", Toast.LENGTH_SHORT).show();

        subredditList = new ArrayList<Subreddits>();

        String listOfsubs[] = {"Earthporn","Winterporn","Summerporn"};

        for(int i=0; i<listOfsubs.length; i++){
            subredditList.add(new Subreddits(listOfsubs[i]));
        }

        subAdapter = new SubredditsAdapter(subredditList, getActivity());
        lv.setAdapter(subAdapter);


        return v;
    }


    private void displaySubredditList() {


/*

        subredditList = new ArrayList<Subreddits>();

        String listOfsubs[] = {"Earthporn","Winterporn","Summerporn"};

        for(int i=0; i<listOfsubs.length; i++){
            subredditList.add(new Subreddits(listOfsubs[i]));
        }

        subAdapter = new SubredditsAdapter(subredditList, getActivity());
        lv.setAdapter(subAdapter);*/

    }
/*
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int pos = lv.getPositionForView(buttonView);
        if(pos != ListView.INVALID_POSITION) {
            Subreddits p = subredditList.get(pos);
            p.setSelected(isChecked);

           // Toast.makeText(this, "Clicked on :" + p.getName() + ", " + isChecked, Toast.LENGTH_SHORT).show();
        }


    }*/

}
