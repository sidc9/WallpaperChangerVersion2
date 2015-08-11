package com.siddhanta.wallpaperchangerversion2;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

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
		// TODO Auto-generated constructor stub
	}
	

	private static class SubsHolder {
		public TextView subName;
		public CheckBox chkbox;
	
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = convertView;
		
		SubsHolder holder = new SubsHolder();


		if(convertView == null) {
				
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.single_listview_item, null);
			
			holder.subName = (TextView) v.findViewById(R.id.subname);
			holder.chkbox = (CheckBox) v.findViewById(R.id.chk_box);
			
			//holder.chkbox.setOnCheckedChangeListener((MainActivity) context);
			
		} else {
			holder = (SubsHolder) v.getTag();
		}
		
		Subreddits p = subsList.get(position);
		holder.subName.setText(p.getName());
		holder.chkbox.setChecked(p.isSelected());
		holder.chkbox.setTag(p);
		return v;
	}

}
//*/