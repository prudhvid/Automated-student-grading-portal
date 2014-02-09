/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erp;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.swing.JOptionPane;
import org.eclipse.persistence.exceptions.DatabaseException;
/**
 *
 * @author Prudhvi
 */
public class DepExt extends Department{
     
    public static boolean adddep(Department x)
    {
        s.em.getTransaction().begin();
        //<editor-fold defaultstate="collapsed" desc="comment">
        /*Department x = new Department();
        x.setCode("CS");
        x.setName("Computer Science");
        x.setRollgen("12345");
        x.setTotalcourses(5);
        
        List<Department> xList=s.em.createNamedQuery("Department.findAll").getResultList();
        for(Department d:xList)
        {
        System.out.println(d.getCode());
        }*/
//</editor-fold>
        x.setCode(x.getCode().toUpperCase());
        x.setName(x.getName().toUpperCase());
        s.em.persist(x);
        x.setTotalcourses(0);
        x.setPresYear((new Date()).getYear()+1900);
        x.setStudNo(0);
        
        try {
            s.em.getTransaction().commit();
        } catch (RollbackException e) {
            JOptionPane.showMessageDialog(null, "Adding failed\nEither the department name or code is already given");
            return false;
        }
        JOptionPane.showMessageDialog(null, "Added Successfully"+x.getName());
        return true;
        
    }
    
    
    public static void changeyear(Department x)
    {
        s.em.getTransaction().begin();
        Department y=(Department) s.em.createNamedQuery("Department.findByCode").setParameter("code",x.getCode() ).getSingleResult();
        y.setPresYear((new Date()).getYear()+1900);
        y.setStudNo(0);
        s.em.persist(y);
        s.em.getTransaction().commit();
    }
    
    public static List<Department> getDepList()
    {
        
        List<Department> list=s.em.createNamedQuery("Department.findAll").getResultList();
        
        
        
        return list;
    }
}
