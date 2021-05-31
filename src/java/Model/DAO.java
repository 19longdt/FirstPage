/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Admin;
import Entity.Category;
import Entity.FeedBack;
import Entity.Order;
import Entity.OrderDetail;
import Entity.OrderforAdmin;
import Entity.Product;
import Entity.User;
import Entity.newPro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class DAO {

    DBConnection dbcom;
    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public static void main(String[] args) {
        DBConnection dbconn = new DBConnection();
        DAO dao = new DAO(dbconn);
//        for (int i = 0; i < dao.getTop4(1).size(); i++) {
//            System.out.println(dao.getTop4(1).get(i));
//        }
//        System.out.println(dao.getTop4(1));
//        System.out.println(dao.getAmountByPid(2));

    }

    public DAO(DBConnection dbcom) {
        this.dbcom = dbcom;
        this.conn = dbcom.getConn();
    }

    public int addAdmin(Admin admin) {
        int n = 0;
        String sql = "insert into admin(Username,Password) values(?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, admin.getUsername());
            pre.setString(2, admin.getPassword());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;

    }

    public void addFeedBack(FeedBack f) {
        String sql = "insert into FeedBack(details, status, account, mail) values(?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, f.getDetails());
            pre.setInt(2, 0);
            pre.setString(3, f.getAccount());
            pre.setString(4, f.getMail());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAdmin(Admin admin) {
        String sql = "update admin set password = '" + admin.getPassword()
                + "' where username = '" + admin.getUsername() + "'";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getUser(String user, String pass) {
        String sql = "Select * from tblUser\n"
                + "where account = ? and pass = ?";

        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9), rs.getString(10)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return null;
    }

    public User checkUser(String user) {
        String sql = "Select * from tblUser \n"
                + "where account = ?";

        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9), rs.getString(10)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return null;
    }

    public Admin checkAdmin(String user) {
        String sql = "Select * from Admin \n"
                + "where username = ?";

        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new Admin(rs.getString(1),
                        rs.getString(2)
                ));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return null;
    }

    public Admin getAdmin(String user, String pass, String code) {
        String sql = "Select * from Admin\n"
                + "where username = ? and Password = ? and [Security code] = ? ";

        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, code);
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new Admin(rs.getString(1),
                        rs.getString(2), rs.getString(3)
                ));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return null;
    }

    public int addUser(User u) {
        int n = 0;
        String sql = "insert into tblUser(Account, Pass, Name ,"
                + " DateOfBirth, Gender, Address, "
                + "Question, Answer, Phone, Email) values(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, u.getAccount());
            pre.setString(2, u.getPassword());
            pre.setString(3, u.getName());
            pre.setString(4, u.getDate());
            pre.setInt(5, u.getGender());
            pre.setString(6, u.getAddress());
            pre.setString(7, u.getQuestion());
            pre.setString(8, u.getAnswer());
            pre.setInt(9, u.getPhone());
            pre.setString(10, u.getMail());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return n;

    }

    public void updateUser(User c) {
        String sql = "update tblUser set pass= '" + c.getPassword() + "', Name = '" + c.getName() + "'"
                + ", DateOfBirth = '" + c.getDate() + "', gender = '" + c.getGender() + "'"
                + ", Address = '" + c.getAddress() + "', Question = '" + c.getQuestion() + "'"
                + ", Answer = '" + c.getAnswer() + "', phone = '" + c.getPhone() + "' where Account = '" + c.getAccount() + "'";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int addCategory(Category cate) {
        int n = 0;
        String sql = "insert into Category(cid,cname) values(?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cate.getCid());
            pre.setString(2, cate.getCname());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;

    }

    public int countByCid(int cid) {
        int n = 0;
        String sql = "select count(*) from tblProduct\n"
                + "where cid = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public void updateCategory(Category cate) {
        String sql = "update Category set cname = '" + cate.getCname() + "' where cid = '" + cate.getCid() + "'";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean addProduct(Product product) {
        String sql = "insert into tblProduct(ProductId,ProductName,Price,Amount,ImgUrl,cid,Description) "
                + "values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, product.getPid());
            pre.setString(2, product.getPname());
            pre.setDouble(3, product.getPrice());
            pre.setInt(4, product.getAmount());
            pre.setString(5, product.getImg());
            pre.setInt(6, product.getCid());
            pre.setString(7, product.getDescription());
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Product getLast() {
        String sql = "select top 1 * from tblProduct \n"
                + "order by ProductId desc";

        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return null;
    }

    public void updateStatusOrderDetailByID(int status, int id) {
        String sql = "update tblOrderDetail set status = ? \n"
                + "where orderid = ? ";

        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, id);
            rs = ps.executeQuery();

        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
    }

    public List<OrderDetail> getAllOrderDetail() {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "select * from tblOrderDetail \n"
                + "order by OrderID desc ";

        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public List<OrderDetail> getOrderDetailDescStaus() {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "select * from tblOrderDetail \n"
                + "where status = 0 or status = 2 \n"
                + "order by OrderID desc ";

        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public List<User> getUser() {
        List<User> list = new ArrayList<>();

        String select = "select * from tblUser";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(select);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9), rs.getString(10)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public List<Product> getProduct() {
        List<Product> list = new ArrayList<>();

        String select = "select * from tblProduct";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(select);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public List<Product> getProductByCid(String id) {
        List<Product> list = new ArrayList<>();

        String select = "select * from tblProduct where cid = ?";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(select);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public int countProductByCid(int cid) {
        String select = "select count(*) from tblProduct where cid =?";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(select);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return 0;
    }

    public int countProductBySearch(String search) {
        String select = "select COUNT(*) from tblProduct \n"
                + " where ProductName like ?";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(select);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return 0;
    }

    public int countProduct() {
        String select = "select COUNT(*) from tblProduct";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(select);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return 0;
    }

    public List<Product> pageProductByCid(int index, int cid) {
        List<Product> list = new ArrayList<>();

        String select = "select * from tblProduct\n"
                + "where cid = ? \n"
                + "order by ProductId\n"
                + "offset ? row fetch next 6 rows only; ";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(select);
            ps.setInt(2, (index - 1) * 6);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public List<Product> pageProductBysearch(int index, String search) {
        List<Product> list = new ArrayList<>();

        String select = " select * from tblProduct\n"
                + " where ProductName like ? \n"
                + " order by ProductId \n"
                + " offset ? row fetch next 6 rows only";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(select);
            ps.setString(1, "%" + search + "%");
            ps.setInt(2, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public List<Product> pageProduct(int index) {
        List<Product> list = new ArrayList<>();

        String select = "select * from tblProduct\n"
                + "order by ProductId\n"
                + "offset "
                + "? row fetch next 6 rows only";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(select);
            ps.setInt(1, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public Product getProductByPName(String pame) {

        String select = "select * from tblProduct\n"
                + "where ProductName =  ?";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(select);
            ps.setString(1, pame);
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return null;
    }

    public List<Product> getProductByName(String search) {
        List<Product> list = new ArrayList<>();

        String select = "select * from tblProduct\n"
                + "where ProductName like ?";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(select);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public Product getProductById(String id) {

        String select = "select * from tblProduct where productid = ?";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(select);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return null;
    }

    public List<Category> getCategory() {
        List<Category> list = new ArrayList<>();

        String select = "select * from Category";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(select);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public List<FeedBack> getFeedBackByStatus() {
        List<FeedBack> list = new ArrayList<>();

        String select = "select * from Feedback\n"
                + "where status = '0' ";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(select);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FeedBack(rs.getInt(1), rs.getString(2),
                        rs.getString(5), rs.getInt(3), rs.getString(4)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public int updateProduct(Product p) {
//        Double price = Double.parseDouble(p.getPrice().trim());
        String sql = "update tblProduct set ProductName = '" + p.getPname() + "', price = ?, "
                + "amount = '" + p.getAmount() + "', imgurl = '" + p.getImg() + "',cid = '" + p.getCid() + "'"
                + "where productid = '" + p.getPid() + "'";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, (int) p.getPrice());
            pre.execute();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getAmountByPid(int pid) {
        String sql = "select amount from tblProduct where productid = ? ";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getAmountByPname(String pname) {
        String sql = "select amount from tblProduct where productname = ? ";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pname);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

//     public int getAmountByPid(int pid) {
//        String sql = "select amount from tblProduct where productid = ? ";
//        try {
//            conn = new DBConnection().getConn();
//            ps = conn.prepareStatement(sql);
//            ps.setInt(1, pid);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                return rs.getInt(1);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return 0;
//    }
    public int getAmountByOrderDetail(int oid, String pname) {
        String sql = "select amount from tblOrderDetail where orderid = ? and ProductName = ?  ";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, oid);
            ps.setString(2, pname);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

//    public int getAmountByPname(int oid, String pname) {
//        String sql = "select * from tblOrderDetail where ProductName like ? ";
//        try {
//            conn = new DBConnection().getConn();
//            ps = conn.prepareStatement(sql);
//            ps.setInt(1, pid);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                return rs.getInt(1);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return 0;
//    }
    public void updateAmountProduct(int pid, int amount) {
        String sql = "update tblProduct set Amount = ? where productid = ? ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, amount);
            pre.setInt(2, pid);
            pre.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStatusOrder(int status, int cid, String pname) {

        String sql = "update tblOrderDetail set status = '" + status + "' where OrderID = '" + cid + "' and ProductName = '" + pname + "'";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStatusOrderforAdmin(int status, int oid) {

        String sql = "update tblOrderDetail set status = ? where OrderID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, status);
            pre.setInt(2, oid);
            pre.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStatusFeedBack(int status, int fid) {

        String sql = "update Feedback set status = '" + status + "' where fid = '" + fid + "'";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getStatusFeedBack(int fid) {

        String sql = "select status from Feedback\n"
                + "where fid = ?";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, fid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getStatusOrder(int oid) {

        String sql = "select distinct status from tblOrderDetail where OrderID = ?";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, oid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void updateAmountProduct(Product p) {

        String sql = "update tblProduct set amount = '" + p.getAmount() + "' where ProductId = '" + p.getPid() + "'";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addOrder(Order o) {
        String sql = "insert into tblOrder(OrderID, TotalMoney) values(?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, o.getOrderid());
            pre.setDouble(2, o.getTotalmoney());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addOrderDetail(OrderDetail o) {
        String sql = "insert into tblOrderDetail(OrderID,productname,price,amount, into_money,"
                + "productid, status, date, account, address, phone) values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, o.getOrderid());
            pre.setString(2, o.getProductname());
            pre.setDouble(3, o.getPrice());
            pre.setInt(4, o.getAmount());
            pre.setDouble(5, o.getIntomoney());
            pre.setInt(6, o.getPid());
            pre.setInt(7, 0);
            pre.setString(8, o.getDate());
            pre.setString(9, o.getAccount());
            pre.setString(10, o.getAddress());
            pre.setInt(11, o.getPhone());

            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteProduct(String id) {
        String sql = "    delete tblProduct \n"
                + "where ProductId = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteuser(String account) {
        String sql = "delete tblUser \n"
                + "where account = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, account);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteOrder(String oid) {
        String sql = "delete tblOrderDetail \n"
                + "where orderid = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, oid);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<OrderDetail> getOrderByAccount(String account) {
        String sql = "select * from tblOrderDetail where account = ? order by orderid desc";
        List<OrderDetail> list = new ArrayList<>();
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, account);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public List<String> getMAXbyCid(int cid) {
        String sql = "with t as(\n"
                + "SELECT ProductID, sum(amount) AS \"So luong\"\n"
                + "  FROM tblOrderDetail o\n"
                + "  GROUP BY o.ProductID \n"
                + "   \n"
                + "  )\n"
                + "SELECT top 1 p.ProductId,  p.ProductName , t.[So luong]\n"
                + "from tblProduct p, t\n"
                + "where p.cid = ? and t.ProductID = p.ProductId \n"
                + "order by t.[So luong] desc";
        List<String> list = new ArrayList<>();
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public int hangtonkhoByCid(int cid) {
        String select = "select sum(amount)\n"
                + "from tblProduct\n"
                + "where cid = ?";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(select);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return 0;
    }

    public int hangdabanByLikeName(String name) {
        String select = "select  sum(amount)\n"
                + "from tblOrderDetail\n"
                + "where ProductName like ? ";
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(select);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return 0;
    }

    public List<newPro> getTop4(int cid) {
        String sql = "    with t as(\n"
                + "SELECT ProductID, sum(amount) AS \"So luong\"\n"
                + "  FROM tblOrderDetail o\n"
                + "  GROUP BY o.ProductID \n"
                + "   \n"
                + "  )\n"
                + "SELECT top 4 p.ProductId,  p.ProductName, p.Price, p.Amount, p.ImgUrl, p.cid, p.Description , t.[So luong]\n"
                + "from tblProduct p, t\n"
                + "where p.cid = ? and t.ProductID = p.ProductId \n"
                + "order by t.[So luong] desc";
        List<newPro> list = new ArrayList<>();
        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new newPro(rs.getInt(1),
                        rs.getString(2).replace("64GB", ""),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public List<Order> getAllOrder() {
        List<Order> list = new ArrayList<>();
        String sql = "select * from tblOrder order by orderid desc\n";

        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getDouble(2)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public List<OrderforAdmin> getAllOrderforAdmin() {
        List<OrderforAdmin> list = new ArrayList<>();
        String sql = "select distinct o.*, od.account, od.Address, od.phone,od.date, od.status\n"
                + "from tblOrder o\n"
                + "join tblOrderDetail od\n"
                + "on od.OrderID = o.OrderID\n"
                + "order by o.OrderID desc";

        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderforAdmin(rs.getInt(1), rs.getDouble(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public List<OrderforAdmin> getOrderByOid(int oid) {
        List<OrderforAdmin> list = new ArrayList<>();
        String sql = "select o.OrderID, od.Amount, od.ProductID, od.Into_Money\n"
                + "from tblOrder o\n"
                + "join tblOrderDetail od\n"
                + "on od.OrderID = o.OrderID\n"
                + "where o.OrderID = ?";

        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, oid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderforAdmin(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public List<Order> getAllOrder1() {
        List<Order> list = new ArrayList<>();
        String sql = "select * from tblOrder \n";

        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getDouble(2)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public List<OrderDetail> getOrderDetailbyID(int id) {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "select * from tblOrderDetail \n"
                + "where OrderID =  ? ";

        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10), rs.getInt(11)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    public List<OrderforAdmin> getAllOrderbyStatus(int status) {
        List<OrderforAdmin> list = new ArrayList<>();
        String sql = "select distinct o.*, od.account, od.Address, od.phone,od.date, od.status\n"
                + "from tblOrder o\n"
                + "join tblOrderDetail od\n"
                + "on od.OrderID = o.OrderID\n"
                + "where od.status = ? \n"
                + "order by o.OrderID desc";

        try {
            conn = new DBConnection().getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderforAdmin(rs.getInt(1), rs.getDouble(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    /*
    with t as(
SELECT ProductID, sum(amount) AS "So luong"
  FROM tblOrderDetail o
  GROUP BY o.ProductID 
   
  )
SELECT top 1 p.ProductId,  p.ProductName , t.[So luong]
from tblProduct p, t
where p.cid = 1 and t.ProductID = p.ProductId 
order by t.[So luong] desc
     */
 /*
        with t as(
SELECT ProductID, sum(amount) AS "So luong"
  FROM tblOrderDetail o
  GROUP BY o.ProductID 
   
  )
SELECT top 4 p.ProductId,  p.ProductName, p.ImgUrl , t.[So luong]
from tblProduct p, t
where p.cid = 1 and t.ProductID = p.ProductId 
order by t.[So luong] desc
     */
 /*
    select account, sum(Into_Money) as Money
from tblOrderDetail
group by account 
order by sum(Into_Money) desc
     */
}
