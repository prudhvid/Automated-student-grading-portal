package erp;

import erp.Department;
import erp.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-15T15:52:18")
@StaticMetamodel(Semester.class)
public class Semester_ { 

    public static volatile CollectionAttribute<Semester, Student> studentCollection;
    public static volatile SingularAttribute<Semester, String> number;
    public static volatile SingularAttribute<Semester, Integer> minElectives;
    public static volatile SingularAttribute<Semester, Department> dep;

}