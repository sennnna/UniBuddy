package com.example.login_chat.viewmodel.login;

import android.app.Application;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class PhotoAlbumViewModel extends AndroidViewModel {

    private MutableLiveData<List<Uri>> photoUriList = new MutableLiveData<>();

    public PhotoAlbumViewModel(@NonNull Application application) {
        super(application);
        loadAlbum();
    }

    //加载相册
    private void loadAlbum(){
        Cursor cursor = getApplication().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
            List<Uri> list = new ArrayList<>();
            while (cursor.moveToNext()){
                long id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.MediaColumns._ID));
                Uri uri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id);
                list.add(uri);
            }
            photoUriList.setValue(list);
        }
    }

    public MutableLiveData<List<Uri>> getPhotoUriList() {
        return photoUriList;
    }
}
