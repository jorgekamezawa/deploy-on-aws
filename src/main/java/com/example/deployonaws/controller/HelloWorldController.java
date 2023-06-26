package com.example.deployonaws.controller;

import com.example.deployonaws.config.AwsEc2IpService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloWorld")
public class HelloWorldController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/aws")
    @ResponseStatus(HttpStatus.OK)
    public Output helloWorldAws() {
        return Output.create(AwsEc2IpService.getInstanceId(), AwsEc2IpService.getAZ());
    }
}

record Output(String helloWorld, String ec2Ip, String availabilityZone) {

    static Output create(String ec2Ip, String availabilityZone) {
        return new Output("Hello World", ec2Ip, availabilityZone);
    }
}
