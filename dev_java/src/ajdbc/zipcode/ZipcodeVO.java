package ajdbc.zipcode;

public class ZipcodeVO {

	private String uid_no;
	private String zipcode;
	private String zdo;
	private String sigu;
	private String dong;
	private String ri;
	private String bungi;
	private String aptname;
	private String upd_date;
	private String address;

	public ZipcodeVO(String uid_no, String zipcode, String zdo, String sigu, String dong, String ri, String bungi,
			String aptname, String upd_date, String address) {
		
		this.uid_no = uid_no;
		this.zipcode = zipcode;
		this.zdo = zdo;
		this.sigu = sigu;
		this.dong = dong;
		this.ri = ri;
		this.bungi = bungi;
		this.aptname = aptname;
		this.upd_date = upd_date;
		this.address = address;
	}

	public ZipcodeVO(String address, String zipcode) {
		this.address = address;
		this.zipcode = zipcode;
	}

	public String getUid_no() {
		return uid_no;
	}

	public void setUid_no(String uid_no) {
		this.uid_no = uid_no;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getZdo() {
		return zdo;
	}

	public void setZdo(String zdo) {
		this.zdo = zdo;
	}

	public String getSigu() {
		return sigu;
	}

	public void setSigu(String sigu) {
		this.sigu = sigu;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getRi() {
		return ri;
	}

	public void setRi(String ri) {
		this.ri = ri;
	}

	public String getBungi() {
		return bungi;
	}

	public void setBungi(String bungi) {
		this.bungi = bungi;
	}

	public String getAptname() {
		return aptname;
	}

	public void setAptname(String aptname) {
		this.aptname = aptname;
	}

	public String getUpd_date() {
		return upd_date;
	}

	public void setUpd_date(String upd_date) {
		this.upd_date = upd_date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}