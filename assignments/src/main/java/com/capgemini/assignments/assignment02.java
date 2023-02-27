package com.capgemini.assignments;

public class assignment02{
	employee Employee;
	programer Programer;
	accountant Acountant;
	designer Designer;
	public assignment02(employee employee, programer programer, accountant acountant, designer designer, tester tester,
			BusinessDev businessDeveloper, architect architect, TeamLead teamLeader, chairman chairman,
			CTO cTO, CFO cFO, CEO cEO) {
		super();
		Employee = employee;
		Programer = programer;
		Acountant = acountant;
		Designer = designer;
		Tester = tester;
		BusinessDeveloper = businessDeveloper;
		Architect = architect;
		TeamLeader = teamLeader;
		Chairman = chairman;
		CTO = cTO;
		CFO = cFO;
		CEO = cEO;
	}
	tester Tester;
	BusinessDev BusinessDeveloper;
	architect Architect;
	TeamLead TeamLeader;
	chairman Chairman;
	CTO CTO;
	CFO CFO;
	CEO CEO;
}
class employee{
	String name,email,address,birthday;
	String behavior = "work";
}
class programer extends employee{
	String pl;
	String behavior = "code, fix bugs";
	void employee(String name,String email,String address,String PL){
		this.name=name;
		this.email=email;
		this.address=address;
		this.pl=PL;
	}
	String getname() {
		return name;
	}
	String getemail(){
		return email;
	}
	String getaddress() {
		return address;
	}
	String getpl() {
		return pl;
	}
}
class accountant extends employee{
	void employee(String name,String email,String address,String PL){
		this.name=name;
		this.email=email;
		this.address=address;
	}
	String getname() {
		return name;
	}
	String getemail(){
		return email;
	}
	String getaddress() {
		return address;
	}
}
class designer extends employee{
	String philosophy,tools;
	String behavior = "design";
	void employee(String name,String email,String address,String philosophy, String tools){
		this.name=name;
		this.email=email;
		this.address=address;
		this.philosophy = philosophy;
		this.tools=tools;
	}
	String getname() {
		return name;
	}
	String getemail(){
		return email;
	}
	String getaddress() {
		return address;
	}
	String getphilosophy() {
		return philosophy;
	}String gettools() {
		return tools;
	}
}
class tester extends employee{
	String methodologies;
	String behavior = "test, verify.";
	void employee(String name,String email,String address,String methodologies){
		this.name=name;
		this.email=email;
		this.address=address;
		this.methodologies= methodologies;
	}
	String getname() {
		return name;
	}
	String getemail(){
		return email;
	}
	String getaddress() {
		return address;
	}
	String getmethodologies() {
		return methodologies;
	}
}

class BusinessDev extends employee{
	String domains;
	String behavior = "collect requirements, analyze requirements, write documents.";
	void employee(String name,String email,String address,String domains){
		this.name=name;
		this.email=email;
		this.address=address;
		this.domains= domains;
	}
	String getname() {
		return name;
	}
	String getemail(){
		return email;
	}
	String getaddress() {
		return address;
	}
	String getdomains() {
		return domains;
	}
	
}
class architect extends programer{
	String methodology;
	String behavior = "design system";
	void employee(String name,String email,String address,String methodology, String PL){
		this.name=name;
		this.email=email;
		this.address=address;
		this.methodology= methodology;
		this.pl=PL;
	}
	String getname() {
		return name;
	}
	String getemail(){
		return email;
	}
	String getaddress() {
		return address;
	}
	String getmethodology() {
		return methodology;
	}String getpl() {
		return pl;
	}
}
class TeamLead extends programer{
	String tools,methods;
	String behavior = "schedule, organize, manage programmers, designers and testers.";
	void employee(String name,String email,String address,String tools, String methods, String PL){
		this.name=name;
		this.email=email;
		this.address=address;
		this.tools= tools;
		this.methods= methods;
		this.pl=PL;
	}
	String getname() {
		return name;
	}
	String getemail(){
		return email;
	}
	String getaddress() {
		return address;
	}
	String gettools() {
		return tools;
	}
	String getmethods() {
		return methods;
	}String getpl() {
		return pl;
	}
}
class chairman extends employee{
	void employee(String name,String email,String address,String PL){
		this.name=name;
		this.email=email;
		this.address=address;
	}
	String getname() {
		return name;
	}
	String getemail(){
		return email;
	}
	String getaddress() {
		return address;
	}
}
class CTO extends architect{
	String domain;
	String behavior = "advise technologies";
	void employee(String name,String email,String address,String methodology, String PL, String domain){
		this.name=name;
		this.email=email;
		this.address=address;
		this.methodology= methodology;
		this.pl=PL;
		this.domain=domain;
	}
	String getname() {
		return name;
	}
	String getemail(){
		return email;
	}
	String getaddress() {
		return address;
	}
	String getmethodology() {
		return methodology;
	}String getpl() {
		return pl;
	}String getdomain() {
		return domain;
	}		
}
class CFO extends employee{
	String managementskill;
	String behavior="manage finance";
	void employee(String name,String email,String address,String managementskill){
		this.name=name;
		this.email=email;
		this.address=address;
		this.managementskill=managementskill;
	}
	String getname() {
		return name;
	}
	String getemail(){
		return email;
	}
	String getaddress() {
		return address;
	}String managementskill() {
		return managementskill;
	}
}
class CEO extends employee{
	String vission,mission;
	String behavior="manage finance";
	void employee(String name,String email,String address,String vission,String mission){
		this.name=name;
		this.email=email;
		this.address=address;
		this.vission=vission;
		this.mission=mission;
	}
	String getname() {
		return name;
	}
	String getemail(){
		return email;
	}
	String getaddress() {
		return address;
	}String vission() {
		return vission;
	}String mission() {
		return mission;
	}
}


