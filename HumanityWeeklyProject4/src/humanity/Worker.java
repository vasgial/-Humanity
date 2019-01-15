package humanity;

public class Worker extends Human implements HourPayable {
	
	private float weekSalary;
	private int workHourtoDay;
	
	public Worker(String firstName, String lastName , float weekSalary, int workHourtoDay) {
		super(firstName, lastName);
		this.weekSalary = weekSalary;
		this.workHourtoDay = workHourtoDay;
	}
	
	public float getWeekSalary() {
		return weekSalary;
	}

	public void setWeekSalary(float weekSalary) {
		this.weekSalary = weekSalary;
	}

	public int getWorkHourtoDay() {
		return workHourtoDay;
	}

	public void setWorkHourtoDay(int workHourtoDay) {
		this.workHourtoDay = workHourtoDay;
	}

	public Worker() {
		// TODO Auto-generated constructor stub
	}

	public Worker(float weekSalary, int workHourtoDay) {
		this.weekSalary = weekSalary;
		this.workHourtoDay = workHourtoDay;
	}
	
	public String toString() {
		return  super.toString() + "weekSalary" + weekSalary + "workHourtoDay" + workHourtoDay;
	}

	@Override
	public int calculateMoneyByHour() {
		return (int) ((weekSalary/5)/workHourtoDay);
	}
}
