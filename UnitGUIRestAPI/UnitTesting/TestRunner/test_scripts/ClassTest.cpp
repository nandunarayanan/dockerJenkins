#ifndef CLASS_TEST
#define CLASS_TEST

#include <gtest/gtest.h>
#include "ClassTest.h"
#include "../src/hospitalmanagement.h"
#include "../src/hospitalmanagement.cpp"
#include "../logger/Logger.h"
#include "TestMain.h"
#include "../test_library/CsvRead.h"
#include "../utility/TestUtility.h"


extern TestUtility s1;

/****************************************************************************** 
*Test Fixture Name : DoctorTest Class fixture
*
* Description      : This is the test fixture created for testing "doctor" class.
* 		      The object of the class is declared which is activated everytime 
*		      the test related to fixture is run
*
******************************************************************************/
class DoctorTest : public ::testing::Test 
{
	protected:
	virtual void SetUp() 
	{
		  s -> setD_spec(0); //Setting default value before starting the test.
		  
	}

	virtual void TearDown()
	{  
		 s -> setD_spec(0); //Resetting the value to default after test
		 //read_csv::clear() ; //clear the vector data
		 
	}
	words1.clear(); //clear the vector data
	words.clear();
	read_csv.clear();
	doctor d;
	std::string filename;
};
/****************************************************************************** 
*Test Name 	: getspec
*
* Description  : This test is using the DoctorTest Test fixture and is testing 
*                the getSpec() method of the class doctor.
* 
*****************************************************************************/
TEST_F(DoctorTest,getspec)
{	
	s -> setD_spec(1);    
    	EXPECT_EQ("GENERAL_MEDICINE", d.getSpec());
}
/****************************************************************************** 
*Test Name     : getspec2
*
* Description  : This test is using the DoctorTest Test fixture and is testing 
*                the getSpec() method of the class doctor.
*
******************************************************************************/
TEST_F(DoctorTest,getspec2)
{
	s -> setD_spec(2);    
    	EXPECT_EQ("NEUROLOGY", d.getSpec());
}
/******************************************************************************
*Test Name     : getspec3
*
* Description  : This test is using the DoctorTest Test fixture and is testing 
*                the getSpec() method of the class doctor.
* 
******************************************************************************/
TEST_F(DoctorTest,getspec3)
{
	s -> setD_spec(3);    
    	EXPECT_EQ("ONCOLOGY", d.getSpec());
}
/******************************************************************************
*Test Name     : getspec4
*
* Description  : This test is using the DoctorTest Test fixture and is testing 
*                the getSpec() method of the class doctor.
* 
******************************************************************************/
TEST_F(DoctorTest,getspec4)
{
	s -> setD_spec(4);    
    	EXPECT_EQ("HAEMATOLOGY", d.getSpec());
}
/******************************************************************************
*Test Name     : getspec5
*
* Description  : This test is using the DoctorTest Test fixture and is testing 
*                the getSpec() method of the class doctor. 
*
******************************************************************************/
TEST_F(DoctorTest,getspec5)
{
	s -> setD_spec(5);    
    	EXPECT_EQ("GASTROENTEROLOGY", d.getSpec());
}
/******************************************************************************
*Test Name     : getspec6
*
* Description  : This test is using the DoctorTest Test fixture and is testing 
*                the getSpec() method of the class doctor. 
*
******************************************************************************/
TEST_F(DoctorTest,getspec6)
{
	s -> setD_spec(6);    
    	EXPECT_EQ("GYNAECOLOGY", d.getSpec());
}
/****************************************************************************** 
*Test Name 	: getspec_csv                       
*
* Description  : This test is using the DoctorTest Test fixture and is testing 
*                the getSpec() method of the class doctor. It is accessing the 
*		 test input from the CSV file.
* 
******************************************************************************/
TEST_F(DoctorTest,getspec_csv)
{
	filename = s1.getCsvFilePath("file3");
	CsvReader(filename);

	for(int i=0;i<words1.size();i++)
	{
		std::cout<<"words1 vector : "<<words1[i]<<endl;
		s -> setD_spec(std::stoi(read_csv[i]));    
    		EXPECT_EQ(words1[i], d.getSpec());
 	}
}
/******************************************************************************
*Test Fixture Name : PatientTest 
*
* Description	   : This is the test fixture created for testing the class 
*		     "patient".The object of the class is created in this fixture,
*		      which is used in respective test cases 
*
******************************************************************************/
class PatientTest : public ::testing::Test 
{
	protected:
	virtual void SetUp() 
	{
		s -> setP_dep(0); //Setting the value to default before test
		//read_csv::clear() ; //clear the vector data
		
	}
	virtual void TearDown() 
	{
		s -> setP_dep(0); //resetting the value to default after the test
		//read_csv::clear() ; //clear the vector data
		
	}
	words1.clear(); //clear the vector data
	words.clear();
	read_csv.clear();
	patient p;	
	std::string filename;
};
/******************************************************************************
*Test Name     : getdep
*
* Description  : This test is using the PatientTest Test fixture and is testing 
*                the getDept() method of the class patient. 
*
******************************************************************************/
TEST_F(PatientTest,getdep)
{
	s -> setP_dep(1);
	ASSERT_EQ("GENERAL_MEDICINE",p.getDept());
}
/******************************************************************************
*Test Name     : getdep2
*
* Description  : This test is using the PatientTest Test fixture and is testing 
*                the getDept() method of the class patient. 
*
******************************************************************************/

