/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erp;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Prudhvi
 */
@Entity
@Table(name = "DEPARTMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name"),
    @NamedQuery(name = "Department.findByCode", query = "SELECT d FROM Department d WHERE d.code = :code"),
    @NamedQuery(name = "Department.findByTotalcourses", query = "SELECT d FROM Department d WHERE d.totalcourses = :totalcourses"),
    @NamedQuery(name = "Department.findByPresYear", query = "SELECT d FROM Department d WHERE d.presYear = :presYear"),
    @NamedQuery(name = "Department.findByStudNo", query = "SELECT d FROM Department d WHERE d.studNo = :studNo"),
    @NamedQuery(name = "Department.findByTotalteachers", query = "SELECT d FROM Department d WHERE d.totalteachers = :totalteachers")})
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE")
    private String code;
    @Basic(optional = false)
    @Column(name = "TOTALCOURSES")
    private int totalcourses;
    @Column(name = "PRES_YEAR")
    private Integer presYear;
    @Column(name = "STUD_NO")
    private Integer studNo;
    @Basic(optional = false)
    @Column(name = "TOTALTEACHERS")
    private int totalteachers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dep")
    private Collection<Student> studentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dep")
    private Collection<Course> courseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dep")
    private Collection<Teacher> teacherCollection;

    public Department() {
    }

    public Department(String code) {
        this.code = code;
    }

    public Department(String code, String name, int totalcourses, int totalteachers) {
        this.code = code;
        this.name = name;
        this.totalcourses = totalcourses;
        this.totalteachers = totalteachers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTotalcourses() {
        return totalcourses;
    }

    public void setTotalcourses(int totalcourses) {
        this.totalcourses = totalcourses;
    }

    public Integer getPresYear() {
        return presYear;
    }

    public void setPresYear(Integer presYear) {
        this.presYear = presYear;
    }

    public Integer getStudNo() {
        return studNo;
    }

    public void setStudNo(Integer studNo) {
        this.studNo = studNo;
    }

    public int getTotalteachers() {
        return totalteachers;
    }

    public void setTotalteachers(int totalteachers) {
        this.totalteachers = totalteachers;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @XmlTransient
    public Collection<Teacher> getTeacherCollection() {
        return teacherCollection;
    }

    public void setTeacherCollection(Collection<Teacher> teacherCollection) {
        this.teacherCollection = teacherCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "erp.Department[ code=" + code + " ]";
    }
    
}
