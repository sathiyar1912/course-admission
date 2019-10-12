package mecse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.annotation.ManagedBean;
//import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.faces.context.ExternalContext;
import javax.faces.bean.*;
import javax.faces.event.ValueChangeEvent;
/**
 *
 * @author Sathya praba
 */
@ViewScoped 
@javax.faces.bean.ManagedBean
@javax.faces.bean.RequestScoped
@SessionScoped
public class loginbean implements Serializable{
 @ManagedProperty(value="#{param.pageid}")

    /**
     * Creates a new instance of loginbean
     */
    private String roll_number="";
    public  static String  name="";
    private String password="";
    private String type="";
    private String dept="";
    private String day="";
    private String mail="";
    private float gre_score=0;
    private float toefl_score=0;
    private float university_rating=0;
    private float sop=0;
    private float lop=0;
    private float cgpa=0;
    private float research=0;
    
    static String name_temp="";
    

    /**
    * Constructor for loginbean.
    */

    public String getName_temp() {
        return reg_department;
    }

    public void setName_temp(String name_temp) {
        this.name_temp = name_temp;
    }
    
    static String rollnumber_temp="";
    

    /**
    * Constructor for loginbean.
    */

    public String getRollnumber_temp() {
        return rollnumber_temp;
    }

    public void setRollnumber_temp(String rollnumber_temp) {
        this.rollnumber_temp = rollnumber_temp;
    }
    
    static String mail_temp="";


    public String getMail_temp() {
        return mail_temp;
    }

    public void setMail_temp(String mail_temp) {
        this.mail_temp = mail_temp;
    }
    
    private String reg_department = "";
    
    
    public String getReg_department() {
        return reg_department;
    }

    public void setReg_department(String reg_department) {
        this.reg_department = reg_department;
    }
    
    
    
    private List admin_display = new ArrayList();
    private int str_length = 0;
    
    
    public int getStr_length() {
        return str_length;
    }

    public void setStr_length(int str_length) {
        this.str_length = str_length;
    }
    

    public List getAdmin_display() {
        int i = 0;
        try{
            str_length=0;
            Class.forName("oracle.jdbc.driver.OracleDriver");
               
                String dbURL="jdbc:oracle:thin:@//localhost:1521/orc";
                String dbUser_name="system";
                String dbPassword="sathiya";                
            Connection con=DriverManager.getConnection(dbURL,dbUser_name,dbPassword);
            Statement stat=con.createStatement();
            String query="select count(*) as count from student_score";
            ResultSet rs=stat.executeQuery(query);
            
            while(rs.next()){
                str_length=Integer.parseInt(rs.getString(1));
            }
            
            query="select ROLL_NUMBER, NAME,MAIL, DEPARTMENT  from student_score";
            rs=stat.executeQuery(query);

            while(rs.next()){
                admin_display.add(i,new setAdmin_display(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                i++;
            }
            
        }
        catch (Exception e)
        {
            System.out.println("Error Data : " + e.getMessage());
        }
        return admin_display;
    }

    

    public class setAdmin_display {

        String rollnum;
        String studentName;
        String email;
        String department;


        public setAdmin_display(String rollnum,String studentName,String email,String department) {
            this.rollnum = rollnum;
            this.studentName = studentName;
            this.email = email;
            this.department=department;
        }

        public String getRollnum() {
            return rollnum;
        }

        public String getStudentName() {
            return studentName;
        }

        public String getEmail() {
            return email;
        }

        public String getDepartment() {
            return department;
        }

    }

    
/*----------------------------------------  */ 
    
    private List faculty_display = new ArrayList();

    
    private String current_faculty_department = "";
    
    
    public String getCurrent_faculty_department() {
        return current_faculty_department;
    }

    public void setCurrent_faculty_department(String current_faculty_department) {
        this.current_faculty_department = current_faculty_department;
    }
    
    
    private String admin_name = "";
    
    
    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }
    
    
    private String admin_password = "";
    
    
    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }
    
    

