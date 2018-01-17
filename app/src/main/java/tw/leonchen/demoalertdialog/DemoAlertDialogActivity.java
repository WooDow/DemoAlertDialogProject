package tw.leonchen.demoalertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class DemoAlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_alert_dialog);

    }

    public void processMessageDialog(View view) {
        //AlertDialog.Builder builder = new AlertDialog.Builder(DemoAlertDialogActivity.this);
        AlertDialog.Builder builder = new AlertDialog.Builder(DemoAlertDialogActivity.this, android.R.style.Theme_Material_Dialog_Alert);

        builder.setTitle("About");
        builder.setMessage("System Warning: Virus attack");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        //builder.setCancelable(false);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void processConfirmDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(DemoAlertDialogActivity.this);
        builder.setTitle("Game Exit?");
        builder.setMessage("Please Do not leave me......");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DemoAlertDialogActivity.this, "Yes", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DemoAlertDialogActivity.this, "No", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setCancelable(false);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void processMultiChoiceDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(DemoAlertDialogActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        final String[] themes = {"Fashion", "Classic", "Traditional"};
        builder.setTitle("Theme Setting:");

        builder.setSingleChoiceItems(themes, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {
                Toast.makeText(DemoAlertDialogActivity.this, themes[position], Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DemoAlertDialogActivity.this, "Confirm", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DemoAlertDialogActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void processCustomDialog(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View customView = inflater.inflate(R.layout.customlayout, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(DemoAlertDialogActivity.this);
        builder.setView(customView);
        final AlertDialog dialog = builder.create();
        dialog.show();

        CheckBox cb_music = (CheckBox) dialog.findViewById(R.id.cb_music);
        RadioButton rb_easy = (RadioButton)dialog.findViewById(R.id.rb_easy);

        cb_music.setChecked(true);
        rb_easy.setChecked(true);

        Button btn_ok = (Button) dialog.findViewById(R.id.btn_ok);
        Button btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
