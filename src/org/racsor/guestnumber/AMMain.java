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
	private static final String CT_TAG = "AMMAIN";
	private static final String CT_BUNDLE_INCOGNITA = "incognita";
	private static final String CT_BUNDLE_INTENTOS = "intentos";
	EditText mValor;
	TextView mMensaje1;
	TextView mMensaje2;
	int mIncognita;
	int mIntentos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(CT_TAG, "onCreate invocat");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.am_main);
		mValor = (EditText) findViewById(R.id.am_et_valor);
		mMensaje1 = (TextView) findViewById(R.id.am_tv_mensaje1);
		mMensaje2 = (TextView) findViewById(R.id.am_tv_mensaje2);

		findViewById(R.id.am_bt_enviar).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						computaIntento();
					}
				});
		if (savedInstanceState == null) {
			inicializaIncognita();
		} else
			restaurarEstat(savedInstanceState);

	}

	private void restaurarEstat(Bundle savedInstanceState) {
		Log.d(CT_TAG, "restaurarEstat invocat");
		mIncognita = savedInstanceState.getInt(CT_BUNDLE_INCOGNITA);
		mIntentos = savedInstanceState.getInt(CT_BUNDLE_INTENTOS);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		Log.d(CT_TAG, "onSaveInstanceState invocat");
		super.onSaveInstanceState(outState);
		outState.putInt(CT_BUNDLE_INCOGNITA, mIncognita);
		outState.putInt(CT_BUNDLE_INTENTOS, mIntentos);
	}

	private void inicializaIncognita() {
		Log.d(CT_TAG, "inicializaIncognita invocat");
		mIntentos = 0;
		mIncognita = new Random().nextInt(100) + 1;
		Log.d(CT_TAG, "La incongita es:" + mIncognita);

	}

	private void computaIntento() {
		mIntentos++;
		int valAct;
		try {
			valAct = Integer.valueOf(mValor.getText().toString()).intValue();

		} catch (Exception e) {
			mMensaje1.setText(R.string.am_val_invalido);
			return;
		}
		if (valAct == mIncognita) {
			mMensaje1.setText(R.string.am_val_acertado);
			mMensaje2.setText(getResources().getString(R.string.am_val_intento,
					mIntentos));
			findViewById(R.id.am_bt_enviar).setEnabled(false);
		} else if (valAct < mIncognita) {
			mMensaje1.setText(getResources().getString(R.string.am_val_mayor,
					valAct));
			mMensaje2.setText(getResources().getString(R.string.am_val_intento,
					mIntentos));
		} else {
			mMensaje1.setText(getResources().getString(R.string.am_val_menor,
					valAct));
			mMensaje2.setText(getResources().getString(R.string.am_val_intento,
					mIntentos));
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.d(CT_TAG, "method onCreateOptionsMenu");
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.am_main, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		Log.d(CT_TAG, "method onDestroy");
		super.onDestroy();
	}


	@Override
	protected void onPause() {
		Log.d(CT_TAG, "method onPause");
		super.onPause();
	}


	@Override
	protected void onRestart() {
		Log.d(CT_TAG, "method onRestart");
		super.onRestart();
	}


	@Override
	protected void onResume() {
		Log.d(CT_TAG, "method onResume");
		super.onResume();
	}


	@Override
	protected void onStart() {
		Log.d(CT_TAG, "method onStart");
		super.onStart();
	}


	@Override
	protected void onStop() {
		Log.d(CT_TAG, "method onStop");
		super.onStop();
	}


}
