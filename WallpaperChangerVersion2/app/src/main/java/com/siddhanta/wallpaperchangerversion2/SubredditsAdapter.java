package com.siddhanta.wallpaperchangerversion2;

import java.util.List;

import android.app.ActionBar;
import android.content.Context;
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
	boolean selected = false;
	
	public Subreddits(String name) {
		super();
		this.name = name;
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


	public SubredditsAdapter(List<Subreddits> subsList, Context context) {
		super(context, R.layout.single_listview_item, subsList);
		this.subsList = subsList;
		this.context = context;

	}
	

	private static class SubsHolder {
		public TextView subName;
		public CheckBox chkbox;
	
	}


    SubsHolder holder = new SubsHolder();
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View v = convertView;


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

                    if(isChecked)
                        p.setSelected(!isChecked);
                    else
                        p.setSelected(isChecked);

                         Toast.makeText(arg0.getContext(), "Clicked on :" + p.getName() + ", " + isChecked, Toast.LENGTH_SHORT).show();

                }
            });
			holder.chkbox = temp;
            //v.setTag(101);

		}
		/*else {
			holder = (SubsHolder) v.getTag(101);
		}*/
		


            holder.subName.setText(p.getName());
            holder.chkbox.setChecked(p.isSelected());
            holder.chkbox.setTag(p);


		return v;
	}


}
//*/