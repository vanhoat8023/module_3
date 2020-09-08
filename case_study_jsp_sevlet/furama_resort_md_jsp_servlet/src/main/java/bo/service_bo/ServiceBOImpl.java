package bo.service_bo;

import model.Service;

import java.util.List;

public class ServiceBOImpl implements ServiceBO{
    ServiceBO serviceBO = new ServiceBOImpl();
    @Override
    public List<Service> findAll() {
        return null;
    }

    @Override
    public void save(Service service) {

    }

    @Override
    public Service findById(int id) {
        return null;
    }

    @Override
    public int update(Service service) {
        return 0;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public boolean validateId() {
        return false;
    }

    @Override
    public int nextId() {
        return 0;
    }
}
