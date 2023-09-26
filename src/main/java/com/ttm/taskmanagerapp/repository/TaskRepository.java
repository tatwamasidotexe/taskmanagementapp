package com.ttm.taskmanagerapp.repository;

import org.springframework.stereotype.Repository;

import com.ttm.taskmanagerapp.Task;

import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	default List<Task> findAll() { return null; };
	default Optional<Task> findById(Long id) { return null; };
	
	
	@SuppressWarnings("unchecked")
	default Task save(Task task) { return task; };
	
	default void delete(Task task) {};
}