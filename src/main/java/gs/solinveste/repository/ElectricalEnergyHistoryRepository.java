package gs.solinveste.repository;

import gs.solinveste.model.ElectricalEnergyHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricalEnergyHistoryRepository extends JpaRepository<ElectricalEnergyHistory, Integer> {
}
