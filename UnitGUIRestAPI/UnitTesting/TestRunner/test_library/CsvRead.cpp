#include <iostream>

#include <gtest/gtest.h>
#include <string>
#include "CsvRead.h"

using namespace std;


vector<string> words;
vector<string> words1;

void CsvReader(std::string filename)
{

	std::vector<std::string> vecOfStr;
        std::string tmp,tmp2,r_dtype;
        char delim = ';'; 
	bool result = getFileContent(filename, vecOfStr);
	std::cout<<"result "<<result<<endl;
	
	if(result)
    	{
    		for(std::string & line : vecOfStr)        
        	{
		  std::string lCopy = line;
		  //std::cout<<line<<endl;
		  replace(lCopy.begin(),lCopy.end(),',',' ');
		  std::stringstream str_strm1(lCopy);
		  
		  
	          int c=0;
          
		  while (std::getline(str_strm1, tmp, delim)) 
		   {
		   	if (c == 0)
		   	{
		   	   words.push_back(tmp);	
		   	   c++;   	
		   	}
		   	else
		   	{
				std::cout <<"Seperated value"<<tmp<<endl;		
		  		std::stringstream str_strm2(tmp);
				int c1=0;
		   		while(std::getline(str_strm2,tmp2,'%'))
				{
					if(c1 == 0)
					{
						r_dtype = tmp2;
						c1++;
					}
					else
					{
						if(r_dtype == "int")
						{
							int data_type;
							data_type = stoi(tmp2);
							tmp2 = to_string(data_type);
							std::cout <<"tmp2 = "<<tmp2<<endl;
							words1.push_back(tmp2);
							c1=0;
						}
						else if(r_dtype == "float")
						{
							float data_type;
							data_type = stof(tmp2);
							tmp2 = to_string(data_type);
							std::cout << "tmp2 = "<<tmp2<<endl;
							words1.push_back(tmp2);
							c1=0;
						}
						else if(r_dtype == "double")
						{
							double data_type;
							data_type = stod(tmp2);
							tmp2 = to_string(data_type);
							std::cout << "tmp2 = "<<tmp2<<endl;
							words1.push_back(tmp2);
							c1=0;
						}
						else
						{

							std::cout << "else tmp2 = "<<tmp2<<endl;
							words1.push_back(tmp2);
                                                        c1=0;

						}
					}	

				}
			//	tmp.erase( std::remove(tmp.begin(), tmp.end(), '\r'), tmp.end() );
		   	//	words1.push_back(tmp);
		   		c = 0;
		   	}   
		   }
        	}
    	}
    	LOG_DEBUG("Reading CSV:");
    	for(int ab = 0; ab < words.size(); ab++) 
	{
		LOG_DEBUG(words[ab]+": testcase to AUT");
		LOG_DEBUG(words1[ab]+": LHS");
		
		std::cout<<words[ab]<<": testcase to AUT" <<endl;
		std::cout<<words1[ab]<<": LHS"<<endl;
	}
}




}
