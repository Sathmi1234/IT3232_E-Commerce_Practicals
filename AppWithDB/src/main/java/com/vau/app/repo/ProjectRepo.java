package com.vau.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vau.app.model.Project;

public interface ProjectRepo extends JpaRepository<Project, String>{

}
