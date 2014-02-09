package erp;

import erp.Course;
import erp.Semester;
import erp.Student;
import erp.Teacher;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-15T15:52:18")
@StaticMetamodel(Department.class)
public class Department_ { 

    public static volatile CollectionAttribute<Department, Course> courseCollection;
    public static volatile CollectionAttribute<Department, Semester> semesterCollection;
    public static volatile SingularAttribute<Department, String> name;
    public static volatile CollectionAttribute<Department, Student> studentCollection;
    public static volatile CollectionAttribute<Department, Teacher> teacherCollection;
    public static volatile SingularAttribute<Department, String> rollgen;
    public static volatile SingularAttribute<Department, String> code;
    public static volatile SingularAttribute<Department, Integer> totalcourses;

}