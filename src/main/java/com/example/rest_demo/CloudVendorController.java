package com.example.rest_demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/CloudVendor")


public class CloudVendorController {
    CloudVendorService cloudVendorService;
    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }


//read specific cloud vendor details
    @GetMapping("{vendorId}")
    public ResponseEntity<Object>getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
    //public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
                return ResponseHandler.responseBuilder ("Requested vendor details are here",
        HttpStatus.OK ,cloudVendorService.getCloudVendor(vendorId));
      //return  cloudVendorService.getCloudVendor(vendorId);

        // ("c1","Abcccc","Adress a1","XXXXXX");


    }
    //read all specific details
    @GetMapping()
    public List <CloudVendor> getAllCloudVendorDetails()  {
        return  cloudVendorService.getAllCloudVendor();
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {

        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud vendor is created";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {

     cloudVendorService.updateCloudVendor(cloudVendor);

        return "Cloud vendor is updated";

    }
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String VendorId) {

        cloudVendorService.deleteCloudVendor(VendorId);
        return "Cloud vendor is deleted Successfully";
    }
}


