package com.example.sanapruebados;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.FileUriExposedException;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sanapruebados.MDetalleAdiccion.AdiccionListActivity;
import com.example.sanapruebados.entidades.Adiccion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link altaAdiccionesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class altaAdiccionesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View vista;
    private EditText nombre;
    private EditText descripcion;
    private Button btCambiarImagen,btAgregar,btLista;
    private ImageView imageView;
    daoAdiccion daoA;
    final int REQUEST_CODE_GALLERY=999;

    public altaAdiccionesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment altaAdiccionesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static altaAdiccionesFragment newInstance(String param1, String param2) {
        altaAdiccionesFragment fragment = new altaAdiccionesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista=inflater.inflate(R.layout.fragment_alta_adicciones, container, false);
        // Inflate the layout for this fragment
        daoA=new daoAdiccion(getActivity().getApplicationContext());
        nombre=(EditText)vista.findViewById(R.id.ETNombreA);
        descripcion=(EditText)vista.findViewById(R.id.ETDescripA);
        btCambiarImagen=(Button)vista.findViewById(R.id.BTCambiarImg);
        btAgregar=(Button)vista.findViewById(R.id.BTAgregarAdic);
        btLista=(Button)vista.findViewById(R.id.BTListaAdic);
        imageView=(ImageView)vista.findViewById(R.id.imageView2);
        btCambiarImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_CODE_GALLERY);
            }
        });
        btAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regAdiccion();
            }
        });
        btLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), AdiccionListActivity.class);
                startActivity(intent);
            }
        });
        return vista;
    }
    public void regAdiccion(){
        try {
            Adiccion ad=new Adiccion();
            ad.setNombre(nombre.getText().toString());
            ad.setDescripcion(descripcion.getText().toString());
            ad.setImage(imageViewToByte(imageView));
            Toast.makeText(getActivity().getApplicationContext(),"AGREGADO CORRECTAMENTE",Toast.LENGTH_SHORT).show();
            daoA.insertAdiccion(ad);
            nombre.setText("");
            descripcion.setText("");
            imageView.setImageResource(R.mipmap.ic_launcher);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    private  byte[] imageViewToByte(ImageView image){
        Bitmap bitmap=((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray=stream.toByteArray();
        return byteArray;

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults) {
        if (requestCode==REQUEST_CODE_GALLERY){
            if (grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_GALLERY);
            }else {
                Toast.makeText(getActivity().getApplicationContext(),"AGREGAANDO IMAGEN",Toast.LENGTH_SHORT).show();
            }
            return;

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_CODE_GALLERY && resultCode ==RESULT_OK && data !=null){
            Uri uri=data.getData();
            try{
                InputStream inputStream=getActivity().getContentResolver().openInputStream(uri);
                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
