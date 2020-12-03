#include <gtest/gtest.h>
#include "../test_library/CsvTester.h"
#include "../utility/TestUtility.h"
#include "TestMain.h"



TestUtility s1;
std::string filename;
    

TEST(DdsAPI_Test, CSVReadType_1)
{
	{
		filename = s1.getCsvFilePath("file1");
		s1.readCSV(filename);
		for(int ab =0; ab<s1.words.size();ab++)
		{
			ASSERT_EQ(s1.words1[ab], s1.evaluvateTestcase(s1.words[ab]));
		}
		
	}
}

TEST(DdsAPI_Test, CSVReadType_2)
{
	{
		filename = s1.getCsvFilePath("file2");
		s1.readCSV(filename);
		for(int ab =0; ab<s1.words.size();ab++)
		{
			ASSERT_EQ(s1.words1[ab], s1.evaluvateTestcase(s1.words[ab]));
		}
		
	}
}
