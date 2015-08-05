package com.siddhanta.wallpaperchangerversion2;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sidd.c on 5/8/2015.
 */
public class Tab1 extends Fragment implements android.widget.CompoundButton.OnCheckedChangeListener {

    ListView listView;
    ArrayList<Subreddits> subredditList;
    SubredditsAdapter subredditsAdapter;

    Context myTest = getActivity();

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_1, container, false);


        Log.d("WallpaperChanger", "Calling now");
        displaySubredditList();

        return v;
    }

    private void displaySubredditList() {
        subredditList = new ArrayList<Subreddits>();

        String listOfSubs[] = {"Earthporn","Winterporn","Summerporn"};

        Log.d("WallpaperChanger","List la");

        for(int i=0; i<listOfSubs.length; i++) {
            subredditList.add(new Subreddits(listOfSubs[i]));
        }

        subredditsAdapter = new SubredditsAdapter(subredditList, this.getActivity());
        listView.setAdapter(subredditsAdapter);

        Log.d("WallpaperChanger", "Done!");
    }


    public void onCheckedChanged(CompoundButton button, boolean isChecked) {

        Log.d("WallpaperChanger","Clicked!");
        int pos = listView.getPositionForView(button);
        if (pos != ListView.INVALID_POSITION) {
            Subreddits p = subredditList.get(pos);
            p.setSelected(isChecked);

            //Toast.makeText(this, "Clicked on : " + p.getName() + ", " + isChecked, Toast.LENGTH_SHORT).show();
        }
    }

}
