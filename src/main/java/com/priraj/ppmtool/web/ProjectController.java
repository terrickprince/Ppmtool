package com.priraj.ppmtool.web;

import com.priraj.ppmtool.domain.Project;
import com.priraj.ppmtool.services.ProjectService;
import com.priraj.ppmtool.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    ValidationService validationService;

    @PostMapping("/create")
    public ResponseEntity<?> createProject(@Valid @RequestBody Project project, BindingResult result){
        if(result.hasErrors())
            return validationService.getValidatonErrors(result.getFieldErrors());
        return new ResponseEntity<Project>(projectService.saveOrUpdateProject(project), HttpStatus.CREATED);
    }

    @GetMapping("/get/{projectIdentifier}")
    public ResponseEntity<Project> getProjectById(@PathVariable String projectIdentifier){
        return new ResponseEntity<Project>(projectService.getProjectDetails(projectIdentifier),HttpStatus.OK);
    }

    @GetMapping("/getAllProjects")
    public ResponseEntity<Iterable<Project>> getAllProjects(){
        return new ResponseEntity<Iterable<Project>>
                (projectService.findAllProjects(),HttpStatus.OK);
    }
    @GetMapping("/delete/{projectIdentifier}")
    public void deleteProjectById(@PathVariable String projectIdentifier){
        projectService.deleteProjectByIdentifier(projectIdentifier);
    }

}
