
import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {

    Connection con = null;
    PreparedStatement pst;

    void Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String mysqlURL = "jdbc:mysql://localhost:3306/oop";
            con = DriverManager.getConnection(mysqlURL, "root", "");
        } catch (Exception ex) {

        }
    }

    public int Insert(Employee e) {
        int res = 0;
        try {
            Connection();
            String ins = "insert into employee values (?,?,?,?,?,?)";

            pst = con.prepareStatement(ins);

            pst.setInt(1, e.id);
            pst.setString(2, e.name);
            pst.setInt(3, e.cnic);
            pst.setString(4, e.username);
            pst.setString(5, e.password);
            pst.setString(6, e.email);

            res = pst.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return res;
    }

    public int Update(Employee e) {
        int res = 0;
        try {
            Connection();
            String upd = "update employee set name=?, cnic=?, username = ?, password=?, email=? where id = ?";
            pst = con.prepareStatement(upd);

            pst.setString(1, e.name);
            pst.setInt(2, e.cnic);
            pst.setString(3, e.username);
            pst.setString(4, e.password);
            pst.setString(5, e.email);
            pst.setInt(6, e.id);

            res = pst.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return res;
    }

    public ResultSet Login(Employee e) {
        ResultSet rs = null;
        try {
            Connection();
            String log = "select * from employee where username='" + e.username + "' and password='" + e.password + "' ";

            Statement st = con.createStatement();

            rs = st.executeQuery(log);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return rs;
    }

    ArrayList<Employee> SelectAll() {
        ArrayList<Employee> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection();
            String qry = "select * from employee";
            Statement st = con.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                Employee e = new Employee();
                e.id = rs.getInt("id");
                e.name = rs.getString("name");
                e.cnic = rs.getInt("cnic");
                e.username = rs.getString("username");
                e.password = rs.getString("password");
                e.email = rs.getString("email");
                list.add(e);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    ArrayList<Employee> Select(Employee e) {
        ArrayList<Employee> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection();
            String log = "select * from employee where username='" + e.username + "' and password='" + e.password + "' ";

            Statement st = con.createStatement();
            rs = st.executeQuery(log);
            while (rs.next()) {
                e.id = rs.getInt("id");
                e.name = rs.getString("name");
                e.cnic = rs.getInt("cnic");
                e.username = rs.getString("username");
                e.password = rs.getString("password");
                e.email = rs.getString("email");
                list.add(e);
            }
        } catch (Exception ex) {

        }
        return list;
    }
}
