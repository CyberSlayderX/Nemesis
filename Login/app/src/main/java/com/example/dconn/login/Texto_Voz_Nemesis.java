package com.example.dconn.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Texto_Voz_Nemesis extends AppCompatActivity {


    private Button hablarAhora;
    private EditText editText;
    TTSManager ttsManager =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto__voz__nemesis);
    ttsManager= new TTSManager();
    ttsManager.init(this);

    editText=findViewById(R.id.input_text);
    hablarAhora=findViewById(R.id.speak_now);

    hablarAhora.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String text= editText.getText().toString();
            ttsManager.initQueue(text);
        }
    });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}
