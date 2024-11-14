package gs.solinveste.repository;

import gs.solinveste.model.SolarPanelBudget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolarPanelBudgetRepository extends JpaRepository <SolarPanelBudget, Integer> {
}
