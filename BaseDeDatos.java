package tecnm.celaya;


import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

public class BaseDeDatos extends AppCompatActivity {
    String[] s1;
    int[] precio;
    String[] nombre;
    ImageView img;
    int idComidaActual;

    int indicePag = 0;


    BaseDeDatos(){

        InsertarNombres();
        NombresActuales();
        InsertarImagenes();
        InsertarPrecios();

    }
    void InsertarNombres(){
        s1 = new String[100];
        s1[0]="Enchiladas";
        s1[1]="Picadillo";
        s1[2]="Alitas de pollo";
        s1[3]="Enchiladas suizas";
        s1[4]="Ensalada";
        s1[5]="Ensalada de pollo";
        s1[6]="Filete a la plancha";
        s1[7]="Malteada";
        s1[8]="Mollelinces";
        s1[9]="Omelette";
        s1[10]="QuesaLinces";
        s1[11]="Sandwitch";
        s1[12]="Suchi Tec";
        s1[13]="Tacos de costilla";
        s1[14]="Torta de milanesa";
    }

    void NombresActuales(){
        nombre = new String[16];
        for (int i = 0; i < 16; i++) {
            nombre[i]=s1[i+(16*indicePag)];
        }
    }
    void InsertarImagenes(){
        //img = new ImageView(this);
        //img.setImageDrawable(getDrawable(R.drawable._enchilada));

    }
    void InsertarPrecios(){
        precio = new int[100];
        precio[0]=2222;
        precio[1]=1590;
        precio[2]=65;
        precio[3]=65;
        precio[4]=50;
        precio[5]=50;
        precio[6]=50;
        precio[7]=25;
        precio[8]=40;
        precio[9]=55;
        precio[10]=25;
        precio[11]=30;
        precio[12]=65;
        precio[13]=40;
        precio[14]=40;
    }

}
