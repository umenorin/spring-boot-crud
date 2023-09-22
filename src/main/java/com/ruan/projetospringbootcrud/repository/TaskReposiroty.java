package com.ruan.projetospringbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruan.projetospringbootcrud.model.Task;


@Repository
public interface TaskReposiroty extends JpaRepository<Task, Long>{

}