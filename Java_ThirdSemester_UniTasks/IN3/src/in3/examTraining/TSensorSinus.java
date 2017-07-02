package in3.examTraining;

public class TSensorSinus extends TSensorPeriodic {
	// A * sin (wt)
	public TSensorSinus(long timePeriod, double tMin, double tMax){
		super (timePeriod, tMin, tMax);
	}
	public double getT(long time){
		long t = time % timePeriod;
		long f = 1 / timePeriod;
		double omega = 2 * Math.PI * f;
		return (tMax - tMin) / 2 * Math.sin(omega * t) + (tMax + tMin) / 2;
	}
}
