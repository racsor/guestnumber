package org.racsor.guestnumber;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class AEMenu extends Activity {
	private static final String CT_TAG = "AEMenu";
	private static final String CT_BUNDLE_INCOGNITA = "incognita";
	private static final String CT_BUNDLE_INTENTOS = "intentos";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ae_menu);
		findViewById(R.id.ae_bt_adivinator).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						invocaAdivinator();
					}
				});
	}


	protected void invocaAdivinator() {
		Log.d(CT_TAG, "method invocaAdivinator");
		Intent i=new Intent(this,AMMain.class);
		startActivity(i);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.am_main, menu);
		return true;
	}

}
