package br.com.livrarialib;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class DAOFactory {

    @Inject
    private EntityManager manager;

    @Produces
    public <T> DAO<T> factory(InjectionPoint point) {
        ParameterizedType types = (ParameterizedType) point.getType();

        Type type = types.getActualTypeArguments()[0];

        return new DAO<T>((Class<T>)type, manager);
    }
}
