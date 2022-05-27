package id.ac.unsyiah.uangku;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper2 extends SQLiteOpenHelper {
    private static  final String DATABASE_NAME = "Uangku.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper2(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //buat tabel pengeluaran
        String sql2 = "create table pengeluaran(tanggal text null, kategori text null, item text null, harga int null);";
        Log.d("Data", "onCreate : " + sql2);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db0, int db1, int db2){
    }
}
