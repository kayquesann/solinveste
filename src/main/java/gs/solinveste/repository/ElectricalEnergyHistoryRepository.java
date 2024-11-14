package gs.solinveste.repository;

import gs.solinveste.model.ElectricalEnergyHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectricalEnergyHistoryRepository extends JpaRepository<ElectricalEnergyHistory, Integer> {
}
