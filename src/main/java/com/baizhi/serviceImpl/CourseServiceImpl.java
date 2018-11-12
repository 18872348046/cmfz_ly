package com.baizhi.serviceImpl;

import com.baizhi.dao.CourseDAO;
import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseDAO courseDAO;
    @Override
    public void add(Course course) {
        course.setId(UUID.randomUUID().toString().replace("-",""));
        course.setFlag("b");
        courseDAO.insert(course);
    }

    @Override
    public void motify(Course course) {

    }

    @Override
    public void remove(String id) {
        courseDAO.delete(id);
    }

    @Override
    public void removeAll(String[] id) {

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Course> findAll() {
        return courseDAO.queryAll();
    }

    @Override
    public Course findById(String id) {
        return null;
    }

    @Override
    public List<Course> findAllPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public Long findPage() {
        return null;
    }
}
