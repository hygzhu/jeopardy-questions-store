package com.example.servingwebcontent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionService {
    @Autowired
    private QuestionRepository repo;

    public List<Question> listAll() {
        return repo.findAll();
    }

    public void save(Question product) {
        repo.save(product);
    }

    public Question get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
