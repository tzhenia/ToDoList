package com.tzhenia.dao;

import com.tzhenia.entity.Note;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@AllArgsConstructor
public class NoteDAOImpl implements NoteDAO {
    private final SessionFactory sessionFactory;

    @Override
    public List<Note> getNotes() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Note> cq = cb.createQuery(Note.class);
        Root<Note> root = cq.from(Note.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void deleteNote(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Note book = session.byId(Note.class).load(id);
        session.delete(book);
    }

    @Override
    public void saveNote(Note note) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(note);
    }

    @Override
    public Note getNote(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Note.class, id);
    }
}
