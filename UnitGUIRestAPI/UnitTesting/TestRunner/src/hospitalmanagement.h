#ifndef HOSPITAL_H
#define HOSPITAL_H

#include<iostream>
#include<fstream>
#include<iomanip>
#include<string>
#include<stdlib.h>
#include<stdio.h>

using namespace std;

void addDoc();

void displayDoc();
void deleteDoc();
void dispDatabase();
void numberofDocs();
void getDoctorDatabase();
void getDoctor();
void numberofPats();
void addPat();

void displayPat();
void dispPatDatabase();
void numberofPats();
void getPatientDatabase();
void getStatus();



class doctor{
	public:
	string d_fname,d_lname;
	int d_ID, d_age,experience,d_totalno,d_spec=0;
	string qual,d_city;
	string getSpec();
	
   	friend void addDoc();
   	friend void editDoc(doctor &docobj);
   	friend void displayDoc();
   	friend void deleteDoc();
   	friend void dispDatabase();
   	friend void numberofDocs();
   	friend void getDoctorDatabase();
};

void editDoc(doctor &docobj);

class patient{
	public:
	string fname,lname,occupation,p_city,dis,addDate,relDate;
	int p_age,p_ID,p_dep=0;
	long double phnumber,bill;
	string getDept();
	friend void getDoctor();
	friend void addPat();
	friend void editPat(patient &pat);
	friend void displayPat();
	friend void deletePat();
	friend void dispPatDatabase();
	friend void numberofPats();
   	friend void getPatientDatabase();
   	

					
};

void editPat(patient &pat);

class bed{
	public:
	int total=1000;
	friend void getStatus();
};


#endif