TEST_F(PatientTest,getdep2)
{
	s -> setP_dep(2);
	ASSERT_EQ("NEUROLOGY",p.getDept());
}
/******************************************************************************
*Test Name     : getdep3
*
* Description  : This test is using the PatientTest Test fixture and is testing 
*                the getDept() method of the class patient. 
*
******************************************************************************/
TEST_F(PatientTest,getdep3)
{
	s -> setP_dep(3);
	ASSERT_EQ("ONCOLOGY",p.getDept());
}
/******************************************************************************
*Test Name     : getdep4
*
* Description  : This test is using the PatientTest Test fixture and is testing 
*                the getDept() method of the class patient. 
*
******************************************************************************/
TEST_F(PatientTest,getdep4)
{
	s -> setP_dep(4);
	ASSERT_EQ("HAEMATOLOGY",p.getDept());
}
/******************************************************************************
*Test Name     : getdep5
*
* Description  : This test is using the PatientTest Test fixture and is testing 
*                the getDept() method of the class patient. 
*
******************************************************************************/
TEST_F(PatientTest,getdep5)
{
	s -> setP_dep(5);
	ASSERT_EQ("GASTROENTEROLOGY",p.getDept());
}
/******************************************************************************
*Test Name     : getdep6
*
* Description  : This test is using the PatientTest Test fixture and is testing 
*                the getDept() method of the class patient. 
*
******************************************************************************/
TEST_F(PatientTest,getdep6)
{
	s -> setP_dep(6);
	ASSERT_EQ("GYNAECOLOGY",p.getDept());
}
/******************************************************************************
*Test Name     : csvread_dep
*
* Description  : This test is using the PatientTest Test fixture and is testing 
*                the getDept() method of the class patient. It is taking the test
*		 input from the CSV file
*
******************************************************************************/
TEST_F(PatientTest,csvread_dep)
{
	filename = s1.getCsvFilePath("file4");
	CsvReader(filename);

	for(int i=0;i<words1.size();i++)
	{	
		s -> setP_dep(std::stoi(read_csv[i]));    
    		EXPECT_EQ(words1[i], p.getDept());
 	}
}
/******************************************************************************
*Test Fixture Name : PasswordTest
*
* Description      : This is the test fixture created for testing "password" class.
* 		     In this the object of the class is declared which is activated
*		     everytime the test related to fixture is run and setting the 
*		     defualt password in SetUp()				   
*
******************************************************************************/
class PasswordTest : public ::testing::Test 
{
	protected:
	virtual void SetUp() 
	{
		s->setP_pass("sachin");   //Setting the test password
  	}
  
  	virtual void TearDown() 
  	{
    	 	s->setP_pass("");        //reset the variable to null string
  	}
  	password pwd;
};
/******************************************************************************
*Test Case Name :VerifyPassword_true
*
* Description   : This test is using test fixture PasswordTest and it is 
*		  testing the method verifyPassword() of class password class.		   
*
******************************************************************************/
TEST_F(PasswordTest,VerifyPassword_true)
{
	s->setP_x("sachin") ;
	cout<<"Inside Test Password"<<endl;
	ASSERT_EQ(1,pwd.verifyPassword());
}
/******************************************************************************
*Test Case Name :VerifyPassword_false
*
* Description   : This test is using test fixture PasswordTest and it is 
*		  testing the method verifyPassword() of class password class.		   
*
******************************************************************************/
TEST_F(PasswordTest,VerifyPassword_false)
{
	s->setP_x("Sachin") ;
	cout<<"Inside Test Password"<<endl;
	ASSERT_EQ(0,pwd.verifyPassword());
}

#endif
