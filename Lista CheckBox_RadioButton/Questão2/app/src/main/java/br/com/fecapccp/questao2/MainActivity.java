package br.com.fecapccp.questao2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSalario;
    private RadioButton rb40, rb45, rb50;
    private Button btnCalcular;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextSalario = findViewById(R.id.editTextSalario);
        rb40 = findViewById(R.id.rb40);
        rb45 = findViewById(R.id.rb45);
        rb50 = findViewById(R.id.rb50);
        btnCalcular = findViewById(R.id.btnCalcular);
        textResultado = findViewById(R.id.textResultado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnCalcular.setOnClickListener(View -> {
                String salarioStr = editTextSalario.getText().toString();

                if (salarioStr.isEmpty()) {
                    textResultado.setText("Por favor, digite um salário válido.");
                    return;
                }

                double salario = Double.parseDouble(salarioStr);
                double percentual = 0;

                if (rb40.isChecked()) {
                    percentual = 0.40;
                } else if (rb45.isChecked()) {
                    percentual = 0.45;
                } else if (rb50.isChecked()) {
                    percentual = 0.50;
                } else {
                    textResultado.setText("Selecione um percentual de aumento.");
                    return;
                }

                double novoSalario = salario + (salario * percentual);
                textResultado.setText(String.format("Novo salário: R$ %.2f", novoSalario));

        });
    }
}