    public List getFaculty_display() {
        int i = 0;
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
               
                String dbURL="jdbc:oracle:thin:@//localhost:1521/orc";
                String dbUser_name="system";
                String dbPassword="sathiya";                
            Connection con=DriverManager.getConnection(dbURL,dbUser_name,dbPassword);
            Statement stat=con.createStatement();
            
            String query="select count(*) as count from student_score  where department="+"'"+faculty_department_temp+"'";
            ResultSet rs=stat.executeQuery(query);
            
            while(rs.next()){
                str_length=Integer.parseInt(rs.getString(1));
            }
            
            query="select ROLL_NUMBER, NAME,MAIL, DEPARTMENT from student_score where department="+"'"+faculty_department_temp+"'";
            rs=stat.executeQuery(query);
            
            current_faculty_department=faculty_department_temp;

            while(rs.next()){
                System.out.println(rs.getString(1));
                faculty_display.add(i,new setFaculty_display(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                i++;
            }
        }
        catch (Exception e)
        {
            System.out.println("Error Data : " + e.getMessage());
        }
        return faculty_display;
    }


    public class setFaculty_display {

        String rollnum;
        String studentName;
        String email;
        String department;


        public setFaculty_display(String rollnum,String studentName,String email,String department) {
            this.rollnum = rollnum;
            this.studentName = studentName;
            this.email = email;
            this.department=department;
        }

        public String getRollnum() {
            return rollnum;
        }

        public String getStudentName() {
            return studentName;
        }

        public String getEmail() {
            return email;
        }

        public String getDepartment() {
            return department;
        }

    }

    
    
/*----------------------------------------  */ 
    
    


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public String getFive() {
        return five;
    }

    public void setFive(String five) {
        this.five = five;
    }

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }

    public String getSeven() {
        return seven;
    }

    public void setSeven(String seven) {
        this.seven = seven;
    }
    private String one;
    private String two;
    private String three;
    private String four;
    private String five;
    private String six;
    private String seven;
    private String hour;
    private String class1;
    private String seat;
    private String c1;
    private String hr;

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    private String course;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSyear() {
        return syear;
    }

    public void setSyear(String syear) {
        this.syear = syear;
    }
    private String syear;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRoll_number() {
        return password;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    				 		
    public float getGre_score() {
        return gre_score;
    }

    public void setGre_score(float gre_score) {
        this.gre_score = gre_score;
    }
    
    public float getToefl_score() {
        return toefl_score;
    }

    public void setToefl_score(float toefl_score) {
        this.toefl_score = toefl_score;
    }
    
    public float getUniversity_rating() {
        return university_rating;
    }

    public void setUniversity_rating(float university_rating) {
        this.university_rating = university_rating;
    }
    
    public float getSop() {
        return sop;
    }

    public void setSop(float sop) {
        this.sop = sop;
    }
    
    public float getLop() {
        return lop;
    }

    public void setLop(float lop) {
        this.lop = lop;
    }
    
    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }
    
    public float getResearch() {
        return research;
    }

    public void setResearch(float research) {
        this.research = research;
    }
    
    

    private String[] str_department = new String[] {"M.E (Computer Science and Engineering)","M.Tech (Information Technology)","M.E (Software Engineering)","M.E (Communication Systems)","M.E (Wireless Communication)","M.E (Biometrics and Cyber Security)","M.E (Computer Integrated Manufacturing)","M.E (Automotive Engineering)","M.E (Applied Electronics)","M.Tech (Bio Technology)","M.E (Industrial Engineering)","M.E (Industrial Metallurgy)","M.E (Energy Engineering)","M.E (Engineering Design)","M.E (Infrastructure Engineering)","M.E (Control Systems)","M.E (Embedded & Real Time Systems)","M.E (Lean Manufacturing)","M.E (Power Electronics and Drives)","M.E (Product Design and Commerce)","M.E (Manufacturing Engineering)","M.E (Structural Engineering)","M.E (Virtual Prototyping and Digital Manufacturing)","M.E (VLSI Design)","M.Tech (Nano Technology)","M.Tech (Textile Technology)"};

    public String[] getStr_department() {
        return str_department;
    }

    public void setStr_department(String[] str_department) {
        this.str_department = str_department;
    }
    
    
    private String[] str_department_list=new String[] {"M.E (Computer Science and Engineering)","M.Tech (Information Technology)","M.E (Software Engineering)","M.E (Communication Systems)","M.E (Wireless Communication)","M.E (Biometrics and Cyber Security)","M.E (Computer Integrated Manufacturing)","M.E (Automotive Engineering)","M.E (Applied Electronics)","M.Tech (Bio Technology)","M.E (Industrial Engineering)","M.E (Industrial Metallurgy)","M.E (Energy Engineering)","M.E (Engineering Design)","M.E (Infrastructure Engineering)","M.E (Control Systems)","M.E (Embedded & Real Time Systems)","M.E (Lean Manufacturing)","M.E (Power Electronics and Drives)","M.E (Product Design and Commerce)","M.E (Manufacturing Engineering)","M.E (Structural Engineering)","M.E (Virtual Prototyping and Digital Manufacturing)","M.E (VLSI Design)","M.Tech (Nano Technology)","M.Tech (Textile Technology)"};
    
