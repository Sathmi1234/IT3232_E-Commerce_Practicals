package com.vau.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vau.app.model.Insurance;

public interface InsuranceRepo extends JpaRepository<Insurance, String>{

}
