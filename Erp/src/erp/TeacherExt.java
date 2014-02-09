/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erp;

import java.util.List;

/**
 *
 * @author Prudhvi
 */
public class TeacherExt extends Teacher {
    public static void genRollno(Teacher x)
    {
        s.em.getTransaction().begin();
        String rollString="";
        rollString+=x.getDep().getCode();
        rollString+="T";
        Department d=(Department)s.em.createNamedQuery("Department.findByCode").setParameter("code", x.getDep().getCode()).getSingleResult();
        rollString+=String.format("%03d", d.getTotalteachers()+1);
        d.setTotalteachers(d.getTotalteachers()+1);
        x.setId(rollString);
        
        s.em.persist(d);
        s.em.persist(x);
        s.em.getTransaction().commit();
        
    }
    public static String register(Teacher x)
    {
        String rollString;
        
        genRollno(x);
        rollString=x.getId();
        
        return rollString;
    }
    public void givegrade()
    {
        
    }
    public static List<Teacher> getList()
    {
        return s.em.createNamedQuery("Teacher.findAll").getResultList();
    }
    public static List<Teacher> getList(Department d)
    {
        return s.em.createQuery("SELECT t FROM Teacher t WHERE t.dep=:arg1 ").setParameter("arg1", d).getResultList();
    }
}
