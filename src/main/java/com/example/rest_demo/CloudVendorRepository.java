package com.example.rest_demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

}
