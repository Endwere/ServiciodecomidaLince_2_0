package tecnm.celaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActividadInicio extends AppCompatActivity {

    final BaseDeDatos obj = new BaseDeDatos();//COEA
    final Bundle bundle = new Bundle();//COEA

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_inicio);
        //metodos primarios
        bundle.putBinder("object_value", new ObjectWrapperForBinder(obj));//COEA
        Proceso();
    }

    private void Proceso() {
        Button botonA1 = findViewById(R.id.buttonA1);
        botonA1.setTextColor(Color.parseColor("#AE2017"));
        eventoBotonA1(botonA1);

    }
    public void eventoBotonA1(Button a){
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActividadCatalogo();
            }
        });
    }
    public void abrirActividadCatalogo() {
        Intent intent = new Intent(this, ActividadCatalogo.class);
        intent.putExtras(bundle);//para compartir objeto entre actividades
        startActivity(intent);
    }
    public void CompartirObjeto(){
        bundle.putBinder("object_value", new ObjectWrapperForBinder(obj));//COEA

    }
}