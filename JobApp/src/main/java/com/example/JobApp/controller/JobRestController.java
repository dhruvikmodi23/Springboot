package com.example.JobApp.controller;

import com.example.JobApp.model.JobPost;
import com.example.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class JobRestController {

    @Autowired
    private JobService jobService;

//    @GetMapping(path="JobPosts",produces = {"application/json"})
    @GetMapping("JobPosts")
//    @ResponseBody
     public List<JobPost> getAllJobs(Model model){
         return jobService.getAllJobs();
     }

     //path variable
     @GetMapping("JobPost/{postId}")
     public JobPost getJob(@PathVariable("postId") int postId){
          return jobService.getJob(postId);
     }

     //request body
//     @PostMapping(path="JobPost", consumes= {"application/xml"})
     @PostMapping("JobPost")
     public JobPost addJob(@RequestBody JobPost jobPost){
          jobService.addJob(jobPost);
          return jobService.getJob(jobPost.getPostId());
     }

     //put request
     @PutMapping("JobPost")
     public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
          return jobService.getJob(jobPost.getPostId());
     }

     //delete request
     @DeleteMapping("JobPost/{postId}")
     public void deleteJob(@PathVariable("postId") int postId){
          jobService.deleteJob(postId);
          System.out.println("Job deleted");
     }
}
