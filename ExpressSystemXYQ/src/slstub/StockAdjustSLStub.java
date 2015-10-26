package slstub;

import stcokslservice.StockAdjustSLService;
import vo.AreaVO;

public class StockAdjustSLStub implements StockAdjustSLService {
	
	String[] ES ={"(0,0,0)","(1,2,3)"};
	String EP="50%";

	@Override
	public AreaVO[] getAreas() {
		// TODO Auto-generated method stub
		AreaVO vo1 = new AreaVO("������",ES,EP);
		AreaVO vo2 = new AreaVO("������",ES,EP);
		
		AreaVO[] VOS = {vo1,vo2};
		
		return VOS;
	}

	@Override
	public AreaVO selectArea(String name) {
		// TODO Auto-generated method stub
		if(name.equals("������"))
			return new AreaVO(name,ES,EP);
		else return null;
	}

	@Override
	public ResultMessage range(String adjustrange) {
		// TODO Auto-generated method stub
		return ResultMessage.True;
	}

}
