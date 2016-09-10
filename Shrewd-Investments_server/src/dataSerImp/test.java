package dataSerImp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import PO.CashflowPO;
import PO.DebtPayPO;
import PO.GrowthPO;
import PO.NowStockPO;
import PO.OperationPO;
import PO.ReportPO;
import PO.ShortPO;
import PO.StockPO;
import sun.net.www.content.image.gif;
import sun.print.PSPrinterJob.PluginPrinter;

public class test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		AbilitySerImp abilitySerImp=new AbilitySerImp();
//		ReportPO po=abilitySerImp.getReport("600566", "20141");
//		OperationPO po=abilitySerImp.getOperation("600566", "20141");
//		GrowthPO po=abilitySerImp.getGrowth("600566", "20141");
//		DebtPayPO po=abilitySerImp.getDebtPay("603158", "20141");
//		CashflowPO po=abilitySerImp.getCashFlow("000831", "20141");
//		System.out.println(po.getCashflowratio());
		
//		GetMarketSerImp getMarketSerImp=new GetMarketSerImp();
//		ArrayList<StockPO> stockPOs=getMarketSerImp.getHistoryMarket("000001");
//		for (int i=0;i<stockPOs.size();i++){
//			System.out.println(stockPOs.get(i).getDate());
//		}
//		NowStockPO nowStockPO=getMarketSerImp.getNowMarket("000001");
//		System.out.println(3102.1248-3090.7127);
//		System.out.println(nowStockPO.getPrice_change());
//		ArrayList<ShortPO> shortPOs=getMarketSerImp.getShort();
//		for (int i = 0; i < shortPOs.size(); i++) {
//			System.out.println(shortPOs.get(i).getPrice());
//			
//		}
		GetStockSerImp getStockSerImp=new GetStockSerImp();
		NowStockPO nowStockPO=getStockSerImp.getNowStockPO("603558");
		System.out.println(nowStockPO.getName());
//		ArrayList<StockPO> stockPOs=getStockSerImp.getHistoryStock("600859");
//		for (int i = 0; i < stockPOs.size(); i++) {
//			System.out.println(stockPOs.get(i).getTurnover());
//		}
//		ArrayList<NowStockPO> nowStockPOs=getStockSerImp.getNowStock("risk");
//		System.out.println(nowStockPOs.size());
//		for (int i = 0; i < nowStockPOs.size(); i++) {
//			System.out.println(nowStockPOs.get(i).getName());
//		}

		
	}

}
