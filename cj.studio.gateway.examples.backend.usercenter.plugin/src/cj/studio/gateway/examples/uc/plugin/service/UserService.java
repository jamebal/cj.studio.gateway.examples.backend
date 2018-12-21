package cj.studio.gateway.examples.uc.plugin.service;

import java.util.List;

import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.gateway.examples.backend.usercenter.bo.UserBO;
import cj.studio.gateway.examples.backend.usercenter.service.IUserService;
import cj.studio.gateway.examples.uc.plugin.dao.IUserDAO;
import cj.studio.orm.mybatis.annotation.CjTransaction;

@CjBridge(aspects = "transaction")
@CjService(name = "user")
public class UserService implements IUserService {
	@CjServiceRef(refByName = "mybatis.cj.studio.gateway.examples.uc.plugin.dao.IUserDAO")
	IUserDAO userDAO;

	@CjTransaction
	@Override
	public void save(UserBO bo) {
		userDAO.save(bo);
	}

	@CjTransaction
	@Override
	public void delete(String id) {
		userDAO.delete(id);
	}

	@CjTransaction
	@Override
	public List<UserBO> query() {
		return userDAO.query();
	}
	@CjTransaction
	@Override
	public UserBO getUser(String id) {
		return userDAO.getUser(id);
	}
}
