package test.msn.Dao;

import test.msn.Entities.Users1;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public class DaoUsers1Impl implements DaoUsers1 {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Users1 o) throws HibernateException {
        sessionFactory.getCurrentSession().save(o);
    }

    @Override
    public Object[] saveCustom(String user, String pass, String age) {
        int affrow = sessionFactory.getCurrentSession().createSQLQuery(
                        "call stored_users1(:user, :pass, :age)"
                )
                .setParameter("user", user)
                .setParameter("pass", pass)
                .setParameter("age", age)
                .executeUpdate();

        BigInteger lastid = (BigInteger) sessionFactory.getCurrentSession().createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult();

        return new Object[] {Long.valueOf(String.valueOf(lastid)), affrow};
    }

    @Override
    public void update(Users1 o) throws HibernateException {
        sessionFactory.getCurrentSession().update(o);
    }

    @Override
    public void delete(Users1 o) throws HibernateException {
        sessionFactory.getCurrentSession().delete(o);
    }

    @Override
    public Users1 byid(Long ID) throws HibernateException {
        return sessionFactory.getCurrentSession().get(Users1.class, ID);
    }

    @Override
    public List<Users1> all() throws HibernateException {
        // Create CriteriaBuilder
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Users1> criteria = builder.createQuery(Users1.class);
        Root<Users1> root = criteria.from(Users1.class);
        criteria.select(root);
        List<Users1> results = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        return results;
    }

    @Override
    public List<Object[]> allCustom() throws HibernateException {
        List<Object[]> res = sessionFactory.getCurrentSession().createSQLQuery(
                "call view_users1()"
        )
        .list();

        return res;
    }

    @Override
    public Users1 byEmail(String email) throws HibernateException {
        // Create CriteriaBuilder
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Users1> criteria = builder.createQuery(Users1.class);
        Root<Users1> root = criteria.from(Users1.class);
        criteria.select(root).where(builder.equal(root.get("username"), email));
        Users1 result = sessionFactory.getCurrentSession().createQuery(criteria).getSingleResult();
        return result;
    }
}
