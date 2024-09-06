package com.rupp.finalprojectlms.features.enrollment;

import com.rupp.finalprojectlms.domain.Enrollment;
import com.rupp.finalprojectlms.features.enrollment.dto.CreateEnrollment;
import com.rupp.finalprojectlms.features.enrollment.dto.EnrollmentResponse;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentResponse> getAllEnrollments();
    EnrollmentResponse getEnrollmentById(Long id);
    EnrollmentResponse createEnrollment(CreateEnrollment createEnrollment);
    EnrollmentResponse updateEnrollment(Long id, CreateEnrollment createEnrollment);
    void deleteEnrollment(Long id);
}
