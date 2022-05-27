package id.ac.unsyiah.uangku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomePemasukan extends AppCompatActivity {
    Button homepeng, statistik, pengaturan, akun, add;
    String[] daftar;
    ListView listView;
    Menu menu;
    protected Cursor cursor;
    DataHelper database;
    public static HomePemasukan hpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pemasukan);

        homepeng = (Button) findViewById(R.id.home_peng);

        homepeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bukaHomePeng = new Intent(getApplicationContext(), HomePengeluaran.class);
                startActivity(bukaHomePeng);
            }
        });

        statistik = (Button) findViewById(R.id.to_sta);
        statistik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buka_statistik = new Intent(getApplicationContext(), StatistikPengeluaran.class);
                startActivity(buka_statistik);
            }
        });
//        add = (Button) findViewById(R.id.to_add);
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent buka_add = new Intent(getApplicationContext(), AddPengeluaran.class);
//                startActivity(buka_add);
//            }
//        });
        FloatingActionButton add = findViewById(R.id.to_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buka_add = new Intent(HomePemasukan.this, AddPemasukan.class);
                startActivity(buka_add);
            }
        });

        pengaturan = (Button) findViewById(R.id.to_set);
        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buka_set = new Intent(getApplicationContext(), Pengaturan.class);
                startActivity(buka_set);
            }
        });

        akun = (Button) findViewById(R.id.to_acc);
        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buka_acc = new Intent(getApplicationContext(), Akun.class);
                startActivity(buka_acc);
            }
        });

        hpl = this;
        database = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pemasukan", null );
        daftar = new String [cursor.getCount()];
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
            daftar[i] = cursor.getString(2).toString();
        }
        listView = (ListView) findViewById(R.id.item);
        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        listView.setSelected(true);
    }

}