package ketnoiCSDL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import entities.Sinhvien;

public class sinhvienDAO {
	
	private Connection con;
	public sinhvienDAO() throws Exception{
		con=ketnoi.getConnecttion();
	}
	
	public boolean persist(Sinhvien sv)throws Exception{
		String sql="insert into sinhvien values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,sv.getMaso());
		ps.setString(2, sv.getHoten());
		ps.setString(3, sv.getLop());
		ps.setString(4, sv.getEmail());
		return ps.executeUpdate()>0;
			
	}
	
	public  boolean delete(Sinhvien sv) throws Exception{
		String sql = "delete from sinhvien where maso=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, sv.getMaso());
		return ps.executeUpdate() > 0;
		
	}
	
	public ArrayList<Sinhvien> getAll() throws SQLException {
		String sql="select * from sinhvien";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Sinhvien>lst=new ArrayList<>();
		while(rs.next()){
			Sinhvien sv=new Sinhvien(
					rs.getString("maso"),
					rs.getString("ten"),
					rs.getString("lop"),
					rs.getString("email"));
			lst.add(sv);
		}
		return lst;
	}
	
	
	
	

}
