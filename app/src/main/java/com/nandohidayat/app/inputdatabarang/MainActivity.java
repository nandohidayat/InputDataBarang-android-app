package com.nandohidayat.app.inputdatabarang;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.List;

public class MainActivity extends ListActivity {
    String dataBarang[] = null;
    String dB[] = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);

        db.addBarang(new Barang("B0001", "Buku", 5000.0, 6000.0, 100));

        List<Barang> barangList = db.getSemuaBarang();
        dataBarang = new String[barangList.size()];
        dB = new String[barangList.size()];
        int i = 0;
        for(Barang barang : barangList) {
            dataBarang[i] = barang.getKodeBarang() +
                    " | " + barang.getNamaBarang() +
                    " | " + barang.getHargaBeli() +
                    " | " + barang.getHargaJual() +
                    " | " + barang.getStok();
            dB[i] = barang.getKodeBarang();
            i++;
        }

        setListAdapter(new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1, dataBarang));
        registerForContextMenu(getListView());
    }
}