    public String[] getStr_department_list() {
        return str_department_list;
    }

    public void setStr_department_list(String[] str_department_list) {
        this.str_department_list = str_department_list;
    }
  
    

    
    private String select_dept="";
    
    public String getSelect_dept() {
        return select_dept;
    }

    public void setSelect_dept(String select_dept) {
        this.select_dept = select_dept;
    }
    
    private String faculty_dept="";
    
    public String getFaculty_dept() {
        return faculty_dept;
    }

    public void setFaculty_dept(String faculty_dept) {
        this.faculty_dept = faculty_dept;
    }
    

    
    public void valueChanged(ValueChangeEvent e) {
        String t = (String) e.getNewValue();
        System.out.println(t);
        setSelect_dept(t);
    }
    
    

    
    private String faculty_name = "";
    private String faculty_password = "";
    private String faculty_mail = "";
    private String faculty_department = "";
    private String faculty_department_temp = "";
    
    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }
    
    
    public String getFaculty_password() {
        return faculty_password;
    }

    public void setFaculty_password(String faculty_password) {
        this.faculty_password = faculty_password;
    }
    
    
    public String getFaculty_mail() {
        return faculty_mail;
    }

    public void setFaculty_mail(String faculty_mail) {
        this.faculty_mail = faculty_mail;
    }
    
    
    public String getFaculty_department() {
        return faculty_department;
    }

    public void setFaculty_department(String faculty_department) {
        this.faculty_department = faculty_department;
    }
    
    public String getFaculty_department_temp() {
        return faculty_department_temp;
    }

    public void setFaculty_department_temp(String faculty_department_temp) {
        this.faculty_department_temp = faculty_department_temp;
    }
    
    public loginbean() {
    }
    
    
public String callServlet_temp(String test_name,String test_password)
{
name=test_name;
password=test_password;
return callServlet();
}
    
    
public String callServlet()
    {
        int check=0;
            String input="";
            String table_userName="";
            String table_password="";
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
               
                String dbURL="jdbc:oracle:thin:@//localhost:1521/orc";
                String dbUser_name="system";
                String dbPassword="sathiya";                
                Connection con=DriverManager.getConnection(dbURL,dbUser_name,dbPassword);
                Statement stat=con.createStatement();
                String query="select * from student_credentials where name="+"'"+name+"'";
                ResultSet rs=stat.executeQuery(query);
                while(rs.next())
                {
                    table_password=rs.getString("password");
                    //loginbean.name=rs.getString("name");
                    roll_number=rs.getString("roll_number");
                    mail=rs.getString("mail");
                }

                
                if(table_password.equals(password) && table_password!="")
                        {
                            check=1;
                       FacesContext context = FacesContext.getCurrentInstance();
                            try {
                                    HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
                                    session.setAttribute("userName", name);
                                    setName(name);
                                    setRoll_number(roll_number);
                                    loginbean.name_temp=name;
                                    loginbean.rollnumber_temp=roll_number;
                                    loginbean.mail_temp=mail;
                                    context.getExternalContext().dispatch("student_score.xhtml");
                                    //System.out.println(table_userName);
                                    

                                }catch (Exception e) {
                                        //e.printStackTrace();
                                }                
                        }
                else 
                {
                    check=0;
                    System.out.println("Name = "+name);
                    System.out.println("roll_number = NULL");
                    System.out.println("Mail Id = NULL");
                  FacesContext context = FacesContext.getCurrentInstance();
                            try {
                                HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
                                name=null;
                                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Incorrect Username and Passowrd","Please enter correct username and Password"));
                                    context.getExternalContext().dispatch("invalid_credential.xhtml");
                                    //System.out.println(table_userName);

                                }catch (Exception e) {
                                        //e.printStackTrace();
                                }                               
                }
                FacesContext context = FacesContext.getCurrentInstance();
            try {
                HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            session.setAttribute("userName", name);
            context.getExternalContext().dispatch("department_list.xhtml");

            }catch (Exception e) {
                //e.printStackTrace();
            }
            
            }

            catch(Exception sqle)
            {
                System.out.println("check2");
                System.out.println(sqle);
                System.out.println(sqle.getMessage());
            }

        if(check==1)
        {
            System.out.println("Name = "+name);
            System.out.println("roll_number = "+roll_number);
            System.out.println("Mail Id = "+mail);
            return "Success";
        }
        return "Failure";
    }



