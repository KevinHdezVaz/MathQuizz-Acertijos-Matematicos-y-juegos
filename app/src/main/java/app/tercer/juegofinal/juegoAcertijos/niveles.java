package app.tercer.juegofinal.juegoAcertijos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.tercer.juegofinal.Adaptadores.CustomAdapter;
import app.tercer.juegofinal.Adaptadores.Spacecraft;
import app.tercer.juegofinal.MenuJuegos;
import app.tercer.juegofinal.PreferenciaNvl;
import app.tercer.juegofinal.R;

public class niveles extends AppCompatActivity {
    private CustomAdapter adaptador;
    Dialog epicDialog;
    ImageView cerrar;
    Button botonvam,btnvam2;
    private GridView grid;
    nivel1 nvl = new nivel1();
    nivel2 nvl2 = new nivel2();
Boolean itemsLocked,level2;
RelativeLayout cambiodecolor;
    Toolbar toolbar;
CardView relativeLayout;
    ArrayList<Spacecraft> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);
      listItems = new ArrayList<>();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(niveles.this, MenuJuegos.class));
                finish();
            }
        });


        cambiodecolor = findViewById(R.id.cambiodecolor);
        epicDialog = new Dialog(this);

        level2 = nvl2.pasarnvl;
        grid = (GridView)  findViewById(R.id.item);


         listItems.add(new Spacecraft((R.drawable.uno) ));
        listItems.add(new Spacecraft((R.drawable.dos) ));
        listItems.add(new Spacecraft((R.drawable.tres)));

        listItems.add(new Spacecraft((R.drawable.cuatro)));
        listItems.add(new Spacecraft((R.drawable.cinco)));
        listItems.add(new Spacecraft((R.drawable.seis)));

        listItems.add(new Spacecraft((R.drawable.siete)));
        listItems.add(new Spacecraft((R.drawable.ocho)));
        listItems.add(new Spacecraft((R.drawable.nueve)));
        listItems.add(new Spacecraft((R.drawable.diez)));

        listItems.add(new Spacecraft((R.drawable.once)));
        listItems.add(new Spacecraft((R.drawable.doce)));
        listItems.add(new Spacecraft((R.drawable.trece)));
        listItems.add(new Spacecraft((R.drawable.catorce)));
        listItems.add(new Spacecraft((R.drawable.quice)));
        listItems.add(new Spacecraft((R.drawable.diesiseis)));
        listItems.add(new Spacecraft((R.drawable.diesisiete)));
        listItems.add(new Spacecraft((R.drawable.diesiocho)));
        listItems.add(new Spacecraft((R.drawable.diesnueve)));
        listItems.add(new Spacecraft((R.drawable.veinte)));
        listItems.add(new Spacecraft((R.drawable.veintiuno)));
        listItems.add(new Spacecraft((R.drawable.veintidos)));
        listItems.add(new Spacecraft((R.drawable.veintitres)));
        listItems.add(new Spacecraft((R.drawable.veinticuatro)));
        listItems.add(new Spacecraft((R.drawable.veinticinco)));
        listItems.add(new Spacecraft((R.drawable.veintiseis)));
        listItems.add(new Spacecraft((R.drawable.veintisiete)));
        listItems.add(new Spacecraft((R.drawable.veintiocho)));
        listItems.add(new Spacecraft((R.drawable.veintinueve)));
        listItems.add(new Spacecraft((R.drawable.treinta)));






        switch (PreferenciaNvl.getLevel(getApplicationContext())){

            case 0:
                //No realiza nada
                break;
            case 1:

                startActivity(new Intent(niveles.this, nivel1.class));
               break;
            case 2:
                startActivity(new Intent(niveles.this, nivel2.class));

                 break;
            case 3:
                startActivity(new Intent(niveles.this, nivel3.class));
                break;
            case 4:
                startActivity(new Intent(niveles.this, nivel4.class));
                break;
            case 5:
                startActivity(new Intent(niveles.this, nivel5.class));
                break;
            case 6:
                startActivity(new Intent(niveles.this, nivel6.class));
                break;
            case 7:
                startActivity(new Intent(niveles.this, nivel7.class));
                break;
            case 8:
                startActivity(new Intent(niveles.this, nivel8.class));
                break;

            case 9:
                startActivity(new Intent(niveles.this, nivel9.class));
                break;

            case 10:
                startActivity(new Intent(niveles.this, nivel10.class));
                break;
            case 11:
                startActivity(new Intent(niveles.this, nivel11.class));
                break;
            case 12:
                startActivity(new Intent(niveles.this, nivel12.class));
                break;
            case 13:
                startActivity(new Intent(niveles.this, nivel13.class));
                break;
            case 14:
                startActivity(new Intent(niveles.this, nivel14.class));
                break;

            case 15:
                startActivity(new Intent(niveles.this, nivel15.class));
                break;
            case 16:
                startActivity(new Intent(niveles.this, nivel16.class));
                break;
            case 17:
                startActivity(new Intent(niveles.this, nivel17.class));
                break;


        }
        adaptador = new CustomAdapter(this, listItems);
        grid.setAdapter(adaptador);



        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {


                if (position == 0) {

                    Intent intent = new Intent(niveles.this, nivel1.class);
                     startActivity(intent);

                 }


if(position==1) {
    if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==2)
    {

        Intent intent = new Intent(niveles.this, nivel2.class);
        startActivity(intent);

    }

     isEnabled(1);

}

                if(position==2) {
                    if(PreferenciaNvl.getlvlCompleto(getApplicationContext()) ==3)
                    {

                        Intent intent = new Intent(niveles.this, nivel3.class);
                        startActivity(intent);

                    }

                    isEnabled(2);

                }

                if(position==3) {
                    //    if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==4)
                    {

                        Intent intent = new Intent(niveles.this, nivel4.class);
                        startActivity(intent);

                    }
                    //  isEnabled(3);

                }

                if(position==4) {
                    //  if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==5)
                    {

                        Intent intent = new Intent(niveles.this, nivel5.class);
                        startActivity(intent);

                    }
                    //   isEnabled(4);

                }

                if(position==5) {
                    //   if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==6)
                    {

                        Intent intent = new Intent(niveles.this, nivel6.class);
                        startActivity(intent);

                    }
                    //   isEnabled(5);

                }

                if(position==6) {
                    //    if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==7)
                    {

                        Intent intent = new Intent(niveles.this, nivel7.class);
                        startActivity(intent);

                    }
                    //  isEnabled(6);

                }

                if(position==7) {
                    //   if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==8)
                    {

                        Intent intent = new Intent(niveles.this, nivel8.class);
                        startActivity(intent);

                    }
                    //   isEnabled(7);

                }

                if(position==8) {
                    //     if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==9)
                    {

                        Intent intent = new Intent(niveles.this, nivel9.class);
                        startActivity(intent);

                    }
                    //   isEnabled(8);

                }

                if(position==9) {
                    //      if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==10)
                    {

                        Intent intent = new Intent(niveles.this, nivel10.class);
                        startActivity(intent);

                    }
                    //      isEnabled(9);

                }
                if(position==10) {
                    //   if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==11)
                    {

                        Intent intent = new Intent(niveles.this, nivel11.class);
                        startActivity(intent);

                    }
                    //   isEnabled(10);

                }
                if(position==11) {
                    //if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==12)


                        Intent intent = new Intent(niveles.this, nivel12.class);
                        startActivity(intent);


                    //isEnabled(11);

                }
                if(position==12) {
                    //if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==13)


                    Intent intent = new Intent(niveles.this, nivel13.class);
                    startActivity(intent);


                    //isEnabled(12);

                }
                if(position==13) {
                    //if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==14)


                    Intent intent = new Intent(niveles.this, nivel14.class);
                    startActivity(intent);


                    //isEnabled(13);

                }
                if(position==14) {
                    //if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==15)


                    Intent intent = new Intent(niveles.this, nivel15.class);
                    startActivity(intent);


                    //isEnabled(14);

                }
                if(position==15) {
                    //if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==16)


                    Intent intent = new Intent(niveles.this, nivel16.class);
                    startActivity(intent);


                    //isEnabled(15);

                }
                if(position==16) {
                    //if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==17)


                    Intent intent = new Intent(niveles.this, nivel17.class);
                    startActivity(intent);


                    //isEnabled(16);

                }
                if(position==17) {
                    //if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==17)


                    Intent intent = new Intent(niveles.this, nivel18.class);
                    startActivity(intent);


                    //isEnabled(16);

                }      if(position==18) {
                    //if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==17)


                    Intent intent = new Intent(niveles.this, nivel19.class);
                    startActivity(intent);


                    //isEnabled(16);

                }      if(position==19) {
                    //if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==17)


                    Intent intent = new Intent(niveles.this, nivel20.class);
                    startActivity(intent);


                    //isEnabled(16);

                }
                if(position==20) {
                    //if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==17)


                    Intent intent = new Intent(niveles.this, nivel21.class);
                    startActivity(intent);


                    //isEnabled(16);

                }
                if(position==21) {
                    //if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==17)


                    Intent intent = new Intent(niveles.this, nivel22.class);
                    startActivity(intent);


                    //isEnabled(16);

                }
                if(position==22) {
                    //if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==17)


                    Intent intent = new Intent(niveles.this, nivel23.class);
                    startActivity(intent);


                    //isEnabled(16);

                }   if(position==23) {
                    //if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==17)


                    Intent intent = new Intent(niveles.this, nivel24.class);
                    startActivity(intent);


                    //isEnabled(16);

                }
                if(position==24) {
                    //if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==17)


                    Intent intent = new Intent(niveles.this, nivel25.class);
                    startActivity(intent);


                    //isEnabled(16);

                }
                if(position==25) {
                    //if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==17)


                    Intent intent = new Intent(niveles.this, nivel26.class);
                    startActivity(intent);


                    //isEnabled(16);

                }
                if(position==26) {
                    //if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==17)


                    Intent intent = new Intent(niveles.this, nivel27.class);
                    startActivity(intent);


                    //isEnabled(16);

                }

            }
        });




}
    public boolean isEnabled(int position) {


        return false;
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(niveles.this,MenuJuegos.class));
        finish();
    }
}


