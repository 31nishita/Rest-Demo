package com.example.rest_demo;
import java.util.List;
public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String CloudVendorId);
    public CloudVendor getCloudVendor(String CloudVendorId);
    public List<CloudVendor>getAllCloudVendor();
}