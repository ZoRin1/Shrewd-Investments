package dataSerImp;

import PO.CashflowPO;
import PO.DebtPayPO;
import PO.GrowthPO;
import PO.OperationPO;
import PO.ReportPO;

public class test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		AbilitySerImp abilitySerImp=new AbilitySerImp();
//		ReportPO po=abilitySerImp.getReport("600566", "20141");
//		OperationPO po=abilitySerImp.getOperation("600566", "20141");
//		GrowthPO po=abilitySerImp.getGrowth("600566", "20141");
//		DebtPayPO po=abilitySerImp.getDebtPay("603158", "20141");
		CashflowPO po=abilitySerImp.getCashFlow("000831", "20141");
		System.out.println(po.getCashflowratio());
	}

}
