#include <gtest/gtest.h>
#include "../test_library/CsvTester.h"
#include "../utility/TestUtility.h"
#include "TestMain.h"



extern TestUtility s1;
std::string filename;
    

TEST(DdsAPI_Test, CSVReadType_1)
{
	{
		filename = s.getCsvFilePath("file1");
		s.readCSV(filename);
		for(int ab =0; ab<s.words.size();ab++)
		{
			ASSERT_EQ(s.words1[ab], s.evaluvateTestcase(s.words[ab]));
		}
		
	}
}

TEST(DdsAPI_Test, CSVReadType_2)
{
	{
		filename = s.getCsvFilePath("file2");
		s.readCSV(filename);
		for(int ab =0; ab<s.words.size();ab++)
		{
			ASSERT_EQ(s.words1[ab], s.evaluvateTestcase(s.words[ab]));
		}
		
	}
}
