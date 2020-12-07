/******************************************************************************
 * File Name      : hospitalmanagement.cpp
 *  
 * Description    : This is the file responsible for all the operstions related to 
 *				    Hospital Management Database.
 *
 * Modifiled Date : 07/12/2020
 *
 *****************************************************************************/
#include"hospitalmanagement.h" 
using namespace std;

/*****************function declarations***************************************/
int  chooseMain();
void getDoctorDatabase();
void getPatientDatabase();		
void getBedDatabase();
void getPatientReport();
/***************Declaring Test Points*****************************************/
#ifdef TESTING  

Testpoints *Testpoints::instance = 0;
Testpoints *s = s->getInstance();

#endif
/****************************************************************************** 
* Class Name  : password 
*
* Description : This class is used to declare the attributes and methods used 
*				in receiving, verifying and keeping the password protected. 		    
* 
******************************************************************************/
class password
{	
	public:
	string pass;
	void getPassword()
	{
    	cout<<"\nChoose a password for your system:"<<endl;
    
#ifndef TESTING
    	cin>>pass;
#endif
    }
    
	int verifyPassword()
	{
		string x;
		cout<<"\nEnter the password:"<<endl;
#ifndef TESTING
		cin>>x;
	
#endif
#ifdef TESTING
		x=s->getP_x();
		pass= s->getP_pass();
		cout<<x<<endl;
#endif	
		if (x==pass)
			return 1;
		else 
			return 0;	 	
    }    
    void passwordProtect()
    {
#ifndef TESTING
    	int veri=verifyPassword();
#endif
#ifdef TESTING
		int veri = s -> getPass_veri();
#endif
		if(veri==1)
		{
			cout<<"\nAccess Granted!"<<endl;
		}
		else 
		{
			cout<<right<<setw(40)<<setfill(' ')
			<<"\nAccess Denied!\n\nSystem will shut down\n\nPlease come back again."
			<<endl;
		 	exit(0);
		}
	}
};
/****************************************************************************** 
* Class Name  : doctor 
*
* Description : This class is used to declare the attributes and methods used 
*				maintain doctor database and displaying the reqested doctor 
*				information 		    
* 
******************************************************************************/
class doctor
{
	public:
	string d_fname,d_lname;
	int d_ID, d_age,experience,d_totalno;
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
/******************************************************************************
*Function Name    :string getSpec()
*
*Description      : This is the methos of class doctor. It is used to get the 
*				    information about user's choice of department	 		   
* 
*Input Parameters : None
* 
* Return Value    : string
* 
******************************************************************************/
string doctor::getSpec()
{
 	string sp;
	cout<<"1.GENERAL_MEDICINE"<<endl;
	cout<<"2.NEUROLOGY"<<endl;
	cout<<"3.ONCOLOGY"<<endl;
	cout<<"4.HAEMATOLOGY"<<endl;
	cout<<"5.GASTROENTEROLOGY"<<endl;
	cout<<"6.GYNAECOLOGY "<<endl;
	int spec;
/* Avoiding Standard Input for Testing */	
#ifndef TESTING	
	cin>>spec;
#endif
/* Setting the test point used while Testing */
#ifdef TESTING
	spec = s->getD_spec();
#endif
	switch(spec)
	{
		case 1:	{
					sp="GENERAL_MEDICINE";
					break;
				}
		case 2:	{
					sp="NEUROLOGY";
					break;
				}
		case 3:	{
		    		sp="ONCOLOGY";
					break;
				}
		case 4:	{
					sp="HAEMATOLOGY";
					break;
				}
		case 5:	{
					sp="GASTROENTEROLOGY";
					break;
				}
		case 6:	{
					sp="GYNAECOLOGY";
					break;
				}
		default:{
					cout<<"\nCome on!Enter a valid option."<<endl;
			
				}
	
	}
	return sp;
}
/******************************************************************************
*Function Name    : void addDoc()
*
*Description      : This function is used to create new doctor profile in 
*				     hospital database.	 		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
void addDoc()
{
	doctor d;
	cout<<"Fill up the following details"<<endl;
	cout<<"ID:"<<endl;
	cin>>d.d_ID;
	cout<<"First Name:"<<endl;
	cin>>d.d_fname;
	cout<<"Last Name:"<<endl;
	cin>>d.d_lname;
	cout<<"Age:"<<endl;
	cin>>d.d_age;
	cout<<"Choose Qualification among the following:\n1.MBBS\n2.MD"
	<<endl;
	int q;
	cin>>q;  		
   	if(q==1)
   		d.qual="MBBS";
	else 
		d.qual="MD";		
	cout<<"Choose Specialization among the following:"<<endl;
	string spec=d.getSpec();
	cout<<"Experience (in Years):"<<endl;
	cin>>d.experience;
	cout<<"City:"<<endl;
	cin>>d.d_city;
	system("cls");
	fstream fileObj;   
	fileObj.open("doctor.txt",ios::app );
	fileObj.seekp (0, ios::end); fileObj<<d.d_ID<<endl<<d.d_fname
	<<endl<<d.d_lname<<endl<<d.d_age<<endl<<d.qual<<endl<<spec<<endl
	<<d.experience<<endl<<d.d_city<<endl;
	fileObj.close();
	cout<<"\n\t\tNew Doctor profile created successfully!"<<endl<<endl<<endl;
	cout<<"\n\n\n\nEnter 1 to return to Doctor Database\nEnter 2 to Exit."
	<<endl;
	int c;
	cin>>c;
	if(c==1)
	{
		  system("cls");
		  getDoctorDatabase();
	}
	else
		exit(0);		 
}
/******************************************************************************
*Function Name    : void editDoc(doctor &docobj)
*
*Description      : This function is used to edit doctor profile in 
*				     hospital database.	 		   
* 
*Input Parameters : doctor &docobj
* 
* Return Value    : void
* 
******************************************************************************/
void editDoc(doctor &docobj)
{
	string x;
	cout<<"\nEnter the ID of the Doctor whose profile you want to Edit:"<<endl;
	cin>>x;
	fstream fileObj("doctor.txt");
	fileObj.seekg(0);
	int age,exp,count=0;
	string ID,fname,lname,ci,qua,spe;
	while(fileObj>>ID>>fname>>lname>>age>>qua>>spe>>exp>>ci)
	{
		if(ID==x)
		{
			cout<<"\n\n1.ID:"<<ID<<endl<<"2.First Name:"<<fname<<endl
			<<"3.Last Name:"<<lname<<endl<<"4.Age:"<<age<<endl
			<<"5.Qualification:"<<qua<<endl<<"6.Specialization:"
			<<spe<<endl<<"7.Experience:"<<exp<<endl<<"8.City:"<<ci<<endl<<endl;
			count++;
			break;
		}
	}
	fileObj.close();
	if(count==0)
	{
		cout<<"\nNo matching records found!"<<endl;
		exit(0);
	}
	/* datatransfer begins */
	fstream file("doctor.txt");
	file.seekg (0, ios::beg);
	file.seekg(0);
	string line;
    ofstream tempObj;
	tempObj.open("copy.txt");
    tempObj.seekp(0);
  	int skip = 0;
  	int age1,exp1;
	string fname1,lname1,ci1,qua1,spe1;
	file.seekg(0);file.seekg(0,ios::cur); //setting the pointer to beginning of file
	while(file>>line>>fname1>>lname1>>age1>>qua1>>spe1>>exp1>>ci1)
	{
		if(line!=x)
		{
			tempObj<<line<<endl<<fname1<<endl<<lname1<<endl<<age1<<endl<<qua1
			<<endl<<spe1<<endl<<exp1<<endl<<ci1<<endl;
		}			
	}

	file.close();
  	tempObj.close();
  	remove("doctor.txt");
  	int result;
  	char oldname[] ="copy.txt";
  	char newname[] ="doctor.txt";
  	result= rename( oldname , newname );
	/* datatransfer ends */
	int edit;
	cout<<"Enter number corresponding to the Field you want to Edit:"<<endl;
	cin>>edit;
	cout<<endl;
	switch(edit)
	{
		case 1:	{
					cout<<"ID"<<endl;
					cin>>ID;
					break;
				}
		case 2:	{
					cout<<"First Name:"<<endl;
					cin>>fname;		
					break;
				}
		case 3:	{
					cout<<"Last Name:"<<endl;
					cin>>lname;
					break;
				}
		case 4:	{
					cout<<"Age:"<<endl;
					cin>>age;
					break;
				}
		case 5:	{
					cout<<"Choose Qualification among the following:\n1.MBBS\n2.MD"
					<<endl;
   					int q;
   					cin>>q;
   					if(q=1)
   					{
		   				qua="MBBS";
		   			}
					else 
					{
						qua="MD";
					}
					break;
				}
		case 6:	{
					system("cls");
					spe=docobj.getSpec();
					break;
				}
		case 7:	{
					cout<<"Experience:"<<endl;
					cin>>exp;
					break;
				}
		case 8:	{
					cout<<"City:"<<endl;
					cin>>ci;
					break;
				}
		default:{
					cout<<"Invalid Input!"<<endl;
					exit(0);
				}
	}
	system("cls");
	cout<<right<<setw(50)<<setfill(' ')<<"--Updated Profile--"<<endl<<endl;
	cout<<"\n\n1.ID:"<<ID<<endl<<"2.FirstName:"<<fname<<endl<<"3.LastName:"
	<<lname<<endl<<"4.Age:"<<age<<endl<<"5.Qualification:"<<qua<<endl
	<<"6.Specialization:"<<spe<<endl<<"7.Experience:"<<exp<<endl<<"8.City:"
	<<ci<<endl<<endl;
	/* updated datatransfer */
	fstream newObj;	
	newObj.open("doctor.txt", ios::app);
	newObj.seekp (0, ios::end);
	newObj<<ID<<endl<<fname<<endl<<lname<<endl<<age<<endl<<qua<<endl<<spe<<endl
	<<exp<<endl<<ci<<endl;
	newObj.close();
	/* datatransfer completion */
	cout<<"\n\nEnter 1 to return to Doctor Database\nEnter 2 to Exit."<<endl;
	int c;
	cin>>c;
	if(c==1)
	{
	  	system("cls");
	  	getDoctorDatabase();
	}
	else
	  	exit(0);
}
/******************************************************************************
*Function Name    : void displayDoc()
*
*Description      : This function is used to display requested doctor profile.	 		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
void displayDoc()
{
	int x;
	cout<<"\n\nEnter the ID of the Doctor whose profile you want to display:"
	<<endl;
	cin>>x;
	ifstream file;file.open("doctor.txt",ios::out|ios::in);
	file.seekg(0);
	int ID,age,exp,count=0;
	string fname,lname,ci,qua,spe;
	while(file >> ID >> fname >> lname >>age >>qua >> spe >>exp >> ci)//!fileObj.eof()
	{
		if(ID==x)
		{
			cout<<"\n\n1.ID:"<<ID<<endl<<"2.FirstName:"<<fname<<endl
			<<"3.LastName:"<<lname<<endl<<"4.Age:"<<age<<endl
			<<"5.Qualification:"<<qua<<endl<<"6.Specialization:"
			<<spe<<endl<<"7.Experience:"<<exp<<endl<<"8.City:"<<
			ci<<endl<<endl;
			count++;
		}
	}
	file.close();
	if (count==0)
	{
		cout<<"\nNo matching records found!"<<endl;
	}		
	cout<<"\n\nEnter 1 to return to Doctor Database\nEnter 2 to Exit."<<endl;
	int c;
	cin>>c;
	if(c==1)
	{
		system("cls");
	 	getDoctorDatabase();
	}
	else
	{
		exit(0);
	}
}
/******************************************************************************
*Function Name    : void deleteDoc()
*
*Description      : This function is used to delete requested doctor profile 
*				    from the hospital database.	 		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
void deleteDoc()
{
	string x;
	cout<<"\nEnter the ID of the Doctor whose profile you want to Delete:"
	<<endl;
#ifndef TESTING
	cin>>x;
#endif
	fstream fileObj("doctor.txt");
	fileObj.seekg(0);
	int age,exp,count=0;
	string ID,fname,lname,ci,qua,spe;
	while(fileObj>>ID>>fname>>lname>>age>>qua>>spe>>exp>>ci)
	{
		if(ID==x)
		{
			cout<<"\n\n1.ID:"<<ID<<endl<<"2.FirstName:"<<fname<<endl
			<<"3.LastName:"<<lname<<endl<<"4.Age:"<<age<<endl
			<<"5.Qualification:"<<qua<<endl<<"6.Specialization:"<<spe
			<<endl<<"7.Experience:"<<exp<<endl<<"8.City:"<<ci<<endl<<endl;
			count++;
			break;
		}
	}
	fileObj.close();
	if(count==0)
	{
		cout<<"\nNo matching records found!"<<endl;
		exit(0);
	}
	cout<<"Are you sure you want to delete this profile?\n1.YES\n2.NO"<<endl;
	int n;
#ifndef TESTING
	cin>>n;
#endif
#ifdef TESTING
	n=1;
#endif
	if(n==1)
	{
		fstream file("doctor.txt");
		file.seekg (0, ios::beg);
		file.seekg(0);
		string line;
	   	ofstream tempObj;
		tempObj.open("copy.txt");
	   	tempObj.seekp(0);
	  	int skip = 0;
	  	int age1,exp1;
		string fname1,lname1,ci1,qua1,spe1;
        /* setting the pointer to beginning of file */
		file.seekg(0);file.seekg(0,ios::cur); 
		while(file>>line>>fname1>>lname1>>age1>>qua1>>spe1>>exp1>>ci1)
		{
			if(line!=x)
			{
				tempObj<<line<<endl<<fname1<<endl<<lname1<<endl
				<<age1<<endl<<qua1<<endl<<spe1<<endl<<exp1<<endl
				<<ci1<<endl;
			}			
		}
	  	file.close();
	  	tempObj.close();
	  	remove("doctor.txt");
	  	int result;
	  	char oldname[] ="copy.txt";
	  	char newname[] ="doctor.txt";
	  	result= rename( oldname , newname );
	  	system("cls");
	  	cout<<"\n\t\tFile successfully deleted"<<endl;
	}
	cout<<"\n\nEnter 1 to return to Doctor Database\nEnter 2 to Exit."<<endl;
	int c;
