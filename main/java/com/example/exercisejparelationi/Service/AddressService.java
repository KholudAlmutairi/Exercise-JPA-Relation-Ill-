package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.Api.ApiException;
import com.example.exercisejparelationi.DTO.AddressDTO;
import com.example.exercisejparelationi.Model.Address;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repository.AddressRepository;
import com.example.exercisejparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
   private final AddressRepository addressRepository;
   private final TeacherRepository teacherRepository;

    public List<Address> getAllAddresss() {
        return addressRepository.findAll();
    }

     // • Add teacher address
    public void addAddress(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("teacher not found");
        }
        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);
        addressRepository.save(address);

    }

     //• Update teacher address
    public void updateAddress(AddressDTO addressDTO) {
        Address address=addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (address == null) {
            throw new ApiException("Address not found");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);


    }

   //• Delete teacher address
    public void deleteAddress(Integer id) {
        Address a=addressRepository.findAddressById(id);
        if (a == null) {
            throw new ApiException("Wrong id");
        }
        addressRepository.delete(a);
    }










}
