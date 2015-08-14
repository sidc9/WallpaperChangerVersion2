package com.siddhanta.wallpaperchangerversion2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

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
    Subreddits subreddit_item;

    private Dialog mDialog;

    public static String PREFS_NAME = "myprefs";

   // DatabaseManager mDatabaseManager = new DatabaseManager(getActivity());
  //  SQLiteDatabase db = mDatabaseManager.getWritableDatabase();


    @Override
    public View onCreateView(LayoutInflater inflater,  final ViewGroup container, Bundle savedInstanceState) {


        //ContentValues values = new ContentValues();
       // long newRowId;

        subredditList = new ArrayList<Subreddits>();

        final SharedPreferences prefs;
        final SharedPreferences.Editor prefs_edit;

        prefs = this.getActivity().getSharedPreferences(PREFS_NAME,0);
        boolean init = prefs.getBoolean("init",true);
        prefs_edit = prefs.edit();

        final View v = inflater.inflate(R.layout.tab_1, container, false);
        lv = (ListView) v.findViewById(R.id.listview);
        //displaySubredditList();
        //Toast.makeText(getContext(),"Clicked Tab 1", Toast.LENGTH_SHORT).show();

        fab = (FloatingActionButton) v.findViewById(R.id.fab);

        final SubredditsAdapter.SubsHolder vv = new SubredditsAdapter.SubsHolder();
        vv.subName  = (TextView) v.findViewById(R.id.subname);


        vv.subName.setOnLongClickListener(new View.OnLongClickListener() {
            //TextView vv;
            //vv = (TextView) v.findViewById(R.id.subname).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View arg0) {
                CharSequence name = vv.subName.getText();

                int a = subredditList.indexOf(name);
                Toast.makeText(getActivity(), "Long Clicked on :" + " at " + "," + a, Toast.LENGTH_SHORT).show();
                return false;
            }
        });//*/


        v.findViewById(R.id.fab).setOnClickListener(new OnClickListener() {
            //v.findViewById(R.id.button_add).setOnClickListener(new OnClickListener() {
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

                        if (text != null && text.compareTo("") != 0) {
                            //subredditList.add(new Subreddits(text));
                            int count = prefs.getInt("count",0);
                            addItems(text);
                            mDialog.dismiss();

                            prefs_edit.putString(String.valueOf(count), text);
                            prefs_edit.putBoolean(String.valueOf(count) + "_state", true);
                            count = count + 1;
                            prefs_edit.putInt("count",count);
                            prefs_edit.commit();

                            Toast.makeText(getActivity(),"Added new " + text + " at position "+ (count-1),Toast.LENGTH_SHORT).show();
                            //subAdapter.notifyDataSetChanged();
                        }
                    }
                });

                mDialog.show();

                //Toast.makeText(arg0.getContext(),"You clicked me!",Toast.LENGTH_SHORT).show();
            }
        });


//        subredditList = new ArrayList<Subreddits>();
  //      addItems("");




        /*subredditList = new ArrayList<Subreddits>();

        String listOfsubs[] = {"Earthporn","Winterporn","Summerporn"};

        for(int i=0; i<listOfsubs.length; i++){
            subredditList.add(new Subreddits(listOfsubs[i]));
        }

        subAdapter = new SubredditsAdapter(subredditList, getActivity());
        lv.setAdapter(subAdapter);*/






        if(init){ // if this is the first run
            String listOfsubs[] = {"Earthporn","Winterporn","Summerporn"}; //Default list

            for (int i = 0; i < listOfsubs.length; i++){
                subredditList.add(new Subreddits(listOfsubs[i], true));
                prefs_edit.putString(String.valueOf(i), listOfsubs[i]);
                prefs_edit.putBoolean(String.valueOf(i) + "_state", true);

/*                values.put(mDatabaseManager.KEY_NAME, listOfsubs[i]);
                values.put(mDatabaseManager.KEY_POSITION, i);
                values.put(mDatabaseManager.KEY_STATE, true);

                newRowId = db.insert(mDatabaseManager.TABLE_NAME,null,values);
                Toast.makeText(v.getContext(),"Inserted row "+newRowId,Toast.LENGTH_SHORT).show();*/
            }

            subAdapter = new SubredditsAdapter(subredditList, getActivity());
            lv.setAdapter(subAdapter);

            prefs_edit.putBoolean("init", false);
            prefs_edit.putInt("count",listOfsubs.length);
            prefs_edit.commit();

            Toast.makeText(v.getContext(),"Init",Toast.LENGTH_SHORT).show();

        }
        else{

            int count = prefs.getInt("count",0);
            String sub_names;
            boolean sub_state;
            for(int i=0; i<count; i++){
                sub_names = prefs.getString(String.valueOf(i),"err_not_found");
                sub_state = prefs.getBoolean(String.valueOf(i) + "_state", false);
                subredditList.add(new Subreddits(sub_names, sub_state));
            }

            subAdapter = new SubredditsAdapter(subredditList, getActivity());
            lv.setAdapter(subAdapter);

            Toast.makeText(v.getContext(),"Number of items: " + count,Toast.LENGTH_SHORT).show();

        }

        return v;
    }


public void addItems(String itemName){

    SharedPreferences prefs;
    SharedPreferences.Editor prefs_edit;

    subredditList.add(new Subreddits(itemName, true));
    subAdapter.notifyDataSetChanged();

    subAdapter = new SubredditsAdapter(subredditList, getActivity());
    lv.setAdapter(subAdapter);

    /*prefs = this.getActivity().getSharedPreferences(PREFS_NAME, 0);
    int count = prefs.getInt("count",0);

    prefs_edit = prefs.edit();
    prefs_edit.putInt("count",count++);
    prefs_edit.putString(String.valueOf(count), itemName);
    prefs_edit.putBoolean(String.valueOf(count) + "_state", true);
    prefs_edit.commit();

    Toast.makeText(getActivity(),"Added new " + itemName + " at position "+count,Toast.LENGTH_SHORT).show();
    //*/

}


/*    public static void deleteItem(int position){

        prefs = getContext().getSharedPreferences(PREFS_NAME, 0);
        prefs_edit = prefs.edit();

        int count = subsList.size();
        for(int i=position+1; i<count; i++){

            String name = prefs.getString(String.valueOf(i),"err_not_found");
            boolean check_state = prefs.getBoolean(String.valueOf(i)+"_state",false);
            subsList.add(i-1,new Subreddits(name,check_state));

            prefs_edit.putString(String.valueOf(i - 1), name);
            prefs_edit.putBoolean(String.valueOf(i-1)+"_state",check_state);
        }

        prefs_edit.remove(String.valueOf(count-1));
        prefs_edit.remove(String.valueOf(count-1)+"_state");
        count = count-1;
        prefs_edit.putInt("count", count);
        prefs_edit.commit();

        Toast.makeText(getContext(), "Deleted: " + position + ", New count : " + count , Toast.LENGTH_SHORT).show();

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

