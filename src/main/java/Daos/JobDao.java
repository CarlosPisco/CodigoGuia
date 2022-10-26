package Daos;

import Beans.JobBean;

import java.sql.*;
import java.util.ArrayList;

public class JobDao {

    public ArrayList<JobBean> obtenerTrabajos(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/hr?serverTimeZone=America/Lima";

        ArrayList<JobBean> listaTrabajos = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM jobs")) {

            while(rs.next()){
                JobBean job = new JobBean();
                String jobId = rs.getString(1);
                String jobTitle = rs.getString("job_title");
                int minSalary = rs.getInt(3);
                int maxSalary = rs.getInt(4);
                job.setJobId(jobId);
                job.setJobTitle(jobTitle);
                job.setMinSalary(minSalary);
                job.setMaxSalary(maxSalary);
                listaTrabajos.add(job);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaTrabajos;
    }

    public void crearTrabajo(String jobId, String jobTitle, int minSalary, int maxSalary){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/hr?serverTimeZone=America/Lima";

        String sql = "INSERT INTO jobs(job_id, job_title, min_salary, max_salary) VALUES (?, ?, ?, ?)";
        try(Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, jobId);
            pstm.setString(2, jobTitle);
            pstm.setInt(3, minSalary);
            pstm.setInt(4, maxSalary);

            pstm.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public JobBean obtenerTrabajo(String id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/hr?serverTimeZone=America/Lima";

        String sql = "SELECT * FROM jobs WHERE job_id = ?";
        JobBean job = null;
        try(Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, id);

            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                job = new JobBean();
                job.setJobId(rs.getString(1));
                job.setJobTitle(rs.getString(2));
                job.setMinSalary(rs.getInt(3));
                job.setMaxSalary(rs.getInt(4));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return job;
    }

    public void editarTrabajo(String jobId, String jobTitle, int minSalary, int maxSalary){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/hr?serverTimeZone=America/Lima";

        String sql = "UPDATE jobs SET job_title = ?, min_salary = ?, max_salary = ? WHERE job_id = ?";
        try(Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, jobTitle);
            pstm.setInt(2, minSalary);
            pstm.setInt(3, maxSalary);
            pstm.setString(4, jobId);

            pstm.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void eliminarTrabajo(String jobId){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/hr?serverTimeZone=America/Lima";

        String sql = "DELETE FROM jobs WHERE job_id = ?";
        try(Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, jobId);

            pstm.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
