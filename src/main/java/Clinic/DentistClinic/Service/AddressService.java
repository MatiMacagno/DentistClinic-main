package Clinic.DentistClinic.Service;

import Clinic.DentistClinic.Entities.Address;
import Clinic.DentistClinic.Repository.AddressRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private static final Logger logger = Logger.getLogger(AppointmentService.class);

    @Autowired
    AddressRepository addressRepository;

    public boolean existsById(Long id){
        return addressRepository.existsById(id);
    }

    public List<Address> list(){
        return addressRepository.findAll();
    }

    public Address save(Address address){
        return addressRepository.save(address);
    }

    public Boolean deleteAddress(Long id){
        if (!existsById(id)){
            logger.info("Address "+ id + "not exists");
            throw new NotFoundException("Address not exists");
        }
        addressRepository.deleteById(id);
        return true;
    }

    public Optional<Address> searchById(Long id){
        Optional<Address> address = addressRepository.findById(id);
        if (address.isEmpty()){
            logger.info("Address not exists");
            throw new NotFoundException("Address not exists");
        }
        return address;
    }

    public Address updateAddress(Long id, Address newAddress) {
        Address address = addressRepository.findById(id).orElseThrow(() -> {throw new RuntimeException();});
        address.setStreet(newAddress.getStreet());
        address.setNumber(newAddress.getNumber());
        address.setLocality(newAddress.getLocality());
        address.setProvince(newAddress.getProvince());
        logger.info("Update appointment " + id );
        return address;
    }

}
