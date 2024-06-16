package com.example.rest_demo;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CloudVendorServiceImpl implements CloudVendorService{

    CloudVendorRepository cloudVendorRepository;
    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }


    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String CloudVendorId) {
cloudVendorRepository .deleteById(CloudVendorId);
        return "Success";
    }

    @Override
    public  CloudVendor getCloudVendor(String CloudVendorId) {
        if(cloudVendorRepository.findById(CloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested cloud Vendor doesn't exist");
     return  cloudVendorRepository.findById(CloudVendorId).get();



    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepository.findAll();
    }
}
