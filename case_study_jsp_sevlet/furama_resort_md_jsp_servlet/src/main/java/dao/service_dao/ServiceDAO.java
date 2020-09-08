package dao.service_dao;


import model.Service;

import java.util.List;

public interface ServiceDAO {
    List<Service> findAll();

    void save(Service service);

    Service findById(int id);

    int update(Service service);
    boolean remove(int id);
    boolean validateId();
    int nextId();
}
