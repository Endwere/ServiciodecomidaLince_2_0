package tecnm.celaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActividadCatalogo extends AppCompatActivity {
    LinearLayout L;
    BaseDeDatos obj;
    Bundle bundle = new Bundle();
    int cuenta = 0;
    boolean ArrayVacio = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_catalogo);

        obj = (BaseDeDatos) ((ObjectWrapperForBinder) getIntent().getExtras().getBinder("object_value")).getData();
        bundle.putBinder("object_value", new ObjectWrapperForBinder(obj));
        /////////////////////
        eventosBotones();
        iniciarComps();
        InsertOnHolders();
    }

    private void eventosBotones() {
        Button botonRegresar = findViewById(R.id.buttonHome);
        eventoBotonRegresar(botonRegresar);
        Button botonAnterior = findViewById(R.id.buttonAnterior);
        eventoBotonAnterior(botonAnterior);
        Button botonSiguiente = findViewById(R.id.buttonSiguiente);
        eventoBotonSiguiente(botonSiguiente);
    }

    void iniciarComps() {
        LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 4);
        LinearLayout.LayoutParams params5 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1);
        L = (LinearLayout) findViewById(R.id.LayoutDisplayBase);
/////////////////////////rows
        LinearLayout lA = new LinearLayout(this);
        LinearLayout lB = new LinearLayout(this);
        LinearLayout lC = new LinearLayout(this);
        LinearLayout lD = new LinearLayout(this);

        formatoLayoutRows(lB);//params
        formatoLayoutRows(lA);
        formatoLayoutRows(lC);
        formatoLayoutRows(lD);

        lA.setId(R.id.layoutA);
        lB.setId(R.id.layoutB);
        lC.setId(R.id.layoutC);
        lD.setId(R.id.layoutD);

        L.addView(lA);
        L.addView(lB);
        L.addView(lC);
        L.addView(lD);
        ////////////////////////////////////////////////////PlaceHolders
        LinearLayout lA1 = new LinearLayout(this);
        LinearLayout lB1 = new LinearLayout(this);
        LinearLayout lC1 = new LinearLayout(this);
        LinearLayout lD1 = new LinearLayout(this);

        LinearLayout lA2 = new LinearLayout(this);
        LinearLayout lB2 = new LinearLayout(this);
        LinearLayout lC2 = new LinearLayout(this);
        LinearLayout lD2 = new LinearLayout(this);

        LinearLayout lA3 = new LinearLayout(this);
        LinearLayout lB3 = new LinearLayout(this);
        LinearLayout lC3 = new LinearLayout(this);
        LinearLayout lD3 = new LinearLayout(this);

        LinearLayout lA4 = new LinearLayout(this);
        LinearLayout lB4 = new LinearLayout(this);
        LinearLayout lC4 = new LinearLayout(this);
        LinearLayout lD4 = new LinearLayout(this);

        formatoLayoutHolders(lB1);
        formatoLayoutHolders(lA1);
        formatoLayoutHolders(lC1);
        formatoLayoutHolders(lD1);

        formatoLayoutHolders(lB2);
        formatoLayoutHolders(lA2);
        formatoLayoutHolders(lC2);
        formatoLayoutHolders(lD2);

        formatoLayoutHolders(lB3);
        formatoLayoutHolders(lA3);
        formatoLayoutHolders(lC3);
        formatoLayoutHolders(lD3);

        formatoLayoutHolders(lB4);
        formatoLayoutHolders(lA4);
        formatoLayoutHolders(lC4);
        formatoLayoutHolders(lD4);

        lA1.setId(R.id.layoutA1);
        lA2.setId(R.id.layoutA2);
        lA3.setId(R.id.layoutA3);
        lA4.setId(R.id.layoutA4);

        lB1.setId(R.id.layoutB1);
        lB2.setId(R.id.layoutB2);
        lB3.setId(R.id.layoutB3);
        lB4.setId(R.id.layoutB4);

        lC1.setId(R.id.layoutC1);
        lC2.setId(R.id.layoutC2);
        lC3.setId(R.id.layoutC3);
        lC4.setId(R.id.layoutC4);

        lD1.setId(R.id.layoutD1);
        lD2.setId(R.id.layoutD2);
        lD3.setId(R.id.layoutD3);
        lD4.setId(R.id.layoutD4);


        lA.addView(lA1);
        lB.addView(lB1);
        lC.addView(lC1);
        lD.addView(lD1);
        lA.addView(lA2);
        lB.addView(lB2);
        lC.addView(lC2);
        lD.addView(lD2);
        lA.addView(lA3);
        lB.addView(lB3);
        lC.addView(lC3);
        lD.addView(lD3);
        lA.addView(lA4);
        lB.addView(lB4);
        lC.addView(lC4);
        lD.addView(lD4);
    }

    void formatoLayoutRows(LinearLayout a) {
        a.setBackgroundColor(Color.parseColor("#00FFF6"));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 4);
        a.setWeightSum(4);
        a.setOrientation(LinearLayout.HORIZONTAL);
        a.setLayoutParams(params);
    }

    void formatoLayoutHolders(LinearLayout a) {
        a.setBackgroundColor(Color.parseColor("#F3C975"));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1);
        a.setLayoutParams(params);
        a.setOrientation(LinearLayout.VERTICAL);
    }

    void InsertOnHolders() {
        //////////////////nombres
        String nombres[] = new String[16];

        for (int i = 0; i < 16; i++) {
            nombres[i] = obj.nombre[i];
            if (nombres[i] == null) {
                break;
            }
            cuenta++;
        }
        if (cuenta == 0) {//si nombres está vacio acaba el metodo
            return;
        }
        ///////////////imagenes
        ImageView imagenes[] = new ImageView[16];

        for (int i = 0; i < cuenta; i++) {//proceso para asignar imagenes a el array

            ImageView img = new ImageView(this);
            switch (i) {

                case 0:
                    img.setImageDrawable(getDrawable(R.drawable._enchilada));
                    //imagenes[i]=img;
                    imagenes[i] = img;
                    break;
                case 1:
                    img.setImageDrawable(getDrawable(R.drawable._picadillo));
                    imagenes[i] = img;
                    break;
                case 2:
                    img.setImageDrawable(getDrawable(R.drawable._alitas));
                    //imagenes[i]=img;
                    imagenes[i] = img;

                    break;
                case 3:
                    img.setImageDrawable(getDrawable(R.drawable._enchilada_2));
                    imagenes[i] = img;
                    break;
                case 4:
                    img.setImageDrawable(getDrawable(R.drawable._ensalada_1));
                    imagenes[i] = img;
                    break;
                case 5:
                    img.setImageDrawable(getDrawable(R.drawable._ensalada_2));
                    imagenes[i] = img;
                    break;
                case 6:
                    img.setImageDrawable(getDrawable(R.drawable._filete));
                    imagenes[i] = img;
                    break;
                case 7:
                    img.setImageDrawable(getDrawable(R.drawable._malteada));
                    imagenes[i] = img;
                    break;
                case 8:
                    img.setImageDrawable(getDrawable(R.drawable._mollelinces));
                    imagenes[i] = img;
                    break;
                case 9:
                    img.setImageDrawable(getDrawable(R.drawable._omelet));
                    imagenes[i] = img;
                    break;
                case 10:
                    img.setImageDrawable(getDrawable(R.drawable._quesadillas));
                    imagenes[i] = img;
                    break;
                case 11:
                    img.setImageDrawable(getDrawable(R.drawable._sandwitch));
                    imagenes[i] = img;
                    break;
                case 12:
                    img.setImageDrawable(getDrawable(R.drawable._sushi));
                    imagenes[i] = img;
                    break;
                case 13:
                    img.setImageDrawable(getDrawable(R.drawable._tacos_1));
                    imagenes[i] = img;
                    break;
                case 14:
                    img.setImageDrawable(getDrawable(R.drawable._torta_2));
                    imagenes[i] = img;
                    break;
            }
            if (imagenes[i] == null) {
                img.setImageDrawable(getDrawable(R.drawable._image_placeholder));
                imagenes[i] = img;
            }
            eventoImageView(imagenes[i],i);

        }
        ////////////////añadir contenido a holders
        for (int i = 0; i < cuenta; i++) {

            Button btn = new Button(this);
            TextView txt = new TextView(this);

            btn.setText("Button");

            txt.setText(nombres[i]);
            txt.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            txt.setTextColor(Color.parseColor("#AE2017"));

            LinearLayout b;

            switch (i) {

                case 0:
                    b = (LinearLayout) findViewById(R.id.layoutA1);
                    formatoImageView(imagenes[i + (16 * obj.indicePag)]);
                    b.addView(imagenes[i + (16 * obj.indicePag)]);
                    b.addView(txt);
                    break;
                case 1:
                    b = (LinearLayout) findViewById(R.id.layoutA2);
                    formatoImageView(imagenes[i]);
                    b.addView(imagenes[i]);
                    b.addView(txt);

                    break;
                case 2:
                    b = (LinearLayout) findViewById(R.id.layoutA3);

                    formatoImageView(imagenes[i]);
                    b.addView(imagenes[i]);
                    b.addView(txt);

                    break;
                case 3:
                    b = (LinearLayout) findViewById(R.id.layoutA4);
                    formatoImageView(imagenes[i]);
                    b.addView(imagenes[i]);
                    b.addView(txt);
                    break;
                case 4:
                    b = (LinearLayout) findViewById(R.id.layoutB1);
                    formatoImageView(imagenes[i]);
                    b.addView(imagenes[i]);
                    b.addView(txt);
                    break;
                case 5:
                    b = (LinearLayout) findViewById(R.id.layoutB2);
                    formatoImageView(imagenes[i]);
                    b.addView(imagenes[i]);
                    b.addView(txt);
                    break;
                case 6:
                    b = (LinearLayout) findViewById(R.id.layoutB3);
                    formatoImageView(imagenes[i]);
                    b.addView(imagenes[i]);
                    b.addView(txt);
                    break;
                case 7:
                    b = (LinearLayout) findViewById(R.id.layoutB4);
                    formatoImageView(imagenes[i]);
                    b.addView(imagenes[i]);
                    b.addView(txt);
                    break;
                case 8:
                    b = (LinearLayout) findViewById(R.id.layoutC1);
                    formatoImageView(imagenes[i]);
                    b.addView(imagenes[i]);
                    b.addView(txt);
                    break;
                case 9:
                    b = (LinearLayout) findViewById(R.id.layoutC2);
                    formatoImageView(imagenes[i]);
                    b.addView(imagenes[i]);
                    b.addView(txt);
                    break;
                case 10:
                    b = (LinearLayout) findViewById(R.id.layoutC3);
                    formatoImageView(imagenes[i]);
                    b.addView(imagenes[i]);
                    b.addView(txt);
                    break;
                case 11:
                    b = (LinearLayout) findViewById(R.id.layoutC4);
                    formatoImageView(imagenes[i]);
                    b.addView(imagenes[i]);
                    b.addView(txt);
                    break;
                case 12:
                    b = (LinearLayout) findViewById(R.id.layoutD1);
                    formatoImageView(imagenes[i]);
                    b.addView(imagenes[i]);
                    b.addView(txt);
                    break;
                case 13:
                    b = (LinearLayout) findViewById(R.id.layoutD2);
                    formatoImageView(imagenes[i]);
                    b.addView(imagenes[i]);
                    b.addView(txt);
                    break;
                case 14:
                    b = (LinearLayout) findViewById(R.id.layoutD3);
                    formatoImageView(imagenes[i]);
                    b.addView(imagenes[i]);
                    b.addView(txt);
                    break;
                case 15:
                    b = (LinearLayout) findViewById(R.id.layoutD4);
                    formatoImageView(imagenes[i]);
                    b.addView(imagenes[i]);
                    b.addView(txt);
                    break;
            }

        }
        ///////////////////////////////////////////////////


    }

    private void eventoImageView(ImageView a, int i) {
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj.idComidaActual=i;
                abrirActividadInfoComida();
            }
        });
    }

    void formatoImageView(ImageView a) {

        int cincuentadp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        a.setLayoutParams(param);

        a.setMinimumWidth(cincuentadp);
        a.setMinimumHeight(cincuentadp);
    }

    public void abrirActividadInfoComida() {
        Intent intent = new Intent(this, ActividadInfoComida.class);
        intent.putExtras(bundle);//para compartir objeto entre actividades
        startActivity(intent);
    }

    public void eventoBotonRegresar(Button a) {
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void eventoBotonSiguiente(Button a) {
        if (obj.indicePag == 10) {
            return;
        }
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //formatearHolders();
                cuenta = 0;
                ArrayVacio = true;
                obj.indicePag++;
                InsertOnHolders();
            }
        });

    }

    public void eventoBotonAnterior(Button a) {
        if (obj.indicePag == 1) {
            return;
        }
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formatearHolders();
                cuenta = 0;
                ArrayVacio = true;
                obj.indicePag--;
                InsertOnHolders();
            }
        });

    }

    public void formatearHolders() {
        for (int i = 0; i < cuenta; i++) {
            LinearLayout b;
            switch (i) {

                case 0:
                    b = (LinearLayout) findViewById(R.id.layoutA1);
                    b.removeAllViews();
                    b.removeAllViewsInLayout();
                    break;
                case 1:
                    b = (LinearLayout) findViewById(R.id.layoutA2);
                    b.removeAllViews();
                    break;
                case 2:
                    b = (LinearLayout) findViewById(R.id.layoutA3);
                    b.removeAllViews();
                    break;
                case 3:
                    b = (LinearLayout) findViewById(R.id.layoutA4);
                    b.removeAllViews();
                    break;
                case 4:
                    b = (LinearLayout) findViewById(R.id.layoutB1);
                    b.removeAllViews();
                    break;
                case 5:
                    b = (LinearLayout) findViewById(R.id.layoutB2);
                    b.removeAllViews();
                    break;
                case 6:
                    b = (LinearLayout) findViewById(R.id.layoutB3);
                    b.removeAllViews();
                    break;
                case 7:
                    b = (LinearLayout) findViewById(R.id.layoutB4);
                    b.removeAllViews();
                    break;
                case 8:
                    b = (LinearLayout) findViewById(R.id.layoutC1);
                    b.removeAllViews();
                    break;
                case 9:
                    b = (LinearLayout) findViewById(R.id.layoutC2);
                    b.removeAllViews();
                    break;
                case 10:
                    b = (LinearLayout) findViewById(R.id.layoutC3);
                    b.removeAllViews();
                    break;
                case 11:
                    b = (LinearLayout) findViewById(R.id.layoutC4);
                    b.removeAllViews();
                    break;
                case 12:
                    b = (LinearLayout) findViewById(R.id.layoutD1);
                    b.removeAllViews();
                    break;
                case 13:
                    b = (LinearLayout) findViewById(R.id.layoutD2);
                    b.removeAllViews();
                    break;
                case 14:
                    b = (LinearLayout) findViewById(R.id.layoutD3);
                    b.removeAllViews();
                    break;
                case 15:
                    b = (LinearLayout) findViewById(R.id.layoutD4);
                    b.removeAllViews();
                    break;
            }

        }
    }

}