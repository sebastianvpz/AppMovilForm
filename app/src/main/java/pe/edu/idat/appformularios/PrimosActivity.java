    package pe.edu.idat.appformularios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import pe.edu.idat.appformularios.databinding.ActivityPrimosBinding;

    public class PrimosActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityPrimosBinding biding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        biding = ActivityPrimosBinding.inflate(getLayoutInflater());
        setContentView(biding.getRoot());
        biding.btncalcularprimo.setOnClickListener(this);
    }

        @Override
        public void onClick(View view) {
            Integer numero = Integer.parseInt(
                    biding.etnumeroprimo.getText().toString()
            );
            String resultado =
                    esPrimo(numero) ? "El número ingresado es PRIMO"
                            : "El número ingresado NO es PRIMO";
            biding.tvresultadoprimo.setText(resultado);
        }

        private Boolean esPrimo (Integer numero){
            int contadorDiv = 0;
            for(int i = 1; i <= numero; i++){
                if((numero % i) == 0) {
                    contadorDiv++;
                }
            }
            return contadorDiv <= 2;
        }

    }