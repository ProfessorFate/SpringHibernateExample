package contact.dao;

import contact.model.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Queue;

@Component
public class ContactDaoImpl implements ContactDao{

    private SessionFactory sessionFactory;

    @Autowired
    public ContactDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    public Session currentSession(){
        return sessionFactory.openSession();
    }

    @Override
    public List<Contact> list() {
        return currentSession().createQuery("from Contact",Contact.class).list();
    }

    @Override
    public void save(Contact contact) {
        currentSession().save(contact);
    }

    @Override
    public void edit(Contact contact) {
        currentSession().update(contact);
    }

    @Override
    public void delete(int id) {
        currentSession().delete(id);
    }

    @Override
    public Contact get(int id) {
        return currentSession().get(Contact.class,id);
    }
}
