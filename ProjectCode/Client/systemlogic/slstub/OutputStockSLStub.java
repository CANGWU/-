package slstub;

import vo.OutMessageVO;
import ioputslservice.OutputStockService;


public class OutputStockSLStub implements OutputStockService {

	@Override
	public OutMessageVO showInfo(String id) {
		// TODO Auto-generated method stub
		if(id.equals("1234567890"))
			return new OutMessageVO(id,"2015/10/26","�Ϻ�","����","123201510260123456");
		else return null;
	}

	@Override
	public ResultMessage report(String id) {
		// TODO Auto-generated method stub
		return ResultMessage.True;
	}

}
