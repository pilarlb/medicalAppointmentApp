package es.medcen.app.repositories;

import es.medcen.app.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<Slot, Long> {
	
	List<Slot> findBySchedule (Schedule schedule);
	List<Slot> findByScheduleAndAvailable (Schedule schedule, boolean available);
	Slot findByAppointment(Appointment appointment);
	//slot buscar por appointment time no tiene sentido
}
