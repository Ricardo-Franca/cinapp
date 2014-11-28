package br.com.cinapp.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import br.com.cinapp.R;

public class ActivityMain extends Activity{
	
	public final static String EXTRA_MESSAGE = "br.com.cinapp.cinapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
    }    
    
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
    	super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
    	return true;
    }
    
    public void sendMessage(View view){
    	
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
    	
    	switch (item.getItemId()) {
    		case R.id.manter_perfil:
    			startActivity(new Intent(this, ManterPerfilActivity.class));
    			return true;
    		case R.id.manter_Alimento:
    			startActivity(new Intent(this, ManterAlimentoActivity.class));
    			return true;
    		case R.id.gerar_grafico:
    			startActivity(new Intent(this, GerarGraficoActivity.class));
    			return true;
    		default:
    			return super.onMenuItemSelected(featureId, item);
    	}
    }
}