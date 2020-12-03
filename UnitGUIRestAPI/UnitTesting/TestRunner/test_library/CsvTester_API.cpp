#include <iostream>

#include <gtest/gtest.h>

#include "CsvTester.h"

extern TestUtility s1;
extern std::string filename;


/** 
  * 
  *Function Name : csvtest(int rule)
  *
  * Description  : This function is used as the library function in csv testing.
		    This function consists of set of rules which can be used in
		    the csv testing using google test framework. 				   
  * 
  * Parameters   : CSV Test rule (rule)
  * 
  * Return Value : None 
  * 
  */
/*
void csvTestApiDDS(int rule)
{
	switch(rule)
	{
		case 1:
			s1.readCSV(filename);
			for(int ab = 0; ab < s1.words.size(); ab++)
			{
				std::cout<<"word size ="<<s1.words.size()<<s1.words1[ab]<<endl;
        			ASSERT_EQ(s1.words1[ab], s1.evaluvateTestcase(s1.words[ab]));
       			}
			break;
		case 2:
			s1.readCSV(filename);
			for(int ab =0; ab<s1.words.size();ab++)
			{
				ASSERT_EQ(s1.words1[ab], s1.evaluvateTestcase(s1.words[ab]));
			}
			break;
		default:
			break;
			
	} 
		


}
*/
