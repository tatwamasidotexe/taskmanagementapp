package com.ttm.taskmanagerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttm.taskmanagerapp.Task;
import com.ttm.taskmanagerapp.repository.*;

//import jakarta.activation.DataSource;

@RestController
@RequestMapping("/tasks")
public class TaskController {

//	@Autowired
//	private DataSource datasource_tm;
	
    @Autowired
    private TaskRepository taskRepository;

    // Define methods for creating, updating, deleting, and listing tasks
    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
    	return taskRepository.save(task);
    }
    
    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
    	return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }
     
    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
    	Task existingTask = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
    	
    	existingTask.setTitle(task.getTitle());
    	existingTask.setDesc(task.getDesc());
    	existingTask.setStatus(task.getStatus());
    	
    	return taskRepository.save(existingTask);
    }
    
    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
    	taskRepository.deleteById(id);
    }
}