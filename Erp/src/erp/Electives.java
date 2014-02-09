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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Prudhvi
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Electives.findAll", query = "SELECT e FROM Electives e"),
    @NamedQuery(name = "Electives.findByNumElectives", query = "SELECT e FROM Electives e WHERE e.numElectives = :numElectives"),
    @NamedQuery(name = "Electives.findBySemNo", query = "SELECT e FROM Electives e WHERE e.semNo = :semNo"),
    @NamedQuery(name = "Electives.findBySno", query = "SELECT e FROM Electives e WHERE e.sno = :sno")})
public class Electives implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "NUM_ELECTIVES")
    private Integer numElectives;
    @Column(name = "SEM_NO")
    private Integer semNo;
    @Id
    @Basic(optional = false)
    private Integer sno;
    @JoinColumn(name = "DEP", referencedColumnName = "CODE")
    @ManyToOne(optional = false)
    private Department dep;

    public Electives() {
    }

    public Electives(Integer sno) {
        this.sno = sno;
    }

    public Integer getNumElectives() {
        return numElectives;
    }

    public void setNumElectives(Integer numElectives) {
        this.numElectives = numElectives;
    }

    public Integer getSemNo() {
        return semNo;
    }

    public void setSemNo(Integer semNo) {
        this.semNo = semNo;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sno != null ? sno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Electives)) {
            return false;
        }
        Electives other = (Electives) object;
        if ((this.sno == null && other.sno != null) || (this.sno != null && !this.sno.equals(other.sno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "erp.Electives[ sno=" + sno + " ]";
    }
    
}
