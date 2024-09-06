package com.rupp.finalprojectlms.features.enrollment;

import com.rupp.finalprojectlms.domain.Course;
import com.rupp.finalprojectlms.domain.Enrollment;
import com.rupp.finalprojectlms.domain.User;

import com.rupp.finalprojectlms.exception.ResourceNotFoundException;
import com.rupp.finalprojectlms.features.course.CourseRepository;
import com.rupp.finalprojectlms.features.enrollment.dto.CreateEnrollment;
import com.rupp.finalprojectlms.features.enrollment.dto.EnrollmentResponse;

import com.rupp.finalprojectlms.features.user.UserRepository;
import com.rupp.finalprojectlms.mapper.EnrollmentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EnrollmentServiceImp implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentMapper enrollmentMapper;



    @Override
    public List<EnrollmentResponse> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        return enrollments.stream()
                .map(enrollmentMapper::toEnrollmentResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EnrollmentResponse getEnrollmentById(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id: " + id));
        return enrollmentMapper.toEnrollmentResponse(enrollment);
    }

    @Override
    public EnrollmentResponse createEnrollment(CreateEnrollment createEnrollment) {
        // Convert DTO to entity
        Enrollment enrollment = enrollmentMapper.toEnrollment(createEnrollment);

        // Fetch and set user and course entities
        User user = userRepository.findById(createEnrollment.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + createEnrollment.getUserId()));
        Course course = courseRepository.findById(createEnrollment.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + createEnrollment.getCourseId()));

        enrollment.setUser(user);
        enrollment.setCourse(course);

        // Set the enrollment date to the current date
        enrollment.setEnrollmentDate(LocalDate.now()); // Ensure this is set

        // Save the enrollment
        enrollment = enrollmentRepository.save(enrollment);

        // Convert entity to response DTO
        return enrollmentMapper.toEnrollmentResponse(enrollment);
    }

    @Override
    public EnrollmentResponse updateEnrollment(Long id, CreateEnrollment createEnrollment) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id: " + id));

        // Update fields
        User user = userRepository.findById(createEnrollment.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + createEnrollment.getUserId()));
        Course course = courseRepository.findById(createEnrollment.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + createEnrollment.getCourseId()));

        enrollment.setUser(user);
        enrollment.setCourse(course);
        // Set the enrollment date to the current date
        enrollment.setEnrollmentDate(LocalDate.now());

        enrollment = enrollmentRepository.save(enrollment);
        return enrollmentMapper.toEnrollmentResponse(enrollment);
    }

    @Override
    public void deleteEnrollment(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id: " + id));
        enrollmentRepository.delete(enrollment);
    }
}
