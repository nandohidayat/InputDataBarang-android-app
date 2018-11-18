package com.nandohidayat.app.inputdatabarang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Barang> {
    private List<Barang> dataSet;
    Context context;

    public CustomAdapter(List<Barang> data, Context context) {
        super(context, 0, data);
        this.dataSet = data;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);

        Barang barang = dataSet.get(position);

        TextView textKdBrg = (TextView) listItem.findViewById(R.id.textKdBrg);
        textKdBrg.setText(barang.getKodeBarang());

        TextView textNmBrg = (TextView) listItem.findViewById(R.id.textNmBrg);
        textNmBrg.setText(barang.getNamaBarang());

        TextView textHrgBeli = (TextView) listItem.findViewById(R.id.textHrgBeli);
        textHrgBeli.setText(String.format("Rp %.2f",barang.getHargaBeli()));

        TextView textHrgJual = (TextView) listItem.findViewById(R.id.textHrgJual);
        textHrgJual.setText(String.format("Rp %.2f",barang.getHargaJual()));

        TextView textStok = (TextView) listItem.findViewById(R.id.textStok);
        textStok.setText(String.format("%d",barang.getStok()));

        return listItem;
    }
}
