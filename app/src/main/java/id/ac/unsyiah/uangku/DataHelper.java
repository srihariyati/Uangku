package id.ac.unsyiah.uangku;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static  final String DATABASE_NAME = "Uangku.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    private static final String TABLE_PEMASUKAN = "pemasukan";
    private static final String TABLE_PENGELUARAN = "pengeluaran";
    private static final String KEY_TANGGAL = "tanggal";
    private static final String KEY_KATEGORI = "kategori";
    private static final String KEY_ITEM = "item";
    private static final String KEY_HARGA = "harga";

    private static final String CREATE_TABLE_PEMASUKAN = "CREATE TABLE "
            + TABLE_PEMASUKAN + "(" + KEY_TANGGAL + " TEXT,"+ KEY_KATEGORI + "TEXT," + KEY_ITEM + "TEXT," + KEY_HARGA + "INT );";
    private static final String CREATE_TABLE_PENGELUARAN = "CREATE TABLE "
            + TABLE_PENGELUARAN + "(" + KEY_TANGGAL + " TEXT,"+ KEY_KATEGORI + "TEXT," + KEY_ITEM + "TEXT," + KEY_HARGA + "INT );";


    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_PEMASUKAN);
        db.execSQL(CREATE_TABLE_PENGELUARAN);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db0, int db1, int db2){
    }
}
