package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long>{

}
