package test.msn.Services;

import test.msn.Dao.DaoUsers1;
import test.msn.Entities.Users1;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ServiceUsers1")
@Transactional
public class ServiceUsers1Impl implements ServiceUsers1 {

    @Autowired
    DaoUsers1 daoUsers1;

    @Override
    @Transactional
    public void save(Users1 o) throws HibernateException {
        daoUsers1.save(o);
    }

    @Override
    public Object[] saveCustom(String user, String pass, String age) {
        return daoUsers1.saveCustom(user, pass, age);
    }

    @Override
    @Transactional
    public void update(Users1 o) throws HibernateException {
        daoUsers1.update(o);
    }

    @Override
    @Transactional
    public void delete(Users1 o) throws HibernateException {
        daoUsers1.delete(o);
    }

    @Override
    public Users1 byid(Long ID) throws HibernateException {
        return daoUsers1.byid(ID);
    }

    @Override
    public List<Users1> all() throws HibernateException {
        return daoUsers1.all();
    }

    @Override
    public List<Object[]> allCustom() throws HibernateException {
        return daoUsers1.allCustom();
    }
}

