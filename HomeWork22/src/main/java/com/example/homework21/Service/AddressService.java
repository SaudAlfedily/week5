package com.example.homework21.Service;

import com.example.homework21.ApiException.ApiException;
import com.example.homework21.DTO.AddressDTO;
import com.example.homework21.Model.Address;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Repository.AddressRepository;
import com.example.homework21.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

//    public List<Address> getAllAddress(){
//        return addressRepository.findAll();
//    }

    public void addAddress(AddressDTO dto){
        Teacher teacher = teacherRepository.findTeacherById(dto.getTeacher_id());
        if(teacher==null){

            throw new ApiException("teacher not found .  can not add address");
        }
        Address address =new Address(null, dto.getArea(), dto.getStreet(),dto.getBuildingNumber(),teacher);

        addressRepository.save(address);

    }

    public void updateAddress(Integer id,Address address){
        Address oldAddress=addressRepository.findAddressById(id);
        if(oldAddress==null){


            throw new ApiException("Address not found .  can not update address");


        }
        oldAddress.setArea(address.getArea());
        oldAddress.setStreet(address.getStreet());
        oldAddress.setBuildingNumber(oldAddress.getBuildingNumber());
        addressRepository.save(oldAddress);

        // i prevent the user from changing teacher do he can change all his address except primary and foreign key


    }

    public void  deleteAddress(Integer id){
        Address address = addressRepository.findAddressById(id);
        if(address==null){

            throw new ApiException("address not found");

        }
        addressRepository.deleteById(id);
    }

}
