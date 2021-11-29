package es.medcen.app.repositories;

import es.medcen.app.model.*;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	
	List<Schedule> findByHealthWorker (HealthWorker healthworker);
	List<Schedule> findByHealthWorkerAndIsWorkingDay (HealthWorker healthworker, boolean isworkingday);
	Schedule findByHealthWorkerAndDate (HealthWorker healthworker, Calendar date);
}
