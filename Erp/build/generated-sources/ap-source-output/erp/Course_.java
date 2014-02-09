package erp;

import erp.Department;
import erp.Gradesheet;
import erp.Teacher;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-15T15:52:18")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, String> name;
    public static volatile SingularAttribute<Course, String> inSem;
    public static volatile SingularAttribute<Course, String> code;
    public static volatile CollectionAttribute<Course, Gradesheet> gradesheetCollection;
    public static volatile SingularAttribute<Course, Character> type;
    public static volatile SingularAttribute<Course, Teacher> teacherId;
    public static volatile SingularAttribute<Course, Department> dep;

}