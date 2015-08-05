package com.siddhanta.wallpaperchangerversion2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sidd.c on 5/8/2015.
 */

class Subreddits {

    String name;
    boolean selected = false;

    public Subreddits(String m_name) {
        super();
        this.name = m_name;
    }

    public  String getName() { return name;}

    public void setName(String m_name) { this.name = m_name;}

    public boolean isSelected() { return selected;}

    public  void setSelected(boolean selected) { this.selected = selected; }
}

public class SubredditsAdapter extends ArrayAdapter<Subreddits> {

    private List<Subreddits> subsList;
    private Context context;

    public SubredditsAdapter(List<Subreddits> m_subsList, Context m_context) {

        super(m_context,R.layout.single_list_item, m_subsList);
        this.subsList = m_subsList;
        this.context = m_context;
    }

    private static class SubsHolder {
        public TextView subName;
        public CheckBox checkBox;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        SubsHolder holder = new SubsHolder();

        if(convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.single_list_item, null);

            holder.subName = (TextView) v.findViewById(R.id.subname);
            holder.checkBox = (CheckBox) v.findViewById(R.id.chk_box);

            holder.checkBox.setOnCheckedChangeListener(null);
        }
        else {
            holder = (SubsHolder) v.getTag();
        }

        Subreddits p = subsList.get(position);
        holder.subName.setText(p.getName());
        holder.checkBox.setChecked(p.isSelected());
        holder.checkBox.setTag(p);
        return v;

    }

}
