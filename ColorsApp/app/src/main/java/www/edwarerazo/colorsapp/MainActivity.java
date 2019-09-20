package www.edwarerazo.colorsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    View filtroI;
    SeekBar sbrRed;
    SeekBar sbrGreen;
    SeekBar sbrBlue;
    SeekBar sbrAlpha;
    TextView vna;
    TextView vnr;
    TextView vng;
    TextView vnb;
    int colorv = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filtroI = (View) this.findViewById(R.id.filtroVi);
        sbrRed = (SeekBar)this.findViewById(R.id.sbrRed);
        sbrGreen = (SeekBar)this.findViewById(R.id.sbrGreen);
        sbrBlue = (SeekBar)this.findViewById(R.id.sbrBlue);
        sbrAlpha = (SeekBar)this.findViewById(R.id.sbrAlpha);
        vna = (TextView) this.findViewById(R.id.vna);
        vnr = (TextView) this.findViewById(R.id.vnr);
        vng = (TextView) this.findViewById(R.id.vng);
        vnb = (TextView) this.findViewById(R.id.vnb);

        // habilitar menu componente con contextmenu
        registerForContextMenu(filtroI);


        sbrRed.setOnSeekBarChangeListener(this);
        sbrGreen.setOnSeekBarChangeListener(this);
        sbrBlue.setOnSeekBarChangeListener(this);
        sbrAlpha.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Opciones:");
        getMenuInflater().inflate(R.menu.colors_menu1, menu);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean bo) {
        int r = sbrRed.getProgress();
        int g = sbrGreen.getProgress();
        int b = sbrBlue.getProgress();
        int a = sbrAlpha.getProgress();
        vnr.setText(""+r+"%");
        vng.setText(""+g+"%");
        vnb.setText(""+b+"%");
        vna.setText(""+a+"%");
        colorv = Color.argb(a,r,g,b);
        filtroI.setBackgroundColor(colorv);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
