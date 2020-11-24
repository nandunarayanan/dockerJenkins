/**
 * File Name      : ServerUtility.cpp
 *  
 * Description    : This is the file is responsible all the utility related
		     task of the Unit & class level testing.
 *
 * Modifiled Date : 22/09/2020
 *
 */
#include <thread>
#include <string>
#include <algorithm>
#include "TestUtility.h"
#include "../logger/Logger.h"

using namespace CPlusPlusLogging;
using namespace std;

/***************************************************************************************/

#define NULL_PTR 0

ConfigReader* ConfigReader::m_pInstance = NULL_PTR;

ConfigReader::ConfigReader()
{
   m_ConfigSettingMap.clear();
}

ConfigReader::~ConfigReader()
{
   m_ConfigSettingMap.clear();
}

ConfigReader* ConfigReader::getInstance()
{
   // No need to use double re-check lock mechanism here
   // because this getInstance() will call at the time of
   // initialization only and mostly, at the time of
   // initialization, there will be only one thread.

   if(NULL_PTR == m_pInstance)
   {
      m_pInstance = new ConfigReader;
   }
   return m_pInstance;
}

bool ConfigReader::getValue(std::string tag, int& value)
{
   map<string, string>::iterator it ;
   it = m_ConfigSettingMap.find(tag);
   if(it != m_ConfigSettingMap.end())
   {
      value = atoi((it->second).c_str());
      return true;
   }
   return false;
}

bool ConfigReader::getValue(std::string tag, std::string& value)
{
   map<string, string>::iterator it ;
   it = m_ConfigSettingMap.find(tag);
   if(it != m_ConfigSettingMap.end())
   {
      value = it->second;
      return true;
   }
   return false;
}

bool ConfigReader::parseFile(string fileName)
{
   ifstream inputFile;
   inputFile.open(fileName.c_str());
   string delimeter = "=";
   int initPos = 0;

   if (inputFile.fail())
   {
      cout << "Unable to find defaultConfig file" << endl;
      return false;
   }

   string line;
   while(getline(inputFile, line))
   {
      // Remove comment Lines
      size_t found = line.find_first_of('#');
      string configData = line.substr(0, found);

      // Remove ^M from configData
      configData.erase(std::remove(configData.begin(), configData.end(), '\r'), configData.end());

      if(configData.empty())
         continue;

      unsigned int length = configData.find(delimeter);

      string tag, value;

      if (length!=string::npos)
      {
         tag   = configData.substr(initPos, length);
         value = configData.substr(length+1);
      }

      // Trim white spaces
      tag   = reduce(tag);
      value = reduce(value);
      
      if(tag.empty() || value.empty())
         continue;

      // Check if any of the tags is repeated more than one times
      // it needs to pick the latest one instead of the old one.

      // Search, if the tag is already present or not
      // If it is already present, then delete an existing one

      std::map<std::string, std::string>::iterator itr = m_ConfigSettingMap.find(tag);
      if(itr != m_ConfigSettingMap.end())
      {
         m_ConfigSettingMap.erase(tag);
      }

      m_ConfigSettingMap.insert(std::pair<string, string>(tag, value));
   }
   return true;
}

std::string ConfigReader::trim(const std::string& str, const std::string& whitespace)
{
   size_t strBegin = str.find_first_not_of(whitespace);
   if (strBegin == std::string::npos)
      return "";

   size_t strEnd = str.find_last_not_of(whitespace);
   size_t strRange = strEnd - strBegin + 1;

   return str.substr(strBegin, strRange);
}

std::string ConfigReader::reduce(const std::string& str,
      const std::string& fill,
      const std::string& whitespace)
{
   // trim first
   string result = trim(str, whitespace);

   // replace sub ranges
   size_t beginSpace = result.find_first_of(whitespace);
   while (beginSpace != std::string::npos)
   {
      size_t endSpace = result.find_first_not_of(whitespace, beginSpace);
      size_t range = endSpace - beginSpace;

      result.replace(beginSpace, range, fill);

      size_t newStart = beginSpace + fill.length();
      beginSpace = result.find_first_of(whitespace, newStart);
   }

   return result;
}

void ConfigReader::dumpFileValues()
{
   map<string, string>::iterator it;
   for(it=m_ConfigSettingMap.begin(); it!=m_ConfigSettingMap.end(); ++it)
   {
      cout << it->first << " = " << it->second << endl;
   }
}

/***************************************************************************************/
 /** 
  * 
  *Function Name : getCsvFilePath
  *
  * Description  : This function returns the file path of the received filename
    from config file.			   
  * 
  * Parameters   : fileName
  * 
  * Return Value : file path(filePath)
  * 
  * 
  */
