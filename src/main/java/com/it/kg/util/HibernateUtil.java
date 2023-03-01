package com.it.kg.util;

import com.it.kg.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {

        sessionFactory = new Configuration()
                .setProperty(Environment.DRIVER, "org.postgresql.Driver")
                .setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres")
                .setProperty(Environment.USER, "postgres")
                .setProperty(Environment.PASS, "marlen27056")
                .setProperty(Environment.HBM2DDL_AUTO, "create")
                .setProperty(Environment.SHOW_SQL, "true")
                .setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
