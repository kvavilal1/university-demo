package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
