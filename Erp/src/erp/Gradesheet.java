/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erp;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Prudhvi
 */
@Entity
@Table(name = "GRADESHEET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gradesheet.findAll", query = "SELECT g FROM Gradesheet g"),
    @NamedQuery(name = "Gradesheet.findByGrade", query = "SELECT g FROM Gradesheet g WHERE g.grade = :grade"),
    @NamedQuery(name = "Gradesheet.findByPrim", query = "SELECT g FROM Gradesheet g WHERE g.prim = :prim")})
public class Gradesheet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "GRADE")
    private int grade;
    @Id
    @Basic(optional = false)
    @Column(name = "PRIM")
    private Integer prim;
    @JoinColumn(name = "TEACHERID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Teacher teacherid;
    @JoinColumn(name = "ROLL_NO", referencedColumnName = "ROLL_NO")
    @ManyToOne(optional = false)
    private Student rollNo;
    @JoinColumn(name = "COURSECODE", referencedColumnName = "CODE")
    @ManyToOne(optional = false)
    private Course coursecode;

    public Gradesheet() {
    }

    public Gradesheet(Integer prim) {
        this.prim = prim;
    }

    public Gradesheet(Integer prim, int grade) {
        this.prim = prim;
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Integer getPrim() {
        return prim;
    }

    public void setPrim(Integer prim) {
        this.prim = prim;
    }

    public Teacher getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Teacher teacherid) {
        this.teacherid = teacherid;
    }

    public Student getRollNo() {
        return rollNo;
    }

    public void setRollNo(Student rollNo) {
        this.rollNo = rollNo;
    }

    public Course getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(Course coursecode) {
        this.coursecode = coursecode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prim != null ? prim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gradesheet)) {
            return false;
        }
        Gradesheet other = (Gradesheet) object;
        if ((this.prim == null && other.prim != null) || (this.prim != null && !this.prim.equals(other.prim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "erp.Gradesheet[ prim=" + prim + " ]";
    }
    
}
