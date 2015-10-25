package strategydataservice;

import java.util.ArrayList;

import po.SalaryPO;

public interface SalaryStrategyDataService {
	
	public ArrayList<SalaryPO> findAll();
	public void insert(SalaryPO po);
	public void delect(SalaryPO po);
	public void delect(String id);
	public void delect(ArrayList<SalaryPO> salarys);
	public void update(SalaryPO po);
	public void update(ArrayList<SalaryPO> salarys);
	public void init();
	public void finish();

}
