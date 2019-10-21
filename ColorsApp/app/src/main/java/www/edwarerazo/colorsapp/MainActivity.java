package www.edwarerazo.colorsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

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
    Dialog myDialog;
    int colorv = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDialog = new Dialog(this);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.colors_menu2, menu);
        return super.onCreateOptionsMenu (menu);
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

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId ()){
            case R.id.iteYellow:
                sbrRed.setProgress (255);
                sbrGreen.setProgress (255);
                sbrBlue.setProgress (0);
                Toast.makeText (this, "Yellow", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteRed:
                sbrRed.setProgress (255);
                sbrGreen.setProgress (0);
                sbrBlue.setProgress (0);
                Toast.makeText (this, "Red", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteBlue:
                sbrRed.setProgress (0);
                sbrGreen.setProgress (0);
                sbrBlue.setProgress (255);
                Toast.makeText (this, "Blue", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteBlack:
                sbrRed.setProgress (0);
                sbrGreen.setProgress (0);
                sbrBlue.setProgress (0);
                Toast.makeText (this, "Black", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteBrown:
                sbrRed.setProgress (165);
                sbrGreen.setProgress (42);
                sbrBlue.setProgress (42);
                Toast.makeText (this, "Brown", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteCyan:
                sbrRed.setProgress (0);
                sbrGreen.setProgress (255);
                sbrBlue.setProgress (255);
                Toast.makeText (this, "Cyan", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteGreen:
                sbrRed.setProgress (0);
                sbrGreen.setProgress (255);
                sbrBlue.setProgress (0);
                Toast.makeText (this, "Green", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteMagenta:
                sbrRed.setProgress (255);
                sbrGreen.setProgress (0);
                sbrBlue.setProgress (255);
                Toast.makeText (this, "Magenta", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteWhite:
                sbrRed.setProgress (255);
                sbrGreen.setProgress (255);
                sbrBlue.setProgress (255);
                Toast.makeText (this, "White", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteSemiTransparent:
                sbrAlpha.setProgress (128);
                Toast.makeText (this, "SemiTransparent", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteTransparent:
                sbrAlpha.setProgress (0);
                Toast.makeText (this, "Transparent", Toast.LENGTH_SHORT).show ();
                return true;

            default:
                return super.onContextItemSelected (item);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId ()){
            case R.id.iteYellow:
                sbrRed.setProgress (255);
                sbrGreen.setProgress (255);
                sbrBlue.setProgress (0);
                Toast.makeText (this, "Yellow", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteRed:
                sbrRed.setProgress (255);
                sbrGreen.setProgress (0);
                sbrBlue.setProgress (0);
                Toast.makeText (this, "Red", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteBlue:
                sbrRed.setProgress (0);
                sbrGreen.setProgress (0);
                sbrBlue.setProgress (255);
                Toast.makeText (this, "Blue", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteBlack:
                sbrRed.setProgress (0);
                sbrGreen.setProgress (0);
                sbrBlue.setProgress (0);
                Toast.makeText (this, "Black", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteBrown:
                sbrRed.setProgress (165);
                sbrGreen.setProgress (42);
                sbrBlue.setProgress (42);
                Toast.makeText (this, "Brown", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteCyan:
                sbrRed.setProgress (0);
                sbrGreen.setProgress (255);
                sbrBlue.setProgress (255);
                Toast.makeText (this, "Cyan", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteGreen:
                sbrRed.setProgress (0);
                sbrGreen.setProgress (255);
                sbrBlue.setProgress (0);
                Toast.makeText (this, "Green", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteMagenta:
                sbrRed.setProgress (255);
                sbrGreen.setProgress (0);
                sbrBlue.setProgress (255);
                Toast.makeText (this, "Magenta", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteWhite:
                sbrRed.setProgress (255);
                sbrGreen.setProgress (255);
                sbrBlue.setProgress (255);
                Toast.makeText (this, "White", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteSemiTransparent:
                sbrAlpha.setProgress (128);
                Toast.makeText (this, "SemiTransparent", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteTransparent:
                sbrAlpha.setProgress (0);
                Toast.makeText (this, "Transparent", Toast.LENGTH_SHORT).show ();
                return true;
            case R.id.iteAbout:
                Toast.makeText (this, "Transparent", Toast.LENGTH_SHORT).show ();
                return true;

            default:
                return super.onContextItemSelected (item);
        }
    }
/*
    public void ShowPopup(View v) {
        TextView txtclose;
        Button btnFollow;
        myDialog.setContentView(R.layout.custompopup);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("M");
        btnFollow = (Button) myDialog.findViewById(R.id.btnfollow);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable (Color.TRANSPARENT));
        myDialog.show();
    }
    */

}
