package gs.solinveste.repository;

import gs.solinveste.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Set<Address> findByUserId(Integer userId);
}
