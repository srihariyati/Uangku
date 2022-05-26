package id.ac.unsyiah.uangku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddPengeluaran extends AppCompatActivity {
    Button back, addpem, yes, no, buka_pil,p1,p2,p3,p4;
    ImageButton simpan, batal, pu_simpan;
    FrameLayout pu_batal, pilihan;
    DataHelper database;
    String kategori;
    EditText tanggal, namaItem, harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pengeluaran);

        pu_simpan = (ImageButton) findViewById(R.id.popupberhasil);
        pu_simpan.setVisibility(View.INVISIBLE);

        pu_batal = (FrameLayout) findViewById(R.id.popupbatal);
        pu_batal.setVisibility(View.INVISIBLE);

        pilihan = (FrameLayout) findViewById(R.id.pilihan_peng);
        pilihan.setVisibility(View.INVISIBLE);

        back = (Button) findViewById(R.id.btn_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bukaHome = new Intent(getApplicationContext(), HomePengeluaran.class);
                startActivity(bukaHome);
            }
        });

        addpem = (Button) findViewById(R.id.add_pem);
        addpem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bukaAddPem = new Intent(getApplicationContext(), AddPemasukan.class);
                startActivity(bukaAddPem);
            }
        });


        simpan = (ImageButton) findViewById(R.id.btn_simpan);
        //saat klik tombol simpan, menampilkan pop up berhasil simpan
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pu_simpan.setVisibility(View.VISIBLE);

                pu_simpan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent bukaHome = new Intent(getApplicationContext(), HomePengeluaran.class);
                        startActivity(bukaHome);
                    }
                });
            }
        });

        batal = (ImageButton) findViewById(R.id.btn_batal);
        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pu_batal.setVisibility(View.VISIBLE);

                yes = (Button) findViewById(R.id.v);
                no = (Button) findViewById(R.id.x);

                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent bukaHome = new Intent(getApplicationContext(), HomePengeluaran.class);
                        startActivity(bukaHome);
                    }
                });

                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pu_batal.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        buka_pil = (Button) findViewById(R.id.buka_pilihan);
        buka_pil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pilihan.setVisibility(View.VISIBLE);

                p1 = (Button) findViewById(R.id.pil1);
                p2 = (Button) findViewById(R.id.pil2);
                p3 = (Button) findViewById(R.id.pil3);
                p4 = (Button) findViewById(R.id.pil4);

                p1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        kategori = "Makanan";
                    }
                });
                p2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        kategori = "Minuman";
                    }
                });
                p3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        kategori = "Internet";
                    }
                });
                p4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        kategori = "Rumah";
                    }
                });

                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("insert into pengeluaran(tanggal, kategori, item, harga) values(' "+
                        tanggal.getText().toString() +"','"+
                        kategori +"','"+
                        namaItem.getText().toString()+ "','"+
                        harga.getText().toString()+"')");
                Toast.makeText(AddPengeluaran.this,"Data Tersimpan", Toast.LENGTH_SHORT).show();
                HomePengeluaran.hpr.RefreshList();
                finish();

            }
        });

    }
}