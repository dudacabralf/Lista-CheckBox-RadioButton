package br.com.fecapccp.questao1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityescolhaProduto extends AppCompatActivity {

    private CheckBox cbArroz, cbLeite, cbCarne, cbFeijao, cbCoca;
    private Button btnCalcular;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_activityescolha_produto);

        cbArroz = findViewById(R.id.cbArroz);
        cbLeite = findViewById(R.id.cbLeite);
        cbCarne = findViewById(R.id.cbCarne);
        cbFeijao = findViewById(R.id.cbFeijao);
        cbCoca = findViewById(R.id.cbCoca);

        btnCalcular = findViewById(R.id.btnCalcular);
        textResultado = findViewById(R.id.textResultado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double total = 0;

                if (cbArroz.isChecked()) {
                    total += 2.69;
                }
                if (cbLeite.isChecked()) {
                    total += 2.70;
                }
                if (cbCarne.isChecked()) {
                    total += 16.70;
                }
                if (cbFeijao.isChecked()) {
                    total += 3.38;
                }
                if (cbCoca.isChecked()) {
                    total += 3.00;
                }

                textResultado.setText(String.format("Total: R$ %.2f", total));
            }
        });
    }
}