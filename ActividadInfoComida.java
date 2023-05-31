package tecnm.celaya;

import static android.view.View.TEXT_ALIGNMENT_CENTER;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActividadInfoComida extends AppCompatActivity {

    BaseDeDatos obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_info_comida);
        obj = (BaseDeDatos) ((ObjectWrapperForBinder)getIntent().getExtras().getBinder("object_value")).getData();


        init();



    }

    public void init() {
        ImageView imagenes[] = new ImageView[16];
        for (int i = 0; i < 15; i++) {//proceso para asignar imagenes a el array

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

        }

        LinearLayout b;
        b = (LinearLayout) findViewById(R.id.layoutComida);
        formatoImageView(imagenes[obj.idComidaActual + (16 * obj.indicePag)]);
        b.addView(imagenes[obj.idComidaActual + (16 * obj.indicePag)]);
        Button comprar = new Button(this);
        TextView nombre=new TextView(this);
        TextView putprecio=new TextView(this);

        nombre.setText(obj.s1[obj.idComidaActual + (16 * obj.indicePag)]);
        nombre.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        //android:textAlignment="center"
        //android:textSize="20sp"
        //android:textStyle="bold"
        nombre.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, getResources().getDisplayMetrics()));
        putprecio.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()));
        nombre.setTypeface(nombre.getTypeface(), Typeface.BOLD);


        putprecio.setText("Precio: "+obj.precio[obj.idComidaActual + (16 * obj.indicePag)]+"\n");

        //putprecio.setTextAlignment(TEXT_ALIGNMENT_CENTER);


        comprar.setText("Comprar");
        LinearLayout.LayoutParams wrapall = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        wrapall.weight=1;

        comprar.setLayoutParams(wrapall);
        nombre.setLayoutParams(wrapall);
        nombre.setTextColor(Color.parseColor("#AE2017"));
        comprar.setTextColor(Color.parseColor("#AE2017"));
        putprecio.setTextColor(Color.parseColor("#AE2017"));

        comprar.setBackgroundColor(Color.parseColor("#E67D00"));
        eventoBotonComprar(comprar);
        b.addView(nombre);
        b.addView(putprecio);
        b.addView(comprar);



    }
    void formatoImageView(ImageView a) {

        int cincuentadp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);

        a.setLayoutParams(param);
        a.bringToFront();
        a.setMinimumWidth(cincuentadp);
        a.setMinimumHeight(cincuentadp);
    }
    public void eventoBotonComprar(Button a){
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast();
            }
        });
    }
    private void toast() {
        Toast.makeText(this,"Hecho!, su orden llegara en 20 minutos", Toast.LENGTH_SHORT).show();

    }
}