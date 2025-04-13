package br.com.fecapccp.questo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private RadioGroup rgTamanho, rgPagamento;
    private Button btnFinalizar;
    ArrayList<String> saboresSelecionados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        rgTamanho = findViewById(R.id.rgTamanho);
        rgPagamento = findViewById(R.id.rgPagamento);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        saboresSelecionados = getIntent().getStringArrayListExtra("sabores");

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int idTamanho = rgTamanho.getCheckedRadioButtonId();
                int idPagamento = rgPagamento.getCheckedRadioButtonId();

                if (idTamanho != -1 && idPagamento != -1) {
                    RadioButton rbTamanho = findViewById(idTamanho);
                    RadioButton rbPagamento = findViewById(idPagamento);

                    String tamanho = rbTamanho.getText().toString();
                    String pagamento = rbPagamento.getText().toString();

                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putStringArrayListExtra("sabores", saboresSelecionados);
                    intent.putExtra("tamanho", tamanho);
                    intent.putExtra("pagamento", pagamento);
                    startActivity(intent);
                }
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