#include <gtest/gtest.h>
#include "../test_library/CsvTester.h"
#include "TestMain.h"



extern TestUtility s1;
extern std::string filename;
    

TEST(CSV_Test, CSV_Test)
{
	{
		filename = s1.getCsvFilePath("file2");
		csvTestApiDDS(1);
		std::cout<<"Inside TEST"<<endl;
	}
}
