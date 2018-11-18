package com.nandohidayat.app.inputdatabarang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TambahActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah);

        final DatabaseHandler db = new DatabaseHandler(this);
        final EditText editKdBrg = (EditText) findViewById(R.id.inKdBrg);
        final EditText editNmBrg = (EditText) findViewById(R.id.inNmBrg);
        final EditText editHrgBeli = (EditText) findViewById(R.id.inHrgBeli);
        final EditText editHrgJual = (EditText) findViewById(R.id.inHrgJual);
        final EditText editStok = (EditText) findViewById(R.id.inStok);
        final Button btnTambah = (Button) findViewById(R.id.btnTambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String KdBrg = editKdBrg.getText().toString();
                String NmBrg = editNmBrg.getText().toString();
                Double HrgBeli = Double.parseDouble(editHrgBeli.getText().toString());
                Double HrgJual = Double.parseDouble(editHrgJual.getText().toString());
                int Stok = Integer.parseInt(editStok.getText().toString());

                db.addBarang(new Barang(KdBrg, NmBrg, HrgBeli, HrgJual, Stok));

                editKdBrg.setText("");
                editNmBrg.setText("");
                editHrgBeli.setText("");
                editHrgJual.setText("");
                editStok.setText("");

                try {
                    Class c = Class.forName("com.nandohidayat.app.inputdatabarang.MainActivity");
                    Intent i = new Intent(TambahActivity.this, c);
                    startActivity(i);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
