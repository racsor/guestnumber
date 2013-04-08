package org.racsor.guestnumber;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class AMMain extends Activity {
	EditText mValor;
	TextView mMensaje1;
	TextView mMensaje2;
	int mIncognita;
	int mIntentos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.am_main);
		mValor = (EditText) findViewById(R.id.am_et_valor);
		mMensaje1= (TextView)findViewById(R.id.am_tv_mensaje1);
		mMensaje2= (TextView)findViewById(R.id.am_tv_mensaje2);
		
		findViewById(R.id.am_bt_enviar).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				computaIntento();
			}
		});
		
		inicializaIncognita();
		
	}
	
	private void inicializaIncognita() {
		mIntentos=0;
		mIncognita=new Random().nextInt(100)+1;
		Log.d("AMMain" ,"La incongita es:"+mIncognita);
		
	}

	private void computaIntento(){
		mIntentos++;
		int valAct;
		try {
			valAct=Integer.valueOf(mValor.getText().toString()).intValue();
			
		} catch (Exception e) {
			mMensaje1.setText(R.string.am_val_invalido);
			return;
		}
		if (valAct==mIncognita){
			mMensaje1.setText(R.string.am_val_acertado);
			mMensaje2.setText(getResources().getString(R.string.am_val_intento,mIntentos));
			findViewById(R.id.am_bt_enviar).setEnabled(false);
		}
		else if (valAct<mIncognita){
			mMensaje1.setText(getResources().getString(R.string.am_val_mayor,valAct));
			mMensaje2.setText(getResources().getString(R.string.am_val_intento,mIntentos));
		}
		else{
			mMensaje1.setText(getResources().getString(R.string.am_val_menor,valAct));
			mMensaje2.setText(getResources().getString(R.string.am_val_intento,mIntentos));
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.am_main, menu);
		return true;
	}
	
}
