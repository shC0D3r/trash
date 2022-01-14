package dao;

import models.NewHero;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibSessionsFactory;
import java.util.List;

public class NewHeroDAO {
    public NewHero findById(int id) {
        return HibSessionsFactory.getSessionFactory().openSession().get(NewHero.class, id);
    }

    public void save(NewHero hero) {
        Session session = HibSessionsFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(hero);
        tx1.commit();
        session.close();
        System.out.println("Герой был сохранен!"+hero);
    }

    public void update(NewHero hero) {
        Session session = HibSessionsFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(hero);
        tx1.commit();
        session.close();
    }

    public void delete(NewHero hero) {
        Session session = HibSessionsFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(hero);
        tx1.commit();
        session.close();
    }

    public List<NewHero> findAll() {
        List<NewHero> heroes = (List<NewHero>) HibSessionsFactory.getSessionFactory().openSession().createQuery("From NewHero").list();
        return heroes;
    }
}
