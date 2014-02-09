/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erp;

import static erp.DepExt.changeyear;
import java.util.Date;
import java.util.List;
import javax.swing.*;
/**
 *
 * @author Prudhvi
 */
public class StudentExt extends Student{
    
    public static String initregister(Student x)
    {
        //x has name,password,phone,address,Dep;
        s.em.getTransaction().begin();
        x.setRollNo(genRollNo(x));
        x.setInsem(0);        
        s.em.persist(x);
        try {
            s.em.getTransaction().commit();
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
//        addCoreCourses(x);
        return x.getRollNo();
    }
    public static String genRollNo(Student x)
    {
        String sdep=x.getDep().getCode();
        String rollString="";
        
        int y1=(new Date()).getYear()+1900;
        rollString+=y1%100;
        rollString+=sdep;
        
        Department d=((Department)s.em.createNamedQuery("Department.findByCode").setParameter("code", sdep).getSingleResult());
        
        if(d.getPresYear()==y1)
        { rollString+=String.format("%03d", d.getStudNo()+1);d.setStudNo(d.getStudNo()+1);}
        else
            {rollString+="001";DepExt.changeyear(d);}
        
        return rollString;
    }
    
    public static String semreg(Student x,List<Course> eleCourses)
    {
        s.em.getTransaction().begin();
        int nElectives=0;
        x.setInsem(x.getInsem()+1);
        s.em.persist(x);
        s.em.getTransaction().commit();
        
        if(!addCoreCourses(x)||!addElectives(eleCourses, x))
        {
            s.em.getTransaction().begin();
            x.setInsem(x.getInsem()-1);
            s.em.persist(x);
            s.em.getTransaction().commit();
            return  "Sorry,something went wrong!";
        }
        return "Suggesfully registered for this sem";
        
    }
    
    
    
    public static List<Course> getElectives(Student x)
    {        
        return s.em.createQuery("SELECT c FROM Course c WHERE c.dep=:dep AND c.insem=:insem AND c.type=:arg3").setParameter("dep", x.getDep())
                .setParameter("insem", x.getInsem()).setParameter("arg3", 'E').getResultList();        
    }
    
    public static List<Course> getCoreCourses(Student x)
    {
        return s.em.createQuery("SELECT c FROM Course c WHERE c.dep=:dep AND c.insem= :insem AND c.type=:arg3").setParameter("dep", x.getDep())
                .setParameter("insem", x.getInsem()).setParameter("arg3", 'C').getResultList();
    }
    
    public static List<Course> getElectives(Student x,int i)
    {        
        return s.em.createQuery("SELECT c FROM Course c WHERE c.dep=:dep AND c.insem=:insem AND c.type=:arg3").setParameter("dep", x.getDep())
                .setParameter("insem", x.getInsem()+1).setParameter("arg3", 'E').getResultList();        
    }
    public static List<Course> getCoreCourses(Student x,int i)
    {
        return s.em.createQuery("SELECT c FROM Course c WHERE c.dep=:dep AND c.insem= :insem AND c.type=:arg3").setParameter("dep", x.getDep())
                .setParameter("insem", x.getInsem()+1).setParameter("arg3", 'C').getResultList();
    }
    
    public static int getElectivesnumber(Student x,int i)
    {
        return ((Electives)(s.em.createQuery("SELECT e FROM Electives e WHERE e.semNo=:semno AND e.dep=:dep").setParameter("semno", x.getInsem()+1)
                .setParameter("dep", x.getDep()).getSingleResult())).getNumElectives();
                
    }
    public static int getElectivesnumber(Student x)
    {
        return ((Electives)(s.em.createQuery("SELECT e FROM Electives e WHERE e.semNo=:semno AND e.dep=:dep").setParameter("semno", x.getInsem())
                .setParameter("dep", x.getDep()).getSingleResult())).getNumElectives();
                
    }
    
    public static boolean addCoreCourses(Student x)
    {
        s.em.getTransaction().begin();
        List<Course> courseList=s.em.createQuery("SELECT c FROM Course c WHERE c.dep=:dep AND c.insem=:insem and c.type=:arg3").setParameter("dep", x.getDep())
                .setParameter("insem", x.getInsem()).setParameter("arg3", 'C').getResultList();
        
        for(Course c:courseList)
        {
            Gradesheet gs=new Gradesheet();
            gs.setCoursecode(c);
            gs.setRollNo(x);
            gs.setTeacherid(c.getTeacherId());
            gs.setPrim(s.graderecords++);
            s.em.persist(gs);
        }
        
        try {
            s.em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        return true;
    }
    
    public static boolean addElectives(List<Course> list,Student x)
    {
        s.em.getTransaction().begin();
        for(Course c:list)
        {
            Gradesheet gs=new Gradesheet();
            gs.setCoursecode(c);
            gs.setRollNo(x);
            gs.setTeacherid(c.getTeacherId());
            gs.setPrim(null);
            gs.setPrim(s.graderecords++);
            s.em.persist(gs);
        }
        try {
            s.em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        return true;
    }
}