#ifndef TESTING
	cin>>c;
#endif
#ifdef TESTING
	c = s -> getD_delete();
#endif
	if(c==1)
	{
		system("cls");
		getDoctorDatabase();
	}
	else
	{
	 	exit(0);
	}
}
/******************************************************************************
*Function Name    : void dispDatabase()
*
*Description      : This function is used to display hospital database functions.	 		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
void dispDatabase()
{
	fstream fileObj("doctor.txt");
	fileObj.seekg(0);
	cout<<right<<setw(70)<<setfill(' ')<<"DOCTOR DATABASE"<<endl<<endl;
	int age,exp,count=0;
	string ID,fname,lname,ci,qua,spe;
	while(fileObj>>ID>>fname>>lname>>age>>qua>>spe>>exp>>ci)
	{
		count++;
		cout<<right<<setw(50)<<setfill(' ')<<"Doctor Profile:"<<count
		<<endl;
		cout<<"\n\n1.ID:"<<ID<<endl<<"2.FirstName:"<<fname<<
		endl<<"3.LastName:"<<lname<<endl<<"4.Age:"<<age<<endl<<
		"5.Qualification:"<<qua<<endl<<"6.Specialization:"<<spe<<endl
		<<"7.Experience:"<<exp<<endl<<"8.City:"<<ci<<endl<<endl;
	}
	if(count == 0)
	{
		cout<<"\nNo matching records found!"<<endl;
 	 	exit(0);
	}
	cout<<"\n\nEnter 1 to return to Doctor Database\nEnter 2 to Exit."<<endl;
	int c;
	cin>>c;
	if(c==1)
	{
		system("cls");
		getDoctorDatabase();
	} 
	else
	{
		exit(0);
	}
}
/******************************************************************************
*Function Name    : void numberofDocs()
*
*Description      : This function is used to get the number of documents
*				     hospital database functions.	 		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
void numberofDocs()
{
	fstream fileObj("doctor.txt");
	fileObj.seekg(0);
	int age,exp,count=0;
	string ID,fname,lname,ci,qua,spe;
	while(fileObj>>ID>>fname>>lname>>age>>qua>>spe>>exp>>ci)
	{
		count++;
	}
	cout<<"\n\n\tThe no. of doctors in the hospital="<<count<<endl<<endl;
	cout<<"\n\nEnter 1 to return to Doctor Database\nEnter 2 to Exit."<<endl;
	int c;
	cin>>c;
	if(c==1)
	{
		system("cls");
		getDoctorDatabase();
	} 
	else
	{
		exit(0);
	}
} 
/****************************************************************************** 
* Class Name  : patient 
*
* Description : This class is used to declare the attributes and methods used 
*				maintain patient database and displaying the reqested patient 
*				information 		    
* 
******************************************************************************/
class patient
{
	public:
	string fname,lname,occupation,p_city,dis,addDate,relDate;
	int p_age,p_ID;
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
/******************************************************************************
*Function Name    : void getDept()
*
*Description      : This function is a method of class patient. It is used to get
*				    the requested patient department from the hospital database.	 		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
string patient::getDept()
{
	string sp;
	cout<<"1.GENERAL_MEDICINE"<<endl;
	cout<<"2.NEUROLOGY"<<endl;
	cout<<"3.ONCOLOGY"<<endl;
	cout<<"4.HAEMATOLOGY"<<endl;
	cout<<"5.GASTROENTEROLOGY"<<endl;
	cout<<"6.GYNAECOLOGY "<<endl<<endl;
	int dep;
	/* Avoiding standard input for testing */
#ifndef TESTING
	cin>>dep;
#endif
	/* Adding Test point to use in test cases */
#ifdef TESTING
	dep = s -> getP_dep();
#endif
	switch(dep)
	{	
		case 1:	{
					sp= "GENERAL_MEDICINE";
					break;
				}
		case 2:	{
					sp="NEUROLOGY";
					break;
				}
		case 3:	{
					sp="ONCOLOGY";
					break;
				}
		case 4:	{
					sp= "HAEMATOLOGY";
					break;
				}
		case 5:	{
					sp= "GASTROENTEROLOGY";
					break;
				}
		case 6:	{
					sp= "GYNAECOLOGY";
					break;
				}
		default:{
					cout<<"\nCome on!Enter a valid option."<<endl;	
				}
	}
	return sp;
}
/******************************************************************************
*Function Name    : void getDoctor()
*
*Description      : This function is used to get
*				    the information about the doctor from the hospital database.	 		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
void getDoctor()
{
	patient p;
	string dept;
	cout<<"\nEnter the kind of specialization you are looking for:"<<endl<<endl;
	dept=p.getDept();
	fstream fileObj("doctor.txt");
	fileObj.seekg(0);
	cout<<"The doctors available with  "<<dept<<" specialization are:"<<endl
	<<endl;
	int age,exp,count=0;
	string ID,fname,lname,ci,qua,spe;
	while(fileObj>>ID>>fname>>lname>>age>>qua>>spe>>exp>>ci)
	{
		if(spe==dept)
		{
			cout<<"\n\n1.ID:"<<ID<<endl<<"2.FirstName:"<<fname<<
			endl<<"3.LastName:"<<lname<<endl<<"4.Age:"<<age<<endl
			<<"5.Qualification:"<<qua<<endl<<"6.Specialization:"
			<<spe<<endl<<"7.Experience:"<<exp<<endl<<"8.City:"
			<<ci<<endl<<endl;
			count++;
		}
	}
	fileObj.close();
	if(count==0)
	{
		cout<<"\nNo doctors with this specialization found!"<<endl;
		exit(0);
	}
	else
	{
		cout<<"No of doctors with "<<dept<<" specialization:"<<count<<endl;
	}	
	cout<<"\n\n\n\nEnter 1 to return to Patient Database\nEnter 2 to Exit."
	<<endl;
	int c;
	cin>>c;
	if(c==1)
	{
		system("cls");
		getPatientDatabase();	 //backtoPatientMenu
	}
	else
	{
		exit(0);
	} 
}
/******************************************************************************
*Function Name    : void addPat()
*
*Description      : This function is used to add 
*				    information about the patient in the hospital database.	 		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
void addPat()
{
	patient p;
	cout<<"Fill up the following details"<<endl;
	cout<<"ID:"<<endl;
	cin>>p.p_ID;
   	cout<<"First Name:"<<endl;
   	cin>>p.fname;
   	cout<<"Last Name:"<<endl;
   	cin>>p.lname;
   	cout<<"Age:"<<endl;
   	cin>>p.p_age;
	cout<<"Phone No.:"<<endl;
   	cin>>p.phnumber;
   	cout<<"Occupation:"<<endl;
	cin>>p.occupation;
	cout<<"City:"<<endl;
	cin>>p.p_city;
   	cout<<"Disease/Symptoms:"<<endl;
   	cin>>p.dis;
   	cout<<"Admission date  (DD/MM/YYYY):"<<endl;
   	cin>>p.addDate;
   	cout<<"Release date  (DD/MM/YYYY):"<<endl;
   	cin>>p.relDate;	
   	cout<<"Total Bill generated:"<<endl;
   	cin>>p.bill;
	cout<<"Kind of Specialization required:"<<endl;
	string dept=p.getDept();
	system("cls");	
	fstream patObj;   
	patObj.open("patient.txt",ios::app );
    patObj.seekp (0, ios::end);
	patObj<<p.p_ID<<endl<<p.fname<<endl<<p.lname<<endl<<p.p_age<<
	endl<<p.phnumber<<endl<<p.occupation<<endl<<p.p_city<<endl<<p.dis<<endl
	<<p.addDate<<endl<<p.relDate<<endl<<p.bill<<endl<<dept<<endl;
	patObj.close();
	cout<<"\n\t\tNew Patient profile created successfully!"<<endl<<endl<<endl;
	cout<<"\n\n\n\nEnter 1 to return to Patient Database\nEnter 2 to Exit."<<endl;
	int c;
	cin>>c;
	if(c==1)
	{
		system("cls");
		getPatientDatabase();	 //backtoPatientMenu
	}  
	else
	{
	 	exit(0); 
	}
}
/******************************************************************************
*Function Name    : void editPat(patient &pat)
*
*Description      : This function is used to edit 
*				    patient profile in the hospital database.	 		   
* 
*Input Parameters : patient &pat
* 
* Return Value    : None
* 
******************************************************************************/
void editPat(patient &pat)
{
	int x;
	cout<<"\nEnter the ID of the Patient whose profile you want to Edit:"<<endl;
	cin>>x;									 
	fstream patObj("patient.txt");
	patObj.seekg(0);
	string fname,lname,occupation,p_city,dis,addDate,relDate,dept;
	int p_age,p_ID,count=0;
	long double phnumber,bill;
	while(patObj>>p_ID>>fname>>lname>>p_age>>phnumber>>occupation>>p_city>>
	dis>>addDate>>relDate>>bill>>dept)
	{
		if(p_ID==x)
		{
			cout<<"1.ID:"<<p_ID<<endl<<"2.FirstName:"<<fname<<endl
			<<"3.LastName:"<<lname<<endl<<"4.Age"<<p_age<<endl
			<<"5.PhoneNo.:"<<phnumber<<endl<<"6.Occupation:"
			<<occupation<<endl<<"7.City:"<<p_city<<endl
			<<"8.Disease/Symptoms:"<<dis<<endl
			<<"9.Admission date(DD/MM/YYYY):"<<addDate<<endl
			<<"10.Release date(DD/MM/YYYY):"<<relDate<<endl
			<<"11.Total Bill generated:"<<bill<<endl
			<<"12.Kind of Specialization required:"<<dept<<endl;
			count++;
			break;
		}
	}
	patObj.close();
	if(count==0)
	{
		cout<<"\nNo matching records found!"<<endl;
		exit(0);
	}
	/* datatransfer begins */
	fstream file("patient.txt");
	file.seekg (0, ios::beg);
	file.seekg(0);
	int line;
    ofstream tempObj;
	tempObj.open("copy2.txt");
    tempObj.seekp(0);
  	int skip = 0;
  	string fname1,lname1,occupation1,p_city1,dis1,addDate1,relDate1,dept1;
	int p_age1;
	long double phnumber1,bill1;
	/* setting the pointer to beginning of file */
	file.seekg(0);file.seekg(0,ios::cur);
	while(file>>line>>fname1>>lname1>>p_age1>>phnumber1>>occupation1
	>>p_city1>>dis1>>addDate1>>relDate1>>bill1>>dept1)
	{
		if(line!=x)
		{	
			tempObj<<line<<endl<<fname1<<endl<<lname1<<endl
			<<p_age1<<endl<<phnumber1<<endl<<occupation1<<endl<<p_city1<<
			endl<<dis1<<endl<<addDate1<<endl<<relDate1<<endl<<bill1
			<<endl<<dept1<<endl;
		}			
	}
  	file.close();
  	tempObj.close();
  	remove("patient.txt");
  	int result;
  	char oldname[] ="copy2.txt";
  	char newname[] ="patient.txt";
  	result= rename( oldname , newname );
	/* datatransfer ends */
	int edit;
	cout<<"\nEnter number corresponding to the Field you want to Edit:"<<endl
	<<endl;
	cin>>edit;
	switch(edit)						
	{
		case 1:	{
					cout<<"ID"<<endl;
					cin>>p_ID;
					break;
				}
		case 2:	{
					cout<<"First Name:"<<endl;
					cin>>fname;
					break;
				}
		case 3:	{
					cout<<"Last Name:"<<endl;
					cin>>lname;
					break;
				}
		case 4:	{
					cout<<"Age:"<<endl;
					cin>>p_age;
					break;
				}
		case 5:	{
					cout<<"Phone No.:"<<endl;
   					cin>>phnumber;
					break;
				}
		case 6:	{
					cout<<"Occupation:"<<endl;
					cin>>occupation;
					break;
				}
		case 7:	{
					cout<<"City:"<<endl;
					cin>>p_city;
					break;
				}
		case 8:	{
					cout<<"Disease/Symptoms:"<<endl;
					cin>>dis;
					break;
				}
		case 9:	{
					cout<<"Admission date  (DD/MM/YYYY):"<<endl;
					cin>>addDate;
					break;
				}
		case 10:{
					cout<<"Release date  (DD/MM/YYYY):"<<endl;
					cin>>relDate;
				}
		case 11:{
					cout<<"Total Bill generated:"<<endl;
					cin>>bill;
					break;
				}
		case 12:{
					cout<<"Kind of Specialization required:"<<endl;
					dept=pat.getDept();
					break;
				}
		default:{
					cout<<"\nCome on!Enter a valid option."<<endl;
					break;
				}
	}
	system("cls");
	cout<<right<<setw(50)<<setfill(' ')<<"--Updated Profile--"<<endl<<endl;
	cout<<"1.ID:"<<p_ID<<endl<<"2.First Name:"<<fname<<endl<<"3.Last Name:"
	<<lname<<endl<<"4.Age"<<p_age<<endl<<"5.PhoneNo.:"<<phnumber<<endl
	<<"6.Occupation:"<<occupation<<endl<<"7.City:"<<p_city<<endl
	<<"8.Disease/Symptoms:"<<dis<<endl<<"9.Admission date(DD/MM/YYYY):"
	<<addDate<<endl<<"10.Release date(DD/MM/YYYY):"<<relDate<<endl
	<<"11.Total Bill generated:"<<bill<<endl<<"12.Kind of Specialization required:"
	<<dept<<endl;
	/* updated datatransfer */
	fstream newObj;	
	newObj.open("patient.txt", ios::app);
	newObj.seekp (0, ios::end);
	newObj<<p_ID<<endl<<fname<<endl<<lname<<endl<<p_age<<endl<<phnumber
	<<endl<<occupation<<endl<<p_city<<endl<<dis<<endl<<addDate<<endl
	<<relDate<<endl<<bill<<endl<<dept<<endl;
	newObj.close();
	/* Data transfer completion */
	cout<<"\n\nEnter 1 to return to Patient Database\nEnter 2 to Exit."<<endl;
	int c;
	cin>>c;
	if(c==1)
	{
		system("cls");
		getPatientDatabase();
	}  
	else
	{
		exit(0);
	}
}
/******************************************************************************
*Function Name    : void displayPat()
*
*Description      : This function is used to display requested  
*				    patient profile from the hospital database.	 		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
void displayPat()
{
	int x;
	cout<<"\nEnter the ID of the Patient whose profile you want to Display:"
	<<endl;
	cin>>x;									 
	fstream patObj("patient.txt");
	patObj.seekg(0);
	string fname,lname,occupation,p_city,dis,addDate,relDate,dept;
	int p_age,p_ID,count=0;
	long double phnumber,bill;
	while(patObj>>p_ID>>fname>>lname>>p_age>>phnumber>>occupation>>p_city
	>>dis>>addDate>>relDate>>bill>>dept)
	{
		if(p_ID==x)
		{
			cout<<"1.ID:"<<p_ID<<endl<<"2.First Name:"<<fname<<endl
			<<"3.Last Name:"<<lname<<endl<<"4.Age"<<p_age<<endl
			<<"5.Phone No.:"<<phnumber<<endl<<"6.Occupation:"
			<<occupation<<endl<<"7.City:"<<p_city<<endl
			<<"8.Disease/Symptoms:"<<dis<<endl
			<<"9.Admission date(DD/MM/YYYY):"<<addDate<<endl
			<<"10.Release date(DD/MM/YYYY):"<<relDate<<endl
			<<"11.Total Bill generated:"<<bill<<endl
			<<"12.Kind of Specialization required:"<<dept<<endl;
			count++;
			break;
		}
	}
	patObj.close();
	if(count==0)
	{
		cout<<"\nNo matching records found!"<<endl;
		exit(0);
	}
	cout<<"\n\nEnter 1 to return to Patient Database\nEnter 2 to Exit."<<endl;
	int c;
	cin>>c;
	if(c==1)
	{
		system("cls");
		getPatientDatabase();
	} 
	else
	{
		exit(0);
	}	
}
/******************************************************************************
*Function Name    : void deletePat()
*
*Description      : This function is used to delete requested  
*				    patient profile from the hospital database.	 		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
void deletePat()
{
	int x;
	cout<<"\nEnter the ID of the Patient whose profile you want to Delete:"
	<<endl;
	cin>>x;									 
	fstream patObj("patient.txt");
	patObj.seekg(0);
	string fname,lname,occupation,p_city,dis,addDate,relDate,dept;
	int p_age,p_ID,count=0;
	long double phnumber,bill;
	while(patObj>>p_ID>>fname>>lname>>p_age>>phnumber>>occupation>>p_city
	>>dis>>addDate>>relDate>>bill>>dept)
	{
		if(p_ID==x)
		{
			cout<<"1.ID:"<<p_ID<<endl<<"2.FirstName:"<<fname<<endl
			<<"3.LastName:"<<lname<<endl<<"4.Age"<<p_age<<endl
			<<"5.Phone No.:"<<phnumber<<endl<<"6.Occupation:"
			<<occupation<<endl<<"7.City:"<<p_city<<endl
			<<"8.Disease/Symptoms:"<<dis<<endl
			<<"9.Admission date(DD/MM/YYYY):"<<addDate<<endl
			<<"10.Release date(DD/MM/YYYY):"<<relDate<<endl
			<<"11.Total Bill generated:"<<bill<<endl
			<<"12.Kind of Specialization required:"<<dept<<endl;
			count++;
			break;
		}
	}
	patObj.close();
	if(count==0)
	{
		cout<<"\nNo matching records found!"<<endl;
		exit(0);
	}
	cout<<"Are you sure you want to delete this profile?\n1.YES\n2.NO"<<endl;
	int n;cin>>n;
	if(n==1)
	{
		fstream file("patient.txt");
		file.seekg (0, ios::beg);
		file.seekg(0);
		int line;
    	ofstream tempObj;
		tempObj.open("copy2.txt");
    	tempObj.seekp(0);
  		int skip = 0;
  		string fname1,lname1,occupation1,p_city1,dis1,addDate1,relDate1
  		,dept1;
		int p_age1;
		long double phnumber1,bill1;
		/* setting the pointer to beginning of file */
		file.seekg(0);file.seekg(0,ios::cur); 
		while(file>>line>>fname1>>lname1>>p_age1>>phnumber1>>occupation1
		>>p_city1>>dis1>>addDate1>>relDate1>>bill1>>dept1)
		{
			if(line!=x)
			{
				tempObj<<line<<endl<<fname1<<endl<<lname1<<endl
				<<p_age1<<endl<<phnumber1<<endl<<occupation1<<endl
				<<p_city1<<endl<<dis1<<endl<<addDate1<<endl<<relDate1
				<<endl<<bill1<<endl<<dept1<<endl;
			}			
		}
  		file.close();
  		tempObj.close();
  		remove("patient.txt");
  		int result;
  		char oldname[] ="copy2.txt";
  		char newname[] ="patient.txt";
  		result= rename( oldname , newname );
  		system("cls");
  		cout<<"\n\t\tFile successfully deleted"<<endl;
	}
	cout<<"\n\nEnter 1 to return to Patient Database\nEnter 2 to Exit."<<endl;
	int c;
	cin>>c;
	if(c==1)
	{
		system("cls");
		getPatientDatabase();
	}  
	else
	{
		exit(0);
	}
}
/******************************************************************************
*Function Name    : void dispPatDatabase()
*
*Description      : This function is used to display  
*				    patient database functions.	 		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
void dispPatDatabase()
{
	fstream Obj("patient.txt");
	Obj.seekg(0);
	cout<<right<<setw(70)<<setfill(' ')<<"PATIENT DATABASE"<<endl<<endl;
	string fname,lname,occupation,p_city,dis,addDate,relDate,dept;
	int p_age,p_ID,count=0;
	long double phnumber,bill;
	while(Obj>>p_ID>>fname>>lname>>p_age>>phnumber>>occupation>>p_city
	>>dis>>addDate>>relDate>>bill>>dept)
	{
		count++;
		cout<<right<<setw(50)<<setfill(' ')<<"Patient Profile:"<<count
		<<endl;
		cout<<"1.ID:"<<p_ID<<endl<<"2.First Name:"<<fname<<endl
		<<"3.Last Name:"<<lname<<endl<<"4.Age"<<p_age<<endl
		<<"5.Phone No.:"<<phnumber<<endl<<"6.Occupation:"<<occupation
		<<endl<<"7.City:"<<p_city<<endl<<"8.Disease/Symptoms:"<<dis
		<<endl<<"9.Admission date(DD/MM/YYYY):"<<addDate<<endl
		<<"10.Release date(DD/MM/YYYY):"<<relDate<<endl
		<<"11.Total Bill generated:"<<bill<<endl
		<<"12.Kind of Specialization required:"<<dept<<endl<<endl;
		
	}	
	Obj.close();
	if(count==0)
	{
		cout<<"\nNo matching records found!"<<endl;
		exit(0);
	}
	cout<<"\n\nEnter 1 to return to Patient Database\nEnter 2 to Exit."<<endl;
	int c;
	cin>>c;
	if(c==1)
	{
		system("cls");
		getPatientDatabase();
	}  
	else
	{
		exit(0);
	}
}
/******************************************************************************
*Function Name    : void numberofPats()
*
*Description      : This function is used to get the number of   
*				    patients from the database functions.	 		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
void numberofPats()
{
	fstream Obj("patient.txt");
	Obj.seekg(0);
	string fname,lname,occupation,p_city,dis,addDate,relDate,dept;
	int p_age,p_ID,count=0;
	long double phnumber,bill;
	while(Obj>>p_ID>>fname>>lname>>p_age>>phnumber>>occupation
	>>p_city>>dis>>addDate>>relDate>>bill>>dept)
	{  
		count++;		
	}	
	Obj.close();
	cout<<"\n\n\tThe number of patients in the hospital="<<count<<endl;
	cout<<"\n\nEnter 1 to return to Patient Database\nEnter 2 to Exit."
	<<endl;
	int c;
	cin>>c;
	if(c==1)
	{
		system("cls");
		getPatientDatabase();
	} 
	else
	{
		exit(0);
	}
}
/****************************************************************************** 
* Class Name  : bed 
*
* Description : This class is used to declare the attributes and methods used 
*				to provide the information related to bed availability in hospital 		    
* 
******************************************************************************/
class bed
{
	public:
	int total=1000;
	friend void getStatus();
};
/******************************************************************************
*Function Name    : void getStatus()
*
*Description      : This function is used to get the status of   
*		    beds from the database functions.	 		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
 void getStatus()
{	
 	bed b;
	cout<<"\n\tTotal Number of Beds in the hospital:"<<b.total<<endl;
	fstream file("patient.txt");
  	file.seekg(0);
	string fname,lname,occupation,p_city,dis,addDate,relDate,dept;
	int p_age,p_ID,count=0;
	long double phnumber,bill;
	while(file>>p_ID>>fname>>lname>>p_age>>phnumber>>occupation
	>>p_city>>dis>>addDate>>relDate>>bill>>dept)
	{  
		count++;		
	}
	file.close();
	cout<<"\n\tThe number of Occupied Beds="<<count<<endl;
	cout<<"\n\tThe number of Empty Beds="<<b.total-count<<endl;	
	cout<<"\n\nEnter 1 to return to Bed Database\nEnter 2 to Exit."<<endl;
	int c;
	cin>>c;
	if(c==1)
	{
		system("cls");
		getBedDatabase();
	} 
	else
	{
		exit(0);
	}
 }
/******************************************************************************
*Function Name    : int main()
*
*Description      : This is the main function of the application 	   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/

int main()
{
	password A;
	A.getPassword();
    system("cls");		
	cout<<endl;
	cout<<right<<setw(60)<<setfill(' ')
	<<"WELCOME TO ST.MUNGO'S HOSPITAL MANAGEMENT SYSTEM "<<endl;
	cout<<endl<<endl;
	cout<<right<<setw(60)<<setfill(' ')
	<<"------------------------------------------------"<<endl;
	cout<<right<<setw(40)<<setfill(' ')<<"1.Main Menu"<<endl;
	cout<<right<<setw(35)<<setfill(' ')<<"2.Exit"<<endl;
	cout<<right<<setw(60)<<setfill(' ')
	<<"------------------------------------------------"<<endl<<endl;
	cout<<"Enter your choice:"<<endl<<endl;
	int choice1;
	cin>>choice1;
	if (choice1==1)
	{
		system("cls");
		int var=chooseMain();
		system("cls");
		switch(var)
		{
			case 1:	{
						A.passwordProtect();
						system("cls");
						getDoctorDatabase();
						break;
					}
			case 2:	{
			    		A.passwordProtect();
						system("cls");
						getPatientDatabase();
						break;
					}
			case 3:	{
			    		A.passwordProtect();
						system("cls");
						getBedDatabase();
						break;
					} 
			case 4:	{
						return 0;
						break;
					}
			default:
				cout<<"\nCome on!Enter a valid option."<<endl;
		}
		
	}
	else if(choice1==2){
		return 0;
	}
	else
	 	cout<<"\nCome on!Enter a valid option."<<endl;
	

	
}

/******************************************************************************
*Function Name    : int chooseMain()
*
*Description      : This function is used to display main menu    		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
int chooseMain()
{	
	int choice2;
	cout<<right<<setw(40)<<setfill(' ')<<"\nMAIN MENU"<<endl<<endl<<endl;
	cout<<right<<setw(80)<<setfill('-')<<"----------"<<endl;
	cout<<"			"<<"1.Enter Into Doctors' Database"<<endl;
	cout<<"			"<<"2.Enter Into Patients' Database"<<endl;
	cout<<"			"<<"3.Check for Hospital Bed Availability"<<endl;
	cout<<"			"<<"4.Exit"<<endl<<endl;
	cout<<right<<setw(80)<<setfill('-')<<"----------"<<endl;	
	cout<<"\nEnter the number corresponding to your choice:"<<endl;
	cin>>choice2;
	return choice2;	
}
/******************************************************************************
*Function Name    : void getDoctorDatabase()
*
*Description      : This function is used to get the Doctor database functions    		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
void getDoctorDatabase()
{
	int choice_doc;
	cout<<"\n"<<"WELCOME TO DOCTOR'S DATABASE"<<endl<<endl;
	cout<<" "<<"1.Add New Doctor's Information"<<endl;
	cout<<" "<<"2.Edit a Doctor's Information"<<endl;
	cout<<" "<<"3.Display a Doctor's Information"<<endl;
	cout<<" "<<"4.Delete a Doctor's Information"<<endl;
	cout<<" "<<"5.Display Entire Doctor Database"<<endl;
	cout<<" "<<"6.Total Number of Doctors"<<endl;
	cout<<" "<<"7.Exit"<<endl;
	cout<<right<<setw(80)<<setfill('-')<<"----------"<<endl;
	cout<<right<<setw(60)<<setfill(' ')
	<<"\nEnter the number corresponding to your choice:"<<endl<<endl;
	cin>>choice_doc;
	system("cls");
	switch(choice_doc)
	{
		case 1:	{
		    		addDoc();
					break;
				}
		case 2:	{
					doctor k;
					editDoc(k);
					break;
				}
		case 3:	{
					displayDoc();
					break;
				}
		case 4:	{
					deleteDoc();
					break;
				}
		case 5:	{
					dispDatabase();
					break;
				}
		case 6:	{
					numberofDocs();
					break;
				}
		case 7:	{
					exit(0);
					break;
				}
		default:{
					break;
				}
	}
}
/******************************************************************************
*Function Name    : void getPatientDatabase()
*
*Description      : This function is used to get the Patient database functions    		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
void getPatientDatabase()
{
	int choice_pat;
	cout<<"\n"<<"WELCOME TO PATIENT'S DATABASE"<<endl<<endl;
	cout<<" "<<"1.Add New Patient's Information"<<endl;
	cout<<" "<<"2.Edit a Patient's Information"<<endl;
	cout<<" "<<"3.Display a Patient's Information"<<endl;
	cout<<" "<<"4.Delete a Patient's Information"<<endl;
	cout<<" "<<"5.Display Entire Patient Database"<<endl;
	cout<<" "<<"6.Total Number of Patients"<<endl;
	cout<<" "<<"7.Check for doctor availability"<<endl;
	cout<<" "<<"8.Exit"<<endl;
	cout<<right<<setw(80)<<setfill('-')<<"----------"<<endl;
	cout<<right<<setw(60)<<setfill(' ')
	<<"\nEnter the number corresponding to your choice:"<<endl<<endl;
	cin>>choice_pat;
	system("cls");
	switch(choice_pat)
	{
		case 1:	{
					addPat();
					break;
				}
		case 2:	{
					patient p;
					editPat(p);
					break;
				}
		case 3:	{
					displayPat();
					break;
				}
		case 4:	{
					deletePat();
					break;
				}
		case 5:	{
					dispPatDatabase();
					break;
				}
		case 6:	{
					numberofPats();
					break;
				}
		case 7:	{
					getDoctor();
					break;
				}
		case 8:	{
					exit(0);
					break;
				}
		default:{
					break;
				}
	}
}
/******************************************************************************
*Function Name    : void getBedDatabase()
*
*Description      : This function is used to get the bed database functions    		   
* 
*Input Parameters : None
* 
* Return Value    : None
* 
******************************************************************************/
void getBedDatabase()
{
	int choice_bed;
	cout<<"\n"<<"WELCOME TO BED DATABASE"<<endl<<endl;
	cout<<" "<<"1.Check Bed Status"<<endl;	
	cout<<" "<<"2.Exit"<<endl<<endl;	
	cout<<right<<setw(80)<<setfill('-')<<"----------"<<endl;
	cout<<right<<setw(60)<<setfill(' ')
	<<"\nEnter the number corresponding to your choice:"<<endl<<endl;
	cin>>choice_bed;
	system("cls");
	switch(choice_bed)
	{
		case 1:	{
					getStatus();
					break;
				}
		case 2:	{
					exit(0);
					break;
				}
		default:{
					break;
				}
	}
}

