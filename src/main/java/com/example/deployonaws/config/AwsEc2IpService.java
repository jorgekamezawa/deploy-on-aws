package com.example.deployonaws.config;

import com.amazonaws.util.EC2MetadataUtils;
import org.springframework.stereotype.Service;

@Service
public class AwsEc2IpService {

    public static String getInstanceId() {
        return EC2MetadataUtils.getInstanceId();

//        // Getting instance Id
//        String instanceId = EC2MetadataUtils.getInstanceId();
//
//        // Getting EC2 private IP
//        String privateIP = EC2MetadataUtils.getInstanceInfo().getPrivateIp();
//
//        // Getting EC2 public IP
//    AmazonEC2 awsEC2client = AmazonEC2ClientBuilder.defaultClient();
//    String publicIP = awsEC2client.describeInstances(new DescribeInstancesRequest()
//                    .withInstanceIds(instanceId))
//            .getReservations()
//            .stream()
////            .map(Reservation::getInstances)
//            .map(it -> it.rese)
//            .flatMap(List::stream)
//            .findFirst()
//            .map(Instance::getPublicIpAddress)
//            .orElse(null);
    }

    public static String getAZ() {
        return EC2MetadataUtils.getAvailabilityZone();
    }
}
