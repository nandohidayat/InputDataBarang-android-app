package com.nandohidayat.app.inputdatabarang;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "Toko";

    private static final String TABLE_BARANG = "Barang";

    private static final String KEY_KODEBARANG = "KdBrg";
    private static final String KEY_NAMABARANG = "NmBrg";
    private static final String KEY_HARGABELI = "HrgBeli";
    private static final String KEY_HARGAJUAL = "HrgJual";
    private static final String KEY_STOK = "Stok";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_table_barang =
                "CREATE TABLE " + TABLE_BARANG + "(" +
                        KEY_KODEBARANG + " TEXT PRIMARY KEY," +
                        KEY_NAMABARANG + " TEXT," +
                        KEY_HARGABELI + " REAL," +
                        KEY_HARGAJUAL + " REAL," +
                        KEY_STOK + " INTEGER)";
        db.execSQL(query_table_barang);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BARANG);
        onCreate(db);
    }

    public void addBarang(Barang barang) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_KODEBARANG, barang.getKodeBarang());
        values.put(KEY_NAMABARANG, barang.getNamaBarang());
        values.put(KEY_HARGABELI, barang.getHargaBeli());
        values.put(KEY_HARGAJUAL, barang.getHargaJual());
        values.put(KEY_STOK, barang.getStok());
        db.insert(TABLE_BARANG, null, values);
        db.close();
    }

    public Barang getBarang(String KdBrg) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_BARANG,
                new String[]{KEY_KODEBARANG, KEY_NAMABARANG, KEY_HARGABELI, KEY_HARGAJUAL, KEY_STOK},
                KEY_KODEBARANG + "=?",
                new String[]{KdBrg},
                null,
                null,
                null,
                null);
        if (cursor != null)
            cursor.moveToFirst();
        Barang barang = new Barang(
                cursor.getString(0),
                cursor.getString(1),
                cursor.getDouble(2),
                cursor.getDouble(3),
                cursor.getInt(4));
        return barang;
    }

    public List<Barang> getSemuaBarang() {
        List<Barang> barangList = new ArrayList<Barang>();
        String query_select_barang = "SELECT * FROM " + TABLE_BARANG;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query_select_barang, null);
        if(cursor.moveToFirst()) {
            do {
                Barang barang = new Barang(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getDouble(2),
                        cursor.getDouble(3),
                        cursor.getInt(4));
                barangList.add(barang);
            } while (cursor.moveToNext());
        }
        return barangList;
    }

    public void deleteBarang(Barang barang) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BARANG, KEY_KODEBARANG + "='" + barang.getKodeBarang() + "'", null);
        db.close();
        System.out.println("Data terhapus " + barang.getKodeBarang());
    }

    public void deleteRow(Barang xKdBrg) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BARANG, KEY_KODEBARANG + "='" + xKdBrg + "'", null);
        db.close();
        System.out.println("Data terhapus " + xKdBrg);
    }
}