public String callServlet0_temp(String test_gre_score,String test_toefl_score,String test_university_rating,String test_sop,String test_lop,String test_cgpa,String test_research)
{
    int check=0;
    try{
        check=1;
        System.out.println(test_gre_score);
        System.out.println(test_toefl_score);
        System.out.println(test_university_rating);
        System.out.println(test_sop);
        System.out.println(test_lop);
        System.out.println(test_cgpa);
        System.out.println(test_research);
        gre_score=Float.parseFloat(test_gre_score);
        toefl_score=Float.parseFloat(test_toefl_score);
        university_rating=Float.parseFloat(test_university_rating);
        sop=Float.parseFloat(test_sop);
        lop=Float.parseFloat(test_lop);
        cgpa=Float.parseFloat(test_cgpa);
        research=Float.parseFloat(test_research);
    }
    catch(Exception sqle)
    {
        check=0;
    }
    if(check==1)
        {
            return "Success";
        }
    return "Failure";
}




public void callServlet0()
    {
            String input="";
            String table_userName="";
            try{
            if((gre_score>340.0) || (toefl_score>120.0) || (university_rating>10.0) || (sop>10.0) || (lop>10.0) || (cgpa>10.0) || (research>10.0))
            {
                FacesContext context = FacesContext.getCurrentInstance();
               HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            session.setAttribute("userName", name);
            context.getExternalContext().dispatch("invalid_credential.xhtml");
            }
             Class.forName("oracle.jdbc.driver.OracleDriver");
               
                String dbURL="jdbc:oracle:thin:@//localhost:1521/orc";
                String dbUser_name="system";
                String dbPassword="sathiya";                
                Connection con=DriverManager.getConnection(dbURL,dbUser_name,dbPassword);
                Statement stat=con.createStatement();
                String query="delete from student_score where name="+"'"+name+"'";
                ResultSet rs=stat.executeQuery(query);
                
               PreparedStatement ps = null;
               stat=null;
                 String sql = "INSERT INTO student_score(roll_number,name,GRE_SCORE,TOEFL_SCORE,UNIVERSITY_RATING,SOP,LOP,CGPA,RESEARCH,MAIL) VALUES(?,?,?,?,?,?,?,?,?,?)";
                        ps = con.prepareStatement(sql);
                        System.out.println("Name = "+name);
                        System.out.println("Roll Number = "+rollnumber_temp);
                        ps.setString(1, rollnumber_temp);
                        ps.setString(2, name);
                        ps.setFloat(3, gre_score);
                        ps.setFloat(4, toefl_score);
                        ps.setFloat(5, university_rating);
                        ps.setFloat(6, sop);
                        ps.setFloat(7, lop);
                        ps.setFloat(8, cgpa);
                        ps.setFloat(9, research);
                        ps.setString(10, mail_temp);
                        int i = ps.executeUpdate();
                        System.out.println("Data Added Successfully");
                        
                        
                        ProcessBuilder   pb;
                pb = new ProcessBuilder("C:\\Users\\Home\\AppData\\Local\\Programs\\Python\\Python37\\python","C:\\Users\\Home\\Documents\\NetBeansProjects\\Logistic_regression_code\\src\\logistic_regression_code.py",Float.toString(gre_score),Float.toString(toefl_score),Float.toString(university_rating),Float.toString(sop),Float.toString(lop),Float.toString(cgpa),Float.toString(research));

                        pb.redirectErrorStream(true);

                        Process pr = pb.start();  

                        BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                        String line;
                        String line_temp="";
                        while ((line = in.readLine()) != null) {
                            System.out.println(line);
                            line_temp=line;
                        }
                        
                        
                        try {
                            pr.waitFor();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(loginbean.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        
                        int a;
                        int b;
                        int c;
                        
                        int length = line_temp.length();
                        int array_size=0;
                        
                        for(a=1; a < length; a=a+2){
                            if((line_temp.charAt(a))=='1'){
                                array_size++;
                            }
                        }
                        //str_department_list=new String[array_size];
                        System.out.println("String array length is: " + length);
		
                        
                        for(a=1,b=0,c=0; a < length; a=a+2,b=b+1){
                            System.out.println("a = "+a+" "+line_temp.charAt(a)+" "+str_department[b]);
                            if((line_temp.charAt(a))=='0'){
                                System.out.println("b = "+b);
                                str_department_list=ArrayUtils.remove(str_department_list, c); 
                                System.out.println("str_department["+b+"] = "+str_department[b]);
                                //System.out.println("str_department_list["+c+"] = "+str_department_list[c]);
                                
                            }
                            else
                            {
                                c++;
                            }
                        }
                        System.out.println("Name = "+name);
                        loginbean.name=name;
                        

                        System.out.println("check5");
                        in.close();
                       FacesContext context = FacesContext.getCurrentInstance();
                       System.out.println("check6");
            try {
                HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            session.setAttribute("userName", name);
            context.getExternalContext().dispatch("department_list.xhtml");

            }catch (Exception e) {
                e.printStackTrace();
            }         
            }
            catch(SQLException |ClassNotFoundException sqle)
            {
                System.out.println("check66");
                System.out.println(sqle.getMessage());
            } 
            catch(Exception sqle)
            {
                System.out.println("check7");
                System.out.println(sqle.getMessage());
                System.out.println("check8");
            }
            
    }

public String callServlet1_temp(String test_name,String test_password)
{
    admin_name=test_name;
    admin_password=test_password;
    return callServlet1();
}

public String callServlet1()
    {
            int check=0;
            String input="";
            String table_userName="";
            String table_password="";
            try{

                table_password="admin";
                if(admin_password.equals("admin") && admin_password!="" && admin_name.equals("admin"))
                        {
                            check=1;
                       FacesContext context = FacesContext.getCurrentInstance();
                            try {
                                HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
                                    session.setAttribute("name",admin_name);
                                        context.getExternalContext().dispatch("admin_table.xhtml");
                                        System.out.println(table_userName);
                                }catch (Exception e) {
                                        //e.printStackTrace();
                                }                
                        }
                else
                {
                    check=0;
                  FacesContext context = FacesContext.getCurrentInstance();
                            try {
                                    context.getExternalContext().dispatch("invalid_credential.xhtml");
                                    System.out.println(table_userName);

                                }catch (Exception e) {
                                        //e.printStackTrace();
                                }                          
                }
            }
            catch(Exception sqle)
            {
                System.out.println("Data2");
                System.out.println(sqle.getMessage());
            }
        if(check==1)
        {
            return "Success";
        }
        return "Failure";     
    }


public String callServlet2_temp(String test_name,String test_password)
{
    faculty_name=test_name;
    faculty_password=test_password;
    return callServlet2();
}


public String callServlet2()
    {
        int check=0;
            String input="";
            String table_userName="";
            String table_password="";
            try{
             Class.forName("oracle.jdbc.driver.OracleDriver");
               
                String dbURL="jdbc:oracle:thin:@//localhost:1521/orc";
                String dbUser_name="system";
                String dbPassword="sathiya";                
                Connection con=DriverManager.getConnection(dbURL,dbUser_name,dbPassword);
                Statement stat=con.createStatement();
                String query="select * from FACULTY_CREDENTIALS where name="+"'"+faculty_name+"'";
                ResultSet rs=stat.executeQuery(query);
                
                while(rs.next())
                {
                    table_password=rs.getString("password");
                    faculty_dept=rs.getString("department");
                    faculty_department_temp=rs.getString("department");
                }
                
                if(table_password.equals(faculty_password) && table_password!="")
                        {
                            check=1;
                       FacesContext context = FacesContext.getCurrentInstance();
                            try {
                                HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
                                    session.setAttribute("name",faculty_name);
                                        context.getExternalContext().dispatch("faculty_table.xhtml");
                                        System.out.println(table_userName);
                                }catch (Exception e) {
                                        //e.printStackTrace();
                                }                
                        }
                else
                {
                    check=0;
                  FacesContext context = FacesContext.getCurrentInstance();
                            try {
                                    context.getExternalContext().dispatch("invalid_credential.xhtml");
                                    System.out.println(table_userName);

                                }catch (Exception e) {
                                        //e.printStackTrace();
                                }                          
                }
            }

            catch(Exception sqle)
            {
                System.out.println(sqle.getMessage());
            }
            
        if(check==1)
        {
            System.out.println("Name = "+faculty_name);
            System.out.println("Faculty Deparment = "+faculty_dept);
            return "Success";
        }
        System.out.println("Name = "+faculty_name);
        System.out.println("Faculty Deparment = NULL");
        return "Failure";
    }



public void callServletStureg()
    {
            String input="";
            String table_userName="";
            try{
             System.out.println("Data Added Successfully");
             Class.forName("oracle.jdbc.driver.OracleDriver");
               System.out.println("Data Added Successfully");
                String dbURL="jdbc:oracle:thin:@//localhost:1521/orc";
                String dbUser_name="system";
                String dbPassword="sathiya";                
                Connection con=DriverManager.getConnection(dbURL,dbUser_name,dbPassword);
                PreparedStatement ps = null;
                Statement stat=con.createStatement();
                String sql = "INSERT INTO student_credentials(roll_number,name,password,mail) VALUES(?,?,?,?)";
                        ps = con.prepareStatement(sql);
                        ps.setString(1, roll_number);
                        ps.setString(2, name);
                        ps.setString(3, password);
                        ps.setString(4, mail);
                        int i = ps.executeUpdate();
                        System.out.println("Data Added Successfully");
               
                       FacesContext context = FacesContext.getCurrentInstance();
            try {
                HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            session.setAttribute("userName", name);
            context.getExternalContext().dispatch("regsucc.xhtml");

            }catch (Exception e) {
            e.printStackTrace();
            }         
            }
            catch(SQLException |ClassNotFoundException sqle)
            {
                System.out.println(sqle);
            } 
            catch(Exception sqle)
            {
                System.out.println(sqle);
            }
    }









    public String submitCourse(){
        
        System.out.println("select_dept = "+select_dept);
        System.out.println("Name = "+loginbean.name_temp);
        try{
             Class.forName("oracle.jdbc.driver.OracleDriver");
               
                String dbURL="jdbc:oracle:thin:@//localhost:1521/orc";
                String dbUser_name="system";
                String dbPassword="sathiya";                 
                Connection con=DriverManager.getConnection(dbURL,dbUser_name,dbPassword);
                Statement stat=con.createStatement();
                //String query="update student_score set department = "+select_dept+" where name='"+loginbean.name_temp+"'";
                //ResultSet rs=stat.executeQuery(query);
                
                PreparedStatement ps = null;
                String sql = "update student_score set department = ? where name=?";
                ps = con.prepareStatement(sql);
                System.out.println("Name = "+loginbean.name_temp);
                ps.setString(1, select_dept);
                ps.setString(2, loginbean.name_temp);
                int i = ps.executeUpdate();
        }
        catch(Exception e)
            {
                e.printStackTrace();
            }
        
        System.out.println("select_dept = "+select_dept);
        System.out.println("Name = "+loginbean.name_temp);
	return "regsucc";
    }
    
    
        public String faculty_registeration(){
        
        System.out.println("name = "+faculty_name);
        System.out.println("password = "+faculty_password);
        System.out.println("mail = "+faculty_mail);
        System.out.println("dept = "+faculty_department);
        try{
             Class.forName("oracle.jdbc.driver.OracleDriver");
               
                String dbURL="jdbc:oracle:thin:@//localhost:1521/orc";
                String dbUser_name="system";
                String dbPassword="sathiya";                
                Connection con=DriverManager.getConnection(dbURL,dbUser_name,dbPassword);
                Statement stat=con.createStatement();
                String query="delete from faculty_credentials where name='"+faculty_name+"'";
                ResultSet rs=stat.executeQuery(query);
                
                PreparedStatement ps = null;
                String sql = "insert into faculty_credentials(NAME,PASSWORD,MAIL,DEPARTMENT) values(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, faculty_name);
                ps.setString(2, faculty_password);
                ps.setString(3, faculty_mail);
                ps.setString(4, faculty_department);
                faculty_department_temp=faculty_department;
                int i = ps.executeUpdate();
        }
        catch(Exception e)
            {
                e.printStackTrace();
            }
        
	return "regsucc";
        
    }
}