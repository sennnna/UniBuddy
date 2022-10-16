package com.example.login_chat.fragment.login_info;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.login_chat.R;
import com.example.login_chat.screen.PhotoAlbumActivity;
import com.example.login_chat.single.PhotoDataSingle;
import com.example.login_chat.utils.PermissionUtil;

public class HeadSelectFragment extends Fragment {

    private String[] PERMISSIONS_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};

    private final int REQUEST_CODE = 101;

    private ImageView head_image;
    private EditText name_tv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_head_select, container, false);
        head_image = view.findViewById(R.id.head_image);
        name_tv = view.findViewById(R.id.name_tv);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Uri headImage = PhotoDataSingle.newInstance().getHeadImage();
        if (headImage != null){
            Glide
                .with(getView()).load(headImage)
                .skipMemoryCache(true)//跳过内存缓存
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不缓冲disk硬盘中
                .into(head_image);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //image onclick listen
        head_image.setOnClickListener(v -> {
            //检查权限,没有权限则申请权限
            if (PermissionUtil.checkPermissions(PERMISSIONS_STORAGE,requireActivity(),REQUEST_CODE)) {
                Intent intent = new Intent(requireActivity(), PhotoAlbumActivity.class);
                intent.putExtra("isCheck",false);
                startActivityForResult(intent,1);
            }
        });
        //get system album,select image is head
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast toast = Toast.makeText(requireActivity(), "授权失败", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1&&resultCode == 1){
            String image = data.getStringExtra("image");
            Glide.with(getView())
                    .load(Uri.parse(image))
                    .into(head_image);
        }
    }

    /**
     * judge whether the name is empty
     * @return
     */
    public boolean isNameEmpty(){
        return name_tv.getText().toString().isEmpty();
    }

    /**
     * get input name
     * @return
     */
    public String getName(){
        return  name_tv.getText().toString();
    }


}
