package com.example.deployonaws.config;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.util.EC2MetadataUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwsEc2IpService {

    public static String getInstanceId() {
        return EC2MetadataUtils.getInstanceId();
    }

    public static String getAZ() {
        return EC2MetadataUtils.getAvailabilityZone();
    }

    public static String getPublicIp() {
        String instanceId = EC2MetadataUtils.getInstanceId();
        AmazonEC2 awsEC2client = AmazonEC2ClientBuilder.defaultClient();
        return awsEC2client.describeInstances(new DescribeInstancesRequest()
                        .withInstanceIds(instanceId))
                .getReservations()
                .stream()
                .map(Reservation::getInstances)
                .flatMap(List::stream)
                .findFirst()
                .map(Instance::getPublicIpAddress)
                .orElse(null);
    }
}
