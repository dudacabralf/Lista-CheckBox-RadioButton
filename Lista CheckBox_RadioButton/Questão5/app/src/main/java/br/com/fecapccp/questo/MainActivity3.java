package br.com.fecapccp.questo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private TextView appResumoPedido, appTotalPagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        appResumoPedido = findViewById(R.id.appResumoPedido);
        appTotalPagar = findViewById(R.id.appTotalPagar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<String> sabores = getIntent().getStringArrayListExtra("sabores");
        String tamanho = getIntent().getStringExtra("tamanho");
        String pagamento = getIntent().getStringExtra("pagamento");

        StringBuilder resumo = new StringBuilder();
        double total = 0;

        resumo.append("Sabores: ");
        for (String sabor : sabores) {
            resumo.append(sabor).append(" ");

            switch (sabor) {
                case "Calabresa":
                    total += 30.0;
                    break;
                case "Queijo":
                    total += 25.0;
                    break;
                case "Portuguesa":
                    total += 35.0;
                    break;
            }
        }

        resumo.append("\nTamanho: ").append(tamanho);
        resumo.append("\nPagamento: ").append(pagamento);

        // Acrescentar valor de acordo com o tamanho
        switch (tamanho) {
            case "Grande":
                total += 10;
                break;
            case "Media":
                total += 5;
                break;
            case "Pequena":
                total += 0;
                break;
        }

        appResumoPedido.setText(resumo.toString());
        appTotalPagar.setText("Total a pagar: R$ " + String.format("%.2f", total));
    }
}



