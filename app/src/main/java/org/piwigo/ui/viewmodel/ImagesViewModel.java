/*
 * Copyright 2017 Phil Bayfield https://philio.me
 * Copyright 2017 Piwigo Team http://piwigo.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.piwigo.ui.viewmodel;

/**
 * Created by Jeff on 9/26/2017.
 */

import android.content.res.Resources;
import android.databinding.ObservableArrayList;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import org.piwigo.BR;
import org.piwigo.R;
import org.piwigo.io.model.Category;
import org.piwigo.io.model.ImageInfo;
import org.piwigo.io.repository.ImageRepository;
import org.piwigo.ui.adapter.BindingRecyclerViewAdapter;

import java.util.List;

import javax.inject.Inject;


import rx.Subscriber;
import rx.Subscription;

public class ImagesViewModel extends BaseViewModel {


    public ObservableArrayList<ImageInfo> images = new ObservableArrayList<>();
    public BindingRecyclerViewAdapter.ViewBinder<ImageInfo> viewBinder = new ImagesViewBinder();

    @Inject ImageRepository imagesRepository;
    @Inject Resources resources;

    private Integer categoryId;
    private Subscription subscription;

    @Inject public ImagesViewModel() {}

    @Override public void onDestroy() {
       // Log.e(TAG, "onDestroy");
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void loadImages(Integer categoryId) {

        // *** HARD CODED A CATEGORY ID FOR TESTING *******
        this.categoryId = categoryId;
        subscription = imagesRepository.getImages(categoryId)
                .subscribe(new ImagesSubscriber());
    }


    private class ImagesSubscriber extends Subscriber<List<ImageInfo>> {

        @Override public void onCompleted() {}

        @Override public void onError(Throwable e) {
            Log.e("error", e.getMessage());
        }

        @Override public void onNext(List<ImageInfo> imagelist) {
            images.clear();
            images.addAll(imagelist);
        }

    }








    private class ImagesViewBinder implements BindingRecyclerViewAdapter.ViewBinder<ImageInfo> {

        @Override public int getViewType(ImageInfo image) {
            return 0;
        }

        @Override public int getLayout(int viewType) {
            return R.layout.item_images;
        }

        @Override public void bind(BindingRecyclerViewAdapter.ViewHolder viewHolder, ImageInfo image) {
         //   String photos = resources.getQuantityString(R.plurals.album_photos, item.first.nbImages, item.first.nbImages);
         //   if (item.first.totalNbImages > item.first.nbImages) {
         //       int subPhotos = item.first.totalNbImages - item.first.nbImages;
         //       photos += resources.getQuantityString(R.plurals.album_photos_subs, subPhotos, subPhotos);
       //     }
            //Album has no photos yet - set to dummy value
        //    String imageurl ="";
         //   if (item.second == null){
        //    }
        //    else
         //   {
        //        imageurl = item.second.derivatives.large.url;
        //    }
        //    AlbumItemViewModel viewModel = new AlbumItemViewModel(imageurl, item.first.name, photos);
        //    viewHolder.getBinding().setVariable(BR.viewModel, viewModel);
            String imageurl ="";
            imageurl = image.elementUrl;

            String imagename = image.name;

            ImagesItemViewModel viewModel = new ImagesItemViewModel(imageurl, imagename);
            viewHolder.getBinding().setVariable(BR.viewModel, viewModel);
        }

    }







}
