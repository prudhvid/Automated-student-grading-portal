/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erp;

import javax.swing.JOptionPane;

/**
 *
 * @author Prudhvi
 */
public class CourseExt extends Course {
    public static String getCode(Course x,int sem)
    {
        String codeString="";
        
        codeString+=x.getDep().getCode();
        codeString+=sem;
        
        Department d = null;
        try {
            d = (Department) s.em.createNamedQuery("Department.findByCode").setParameter("code", x.getDep().getCode()).getSingleResult();
            codeString+=String.format("%02d", d.getTotalcourses()+1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        
        
        
        return  codeString;
    }
    public  static String addCourse(Course x)
    {
        String msg="";
        
        
        
        x.setCode(getCode(x, x.getInsem()));
        
        s.em.getTransaction().begin();
        s.em.persist(x);
        if(changestoDep(x)){
            try {
                s.em.getTransaction().commit();
            } catch (Exception e) {
                
                msg="Sorry Course already added!";
                return msg;
            }

            msg=x.getCode();
            return msg;
        }
        return "Sorry Course already added!";
    }
    public static boolean changestoDep(Course x)
    {
        Department d = null;
        try{
         d=(Department)s.em.createNamedQuery("Department.findByCode").setParameter("code", x.getDep().getCode()).getSingleResult();
         d.setTotalcourses(d.getTotalcourses()+1);
         s.em.persist(d);
        }
        catch(Exception e)
        {
            
            return false;
        }
        return true;
        
        
        
        
        
    }
}
