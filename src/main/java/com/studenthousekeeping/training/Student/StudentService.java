package com.studenthousekeeping.training.Student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email is already taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(int studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with id " + studentId + " did not exist");
        }
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(Student updatedStudent) {
        Optional<Student> studentOptional = studentRepository.findById(updatedStudent.getId());
        if (studentOptional.isEmpty()) {
            throw new IllegalStateException("Student with id " + updatedStudent.getId() + " does not exist");
        }
        // update the fields of the existing student object with the values from the updatedStudent object
        Student existingStudent = studentOptional.get();
        existingStudent.setFirst_name(updatedStudent.getFirst_name());
        existingStudent.setLast_name(updatedStudent.getLast_name());
        existingStudent.setDepartment(updatedStudent.getDepartment());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setDate_of_birth(updatedStudent.getDate_of_birth());
        studentRepository.save(existingStudent);
    }

    @Transactional
	public void updateStudent2(int studentId, String first_name, String last_name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist"));

                if (first_name != null && first_name.length() > 0 && !Objects.equals(student.getFirst_name(), first_name)) {
                    student.setFirst_name(first_name);
                }
                if (last_name != null && last_name.length() > 0 && !Objects.equals(student.getLast_name(), last_name)) {
                    student.setLast_name(last_name);
                }
                if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
                    Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
                    if (studentOptional.isPresent() && studentOptional.get().getId() != studentId) {
                        throw new IllegalStateException("Email is already taken");
                    }
                    student.setEmail(email);
                }
                studentRepository.save(student);
	}
    
}
