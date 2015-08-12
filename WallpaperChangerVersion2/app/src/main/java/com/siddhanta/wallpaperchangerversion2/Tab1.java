package com.siddhanta.wallpaperchangerversion2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.ArrayList;

/**
 * Created by Sidd.c on 5/8/2015.
 */
public class Tab1 extends Fragment   {

    //Context context11 = (MainActivity) getActivity();
    Context context;// = getActivity();

    ListView lv;
    ArrayList<Subreddits> subredditList;
    SubredditsAdapter subAdapter;
    FloatingActionButton fab;

    private Dialog mDialog;
    private AlertDialog mAlertDialog;


    @Override
    public View onCreateView(LayoutInflater inflater,  final ViewGroup container, Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.tab_1, container, false);
        lv = (ListView) v.findViewById(R.id.listview);
        //displaySubredditList();
        //Toast.makeText(getContext(),"Clicked Tab 1", Toast.LENGTH_SHORT).show();

        fab = (FloatingActionButton) v.findViewById(R.id.fab);



        v.findViewById(R.id.button_add).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {

                mDialog = new Dialog(arg0.getContext());
                mDialog.setContentView(R.layout.dialog_layout);
                mDialog.setTitle("Enter new subreddit");


                mDialog.findViewById(R.id.button_cancel).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDialog.dismiss();
                    }
                });
                mDialog.findViewById(R.id.button_ok).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String text = ((EditText) mDialog.findViewById(R.id.edit_box)).getText().toString();

                        if(text != null && text.compareTo("") != 0) {
                            subredditList.add(new Subreddits(text));
                            mDialog.dismiss();
                            subAdapter.notifyDataSetChanged();
                        }
                    }
                });

                mDialog.show();

                //Toast.makeText(arg0.getContext(),"You clicked me!",Toast.LENGTH_SHORT).show();
            }
        });

        subredditList = new ArrayList<Subreddits>();

        String listOfsubs[] = {"Earthporn","Winterporn","Summerporn"};

        for(int i=0; i<listOfsubs.length; i++){
            subredditList.add(new Subreddits(listOfsubs[i]));
        }

        subAdapter = new SubredditsAdapter(subredditList, getActivity());
        lv.setAdapter(subAdapter);


        return v;
    }




/*    private void displaySubredditList() {




        subredditList = new ArrayList<Subreddits>();

        String listOfsubs[] = {"Earthporn","Winterporn","Summerporn"};

        for(int i=0; i<listOfsubs.length; i++){
            subredditList.add(new Subreddits(listOfsubs[i]));
        }

        subAdapter = new SubredditsAdapter(subredditList, getActivity());
        lv.setAdapter(subAdapter);

    }*/
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

