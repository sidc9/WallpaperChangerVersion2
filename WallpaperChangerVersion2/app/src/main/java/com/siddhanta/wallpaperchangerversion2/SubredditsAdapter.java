package com.siddhanta.wallpaperchangerversion2;

import java.util.List;

import android.app.ActionBar;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

// TODO Saved Check box states


class Subreddits {
	
	String name;
	boolean selected;// = true;
	
	public Subreddits(String name, boolean selected) {
		super();
		this.name = name;
		this.selected = selected;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}
public class SubredditsAdapter extends ArrayAdapter<Subreddits>{

	private List<Subreddits> subsList;
	private Context context;

    ListView lv;

    public static String PREFS_NAME = "myprefs";
    SharedPreferences prefs;
    SharedPreferences.Editor prefs_edit;


	public SubredditsAdapter(List<Subreddits> subsList, Context context) {
		super(context, R.layout.single_listview_item, subsList);
		this.subsList = subsList;
		this.context = context;

	}
	

	public static class SubsHolder {
		public TextView subName;
		public CheckBox chkbox;
	
	}


    SubsHolder holder = new SubsHolder();
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		View v = convertView;


        lv = (ListView) v.findViewById(R.id.listview);
        final SubredditsAdapter subadap = new SubredditsAdapter(subsList,getContext());

        final Subreddits p;
        p = subsList.get(position);

		if(convertView == null) {
				
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.single_listview_item,null);
            //v.setTag(101);


           // rl.findViewById(R.id.rl);
           // rl.addView(holder.subName, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);

			holder.subName = (TextView) v.findViewById(R.id.subname);
			holder.chkbox = (CheckBox) v.findViewById(R.id.chk_box);

            final CheckBox temp = holder.chkbox;

			holder.chkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    final boolean isChecked = temp.isChecked();

                    if (isChecked)
                        p.setSelected(!isChecked);
                    else
                        p.setSelected(isChecked);

                    prefs = getContext().getSharedPreferences(PREFS_NAME, 0);
                    prefs_edit = prefs.edit();
                    prefs_edit.putBoolean(String.valueOf(position) + "_state", isChecked);
                    prefs_edit.commit();
                    Toast.makeText(arg0.getContext(), "Clicked on :" + p.getName() + " at " + "," + position + "," + isChecked, Toast.LENGTH_SHORT).show();

                }
            });
			holder.chkbox = temp;
            //v.setTag(101);



            /*holder.subName.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View arg0){

                    Toast.makeText(arg0.getContext(), "Long Clicked on :" + p.getName() + " at " + "," + position , Toast.LENGTH_SHORT).show();
                    deleteItem(position);
                    lv.setAdapter(subadap);

                    return false;
                }
            });//*/
		}
		/*else {
			holder = (SubsHolder) v.getTag(101);
		}*/
		


            holder.subName.setText(p.getName());
            holder.chkbox.setChecked(p.isSelected());
            holder.chkbox.setTag(p);


		return v;
	}

public void deleteItem(int position){/*

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
    prefs_edit.putInt("count",count);
    prefs_edit.commit();

    Toast.makeText(getContext(), "Deleted: " + position + ", New count : " + count , Toast.LENGTH_SHORT).show();
//*/
    Toast.makeText(getContext(), "Worked", Toast.LENGTH_SHORT).show();
}
}
//*/