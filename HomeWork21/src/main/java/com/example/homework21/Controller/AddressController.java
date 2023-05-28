package com.example.homework21.Controller;

import com.example.homework21.DTO.AddressDTO;
import com.example.homework21.Model.Address;
import com.example.homework21.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/address")
public class AddressController {

    private final AddressService addressService;
    @PostMapping("/add")
public ResponseEntity addAddress(@Valid @RequestBody AddressDTO dto){
    addressService.addAddress(dto);
    return ResponseEntity.status(200).body("address added");

}
@PutMapping("/update/{id}")
    public ResponseEntity updateAddress(@Valid@PathVariable Integer id,@Valid @RequestBody Address address){
        addressService.updateAddress(id,address);
        return ResponseEntity.status(200).body("address updated");

    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable@Valid Integer id){

    addressService.deleteAddress(id);
    return ResponseEntity.status(200).body("Address deleted");

    }

}
