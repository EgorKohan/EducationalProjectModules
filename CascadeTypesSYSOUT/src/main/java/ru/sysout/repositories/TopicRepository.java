package ru.sysout.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sysout.models.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
