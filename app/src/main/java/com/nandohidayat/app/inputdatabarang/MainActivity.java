package com.nandohidayat.app.inputdatabarang;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Action");
        menu.add(0,0,0,"Tambah");
        menu.add(0,1,1,"Hapus");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        try {
            switch (item.getItemId()) {
                case 0: {
                    Class c = Class.forName("com.nandohidayat.app.inputdatabarang.TambahActivity");
                    Intent i = new Intent(MainActivity.this, c);
                    startActivity(i);
                    break;
                }
                case 1: {
                    DatabaseHandler db = new DatabaseHandler(this);
                    AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    db.deleteRow(dB[info.position]);
                    Class c = Class.forName("com.nandohidayat.app.inputdatabarang.MainActivity");
                    Intent i = new Intent(MainActivity.this, c);
                    startActivity(i);
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
