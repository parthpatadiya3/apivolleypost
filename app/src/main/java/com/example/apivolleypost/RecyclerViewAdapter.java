package com.example.apivolleypost;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    List<personlist>personlists;

    public RecyclerViewAdapter(List<personlist> list)
    {
            this.personlists=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {    LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listitem = layoutInflater.inflate(R.layout.list, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(listitem);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i)
    {
        //holder.userid.setText(personlist.get(i).getUserId());
        holder.textView.setText(personlists.get(i).getUname());
        holder.textView2.setText(personlists.get(i).getEmail());
    }


    @Override
    public int getItemCount()
    {
        return personlists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView,textView2;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textView=itemView.findViewById(R.id.textview1);
            textView2=itemView.findViewById(R.id.textview2);
        }
    }
}
