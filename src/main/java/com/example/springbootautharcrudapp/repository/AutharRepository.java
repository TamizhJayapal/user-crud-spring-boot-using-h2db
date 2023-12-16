package com.example.springbootautharcrudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootautharcrudapp.model.Authar;

public interface AutharRepository extends JpaRepository<Authar, Integer>{
	
}
