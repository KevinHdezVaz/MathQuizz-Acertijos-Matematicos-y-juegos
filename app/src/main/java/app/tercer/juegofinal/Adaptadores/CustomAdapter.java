package app.tercer.juegofinal.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.tercer.juegofinal.R;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Spacecraft> listItem;

    public CustomAdapter(Context context, ArrayList<Spacecraft> listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int i) {
        return listItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Spacecraft Item =(Spacecraft)getItem(i);
        view = LayoutInflater.from(context).inflate(R.layout.modelo_gridview,null);
        ImageView imagen = (ImageView)view.findViewById(R.id.imagen);

        imagen.setImageResource(Item.getImgFoto());
         return view;



    }


}