package com.mobileapplecture.ilkin.lectureapp_1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.Image;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilkin on 04-Apr-17.
 */


public class myCustomAdapter extends BaseAdapter {

    LayoutInflater inflater;
    ArrayList<Locations> location_list;
    Context context;

    public myCustomAdapter(Context c) {
        context = c;
        location_list = new ArrayList<>();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resources resources = context.getResources();

        String[] place_name = resources.getStringArray(R.array.place_names);
        String[] place_location = resources.getStringArray(R.array.place_location);
        String[] phone_number = resources.getStringArray(R.array.phone_number);
        String[] place_email = resources.getStringArray(R.array.place_email);


        for (int i = 0; i < 4; i++) {
            location_list.add(new Locations(place_name[i], phone_number[i], place_email[i], place_location[i]));
        }

    }

    @Override
    public int getCount() {
        return location_list.size();
    }

    @Override
    public Object getItem(int position) {
        return location_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.row_layout, parent, false);

        TextView txt_location_name = (TextView) v.findViewById(R.id.txt_location_list);
        ImageButton imgBtn_phone = (ImageButton) v.findViewById(R.id.imgbtn_phone);
        ImageButton imgBtn_location = (ImageButton) v.findViewById(R.id.imgbtn_location);
        ImageButton imgBtn_mail = (ImageButton) v.findViewById(R.id.imgbtn_mail);

        // mekanlarin isimlerini listeye ekleme
        txt_location_name.setText(location_list.get(position).getName());

        //arama butonuna tiklandiginda yapilacak islem
        imgBtn_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // aranacak numara listeden alinir
                Uri number = Uri.parse("tel:" + location_list.get(position).getPhone());                        //Uniform Resource Identifier

                // uygun intent olusturulur
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

                // cihazda arama islemi yapabilecek uygun uygulamalarin olup/olmadigi kontrol ediliyor
                PackageManager packageManager = context.getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(callIntent, 0);
                boolean isIntentsafe = activities.size() > 0;

                // eger uygun uygulama var ise arama geceklestirilir
                if (isIntentsafe) {
                    context.startActivity(callIntent);
                    Toast.makeText(context, "Calling " + location_list.get(position).getPhone(), Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(context, "Failed to call " + location_list.get(position).getPhone(), Toast.LENGTH_SHORT).show();
            }
        });


        // location butonuna tiklandiginda haritada gosterme
        imgBtn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // aranacak numara listeden alinir
                Uri location = Uri.parse(location_list.get(position).getLocation());

                // uygun intent olusturulur
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

                // cihazda arama islemi yapabilecek uygun uygulamalarin olup/olmadigi kontrol ediliyor
                PackageManager packageManager = context.getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
                Boolean isIntentSafe = activities.size() > 0;
                // eger uygun uygulama var ise arama geceklestirilir
                if (isIntentSafe) {
                    context.startActivity(mapIntent);
                    Toast.makeText(context, "starting map app", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // email butonuna tiklandiginda verilen adrese email gonderecek
        imgBtn_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // email intent
                final Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("*/*");

                // mail yazilacak dialog box olusturulur
                LayoutInflater mail_inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View mail_view = mail_inflater.inflate(R.layout.mail_prompt, null);

                final TextView prompt_subject = (TextView) mail_view.findViewById(R.id.txt_mail_subject);
                final TextView prompt_body = (TextView) mail_view.findViewById(R.id.txt_mail_body);


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setView(mail_view);

                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("Gönder", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String subject = String.valueOf( prompt_subject.getText());

                        // assigning values obtained from dialog box
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {location_list.get(position).getEmail()});
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);
                        emailIntent.putExtra(Intent.EXTRA_TEXT, prompt_body.getText());
                        context.startActivity(emailIntent);
//                        Toast.makeText(context,receiver[0],Toast.LENGTH_SHORT).show();
                    }
                });

                // cancel button of email alert box
                alertDialogBuilder.setNegativeButton("İptal et", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alertDialogBuilder.create().show();
                // starting email activity


            }
        });

        return v;
    }
}
