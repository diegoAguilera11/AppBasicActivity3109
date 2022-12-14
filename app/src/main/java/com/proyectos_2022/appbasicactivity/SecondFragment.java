package com.proyectos_2022.appbasicactivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.proyectos_2022.appbasicactivity.adapter.OperationAdapter;
import com.proyectos_2022.appbasicactivity.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private EditText txt_number3, txt_number4;
    Spinner spinner_operations;
    private TextView txt_resultado2;

    String[] operationNames = {"Sumar", "Restar", "Multiplicar", "Dividir"};
    int[] operationIcons = {R.drawable.suma, R.drawable.resta, R.drawable.multiplicar, R.drawable.dividir};

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        txt_number3 = (EditText) binding.txtNumber3;
        txt_number4 = (EditText) binding.txtNumber4;
        txt_resultado2 = (TextView) binding.txtResultado2;
        spinner_operations = (Spinner) binding.spinnerOperations;


        OperationAdapter adapter = new OperationAdapter(this.getContext(), operationNames, operationIcons);
        spinner_operations.setAdapter(adapter);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.buttonThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_thirdFragment);
            }
        });

        binding.btnCalculate2.setOnClickListener((View v) -> {

            boolean validacion = validacion();

            if (validacion) {
                buscarOperacion();
            }
        });


    }

    /*
        M??todo que obtiene la operaci??n indicada por el usuario, ademas
        de hacer el llamado a la funci??n acorde a la selecci??n
     */
    public void buscarOperacion() {
        String selected = spinner_operations.getSelectedItem().toString();
        switch (selected) {
            case "Sumar": {
                suma();
                break;
            }
            case "Restar": {
                resta();
                break;
            }
            case "Multiplicar": {
                multiplicar();
                break;
            }
            case "Dividir": {
                dividir();
                break;
            }
            default: {
                showMessageEmpty("No haz seleccionado ninguna acci??n");
            }
        }
    }

    /*
        M??todo que se encarga de estructurar la validacion de los campos rellenados por el usuario
     */
    public boolean validacion() {
        String c1 = txt_number3.getText().toString();
        String c2 = txt_number4.getText().toString();

        if (c1.isEmpty() || c2.isEmpty()) {
            showMessageEmpty("Todos los campos son obligatorios");
            return false;
        }
        boolean respuestaValidacionNumeros = validarNumeros(c1, c2);
        if (respuestaValidacionNumeros) {
            return true;
        }
        showMessageEmpty("Solo se deben ingresar valores numericos");
        return false;
    }

    // Funci??n que evalua si hay valores numericos en los campos rellenados por el cliente
    public boolean validarNumeros(String numero1, String numero2) {

        try {
            int numeroAux1 = Integer.parseInt(numero1);
            int numeroAux2 = Integer.parseInt(numero2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // M??todo que imprime un mensaje en la interfaz gr??fica del usuario
    public void showMessageEmpty(String message) {
        Toast.makeText(this.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    // Funci??n que realiza la suma de ambos valores numericos ingresados por el usuario
    public String suma() {
        double valor_1 = Integer.parseInt(txt_number3.getText().toString());
        double valor_2 = Integer.parseInt(txt_number4.getText().toString());
        double sum = valor_1 + valor_2;
        String respuesta = String.valueOf(sum);
        txt_resultado2.setText(respuesta);

        return respuesta;
    }

    // Funci??n que realiza la resta de ambos valores numericos ingresados por el usuario
    public String resta() {
        double valor_1 = Integer.parseInt(txt_number3.getText().toString());
        double valor_2 = Integer.parseInt(txt_number4.getText().toString());
        double resta = valor_1 - valor_2;
        String respuesta = String.valueOf(resta);
        txt_resultado2.setText(respuesta);

        return respuesta;
    }

    // Funci??n que realiza la multiplicaci??n de ambos valores numericos ingresados por el usuario
    public String multiplicar() {
        double valor_1 = Integer.parseInt(txt_number3.getText().toString());
        double valor_2 = Integer.parseInt(txt_number4.getText().toString());
        double mul = valor_1 * valor_2;
        String respuesta = String.valueOf(mul);
        txt_resultado2.setText(respuesta);

        return respuesta;
    }

    // Funci??n que realiza la divisi??n de ambos valores numericos ingresados por el usuario
    public String dividir() {
        double valor_1 = Integer.parseInt(txt_number3.getText().toString());
        double valor_2 = Integer.parseInt(txt_number4.getText().toString());
        String respuesta = "";
        if (valor_2 != 0) {
            double div = valor_1 / valor_2;
            respuesta = String.valueOf(div);
            txt_resultado2.setText(respuesta);
        } else {
            Toast.makeText(this.getContext(), "No se puede dividir por 0", Toast.LENGTH_SHORT).show();
        }

        return respuesta;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}