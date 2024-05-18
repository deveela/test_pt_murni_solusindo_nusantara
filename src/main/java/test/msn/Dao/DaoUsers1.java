package test.msn.Dao;

import test.msn.Entities.Users1;
import org.hibernate.HibernateException;

import java.util.List;

public interface DaoUsers1 {
    public void save(Users1 o) throws HibernateException;
    public Object[] saveCustom(String user, String pass, String age);
    public void update(Users1 o) throws HibernateException;
    public void delete(Users1 o) throws HibernateException;
    public Users1 byid(Long ID) throws HibernateException;
    public List<Users1> all() throws HibernateException;
    public List<Object[]> allCustom() throws HibernateException;
    public Users1 byEmail(String email) throws HibernateException;
}
