package midiaplay.projeto.com.midaplay;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button botao;
    private MediaPlayer  mediaPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botao = (Button) findViewById(R.id.buttonTocar_id);

        mediaPlay = MediaPlayer.create(MainActivity.this, R.raw.dj_snake_let_me_love_you);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // isPlaying ele verifica se a midia esta tocando.
                if(mediaPlay.isPlaying()){


                    pausarMusica();



                }else{

                    tocarMusica();


                }



            }
        });
    }
    private void tocarMusica(){

        if (mediaPlay != null) {

            mediaPlay.start();
            botao.setText("Pausar");


        }
    }
    private void pausarMusica(){

        if (mediaPlay != null){

            mediaPlay.pause();
            botao.setText("Tocar");


        }

    }

        //liberar recurso de memoria
    @Override
    protected void onDestroy() {

        if(mediaPlay != null && mediaPlay.isPlaying()){
            //libera memoria do celular, ajuda, quando não quer mais usar
            mediaPlay.stop();
            mediaPlay.release();
            mediaPlay = null;


        }
        super.onDestroy();
    }


}
