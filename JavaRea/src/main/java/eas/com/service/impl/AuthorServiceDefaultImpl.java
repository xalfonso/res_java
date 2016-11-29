package eas.com.service.impl;

import eas.com.entity.Author;
import eas.com.service.AuthorService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 11/28/2016.
 */
public class AuthorServiceDefaultImpl implements AuthorService {


    private List<Author> authorList;

    public AuthorServiceDefaultImpl() {
        this.authorList = new ArrayList<>();
        this.authorList.add(new Author(this.authorList.size() + 1 ,"Leydis", "Esther", "Garzon", "Giro"));
        this.authorList.add(new Author(this.authorList.size() + 1, "Yamile", "Yaquelin", "Sanchez", "Acosta"));
    }

    @Override
    public List<Author> getAll() {
        return this.authorList;
    }
}
