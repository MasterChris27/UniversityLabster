package com.example.cami.universitylabster.administrare_resurse;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cami.universitylabster.R;
import com.example.cami.universitylabster.base_classes.CourseId;


import java.util.ArrayList;


public class AdapterCursuri extends BaseAdapter {
    private ArrayList<CourseId> listData;
    private LayoutInflater layoutInflater;

    public AdapterCursuri(Context aContext, ArrayList<CourseId> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ResourceAsColor")
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.orar_unit, null);
            holder = new ViewHolder();

            holder.ora = convertView.findViewById(R.id.elem_ora);
            holder.numeCurs = convertView.findViewById(R.id.elem_curs);
            holder.numeProf = convertView.findViewById(R.id.elem_prof);
            holder.prezent = convertView.findViewById(R.id.elem_check_in);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.ora.setText(listData.get(position).getOraStart());
        holder.numeCurs.setText(listData.get(position).getNameCourse());
        holder.numeProf.setText(listData.get(position).getNumeProf());
        if (listData.get(position).checkPresent(listData.get(position).getIdUser())) {
            holder.prezent.setBackgroundColor(R.color.colorPrimary);
        } else {
            holder.prezent.setBackgroundColor(R.color.red);
        }

        return convertView;
    }

    static class ViewHolder {
        TextView ora, numeCurs, numeProf;
        View prezent;
    }
}
