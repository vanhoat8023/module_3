package bo.service_bo;

import model.Service;

import java.util.List;

public interface ServiceBO {
    List<Service> findAll();

    void save(Service service);

    Service findById(int id);

    int update(Service service);
    void remove(int id);
    boolean validateMKH(String string);
    int nextId();
}
