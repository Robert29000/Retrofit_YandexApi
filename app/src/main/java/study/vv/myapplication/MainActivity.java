package study.vv.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    String key="trnsl.1.1.20180416T153327Z.fda17494174b11d8.26a0d159a35c9c36ead0bbe856016c63b0e2b86c";
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Translate(String text){
        Retrofit retrofit=new Retrofit.Builder().baseUrl
                ("https://translate.yandex.net/api/v1.5/tr.json/").
                    addConverterFactory(GsonConverterFactory.create()).build();
        TranslationInterface translation=retrofit.create(TranslationInterface.class);
        Call<Data> call=translation.getTranslation(text,"en-ru",key);
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Data translation=response.body();
                TextView text=(TextView)findViewById(R.id.textview);
                text.setText(translation.getText().get(0));
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    public void get(View view) {
        EditText editText=(EditText)findViewById(R.id.editText);
        text=editText.getText().toString();
        Translate(text);
    }
}


