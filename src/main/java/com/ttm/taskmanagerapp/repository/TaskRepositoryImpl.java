package com.ttm.taskmanagerapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ttm.taskmanagerapp.Task;

import jakarta.persistence.EntityManager;

public abstract class TaskRepositoryImpl  implements TaskRepository{
    
	@Autowired
	private EntityManager entityManager;
	
	@Override
    public Task getReferenceById(Long id) {
        return entityManager.getReference(Task.class, id);
    }
	
	@Override
	public List<Task> findAll() {
		return entityManager.createQuery("select t from Task t", Task.class).getResultList();
	}
	
	@Override
	public Optional<Task> findById(Long id) {
		Task task = entityManager.find(Task.class, id);
		return Optional.ofNullable(task);
	}
	
	@SuppressWarnings("unchecked")
	public Task save(Task task) {
		entityManager.persist(task);
		return task;
	}
	
	public void delete(Task task) {
		entityManager.remove(task);
	}
}