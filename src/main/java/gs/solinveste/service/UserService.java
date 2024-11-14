package gs.solinveste.service;

import gs.solinveste.dto.ReadUserDTO;
import gs.solinveste.dto.SaveUserDTO;
import gs.solinveste.model.User;
import gs.solinveste.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Convert an entity to DTO to save a new user
    
    public SaveUserDTO convertToSaveUserDTO (User user) {
        SaveUserDTO saveUserDTO = new SaveUserDTO();
        saveUserDTO.setId(user.getId());
        saveUserDTO.setName(user.getName());
        saveUserDTO.setEmail(user.getName());
        saveUserDTO.setPassword(user.getPassword());
        saveUserDTO.setPhoneNumber(user.getPhoneNumber());
        return saveUserDTO;
    }

    //Convert an entity to DTO to read a user

    public ReadUserDTO convertToReadUserDTO (User user) {
        ReadUserDTO readUserDTO = new ReadUserDTO();
        readUserDTO.setId(user.getId());
        readUserDTO.setName(user.getName());
        readUserDTO.setEmail(user.getName());
        readUserDTO.setPhoneNumber(user.getPhoneNumber());
        return readUserDTO;
    }

    //convert a DTO to entity to save a user

    public User convertToEntity (SaveUserDTO saveUserDTO) {
        User user = new User();
        user.setId(saveUserDTO.getId());
        user.setName(saveUserDTO.getName());
        user.setEmail(saveUserDTO.getEmail());
        user.setPassword(saveUserDTO.getPassword());
        user.setPhoneNumber(saveUserDTO.getPhoneNumber());
        return user;
    }

    //Save a new user

    @Transactional
    public SaveUserDTO saveUser (SaveUserDTO saveUserDTO) {
        User user = convertToEntity(saveUserDTO);
        User savedUser = userRepository.save(user);
        return convertToSaveUserDTO(savedUser);
    }

    //Delete a user

    @Transactional
    public void deleteUser (Integer id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
        userRepository.deleteById(id);
    }

    //Read a user

    @Transactional
    public ReadUserDTO readUser (Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            return convertToReadUserDTO(existingUser);
        } else {
            throw new EntityNotFoundException("Usuário não encontrado");
        }

    }

    //Read all of users

    public List<ReadUserDTO> readUsers () {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToReadUserDTO)
                .collect(Collectors.toList());
    }

    //update the email from a user

    public ReadUserDTO updateEmail (Integer id, String email) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setEmail(email);
            userRepository.save(existingUser);
            return convertToReadUserDTO(existingUser);
        }else {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
    }

    //update the password from a user

    public ReadUserDTO updatePassword (Integer id, String password) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setPassword(password);
            userRepository.save(existingUser);
            return convertToReadUserDTO(existingUser);
        }else {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
    }

    //update the phone number from a user

    public ReadUserDTO updatePhoneNumber (Integer id, String phoneNumber) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setPhoneNumber(phoneNumber);
            userRepository.save(existingUser);
            return convertToReadUserDTO(existingUser);
        }else {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
    }
}
