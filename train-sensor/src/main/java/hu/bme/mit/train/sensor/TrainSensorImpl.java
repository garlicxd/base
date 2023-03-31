package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private String time;
	private int jsPos;
	private int refSpe;

	private Table<String, Integer, Integer> data;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	public TrainSensorImpl() {
		this.time = "00:00";
		this.jsPos = 0;
		this.refSpe = 0;
		this.data = HashBasedTable.create();
	}

	@Override
	public void addCurrentData() {
		this.data.put(this.time, this.jsPos, this.refSpe);
	}

	@Override
	public int getDataSize() {
		return data.size();
	}

	@Override
	public int getSpeedLimit() {
		return this.speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}

	@Override
	public String getTime() {
		return this.time;
	}

	@Override
	public int getJsPos() {
		return this.jsPos;
	}

	@Override
	public int getRefSpe() {
		return this.refSpe;
	}

	@Override
	public void overrideTime(String s) {
		this.time = s;
	}

	@Override
	public void overrideJsPos(int i) {
		this.jsPos = i;
	}

	@Override
	public void overrideRefSpe(int i) {
		this.refSpe = i;
	}
}
