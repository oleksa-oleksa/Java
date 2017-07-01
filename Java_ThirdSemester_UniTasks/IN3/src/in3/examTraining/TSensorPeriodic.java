package in3.examTraining;

public abstract class TSensorPeriodic extends TSensor{
	
	protected long timePeriod;
	protected double tMin;
	protected double tMax;
	
	public TSensorPeriodic (long timePeriod, double tMin, double tMax){
		this.timePeriod = timePeriod;
		this.tMin = tMin;
		this.tMax = tMax;
	}
}
