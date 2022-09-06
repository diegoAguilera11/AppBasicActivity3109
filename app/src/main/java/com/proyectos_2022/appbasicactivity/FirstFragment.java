package com.proyectos_2022.appbasicactivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.proyectos_2022.appbasicactivity.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private EditText txt_number1, txt_number2;

    private TextView txt_resultado;

    /*private RadioButton rad_suma, rad_resta, rad_multiplicar, rad_dividir;

    private RadioGroup rad_group;*/

    private CheckBox checkBox_suma, checkBox_resta, checkBox_multiplicar, checkBox_dividir;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        txt_number1 = (EditText) binding.txtNumber1;
        txt_number2 = (EditText) binding.txtNumber2;
        txt_resultado = (TextView) binding.txtResultado;

        checkBox_suma = (CheckBox) binding.checkBoxSuma;
        checkBox_resta = (CheckBox) binding.checkBoxResta;
        checkBox_multiplicar = (CheckBox) binding.checkBoxMultiplicar;
        checkBox_dividir = (CheckBox) binding.checkBoxDividir;


        /*rad_suma = (RadioButton) binding.radSuma;
        rad_resta = (RadioButton) binding.radRestar;
        rad_multiplicar = (RadioButton) binding.radMultiplicar;
        rad_dividir = (RadioButton) binding.radDividir;
        rad_group = (RadioGroup) binding.radGroup;*/

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        binding.btnCalculate.setOnClickListener((View v) -> {

            // Radio Group
            /*if (rad_suma.isChecked()) {
                //sumar
                suma();
            } else if (rad_resta.isChecked()) {
                //restar
                resta();
            } else if (rad_multiplicar.isChecked()) {
                //multiplicar
                multiplicar();
            } else if (rad_dividir.isChecked()) {
                //dividir
                dividir();*/

            // CheckBox
            if (checkBox_suma.isChecked() && checkBox_resta.isChecked() && checkBox_multiplicar.isChecked() && checkBox_dividir.isChecked()) {
                message(true, true, true, true);
            } else if (checkBox_suma.isChecked() && checkBox_resta.isChecked() && checkBox_multiplicar.isChecked()) {
                message(true, true, true, false);
            } else if (checkBox_resta.isChecked() && checkBox_multiplicar.isChecked() && checkBox_dividir.isChecked()) {
                message(false, true, true, true);
            } else if (checkBox_suma.isChecked() && checkBox_dividir.isChecked() && checkBox_multiplicar.isChecked()) {
                message(true, false, true, true);
            } else if (checkBox_suma.isChecked() && checkBox_resta.isChecked() && checkBox_dividir.isChecked()) {
                message(true, true, false, true);
            } else if (checkBox_suma.isChecked() && checkBox_resta.isChecked()) {
                message(true, true, false, false);
            } else if (checkBox_suma.isChecked() && checkBox_multiplicar.isChecked()) {
                message(true, false, true, false);
            } else if (checkBox_suma.isChecked() && checkBox_dividir.isChecked()) {
                message(true, false, false, true);
            } else if (checkBox_resta.isChecked() && checkBox_multiplicar.isChecked()) {
                message(false, true, true, false);
            } else if (checkBox_resta.isChecked() && checkBox_dividir.isChecked()) {
                message(false, true, false, true);
            } else if (checkBox_dividir.isChecked() && checkBox_multiplicar.isChecked()) {
                message(false, false, true, true);
            } else if (checkBox_suma.isChecked()) {
                message(true, false, false, false);
            } else if (checkBox_resta.isChecked()) {
                message(false, true, false, false);
            } else if (checkBox_multiplicar.isChecked()) {
                message(false, false, true, false);
            } else if (checkBox_dividir.isChecked()) {
                message(false, false, false, true);
            } else {
                // Mostrar Mensaje
                showMessage();
            }


        });
    }

    public void showMessage() {
        Toast.makeText(this.getContext(), "No ha sido seleccionada ninguna acción", Toast.LENGTH_SHORT).show();
    }

    public void message(boolean suma, boolean resta, boolean multi, boolean division) {

        String resultado_1 = "";
        String resultado_2 = "";
        String resultado_3 = "";
        String resultado_4 = "";

        if (suma) {
            resultado_1 = suma();
        }
        if (resta) {
            resultado_2 = resta();
        }
        if (multi) {
            resultado_3 = multiplicar();
        }
        if (division) {
            resultado_4 = dividir();
        }

        String resultado = "Suma: " + resultado_1 + "\nResta: " + resultado_2 + "\nMultiplicación: " + resultado_3 + "\nDivisión: " + resultado_4;
        txt_resultado.setText(resultado);
    }

    public String suma() {
        double valor_1 = Integer.parseInt(txt_number1.getText().toString());
        double valor_2 = Integer.parseInt(txt_number2.getText().toString());
        double sum = valor_1 + valor_2;
        String respuesta = String.valueOf(sum);
        txt_resultado.setText(respuesta);

        return respuesta;
    }

    public String resta() {
        double valor_1 = Integer.parseInt(txt_number1.getText().toString());
        double valor_2 = Integer.parseInt(txt_number2.getText().toString());
        double resta = valor_1 - valor_2;
        String respuesta = String.valueOf(resta);
        txt_resultado.setText(respuesta);

        return respuesta;
    }

    public String multiplicar() {
        double valor_1 = Integer.parseInt(txt_number1.getText().toString());
        double valor_2 = Integer.parseInt(txt_number2.getText().toString());
        double mul = valor_1 * valor_2;
        String respuesta = String.valueOf(mul);
        txt_resultado.setText(respuesta);

        return respuesta;
    }

    public String dividir() {
        double valor_1 = Integer.parseInt(txt_number1.getText().toString());
        double valor_2 = Integer.parseInt(txt_number2.getText().toString());
        String respuesta = "";
        if (valor_2 != 0) {
            double div = valor_1 / valor_2;
            respuesta = String.valueOf(div);
            txt_resultado.setText(respuesta);
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