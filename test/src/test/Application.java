package test;
class Student {
static{
		System.out.println("静态字段默认初始化 className = " + Student.className);
		System.out.println("静态字段默认初始化 classID = " + Student.classID);

		//静态代码块初始化
		classID = 1;
		System.out.println("静态代码块1 classID = " + Student.classID);
	}
	static{
		classID = 2;
		System.out.println("静态代码块2 classID = " + Student.classID);
	}
	public static int classID;
	public static String className = "班级";
	public static void showClassID(){
		System.out.println("调用Student.showClassID()，班级ID号是：" + classID);
	}
	public Student(int studentID,int age,String name) {
		System.out.println("实例字段默认初始化 studentID = " + this.studentID);
		System.out.println("实例字段声明初始化 age = "      + this.age);
		System.out.println("实例字段默认初始化 name = "    + this.name);
		this.studentID = studentID;
		this.age = age;
		this.name = name;
		System.out.println("实例字段实例构造方法初始化");
	}

	int studentID;
	int age = 18;

String name;
	public void study(){
		System.out.println(this.name + "正在学习");

	}
public void study(String partner){
		System.out.println(this.name + "正在与" + partner + "一起学习");
	}
}
//
public class Application {

	public static void main(String[] args) {

        System.out.println("----------------------------------------------类的静态成员");
		System.out.println("main代码块 classID = " + Student.classID);
		System.out.println("main代码块 className = " + Student.className);
		Student.showClassID();
        System.out.println("----------------------------------------------类的实例成员");
        System.out.println("-----------------------张珊实例成员");
		Student s = new Student(1,21,"张珊");
		System.out.println("studentID = " + s.studentID + ",age = " + s.age + ",name = " + s.name);
		s.study();
		s.study("比尔盖茨");
        System.out.println("-----------------------李斯实例成员");
		Student s1 = new Student(2,22,"李斯");
		System.out.println("studentID = " + s1.studentID + ",age = " + s1.age + ",name = " + s1.name);
		s1.study();
		s1.study("马云");

	}
}