string TestUtility::getCsvFilePath(std::string fileName)
{
   // Create object of the class ConfigReader
   ConfigReader* p = ConfigReader::getInstance();

   // parse the configuration file
   p->parseFile();
   
   string filePath("");
   p->getValue(fileName, filePath);
   
   return filePath;
}
/***************************************************************************************/
 /** 
  * 
  *Function Name : getMsg
  *
  * Description  : This function returns a message recieved from AUT				   
  * 
  * Parameters   : None
  * 
  * Return Value : recieved message(m_msgRecived)
  * 
  * 
  */

string TestUtility::getMsg()
{
      return m_msgRecived;
}

  /** 
  * 
  *Function Name : setMsg
  *
  * Description  : This function set a message in AUT				   
  * 
  * Parameters   : msg
  * 
  * Return Value : None
  * 
  * 
  */
void TestUtility::setMsg(string msg)
{
      m_msgRecived = msg;
}

 /** 
  * 
  *Function Name : getMsgPublish
  *
  * Description  : This function returns a publishing message to Server				   
  * 
  * Parameters   : None
  * 
  * Return Value : message to be published(m_msgPublish)
  * 
  * 
  */
string TestUtility::getMsgPublish()
{
      return m_msgPublish;
}

 /** 
  * 
  *Function Name : setMsgPublish
  *
  * Description  : This function sets the message to be published to Server				   
  * 
  * Parameters   : message to be published(m_msgPublish)
  * 
  * Return Value : None
  * 
  * 
  */
void TestUtility::setMsgPublish(string msg)
{
      m_msgPublish = msg;
}



 /** 
  * 
  *Function Name : EvaluvateTestcase
  *
  * Description  : This function evaluate the test case by sending the string 
  *                passed to it and wait for the result from AUT				   
  * 
  * Parameters   : message to AUT(test case in the preorganaized format from the csv file)
  * 
  * Return Value : result for the test case recieved from AUT
  * 
  * 
  */
  
string TestUtility::evaluvateTestcase(string msg)
{
	setMsgPublish(msg);
	while(getMsg() == "")
	{
		std::this_thread::sleep_for(std::chrono::milliseconds(100));
	}
	//int test = stoi(getMsg());
	string test = getMsg();
	setMsg("");
	return test;
}

 /** 
  * 
  *Function Name : readCSV
  *
  * Description  : read the csv file line by line and save it in a vector and 
  *        		   seperate the test cases and expected results 				   
  * 
  * Parameters   : name of the file to be read(testcase csv filename)
  * 
  * Return Value : None
  * 
  * 
  */
void TestUtility::readCSV(std::string filename)
{
    	LOG_DEBUG("Came @ CSV_Test: ");
	std::vector<std::string> vecOfStr;
        std::string tmp,tmp2,r_dtype;
        char delim = ';'; 
	bool result = getFileContent(filename, vecOfStr);
	//std::cout<<result<<endl;
	
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


 /** 
  * 
  *Function Name : getFileContent
  *
  * Description  : read the csv file line by line and save it in a vector 				   
  * 
  * Parameters   : fileName name of the file to be read,
  *				   vecOfStrs variable to save data from csv line by line
  * 
  * Return Value : true on successful read & false on read failure.
  * 
  * 
  */
bool TestUtility::getFileContent(std::string fileName, std::vector<std::string> & vecOfStrs)
{
    // Open the File
    std::ifstream in(fileName.c_str());
    // Check if object is valid
    if(!in)
    {
    	LOG_ERROR(fileName+" cannot open : LOG_ERROR");
        return false;
    }
    std::string str;
    // Read the next line from File untill it reaches the end.
    while (std::getline(in, str))
    {
        // Line contains string of length > 0 then save it in vector
        if(str.size() > 0)
            vecOfStrs.push_back(str);
    }
    //Close The File
    in.close();
    return true;
}

  /** 
  * 
  *Function Name : setStopMain
  *
  * Description  : This function sets boolean variable to stop sending test message 				   
  * 
  * Parameters   : stop boolean variable
  * 
  * Return Value : None
  * 
  * 
  */
  
void TestUtility::setStopMain(bool s)
{
   m_stop_main = s;
}

  /** 
  * 
  *Function Name : getStopMain
  *
  * Description  : This function gets boolean variable to stop sending test message 				   
  * 
  * Parameters   : None
  * 
  * Return Value : stop boolean variable(m_stop_main)
  * 
  * 
  */
  
bool TestUtility::getStopMain()
{
   return m_stop_main;
}
