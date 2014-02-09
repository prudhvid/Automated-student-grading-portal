package erp;

import erp.Course;
import erp.Student;
import erp.Teacher;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-15T15:52:18")
@StaticMetamodel(Gradesheet.class)
public class Gradesheet_ { 

    public static volatile SingularAttribute<Gradesheet, Course> coursecode;
    public static volatile SingularAttribute<Gradesheet, Integer> num;
    public static volatile SingularAttribute<Gradesheet, Date> prim;
    public static volatile SingularAttribute<Gradesheet, Student> rollNo;
    public static volatile SingularAttribute<Gradesheet, Integer> grade;
    public static volatile SingularAttribute<Gradesheet, Teacher> teacherid;

}