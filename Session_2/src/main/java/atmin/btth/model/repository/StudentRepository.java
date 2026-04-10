package atmin.btth.model.repository;

import atmin.btth.model.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> findAll() {
        String sql = "SELECT id, name, faculty, study_year, gpa FROM student ORDER BY id";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("faculty"),
                        rs.getInt("study_year"),
                        rs.getDouble("gpa")
                )
        );
    }
}

