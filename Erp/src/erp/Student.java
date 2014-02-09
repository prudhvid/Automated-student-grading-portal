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
import javax.persistence.Lob;
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
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.name = :name"),
    @NamedQuery(name = "Student.findByRollNo", query = "SELECT s FROM Student s WHERE s.rollNo = :rollNo"),
    @NamedQuery(name = "Student.findByPhone", query = "SELECT s FROM Student s WHERE s.phone = :phone"),
    @NamedQuery(name = "Student.findByPassword", query = "SELECT s FROM Student s WHERE s.password = :password"),
    @NamedQuery(name = "Student.findByInsem", query = "SELECT s FROM Student s WHERE s.insem = :insem")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Id
    @Basic(optional = false)
    @Column(name = "ROLL_NO")
    private String rollNo;
    @Basic(optional = false)
    @Column(name = "PHONE")
    private long phone;
    @Lob
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "INSEM")
    private int insem;
    @JoinColumn(name = "DEP", referencedColumnName = "CODE")
    @ManyToOne(optional = false)
    private Department dep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rollNo")
    private Collection<Gradesheet> gradesheetCollection;

    public Student() {
    }

    public Student(String rollNo) {
        this.rollNo = rollNo;
    }

    public Student(String rollNo, String name, long phone, String password, int insem) {
        this.rollNo = rollNo;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.insem = insem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getInsem() {
        return insem;
    }

    public void setInsem(int insem) {
        this.insem = insem;
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
        hash += (rollNo != null ? rollNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.rollNo == null && other.rollNo != null) || (this.rollNo != null && !this.rollNo.equals(other.rollNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "erp.Student[ rollNo=" + rollNo + " ]";
    }
    
}
