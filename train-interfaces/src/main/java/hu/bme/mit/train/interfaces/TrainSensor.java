package hu.bme.mit.train.interfaces;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	String getTime();
	void overrideTime(String time);

	int getJsPos();
	void overrideJsPos(int i);

	int getRefSpe();
	void overrideRefSpe(int i);

	void addCurrentData();
	int getDataSize();

}
