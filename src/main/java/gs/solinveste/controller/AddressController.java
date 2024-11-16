package gs.solinveste.controller;

import gs.solinveste.dto.AddressDTO;
import gs.solinveste.dto.SaveAddressDTO;
import gs.solinveste.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/endereco")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("{userId}")
    public ResponseEntity<Set<AddressDTO>> readAddressByUser (@PathVariable Integer userId) {
        Set<AddressDTO> addressesDTO = addressService.readAddressByUser(userId);
        return ResponseEntity.ok(addressesDTO);
    }

    @GetMapping
    public ResponseEntity<List<AddressDTO>> readAllAddresses () {
        return ResponseEntity.ok(addressService.readAllAddresses());
    }

    @PostMapping
    public ResponseEntity<SaveAddressDTO> saveAddress (@RequestBody @Valid SaveAddressDTO saveAddressDTO) {
        SaveAddressDTO newUser = addressService.saveAddress(saveAddressDTO);
        return ResponseEntity.ok(newUser);
    }

}
