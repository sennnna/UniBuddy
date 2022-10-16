package com.example.login_chat.single;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class PhotoDataSingle {

    private PhotoDataSingle(){

    }

    private static PhotoDataSingle instance = null;

    private Uri headImage;
    private List<Uri> imageList = new ArrayList<>();

    public static PhotoDataSingle newInstance(){
        if (instance == null){
            instance = new PhotoDataSingle();
        }
        return instance;
    }

    public void setHeadImage(Uri headImage) {
        this.headImage = headImage;
    }

    public Uri getHeadImage(){
        Uri uri = headImage;
        headImage = null;
        return uri;
    }

    public void addImage(Uri uri){
        imageList.add(uri);
    }

    public void removeImage(Uri uri){
        imageList.remove(uri);
    }

    public List<Uri> getImageList() {
        List<Uri> uris = imageList;
        imageList.clear();
        return uris;
    }
}
