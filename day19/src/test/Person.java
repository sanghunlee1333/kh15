package test;

public class Person {
	
	private String lastName;
	private String firstName;
	private int age;
	private String job;
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) { //성 설정
		for (int i = 0; i < lastName.length(); i++) {
			if((lastName.length() >= 1 && lastName.length() <= 2) && (lastName.charAt(i) >= '가' && lastName.charAt(i) <= '힣')) {
				this.lastName = lastName;
			}
		}
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) { //이름 설정
		
		for (int i = 0; i < firstName.length(); i++) {
			if((firstName.length() >= 1 && firstName.length() <= 5) && (firstName.charAt(i) >= '가' && firstName.charAt(i) <= '힣')) {
				this.firstName = firstName;
			}
		}
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) { //나이 설정
		if(age < 1) return; //1보다 작으면 메소드 종료
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) { //직업 설정
		boolean hasKorean;
		boolean hasLowEnglish;
		boolean hasUpEnglish;
		boolean hasNum;
		String jobName = "";
		
		for(int i = 0; i < job.length(); i++) {
			
			hasKorean = job.charAt(i) >= '가' && job.charAt(i) <='힣'; //한글 포함 여부
			hasLowEnglish = job.charAt(i) >= 'a' && job.charAt(i) <='z'; //영소문자 포함 여부
			hasUpEnglish = job.charAt(i) >= 'A' && job.charAt(i) <='Z'; //영대문자 포함 여부
			hasNum = (int)job.charAt(i) >= 0 && (int)job.charAt(i) <= 9; //숫자 포함 여부
						
			if(hasKorean || hasLowEnglish || hasUpEnglish || hasNum) {
				jobName += job.charAt(i);	
			}
			if(jobName.equals(job)) {
				this.job = jobName;
			}
		}
	}
	
	public String getType (int age) { //나이에 따른 정보
		if(this.age <= 7) return "유아";
		else if(this.age <= 13) return "어린이";
		else if(this.age <= 19) return "청소년";
		else return "성인";
	}
	
	//생성자 오버로딩
	public Person(String lastName, String firstName, int age) {
		this(lastName, firstName, age, "무직"); //직업을 설정하지 않은 경우, "무직"으로 설정
	}
	//생성자
	public Person(String lastName, String firstName, int age, String job) {
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setAge(age);
		this.setJob(job);
	}
	
	public void show() {
		System.out.println("이름 : " + this.getLastName() + this.getFirstName() + ", 나이 : " + this.getAge() + ", 직업 : " + this.getJob());
		System.out.println("나이에 따른 정보 : " + this.getType(this.age));
	}
	
	
	
}
