package ru.tolkacheva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tolkacheva.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> { }
