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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "COURSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name"),
    @NamedQuery(name = "Course.findByType", query = "SELECT c FROM Course c WHERE c.type = :type"),
    @NamedQuery(name = "Course.findByInsem", query = "SELECT c FROM Course c WHERE c.insem = :insem"),
    @NamedQuery(name = "Course.findByCredit", query = "SELECT c FROM Course c WHERE c.credit = :credit"),
    @NamedQuery(name = "Course.findByCode", query = "SELECT c FROM Course c WHERE c.code = :code")})
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "TYPE")
    private char type;
    @Column(name = "INSEM")
    private Integer insem;
    @Basic(optional = false)
    @Column(name = "CREDIT")
    private int credit;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE")
    private String code;
    @JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Teacher teacherId;
    @JoinColumn(name = "DEP", referencedColumnName = "CODE")
    @ManyToOne(optional = false)
    private Department dep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coursecode")
    private Collection<Gradesheet> gradesheetCollection;

    public Course() {
    }

    public Course(String code) {
        this.code = code;
    }

    public Course(String code, String name, char type, int credit) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public Integer getInsem() {
        return insem;
    }

    public void setInsem(Integer insem) {
        this.insem = insem;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

    @XmlTransient
    public Collection<Gradesheet> getGradesheetCollection() {
        return gradesheetCollection;
    }

    public void setGradesheetCollection(Collection<Gradesheet> gradesheetCollection) {
        this.gradesheetCollection = gradesheetCollection;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "erp.Course[ code=" + code + " ]";
        return String.format("%15s (%-10s)", name,code);
    }
    
}
