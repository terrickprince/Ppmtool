package com.priraj.ppmtool.services;

import com.priraj.ppmtool.domain.Project;
import com.priraj.ppmtool.exceptions.ProjectIdentifierException;
import com.priraj.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        Project projectResponse = null;
        try{
            projectResponse=projectRepository.save(project);
        }
        catch (Exception exception){
            throw new ProjectIdentifierException("Project Identifier "+project.getProjectIdentifier()+" already exists");
        }
        return  projectResponse;
    }

    public Project getProjectDetails(String projectIdentifier){
        Project projectResponse = projectRepository.findByProjectIdentifier(projectIdentifier);
        if(projectResponse==null){
            throw new ProjectIdentifierException("Project Identifier"+projectIdentifier+" doesn't exists");
        }
        return  projectResponse;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectIdentifier){
        Project projectResponse = getProjectDetails(projectIdentifier);
        projectRepository.delete(projectResponse);
    }
}
