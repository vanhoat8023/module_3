package bo.service_bo;

import dao.service_dao.ServiceDAO;
import dao.service_dao.ServiceDAOImpl;
import model.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceBOImpl implements ServiceBO{
    ServiceDAO serviceDAO = new ServiceDAOImpl();
    @Override
    public List<Service> findAll() {
        return serviceDAO.findAll();
    }

    @Override
    public void save(Service service) {
        serviceDAO.save(service);
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
    public boolean validateMKH(String string) {

        String regexMKH = "[D][V][0-9]{4}";
        Pattern pattern = Pattern.compile(regexMKH);
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()){
            return true;
        }else return false;
    }

    @Override
    public int nextId() {
        return 0;
    }
}
