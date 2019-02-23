package com.priraj.ppmtool.repository;

import com.priraj.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface ProjectRepository extends CrudRepository<Project, BigInteger> {

    Project findByProjectIdentifier(String projectIdentifier);

    @Override
    Iterable<Project> findAll();
}