package erp;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.persistence.*;


public class s extends javax.swing.JFrame {

    public static String REGISTER_PANEL="REGISTERPANEL",DEAN_PANEL="DEANPANEL",DEPARTMENT_PANEL="DEPPANEL",
            TEACHER_REGPANEL="TEACHPANEL",ADD_COURSEPANEL="COURSEPANEL",SEMREGPANEL="SEMREG",
            STUDENT_REGPANEL="STUDENREG",TEACHER_LOGGEDINPANEL="TLOGGEDIN",STUDENT_LOGGEDINPANEL="SLOGGEDIN",TEACHER_GRADEPANEL="TEACHGRADE",
            STUDENT_GRADESHOWPANEL="STUDEGRADSHOW";
    public static EntityManagerFactory emf;
    public static EntityManager em;
    public static int graderecords;
    public s() {
        initComponents();
        emf=Persistence.createEntityManagerFactory("ErpPU");
        em=emf.createEntityManager();
        graderecords=s.em.createNamedQuery("Gradesheet.findAll").getResultList().size();
        graderecords++;
        this.setLocationByPlatform(true);
        MainPanel.setLayout(new CardLayout() );
        
        
        MainPanel.add(new RegisterPanel(),REGISTER_PANEL);
        MainPanel.add(new DeanPanelUI(),DEAN_PANEL);
        MainPanel.add(new AddDepartmentPanel(),DEPARTMENT_PANEL);
        MainPanel.add(new TeacherRegistrationPanel(),TEACHER_REGPANEL);
        MainPanel.add(new AddCoursePanel(),ADD_COURSEPANEL);
        MainPanel.add(new SemRegisPanel(),SEMREGPANEL);
        MainPanel.add(new StudentRegisterPanel(),STUDENT_REGPANEL);
        MainPanel.setOpaque(rootPaneCheckingEnabled);
        MainPanel.add(new TeacherLoggedinPanel(),TEACHER_LOGGEDINPANEL);
        MainPanel.add(new StudentLoggedPanel(),STUDENT_LOGGEDINPANEL);
        MainPanel.add(new GiveGradePanel(),TEACHER_GRADEPANEL);
        MainPanel.add(new StudentGradeShowPanel(),STUDENT_GRADESHOWPANEL);
        show();
        
        
        this.setDefaultCloseOperation(s.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
                {
                    
                    
                    em.close();
                    emf.close();
                    exit();
                }
        });
    }
    private void exit()
    {
        this.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        MainPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                MainPanelComponentShown(evt);
            }
        });
        MainPanel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                MainPanelAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MainPanelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_MainPanelAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_MainPanelAncestorAdded

    private void MainPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_MainPanelComponentShown
        
        this.pack();
        
    }//GEN-LAST:event_MainPanelComponentShown

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(s.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(s.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(s.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(s.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new s().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel MainPanel;
    // End of variables declaration//GEN-END:variables
}
