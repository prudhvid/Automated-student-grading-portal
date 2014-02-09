package erp;

import erp.Course;
import erp.Department;
import erp.Gradesheet;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-15T15:52:18")
@StaticMetamodel(Teacher.class)
public class Teacher_ { 

    public static volatile SingularAttribute<Teacher, String> id;
    public static volatile CollectionAttribute<Teacher, Course> courseCollection;
    public static volatile CollectionAttribute<Teacher, Gradesheet> gradesheetCollection;
    public static volatile SingularAttribute<Teacher, String> password;
    public static volatile SingularAttribute<Teacher, Department> dep;

}