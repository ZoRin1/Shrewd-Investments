package PO;
//这个PO只有股票有
public class BidPO {
	private String code;
	private double bv1;//笔数买一
	private double bp1;//价格买一
	private double bv2;//
	private double bp2;//
	private double bv3;//
	private double bp3;//
	private double bv4;//
	private double bp4;//
	private double bv5;//
	private double bp5;//
	private double av1;//笔数卖一
	private double ap1;//价格卖一
	private double av2;//
	private double ap2;//
	private double av3;//
	private double ap3;//
	private double av4;//
	private double ap4;//
	private double av5;//
	private double ap5;//
	public BidPO(String code, double bv1, double bp1, double bv2, double bp2, double bv3, double bp3, double bv4,
			double bp4, double bv5, double bp5, double av1, double ap1, double av2, double ap2, double av3, double ap3,
			double av4, double ap4, double av5, double ap5) {
		super();
		this.code = code;
		this.bv1 = bv1;
		this.bp1 = bp1;
		this.bv2 = bv2;
		this.bp2 = bp2;
		this.bv3 = bv3;
		this.bp3 = bp3;
		this.bv4 = bv4;
		this.bp4 = bp4;
		this.bv5 = bv5;
		this.bp5 = bp5;
		this.av1 = av1;
		this.ap1 = ap1;
		this.av2 = av2;
		this.ap2 = ap2;
		this.av3 = av3;
		this.ap3 = ap3;
		this.av4 = av4;
		this.ap4 = ap4;
		this.av5 = av5;
		this.ap5 = ap5;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getBv1() {
		return bv1;
	}
	public void setBv1(double bv1) {
		this.bv1 = bv1;
	}
	public double getBp1() {
		return bp1;
	}
	public void setBp1(double bp1) {
		this.bp1 = bp1;
	}
	public double getBv2() {
		return bv2;
	}
	public void setBv2(double bv2) {
		this.bv2 = bv2;
	}
	public double getBp2() {
		return bp2;
	}
	public void setBp2(double bp2) {
		this.bp2 = bp2;
	}
	public double getBv3() {
		return bv3;
	}
	public void setBv3(double bv3) {
		this.bv3 = bv3;
	}
	public double getBp3() {
		return bp3;
	}
	public void setBp3(double bp3) {
		this.bp3 = bp3;
	}
	public double getBv4() {
		return bv4;
	}
	public void setBv4(double bv4) {
		this.bv4 = bv4;
	}
	public double getBp4() {
		return bp4;
	}
	public void setBp4(double bp4) {
		this.bp4 = bp4;
	}
	public double getBv5() {
		return bv5;
	}
	public void setBv5(double bv5) {
		this.bv5 = bv5;
	}
	public double getBp5() {
		return bp5;
	}
	public void setBp5(double bp5) {
		this.bp5 = bp5;
	}
	public double getAv1() {
		return av1;
	}
	public void setAv1(double av1) {
		this.av1 = av1;
	}
	public double getAp1() {
		return ap1;
	}
	public void setAp1(double ap1) {
		this.ap1 = ap1;
	}
	public double getAv2() {
		return av2;
	}
	public void setAv2(double av2) {
		this.av2 = av2;
	}
	public double getAp2() {
		return ap2;
	}
	public void setAp2(double ap2) {
		this.ap2 = ap2;
	}
	public double getAv3() {
		return av3;
	}
	public void setAv3(double av3) {
		this.av3 = av3;
	}
	public double getAp3() {
		return ap3;
	}
	public void setAp3(double ap3) {
		this.ap3 = ap3;
	}
	public double getAv4() {
		return av4;
	}
	public void setAv4(double av4) {
		this.av4 = av4;
	}
	public double getAp4() {
		return ap4;
	}
	public void setAp4(double ap4) {
		this.ap4 = ap4;
	}
	public double getAv5() {
		return av5;
	}
	public void setAv5(double av5) {
		this.av5 = av5;
	}
	public double getAp5() {
		return ap5;
	}
	public void setAp5(double ap5) {
		this.ap5 = ap5;
	}
	
}
