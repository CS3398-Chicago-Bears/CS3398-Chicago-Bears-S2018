package com.cs3398.sportsapp.Model;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.cs3398.sportsapp.R;

import java.nio.charset.Charset;
import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<User>{
    public ArrayList<User> MainList;
    public ArrayList<User> Temp;
    public UserAdapter.UserFilter filter;
    public UserAdapter(Context context, int id, ArrayList<User> UserList){
        super(context, id, UserList);
        this.Temp = new ArrayList<>();
        this.Temp.addAll(UserList);
        this.MainList = new ArrayList<>();
        this.MainList.addAll(UserList);
    }

    @Override
    public Filter getFilter(){
        if(filter == null){
            filter = new UserAdapter.UserFilter();
        }
        return filter;
    }

    public class ViewHolder{
        TextView Name;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent){
        UserAdapter.ViewHolder holder = null;
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_layout, null);
            holder = new UserAdapter.ViewHolder();
            holder.Name = (TextView)convertView.findViewById(R.id.textviewName);
            convertView.setTag(holder);
        }
        else{
            holder = (UserAdapter.ViewHolder)convertView.getTag();
        }
        User u = Temp.get(pos);
        holder.Name.setText(u.getUserName());
        return convertView;
    }

    private class UserFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence charSequence){
            charSequence = charSequence.toString().toLowerCase();
            FilterResults filterResults = new FilterResults();
            if(charSequence != null && charSequence.toString().length() > 0){
                ArrayList<User> List1 = new ArrayList<>();
                for(int i=0, l = MainList.size(); i < l; i++){
                    User subject = MainList.get(i);
                    if(subject.getUserName().toLowerCase().contains(charSequence)){
                        List1.add(subject);
                    }
                }
                filterResults.count = List1.size();
                filterResults.values = List1;
            }
            else{
                synchronized(this){
                    filterResults.values = MainList;
                    filterResults.count = MainList.size();
                }
            }
            return filterResults;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults){
            Temp = (ArrayList<User>)filterResults.values;
            notifyDataSetChanged();
            clear();
            for(int i=0, l = Temp.size();i < l; i++){
                add(Temp.get(i));
            }
            notifyDataSetInvalidated();
        }
    }
}
