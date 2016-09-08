package PO;

public class GrowthPO {
	private String code;//代码
	private String name;//名称
	private String mbrg;//主营业务收入增长率(%)
	private String nprg;//净利润增长率(%)
	private String nav;//净资产增长率
	private String targ;//总资产增长率
	private String epsg;//每股收益增长率
	private String seg;//股东权益增长率
	public GrowthPO(String code, String name, String mbrg, String nprg, String nav, String targ, String epsg,
			String seg) {
		super();
		this.code = code;
		this.name = name;
		this.mbrg = mbrg;
		this.nprg = nprg;
		this.nav = nav;
		this.targ = targ;
		this.epsg = epsg;
		this.seg = seg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMbrg() {
		return mbrg;
	}
	public void setMbrg(String mbrg) {
		this.mbrg = mbrg;
	}
	public String getNprg() {
		return nprg;
	}
	public void setNprg(String nprg) {
		this.nprg = nprg;
	}
	public String getNav() {
		return nav;
	}
	public void setNav(String nav) {
		this.nav = nav;
	}
	public String getTarg() {
		return targ;
	}
	public void setTarg(String targ) {
		this.targ = targ;
	}
	public String getEpsg() {
		return epsg;
	}
	public void setEpsg(String epsg) {
		this.epsg = epsg;
	}
	public String getSeg() {
		return seg;
	}
	public void setSeg(String seg) {
		this.seg = seg;
	}
	
}
