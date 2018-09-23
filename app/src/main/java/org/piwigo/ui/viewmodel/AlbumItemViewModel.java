/*
 * Copyright 2016 Phil Bayfield https://philio.me
 * Copyright 2016 Piwigo Team http://piwigo.org
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



import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.piwigo.helper.CommonVars;

import javax.inject.Inject;


public class AlbumItemViewModel extends BaseViewModel {


    CommonVars comvars = CommonVars.getInstance();


    private final String url;
    private final String title;
    private final String photos;
    private final int catid;


    public AlbumItemViewModel(String url, String title, String photos, int id) {
        this.url = url;
        this.title = title;
        this.photos = photos;
        this.catid = id;

    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getPhotos() { return photos; }

    public int getCatid() { return catid;}




    public void onViewAlbumPhotos(){
        String test = url;

        comvars.setValue(catid);




      // FragmentManager fragmentManager = getFragmentManager();
             // .beginTransaction();

        //  ImageRepository images = new ImageRepository();

      //  List<ImageListResponse> myimages = images.getAlbumImages(11);

     //   getImages.

    }

}
