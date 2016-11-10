package com.bluoh.service;

import com.bluoh.model.Bookmarks;
import com.bluoh.model.Deck;
import org.springframework.data.domain.Page;

public interface BookmarksService {

    Bookmarks create(Bookmarks bookmarks);

    Bookmarks delete(String id);

//    List<Bookmarks> findAll();

    Page<Deck> findAll(int page);

    Bookmarks findById(String id);

    Bookmarks update(Bookmarks bookmarks);

}
