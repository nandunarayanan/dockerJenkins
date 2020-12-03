#ifndef CLASS_TEST
#define CLASS_TEST

//#include <limits.h>
#include <gtest/gtest.h>
#include "ClassTest.h"
#include "../src/hospitalmanagement.h"
#include "../src/hospitalmanagement.cpp"
#include "TestMain.h"



/** 
* 
*Function Name : DoctorTest Class fixture
*
* Description  : This is the text fixture created for testing "doctor" class.
* 		The object of the class is declared which is activated everytime 
*		the test related to fixture is run				   
* 
* Parameters   : None
* 
* Return Value : None
* 
* 
*/

class DoctorTest : public ::testing::Test {
 protected:
  virtual void SetUp() {
  }

  virtual void TearDown() {
    // Code here will be called immediately after each test
    // (right before the destructor).
    //
    //delete (o_doctor);
  }
  doctor d;
};


/** 
* 
*Function Name : Test using DoctorTest Class fixture
*
* Description  : This is used to test the method getSpecc() of doctor class     
* 
* Parameters   : None
* 
* Return Value : None
* 
* 
*/


TEST_F(DoctorTest,getspec){
	
	s -> setD_spec(1);	
	//std::cout <<"Inside Test 1" <<endl;    
    	EXPECT_EQ("GENERAL_MEDICINE", d.getSpec());
 
}

/** 
* 
*Function Name : Test using DoctorTest Class fixture
*
* Description  : This is used to test the method getSpecc() of doctor class     
* 
* Parameters   : None
* 
* Return Value : None
* 
* 
*/

TEST_F(DoctorTest,getspec2){
	s -> setD_spec(2);	
	//std::cout <<"Inside Test 1" <<endl;    
    	EXPECT_EQ("NEUROLOGY", d.getSpec());
 
}

/** 
* 
*Function Name : PatientTest Class fixture
*
* Description  : This is the text fixture created for testing the class "patient". 
*		  The object of the class is created in this fixture, which is used in the test 
*		  created using text fixture    
* 
* Parameters   : None
* 
* Return Value : None
* 
* 
*/

class PatientTest : public ::testing::Test {
protected:
	virtual void SetUp() {
	}
	virtual void TearDown() {
	}
	patient p;	
};

/** 
* 
*Function Name : Test using PatientTest Class fixture
*
* Description  : This is used to test the method getDept() of patient class     
* 
* Parameters   : None
* 
* Return Value : None
* 
* 
*/

TEST_F(PatientTest,getdep)
{
	s -> setP_dep(1);
	ASSERT_EQ("GENERAL_MEDICINE",p.getDept());
}


/** 
* 
*Function Name : PasswordTest Class fixture
*
* Description  : This is the text fixture created for testing "password" class.
* 		In this the object of the class is declared which is activated everytime 
*		the test related to fixture is run				   
* 
* Parameters   : None
* 
* Return Value : None
* 
* 
*/



class PasswordTest : public ::testing::Test {
 protected:
  virtual void SetUp() {
  s->setP_pass("sachin");
  }
  

  virtual void TearDown() {
    // Code here will be called immediately after each test
    // (right before the destructor).
    //
    //delete (o_doctor);
  }
  password pwd;
  
  
};


/** 
* 
*Function Name :Test using PasswordTest Class fixture
*
* Description  : This is to test the method verifyPassword() of password class.		   
* 
* Parameters   : None
* 
* Return Value : None
* 
* 
*/

TEST_F(PasswordTest,VerifyPassword_true)
{
	s->setP_x("sachin") ;
	cout<<"Inside Test Password"<<endl;
	ASSERT_EQ(1,pwd.verifyPassword());
}

/** 
* 
*Function Name :Test using PasswordTest Class fixture
*
* Description  : This is to test the method verifyPassword() of password class.		   
* 
* Parameters   : None
* 
* Return Value : None
* 
* 
*/

TEST_F(PasswordTest,VerifyPassword_false)
{
	s->setP_x("Sachin") ;
	cout<<"Inside Test Password"<<endl;
	ASSERT_EQ(0,pwd.verifyPassword());
}





#endif
