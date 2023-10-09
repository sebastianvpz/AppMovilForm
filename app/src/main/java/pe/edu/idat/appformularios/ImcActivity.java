package pe.edu.idat.appformularios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import pe.edu.idat.appformularios.databinding.ActivityImcBinding;
import pe.edu.idat.appformularios.databinding.ActivityMainBinding;

public class ImcActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityImcBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImcBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btncalcularimc.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Double talla = Double.parseDouble(binding.txtaltura.getText().toString());
        Double peso = Double.parseDouble(binding.txtpeso.getText().toString());
        Double valorImc = calcularImc(talla, peso);
        String resultado = diagnostico(valorImc);
        binding.txtresultadoimc.setText("El valor IMC =" + valorImc +
                " su diágnostico es " + resultado);
    }

    private Double calcularImc(Double talla, Double peso){
        Double tallam = talla / 100;
        return peso / (tallam * tallam);
    }

    private String diagnostico(Double valorImc){
        String resultado = "";
        if(valorImc <= 18.5){
            resultado = "Por debajo del peso.";
        }else if (valorImc <= 25){
            resultado = "Con peso normal";
        } else if (valorImc <= 30) {
            resultado = "Con sobrepeso";
        } else if (valorImc <=35) {
            resultado = "Obesidad Leve";
        } else if (valorImc <= 39) {
            resultado = "Obesidad media";
        } else {
            resultado = "Obesidad mórbida";
        }
        return resultado;

    }
}
