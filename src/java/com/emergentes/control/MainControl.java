package com.emergentes.control;

import com.emergentes.Productos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Ivan Nina
 */
@WebServlet(name = "MainControl", urlPatterns = {"/MainControl"})
public class MainControl extends HttpServlet {
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.sendRedirect("index.jsp");
        String driver = "com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/bd_almacen";
        String usuario="root";
        String password="";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql ="";
        
        ArrayList<Productos> lista = new ArrayList<Productos>();
        try {
            Class.forName (driver);
            conn = DriverManager.getConnection(url,usuario,password);
            //consulta
            sql="select * from productos";
            ps= conn.prepareStatement(sql);
            rs= ps.executeQuery();
            // recores y almacenar de elmentos de la lista
            while(rs.next()){
                Productos c=new Productos();
                c.setId(rs.getInt("id"));
                c.setProducto(rs.getString("producto"));
                c.setPrecio(rs.getInt("Precio"));
                c.setCantidad(rs.getInt("Cantidad"));
                c.setModificar(rs.getString("Modificar"));
                c.setEliminar(rs.getString("eliminar"));
                lista.add(c);   
            }
            
            
        } catch (ClassNotFoundException e){
            System.out.println("error en driver"+e.getMessage());
        }catch (SQLException e){
            System.out.println(" Error al conectar"+e.getMessage());
            
        }
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

}
