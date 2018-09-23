package org.piwigo.io.repository;

/**
 * Created by Jeff on 7/18/2017.
 */


import android.provider.MediaStore;
import android.util.Pair;

import org.piwigo.io.model.Category;
import org.piwigo.io.model.ImageInfo;
import org.piwigo.io.model.ImageListResponse;
import org.piwigo.io.repository.ImageRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.functions.Func2;




public class ImageRepository extends BaseRepository {

    @Inject public ImageRepository() {}

    public Observable<List<ImageInfo>> getImages(Integer categoryId) {
        return restService
                .getImages(categoryId)
                .map(imageListResponse -> imageListResponse.result.images)
                .compose(applySchedulers());


   }



    }


