package gs.solinveste.service;

import gs.solinveste.dto.ChangePasswordDTO;
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

    private User findUserById(Integer id) throws EntityNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
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
        readUserDTO.setEmail(user.getEmail());
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
        User existingUser = findUserById(id);
        userRepository.deleteById(existingUser.getId());

    }

    //Read a user

    @Transactional
    public ReadUserDTO readUser (Integer id) {
            User existingUser = findUserById(id);
            return convertToReadUserDTO(existingUser);
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
            User existingUser = findUserById(id);
            existingUser.setEmail(email);
            userRepository.save(existingUser);
            return convertToReadUserDTO(existingUser);
    }

    //update the password from a user

    public String updatePassword (Integer id, String password) {
            User existingUser = findUserById(id);
            existingUser.setPassword(password);
            userRepository.save(existingUser);
            return "Senha atualizada com sucesso";
    }


}
