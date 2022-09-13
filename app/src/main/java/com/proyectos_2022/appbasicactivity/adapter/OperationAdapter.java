package com.proyectos_2022.appbasicactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.proyectos_2022.appbasicactivity.R;

public class OperationAdapter extends BaseAdapter {

    Context context;
    String[] operationNames;
    int[] operationIcons;

    public OperationAdapter(Context context, String[] operationNames, int[] operationIcons) {
        this.context = context;
        this.operationNames = operationNames;
        this.operationIcons = operationIcons;
    }

    @Override
    public int getCount() {
        return operationIcons.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        /*view = LayoutInflater.from(context).inflate(R.layout.fragment_second, viewGroup, false);
        ImageView imageView = view.findViewById(R.id.);*/

        return view;
    }
}
