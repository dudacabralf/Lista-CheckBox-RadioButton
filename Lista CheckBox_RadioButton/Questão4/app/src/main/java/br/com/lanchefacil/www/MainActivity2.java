package br.com.lanchefacil.www;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {

    private TextInputEditText editTextNome;
    private CheckBox cbXburger, cbXsalada, cbSanduiche, cbBurrito, cbHotDog;
    private Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        editTextNome = findViewById(R.id.editTextNome);
        cbXburger = findViewById(R.id.cbXburger);
        cbXsalada = findViewById(R.id.cbXsalada);
        cbSanduiche = findViewById(R.id.cbSanduiche);
        cbBurrito = findViewById(R.id.cbBurrito);
        cbHotDog = findViewById(R.id.cbHotDog);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString();
                StringBuilder pedidoBuilder = new StringBuilder();

                if (nome.isEmpty()) {
                    editTextNome.setError("Digite seu nome");
                    return;
                }

                StringBuilder ingredientes = new StringBuilder();

                if (cbXburger.isChecked()) ingredientes.append("Xburger\n");
                if (cbXsalada.isChecked()) ingredientes.append("Xsalada\n");
                if (cbSanduiche.isChecked()) ingredientes.append("Sanduiche\n");
                if (cbBurrito.isChecked()) ingredientes.append("Burrito\n");
                if (cbHotDog.isChecked()) ingredientes.append("Hot Dog\n");

                if (ingredientes.length() == 0) {
                    ingredientes.append("Nenhum item selecionado");
                }

                String pedido = pedidoBuilder.toString();

                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("nomeCliente", nome);
                intent.putExtra("pedido",pedido);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }


}