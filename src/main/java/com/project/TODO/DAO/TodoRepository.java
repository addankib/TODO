package com.project.TODO.DAO;

import com.project.TODO.Entity.TODO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TODO, Long> {


}
