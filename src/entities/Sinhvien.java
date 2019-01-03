package entities;

public class Sinhvien {
	private String Maso;
	private String Hoten;
	private String lop;
	private String email;
	public Sinhvien() {
		super();
	}
	public Sinhvien(String maso, String hoten, String lop, String email) {
		super();
		Maso = maso;
		Hoten = hoten;
		this.lop = lop;
		this.email = email;
	}
	public String getMaso() {
		return Maso;
	}
	public void setMaso(String maso) {
		Maso = maso;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Maso == null) ? 0 : Maso.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sinhvien other = (Sinhvien) obj;
		if (Maso == null) {
			if (other.Maso != null)
				return false;
		} else if (!Maso.equals(other.Maso))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Hoten;
	}
	
	
	
	
}
