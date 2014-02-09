package erp;

import erp.Department;
import erp.Gradesheet;
import erp.Semester;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-15T15:52:18")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, Long> phone;
    public static volatile SingularAttribute<Student, String> rollNo;
    public static volatile SingularAttribute<Student, String> address;
    public static volatile SingularAttribute<Student, String> name;
    public static volatile SingularAttribute<Student, Semester> inSem;
    public static volatile CollectionAttribute<Student, Gradesheet> gradesheetCollection;
    public static volatile SingularAttribute<Student, String> password;
    public static volatile SingularAttribute<Student, Department> dep;

}