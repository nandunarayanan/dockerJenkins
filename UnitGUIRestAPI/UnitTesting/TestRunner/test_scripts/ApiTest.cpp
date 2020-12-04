#include <gtest/gtest.h>
#include "../test_library/CsvRead.h"
#include "../utility/TestUtility.h"
#include "TestMain.h"

extern TestUtility s1;

class DdsAPI_Test : public ::testing::Test {
 protected:
  virtual void SetUp() {
    }
  

  virtual void TearDown() {
    // Code here will be called immediately after each test
    // (right before the destructor).
    //
    //delete (o_doctor);
  }
  
  std::string filename;
  
  
};


    

TEST_F(DdsAPI_Test, CSVReadType_1)
{
	{
		filename = s1.getCsvFilePath("file1");
		CsvReader(filename);
		for(int ab =0; ab<words.size();ab++)
		{
			ASSERT_EQ(words1[ab], s1.evaluvateTestcase(words[ab]));
		}
		
	}
}

TEST_F(DdsAPI_Test, CSVReadType_2)
{
	{
		filename = s1.getCsvFilePath("file2");
		CsvReader(filename);
		for(int ab =0; ab<words.size();ab++)
		{
			ASSERT_EQ(words1[ab], s1.evaluvateTestcase(words[ab]));
		}
		
	}
}
