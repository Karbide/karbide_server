package com.bluoh.service;

import com.bluoh.model.Bookmarks;

import java.util.List;

public interface BookmarksService {

    Bookmarks create(Bookmarks bookmarks);

    Bookmarks delete(String id);

//    List<Bookmarks> findAll();

    List<Bookmarks> findAll();

    Bookmarks findById(String id);

    Bookmarks update(Bookmarks bookmarks);

}
