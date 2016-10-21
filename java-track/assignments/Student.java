

public class Student {
	
	String firstName,lastName,kidname;
	int studentId,credits;
	double gpa;
	
	String standing;
	double qualityScore,currentCredit, totalScore;
	double tuition;
	
	public Student(String firstname,String lastname,int studentid){
		this.firstName = firstname;
		this.lastName = lastname;
		this.studentId = studentid;
		this.credits = 0;
		this.gpa = 0.0;
	}
	
	public Student(String firstname,String lastname, int id,double gpa, int cred){
		this.firstName = firstname;
		this.lastName = lastname;
		this.studentId = id;
		this.gpa = gpa;
		this.credits = cred;
		
		}
	
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getName(){
		String name = getFirstName() + " " + getLastName();
		return name;
	}
	

	public int getStudentID() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public double getGPA() {
		return gpa;
	}

	public void setGPA(double gpa) {
		this.gpa = gpa;
	}
	
	public String getClassStanding(){
		if(getCredits()<30){
			standing = "Freshman";
		} else if(getCredits() >=30 && getCredits()<60){
			standing = "Sophomore";
		} else if(getCredits() >=60 && getCredits()<90){
			standing = "Junior";
		} else if(getCredits()>=90){
			standing = "Senior";
		}
		return standing;
	}
	public void submitGrade(double grade,int credit){
		qualityScore = ( credit * grade );
		totalScore += qualityScore;
		this.credits += credit ;
		double gpa = totalScore/this.credits;
		double math = Math.round((gpa)*1000)/1000.0;
		setGPA(math);	
	}
	
	public double computeTuition(){
		for(int i=0;i<14;i++){
			tuition = getCredits() * Math.round((20000/15.0)*100)/100.0;
		}
		if(getCredits()>15){
			tuition = (getCredits()%15 * (1333.33)) + 20000;
		}
		if(getCredits()==15) {
			tuition = 20000;
		}
		return tuition;
	}
	public Student createLegacy(Student two,Student one){
		Student kid = new Student(one.getName(), two.getName(), one.studentId+two.studentId, (one.gpa + two.gpa)/2, Math.max(one.credits, two.credits));
		System.out.println("Kid = " + kid.getName());
	return kid;
	}
    public String toString(){
    	String studentInfo = this.firstName + " " + this.lastName + " Student Id: "+ this.studentId;
    	return studentInfo;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student will = new Student("will","thrill",123456);
		Student willma = new Student("willma","thrillma",100000);
		
		will.submitGrade(3.343, 1);
		
		System.out.println(will.createLegacy(willma, will));

	}

}
