package com.gs.hdfc.dao;

import com.gs.hdfc.bean.Manager;
import com.gs.hdfc.util.VirtualDatabaseUtil;

public class ManagerDAOImpl {

	// create
	public void save(Manager manager) {
		// we will iterate the whole array
		// we will check for first empty slot
		Manager[] managerTable = VirtualDatabaseUtil.getManagerTable();
		// need to scan complete table
		int emptySlotNum = 0;
		for (int i = 0; i < managerTable.length; i++) {
			if (managerTable[i] == null) {
				emptySlotNum = i;
				break;
			}
		}

		managerTable[emptySlotNum] = manager;
	}

	// read
	// findById
	public Manager findById(long id) {
		Manager managerObjToReturn = null;
		// need to get manager table
		Manager[] managerTable = VirtualDatabaseUtil.getManagerTable();
		// need to scan complete table
		for (int i = 0; i < managerTable.length; i++) {
			if (managerTable[i].getManagerId() == id) {
				managerObjToReturn = managerTable[i];
				break;
			}
		}
		return managerObjToReturn;
	}

	// findAll
	public Manager[] findAll() {
		return VirtualDatabaseUtil.getManagerTable();
	}

	// update
	// delete

}
